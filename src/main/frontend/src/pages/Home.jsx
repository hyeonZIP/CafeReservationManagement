import React, {useContext, useEffect, useState} from 'react';
import Header from '../components/Header/Header'
import LoginContextConsumer from "../contexts/LoginContextConsumer";
import HomeForm from "../components/Home/HomeForm";
import {LoginContext} from "../contexts/LoginContextProvider";
import * as auth from "../apis/auth";

const Home = () => {

    const {getCafeInfo} = useContext(LoginContext)
    //회원 정보 조회 - /user/info

    const cancelReservation = async (reserveIdx) =>{
        console.log(reserveIdx);

        let response
        let data
        try{
            response = await auth.cancel(reserveIdx)
        }catch (error){
            console.error(`data : ${error}`)
            console.error(`예약 취소 실패`);
            return
        }

        data = response.data
        const status = response.status
        console.log(`data : ${data}`)
        console.log(`status : ${status}`);

        if (status === 200){
            console.log(`예약취소 성공`);
            alert(`예약취소  성공`)
        }
        else{
            console.log(`예약취소 실패`);
            alert(`예약취소 실패`)
        }
    }

    useEffect(() => {
        getCafeInfo()
    }, []);

    return (
        <>
            <Header/>
            <div className={"container"}>
                <HomeForm cancelReservation={cancelReservation}/>
                <LoginContextConsumer />
            </div>
        </>

    );
};

export default Home;