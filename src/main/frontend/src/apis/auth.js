import api from './api';

//로그인
export const login = (username, password) => api.post(`/login?username=${username}&password=${password}`)

//회원 정보
export const info = () => api.get(`/users/info`)


//회원 가입
export const join = (data) => api.post('/users', data);

//회원 정보 수정
export const update = (data) => api.put('/users', data);

//회원 탈퇴
export const remove = (username) => api.delete(`/users/${username}`)

