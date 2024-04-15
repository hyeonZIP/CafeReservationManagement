import React, {useContext, useEffect, useState} from 'react';
import Header from '../components/Header/Header'
import LoginContextConsumer from "../contexts/LoginContextConsumer";
import HomeForm from "../components/Home/HomeForm";
import {LoginContext} from "../contexts/LoginContextProvider";
import * as auth from "../apis/auth";

const Home = () => {

    const {getCafeInfo} = useContext(LoginContext)
    //회원 정보 조회 - /user/info


    useEffect(() => {
        getCafeInfo()
    }, []);

    return (
        <>
            <Header/>
            <div className={"container"}>
                <HomeForm/>
                <LoginContextConsumer/>
            </div>
        </>

    );
};

export default Home;