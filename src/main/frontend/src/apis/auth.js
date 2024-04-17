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

/*************************************************Home Controller******************************************************/
//회원 예약 정보
export const reserveInfo = (idx)=>api.get(`/home/reservation?idx=${idx}`);
//카페 정보
export const cafeInfo = (idx)=>api.get(`/home/cafe?idx=${idx}`);

/*************************************************Reserve Controller***************************************************/
//선택한 카페idx로 sector정보 요청
export const sectorInfo = (idx)=>api.get(`/reserve/sector?idx=${idx}`);
//선택한 sector idx로 table정보 요청
export const tableInfo = (idx) => api.get(`/reserve/table?idx=${idx}`);

//선택한 카페idx로 메뉴 요청
export const menuInfo = (idx) => api.get(`/reserve/cafe-menu?idx=${idx}`);
//예약 정보 쏴라ㅏㅏㅏㅏㅏㅏ
export const reserve = (data) => api.post(`/reserve/insert-reservation`, data);