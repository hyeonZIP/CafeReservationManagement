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

    // 랜덤한 배경색을 생성하는 함수
    const getRandomColor = () => {
        const red = Math.floor(Math.random() * 106) + 150; // 150 이상인 빨간색
        const green = Math.floor(Math.random() * 106) + 150; // 150 이상인 초록색
        const blue = Math.floor(Math.random() * 106) + 150; // 150 이상인 파란색
        return `rgb(${red}, ${green}, ${blue})`;
    };

    const countColor = (unUsingCount, totalCount) => {
        const percent = unUsingCount / totalCount;
        if (percent >= 0.7) {
            return "#85C09E"; // 연한 녹색으로 표시
        } else if (percent >= 0.3) {
            return "#0087D6"; // 연한 노란색으로 표시
        } else {
            return "#E95643"; // 연한 빨간색으로 표시
        }
    };
    return (
        <div>
            <div className={"form-container"}>
            {Array.isArray(cafeListInfo) ? (
                cafeListInfo.map((cafe, index) => (
                    <div className={"cafe-form"} key={index}>
                        <h2 className={"cafe-title"}>{cafe.cafeName}</h2>
                        {isLogin ? (
                            <Link
                                to="/reserve"
                                state={{idx: cafe.cafeIdx}}
                                className={"btn--form"}
                                style={{backgroundColor : countColor(cafe.unUsingCount,cafe.totalCount)}}
                            >
                                {cafe.unUsingCount}/{cafe.totalCount}
                            </Link>
                        ) : (
                                <div className={"btn--form"} style={{backgroundColor : countColor(cafe.unUsingCount,cafe.totalCount)}}>
                                    {cafe.unUsingCount}/{cafe.totalCount}
                                </div>
                            )}
                    </div>
                ))
            ) : (
                <p>카페 정보 불러오기 오류</p>
            )}
            </div>

            <div className={"reservation-info"}>
                {
                    !isLogin
                        ?
                        <div>Login First dude</div>
                        :
                        (reservationInfo.cafeName === null || reservationInfo.cafeName === undefined
                            ?
                            <div className={"form-container"}><div className={"reservation-form"} style={{backgroundColor : getRandomColor()}}>No Reservation Info</div></div>
                            :
                            <div className={"form-container"}>
                                <div className={"reservation-form"} style={{backgroundColor : getRandomColor()}}>
                                    <div>Reservation ID : {reservationInfo.reservationIdx}</div>
                                    <div>Cafe : {reservationInfo.cafeName}</div>
                                    <div>Table : {reservationInfo.sectorName} . {reservationInfo.seatNo}</div>
                                    <div>Request : {reservationInfo.req}</div>
                                    <div>Response : {reservationInfo.res}</div>
                                    <div>Client : {reservationInfo.userRealName}</div>
                                    <button onClick={()=>cancelReservation(reservationInfo.reservationIdx)}>취소하기</button>
                                </div>
                            </div>
                        )
                }
            </div>
        </div>
    );
};

export default HomeForm;