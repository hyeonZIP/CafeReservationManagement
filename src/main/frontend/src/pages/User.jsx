import React, {useContext, useEffect, useState} from 'react';
import Header from '../components/Header/Header'
import UserForm from "../components/User/UserForm";
import {LoginContext} from "../contexts/LoginContextProvider";
import * as auth from '../apis/auth';
const User = () => {

    const [userInfos, setUserInfos] = useState()
    const {logout, loginCheck} = useContext(LoginContext)
    //회원 정보 조회 - /user/info
    const getUserInfo = async ()=>{
        const response = await auth.info()
        const data =response.data
        console.log(`getUserInfo`);
        console.log(data);
        setUserInfos(data)
    }

    //회원 정보 수정
    const updateUser = async (form) =>{
        console.log(form);

        let response
        let data
        try{
            response = await auth.update(form)
        }catch (error){
            console.error(`data : ${error}`)
            console.error(`회원정보 수정 중 에러가 발생하였습니다`);
            return
        }

        data = response.data
        const status = response.status
        console.log(`data : ${data}`)
        console.log(`status : ${status}`);

        if (status === 200){
            console.log(`회원정보 수정 성공`);
            alert(`회원정보 수정 성공`)
            logout()
        }
        else{
            console.log(`회원정보 수정 실패`);
            alert(`회원정보 수정 실패`)
        }

    }

    // 회원 탈퇴
    const deleteUser = async (username) =>{
        console.log(username);

        let response
        let data
        try{
            response = await auth.remove(username)
        }catch (error){
            console.error(`data : ${error}`)
            console.error(`회원삭제 중 에러가 발생하였습니다`);
            return
        }

        data = response.data
        const status = response.status
        console.log(`data : ${data}`)
        console.log(`status : ${status}`);

        if (status === 200){
            console.log(`회원삭제 성공`);
            alert(`회원삭제  성공`)
            logout()
        }
        else{
            console.log(`회원삭제 실패`);
            alert(`회원삭제 실패`)
        }
    }

    useEffect(() => {
        console.log("User.jsx - LoginCheck")
        loginCheck()
        getUserInfo()

    }, []);
    return (
        <>
            <Header/>
            <div className={"container"}>
                <h1>User</h1>
                <UserForm userInfo={userInfos} updateUser={updateUser} deleteUser={deleteUser}/>
            </div>
        </>

    );
};

export default User;