import React, {useContext} from 'react'
import './HomeForm.css'
import {LoginContext} from "../../contexts/LoginContextProvider";
import {Link} from "react-router-dom";
const HomeForm = ({cancelReservation}) => {

    const {isLogin, cafeListInfo,reservationInfo} = useContext(LoginContext)
    if(!cafeListInfo)
    {
        return null;
    }
    return (
        <div>
            <h2>주변 카페 리스트</h2>
            <div className={"form-container"}>
            {Array.isArray(cafeListInfo) ? (
                cafeListInfo.map((cafe, index) => (
                    <div className={"form"} key={index}>
                        <h2 className={"cafe-title"}>{cafe.cafeName}</h2>
                        <div>cafeIdx : {cafe.cafeIdx}</div>
                        <div>{cafe.unUsingCount}/{cafe.totalCount}</div>
                        {isLogin && (<Link to="/reserve" state={{idx: cafe.cafeIdx}}>예약</Link>)}
                    </div>
                ))
            ) : (
                <p>카페 정보 불러오기 오류</p>
            )}
            </div>

            <div>
                <h2>예약 정보</h2>
                {
                    !isLogin
                        ?
                        <div>Login First dude</div>
                        :
                        (reservationInfo.cafeName === null || reservationInfo.cafeName === undefined
                            ?
                            <div>예약 정보가 없습니다</div>
                            :
                            <div className={"form"}>
                                <div>Reservation ID : {reservationInfo.reservationIdx}</div>
                                <div>Cafe : {reservationInfo.cafeName}</div>
                                <div>Table : {reservationInfo.sectorName} . {reservationInfo.seatNo}</div>
                                <div>Request : {reservationInfo.req}</div>
                                <div>Response : {reservationInfo.res}</div>
                                <div>Client : {reservationInfo.userRealName}</div>
                                <button onClick={()=>cancelReservation(reservationInfo.reservationIdx)}>취소하기</button>
                            </div>
                        )
                }
            </div>
        </div>
    );
};

export default HomeForm;