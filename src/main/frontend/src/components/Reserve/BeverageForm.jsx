import React, {useContext, useEffect, useState} from 'react'
import './ReserveForm.css'
import {LoginContext} from "../../contexts/LoginContextProvider";
import {Link, useNavigate} from "react-router-dom";
const BeverageForm = ({menuInfo, getMenuInfo, cafeIdx, reserve, userInfo, tableTemplateIdx}) => {
    console.log("ReserveForm.jsx ---------------------------------- Mounted")

    const [selectInfo, setSelectInfo] = useState([])
    const [countInfo, setCountInfo] = useState([])
    const [totalPrice, setTotalPrice] = useState(0);

    if (menuInfo[0] === undefined)
    {
        return null;
    }
    console.log("menuInfo : ", menuInfo)
    console.log("userIdx : ", userInfo.idx)
    console.log("tableTemplateIdx : ", tableTemplateIdx)

    const orderList = (idx)=>{
        const exist = selectInfo.findIndex((menu)=>menu === idx)
        if(exist<0)
        {
            console.log("추가")
            setSelectInfo([...selectInfo, idx])
            setCountInfo([...countInfo, 1])
        }
        else
        {
            console.log("카운트만 추가")
            const updatedCountInfo = [...countInfo];
            updatedCountInfo[exist]++;
            setCountInfo(updatedCountInfo);
        }

        const selectMenu = menuInfo.find((menu)=>menu.idx === idx);
        if(selectMenu)
        {
            const menuPrice = selectMenu.price;
            const updatedTotalPrice = totalPrice + menuPrice;
            setTotalPrice(updatedTotalPrice);
        }
    }

    /**
     * 예약 정보 insert 요청
     */
    const reserveHandler = () =>{
        const reserveData = {
            userIdx : userInfo.idx,
            tableIdx : tableTemplateIdx,
            menus : selectInfo,
            count : countInfo
        }

        console.log(reserveData)

        reserve(reserveData)
    }

    return (
        <>
            <table key={1}>
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Price</th>
                        <th>Tag</th>
                    </tr>
                </thead>
                <tbody>
                {menuInfo.map((menu)=> (
                    <tr key={3}>
                        <td>{menu.name}</td>
                        <td>.{menu.price}.</td>
                        <td>{menu.tag}</td>
                        <td>
                            <button onClick={() => orderList(menu.idx)}>+</button>
                        </td>
                    </tr>
                ))}
                </tbody>
            </table>

            <hr/>

            <table key={2}>
                <tbody>
                <tr>
                    <th>Name</th>
                    <th>Count</th>
                    <th>Price</th>
                </tr>
                {selectInfo.map((menuIdx, index) => {
                    const selectMenu = menuInfo.find(menu => menu.idx === menuIdx);
                    console.log("selectMenu : ", selectMenu)

                    const menuName = selectMenu.name;
                    const menuPrice = selectMenu.price;
                    const menuCount = countInfo[index];
                    console.log(menuName);
                    return (
                        <tr key={index}>
                            <td>{menuName}</td>
                            <td>{menuCount}</td>
                            <td>{menuPrice * countInfo[index]}</td>
                        </tr>
                    );
                })}
                <tr>
                    <td colSpan={2}>Total</td>
                    <td>{totalPrice}</td>
                </tr>
                </tbody>
            </table>
            <button onClick={reserveHandler}>예약 하기</button>
        </>
    )
}

export default BeverageForm;