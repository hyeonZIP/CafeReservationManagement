import React from 'react';
import Header from '../components/Header/Header'
import LoginContextConsumer from "../contexts/LoginContextConsumer";

const Home = () => {
    return (
        <>
            <Header/>
            <div className={"container"}>
                <hi>Greetings,</hi>
                <hr/>
                <h2>메인페이지</h2>
                <LoginContextConsumer/>
            </div>
        </>

    );
};

export default Home;