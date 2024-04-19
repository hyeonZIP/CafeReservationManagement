import React, {useContext, useEffect, useState} from 'react';
import Header from '../components/Header/Header'
import ReserveForm from "../components/Reserve/ReserveForm";
import {useLocation} from "react-router-dom";
import {LoginContext} from "../contexts/LoginContextProvider";
import * as auth from "../apis/auth";
const Reserve = () => {
    console.log("Reserve.jsx ---------------------------------- Mounted")
    const [sectorInfo, setSectorInfo] = useState({})

    const [tableInfo, setTableInfo] = useState({})

    const {loginCheck} = useContext(LoginContext)
    const location = useLocation();
    const cafeIdx = location.state.idx;

    /**
     *  cafeIdx를 통해 해당 카페의 sector 정보를 불러온다
     */
    const getSectorInfo = async (cafeIdx)=>{
        try{
            const response = await auth.sectorInfo(cafeIdx)
            const data = response.data
            console.log("카페 구역 정보 불러오기 : " , data);
            setSectorInfo(data);
        }catch (error){
            console.error("카페 구역 정보 불러오기 오류 : ", error);
        }
    }

    /**
     * sector정보를 불러오고 선택한 sector의 테이블 정보를 불러온다
     */
    const getTableInfo = async (idx)=>{
        try{
            console.log("idx : " + idx)
            const response = await auth.tableInfo(idx)
            const data = response.data
            console.log("테이블 정보 불러오기 : " , data);
            setTableInfo(data);
        }catch (error){
            console.error("테이블 정보 불러오기 오류 : ", error);
        }
    }

    useEffect(() => {
        console.log("Reserve.jsx useEffect---------------------------------- Mounted")
        loginCheck()
        getSectorInfo(cafeIdx)
    }, []);

    return (
        <>
            <Header/>
            <div className={"container"}>
                <ReserveForm sectorInfo={sectorInfo} getTableInfo={getTableInfo} tableInfo={tableInfo} cafeIdx={cafeIdx}/>
            </div>
        </>

    );
};

export default Reserve;