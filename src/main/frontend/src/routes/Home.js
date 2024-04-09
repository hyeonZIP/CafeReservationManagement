/* Home.js */
import {useEffect, useState} from "react";
import React from 'react';
import axios from "axios";
import {Link} from "react-router-dom";

const Home = () => {

    const [cafeList, setCafeList] = useState([]);


    useEffect(() => {
        axios.post("http://localhost:8080/", {})
            .then((res) =>{
                console.log(res.data);
                setCafeList(res.data);
            })
            .catch((err)=>{
                console.log(err);
            });
    }, []);

    const table_for = (arr) =>{
        const result = [];

        for(const element of arr) {
            result.push(<th><Link to="/reservation">{element}</Link></th>);
        }


        return result;

    }

    return (
        <table border={1}>
            <thead>
            </thead>
            <tbody>
                <tr>
                    {table_for(cafeList)}
                </tr>
                <tr>
                    <td>카페 여석</td>
                </tr>
            </tbody>
        </table>



    );
};

export default Home;