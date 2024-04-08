/* Home.js */
import React, {useState} from 'react';
import axios from "axios";
import {useNavigate} from "react-router-dom";

const SignIn = () => {
    const [formData, setFormData] = useState({
        email:'',
        password:'',
        whoAreYou: '',
    })

    const navigate = useNavigate();

    const changed = (e) =>{
        const {name, value} = e.target;
        setFormData({...formData, [name]: value});
    }

    const submit = async (e) =>{
        e.preventDefault();
        try
        {
            const response = await axios.post("http://localhost:8080/user/signin", formData);
            console.log("formData : ", formData);
            console.log(response.data);
            if (response.data)
            {
                alert("로그인에 성공했습니다!");
                navigate('/');
            }
            else
            {
                alert("이메일 혹은 비밀번호가 틀렸습니다");
                return;
            }
        }catch (error){
            console.error("Error signin form", error);
        }
    }

    return (
        <form onSubmit={submit}>
            <label>
                <input type={"text"} name={"email"} placeholder={"EMAIL"} value={formData.email}
                       onChange={changed}/>
                <br/>
                <input type={"password"} name={"password"} placeholder={"PASSWORD"} value={formData.password}
                       onChange={changed}/>
                <br/>
                <input type={"radio"} value={"user"} name={"whoAreYou"} checked={formData.whoAreYou = 'user'}
                       onChange={changed}/> User
                <input type={"radio"} value={"admin"} name={"whoAreYou"} checked={formData.whoAreYou = 'admin'}
                       onChange={changed}/> Admin
                <br/>
            </label>
            <button type={"submit"}>Sign In</button>
        </form>

    );
};

export default SignIn;