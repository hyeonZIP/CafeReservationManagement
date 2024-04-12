package com.example.cafe.config;

import com.example.cafe.jwt.JWTFilter;
import com.example.cafe.jwt.JWTUtil;
import com.example.cafe.jwt.LoginFilter;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import java.util.Collections;

@Configuration
@EnableWebSecurity//시큐리티를 위한 Configuration임을 선언
public class SecurityConfig {

    private final AuthenticationConfiguration authenticationConfiguration;

    private final JWTUtil jwtUtil;

    public SecurityConfig(AuthenticationConfiguration authenticationConfiguration, JWTUtil jwtUtil)
    {
        this.authenticationConfiguration = authenticationConfiguration;
        this.jwtUtil = jwtUtil;
    }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception
    {
        //커스텀 필터를 적용 시킨 곳에
        return configuration.getAuthenticationManager();
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder()
    {
        return new BCryptPasswordEncoder();
        //회원정보 검증 및 등록을 위해서는 비밀번호를 암호화
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception
    {
        http
                .cors((cors)->cors
                        .configurationSource(new CorsConfigurationSource() {
                            @Override
                            public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {

                                CorsConfiguration configuration = new CorsConfiguration();

                                configuration.setAllowedOrigins(Collections.singletonList("http://localhost:3000"));
                                configuration.setAllowedMethods(Collections.singletonList("*"));
                                configuration.setAllowCredentials(true);
                                configuration.setAllowedHeaders(Collections.singletonList("*"));
                                configuration.setMaxAge(3600L);

                                configuration.setExposedHeaders(Collections.singletonList("Authorization"));

                                return configuration;
                            }
                        }));
        http
                .csrf((auth)->auth.disable());
        //csrf 세션 방식에서는 세션이 고정되기 때문에 csrf공격에 대한 방어
        //jwt 스테이트리스 상태로 관리 하기때문에 안전
        http
                .formLogin((auth)-> auth.disable());//From 로그인 방식 disable
        http
                .httpBasic((auth)->auth.disable());//http basic 인증 방식 disable

        http
                .authorizeHttpRequests((auth)->auth
                        .requestMatchers("/login", "/", "/users/**", "/test/**").permitAll()
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .requestMatchers("/reissue").permitAll()
//                        .anyRequest().authenticated()
                );
                //로그인 루트 조인 경로에 대해서는 모든 권한을 허용한다
        //어드민 경로는 어드민이라는 권한을 가진 사용자만 접근 가능
        //any리퀘스트는 로그인 한 사용자만 접근가능하도록

        http
                .addFilterBefore(new JWTFilter(jwtUtil), LoginFilter.class);
        http
                .addFilterAt(new LoginFilter(authenticationManager(authenticationConfiguration), jwtUtil), UsernamePasswordAuthenticationFilter.class);

        http
                .sessionManagement((session)->session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        //가장 중요한 jwt 방식에서는 세션을 스테이트리스 상태로 관리
        //그렇게 하기 위해서는 Security Config 설정 추가


        return http.build();
    }
}
