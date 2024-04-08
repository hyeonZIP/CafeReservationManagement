/* Home.js */
import { useNavigate } from "react-router-dom";
import React, {useState} from 'react';
import axios from "axios";


const SignUp = () => {
    const [formData, setFormData] = useState({
        name:'',
        email:'',
        password:'',
        passwordConfirm:''
    })

    const [isEmailDuple, setIsEmailDuple] = useState(true);
    const navigate = useNavigate();

    //입력 값이 바뀔 때 동작
    const changed = (e) =>{
        const {name, value} = e.target;
        setFormData({...formData, [name]: value});
        if (name === 'email')
        {
            //이메일을 새로 입력 할 때마다 중복검사 초기화
            setIsEmailDuple(true);
        }
    }
    const emailDupleCheck = async () =>{
        try
        {
            const response = await axios.post("http://localhost:8080/user/emailduple", {email : formData.email});

            if(response.data)
            {
                //true
                alert("이미 가입된 이메일입니다");
            }
            else
            {
                //false
                alert("가입 가능한 이메일입니다!");
                setIsEmailDuple(false);
            }
        }catch (error){

        }
    }

    const submit = async (e) =>{
        e.preventDefault();
        if (isEmailDuple)
        {
            alert("이메일 중복검사 해주세요");
            return;
        }
        try
        {
            const response = await axios.post("http://localhost:8080/user/signup", formData);
            console.log(response.data);
            alert("회원가입에 성공했습니다!");
            navigate('/');
        }catch (error){
            console.error("Error signup form", error);
        }
    }

    return (
        <form onSubmit={submit}>
            <label>
                <input type={"text"} name={"email"} placeholder={"EMAIL"} value={formData.email} onChange={changed}/>
                <button type={"button"} onClick={emailDupleCheck}>중복 검사</button>
                {!isEmailDuple && <span style={{ color: 'red' }}>중복된 이메일입니다.</span>}
                <br/>
                <input type={"password"} name={"password"} placeholder={"PASSWORD"} value={formData.password}
                       onChange={changed}/><br/>
                <input type={"password"} name={"passwordConfirm"} placeholder={"PASSWORD CONFIRM"}
                       value={formData.passwordConfirm} onChange={changed}/><br/>
                <input type={"text"} name={"name"} value={formData.name} placeholder={"NAME"} onChange={changed}/><br/>
            </label>
            <button type={"submit"}>Sign Up</button>
        </form>

    );
};

export default SignUp;