import React, {createContext, useEffect, useState} from "react";
import api from "../apis/api";
import Cookies from 'js-cookie';
import * as auth from '../apis/auth';
import {useNavigate} from "react-router-dom";

export const LoginContext = createContext();
LoginContext.displayName = 'LoginContextName'
/**
 * 로그인 체크
 * 로그인
 * 로그아웃
 *
 * 로그인 세팅
 * 로그아웃 세팅
 */
const LoginContextProvider = ({children}) => {

    /**
     * 상태
     * -로그인 여부
     * -유저 정보
     * -권한 정보
     * -아이디 저장
     */
    /* --------------------------------------------------[State]------------------------------------------------------*/
    //로그인 정보
    const [isLogin, setLogin] = useState(false);

    //유저 정보
    const [userInfo, setUserInfo] =useState({})

    //권한 정보
    const [roles, setRoles] = useState({isUser : false, isAdmin : false})

    //아이디 저장
    const [rememberUserId, setRememeberUserId] = useState()

    /* ---------------------------------------------------------------------------------------------------------------*/

    //페이지 이동
    const navigate = useNavigate()

    /**
     * 로그인 체크
     * -쿠키에 jwt가 있는지 확인
     * -jwt로 사용자 정보를 요청
     */
    const loginCheck = async () =>{

        //쿠키에서 jwt토큰 가져오기
        const accessToken = Cookies.get("accessToken")//헤더에서 가져오도록 나중에 수정
        console.log(`accessToken : ${accessToken}`)

        //accessToken이 없는 경우
        if(!accessToken)
        {
            console.log('쿠키에 accessToken이 없음');
            logoutSetting()
            return
        }

        //accessToken이 있는 경우
        //header에 jwt 담기
        api.defaults.headers.common.Access = `Bearer ${accessToken}`
        //사용자 정보 요청

        let response
        let data

        try{
            response = await auth.info()
        }catch (error){
            console.log(`error : ${error}`);
        }
        data = response.data
        console.log(`data : ${data}`)

        //인증 실패
        if(data === 'UNAUTHRIZED' || response.status === 401)
        {
            console.error(`accessToken 이 만료되거나 인증에 실패했습니다`);
            return
        }

        //인증 성공
        console.log('accessToken (jwt) 토큰으로 사용자 인증 정보 요청 성공!');

        //로그인 세팅
        loginSetting(data, accessToken);
    }

    //로그인
    const login = async (username, password) =>{
        console.log(`username : ${username}`);
        console.log(`password : ${password}`);

        try{
            const response = await auth.login(username, password)
            const data = response.data
            console.log(`data : ${data}`);
            const status = response.status
            console.log(`status : ${status}`);
            const headers = response.headers
            console.log(`headers : ${headers}`);
            const accessToken = headers.access;
            console.log(`jwt : ${accessToken}`);

            //로그인 성공
            if (status === 200){

                //쿠키에 accessToken(jwt) 저장
                Cookies.set("accessToken", accessToken);

                //로그인 체크 ( /users/{email])
                loginCheck()

                alert(`로그인 성공`)

                navigate("/")
            }
        }catch(error){
            alert(`로그인 실패!`)
            //로그인 실패
            //아이디 또는 비밀번호가 일치하지 않습니다
        }
    }

    //로그아웃
    const logout = () =>{

        const check = window.confirm("로그아웃 하시겠습니까?")

        if(check)
        {
            logoutSetting();

            navigate("/")
        }
    }

    //로그인 세팅
    //userData, accessToken(jwt 토큰)
    const loginSetting = (userData, accessToken) => {
        const {idx, username, realname, role} = userData
        // const roleList = authList.map((auth)=>auth.auth)

        console.log(`idx : ${idx}`);
        console.log(`username : ${username}`);
        console.log(`role : ${role}`);
        console.log(`realname : ${realname}`);

        //axios 객체의 header(Authorization : 'Bearer ${accessToken}')
        api.defaults.headers.common.Authorization = `Bearer ${accessToken}`;

        //로그인 여부 : true
        setLogin(true)

        //유저정보 세팅
        const updatedUserInfo = {idx, username,realname, role}
        setUserInfo(updatedUserInfo)

        //권한정보 세팅
        const updatedRoles = {isUser : false, isAdmin : false}

        if(role === 'ROLE_USER') updatedRoles.isUser = true
        if(role === 'ROLE_ADMIN') updatedRoles.isAdmin = true
        setRoles(updatedRoles)
    }

    //로그아웃 세팅
    const logoutSetting = () =>{
        //axios 헤더 초기화
        api.defaults.headers.common.Authorization = undefined;

        //쿠키 초기화
        Cookies.remove("accessToken")

        //로그인 여부 : false
        setLogin(false)

        //유저 정보 초기화
        setUserInfo(null)

        //권한 정보 초기화
        setRoles(null)
    }

    useEffect(() => {
        //로그인 체크
        loginCheck()
    }, []);


    return(
        <LoginContext.Provider value={{isLogin,userInfo, roles, login, logout, loginCheck}}>
            {children}
        </LoginContext.Provider>
    )
}

export default LoginContextProvider