import React, {useContext, useEffect, useState} from 'react';
import Header from '../components/Header/Header'
import ReserveForm from "../components/Reserve/ReserveForm";
import {useLocation, useParams} from "react-router-dom";
import {LoginContext} from "../contexts/LoginContextProvider";
import * as auth from "../apis/auth";
import BeverageForm from "../components/Reserve/BeverageForm";
const Beverage = () => {
    console.log("Beverage.jsx ---------------------------------- Mounted")

    const [menuInfo, setMenuInfo] = useState({});
    const {userInfo, loginCheck} = useContext(LoginContext)
    const location = useLocation();
    const cafeIdx = location.state.cafeIdx;
    const tableTemplateIdx = location.state.tableTemplateIdx;

    console.log("cafeIdx : " , cafeIdx)
    console.log("tableTemplateIdx : ",tableTemplateIdx)

    const getMenuInfo = async (cafeIdx) =>{
        try{
            const response = await auth.menuInfo(cafeIdx)
            const data = response.data
            console.log("카페 메뉴 불러오기 : " , data);
            setMenuInfo(data)
        }catch (error){
            console.error("카페 메뉴 불러오기 오류 : ", error);
        }
    }

    const reserve = async (reserveData)=>{
        console.log("reserveData : ", reserveData)

        let response
        let data
        try{
            response = await auth.reserve(reserveData)
        }catch (e) {
            console.error(`data : ${e}`)
            console.error(`예약 정보 insert 실패`);
        }

        data = response.data
        const status = response.status
        console.log(`data : ${data}`)
        console.log(`status : ${status}`);

        if (status === 200){
            console.log(`예약 성공`);
            alert(`예약 성공`)
        }
        else{
            console.log(`예약 실패`);
            alert(`예약 실패`)
        }
    }



    useEffect(() => {
        console.log("Beverage.jsx useEffect---------------------------------- Mounted")
        loginCheck()
        getMenuInfo(cafeIdx)
    }, []);


    return (
        <>
            <Header/>
            <div className={"container"}>
                <BeverageForm menuInfo={menuInfo} getMenuInfo={getMenuInfo} cafeIdx={cafeIdx} reserve={reserve} userInfo={userInfo} tableTemplateIdx={tableTemplateIdx}/>
            </div>
        </>

    );
};

export default Beverage;