import React, {useContext} from 'react'
import './LoginForm.css'
import {LoginContext} from "../../contexts/LoginContextProvider";
const LoginForm = () => {

    const{ login } = useContext(LoginContext)
    const onLogin=(e)=>{
        e.preventDefault()

        const form = e.target
        const username = form.username.value
        const password = form.password.value

        login( username, password)
    }
    return (
        <div className={"form"}>
            <h2 className={"login-title"}>Login</h2>

            <form className={"login-form"} onSubmit={(e) => onLogin(e)}>
                <div>
                    <label htmlFor={"name"}>email</label>
                    <input type={"text"}
                           id={"username"}
                           placeholder={"EMAIL"}
                           name={"username"}
                           required/>
                </div>
                <div>
                    <label htmlFor={"name"}>password</label>
                    <input type={"password"}
                           id={"password"}
                           placeholder={"PASSWORD"}
                           name={"password"}
                           required/>
                </div>
                    <button type={"submit"} className={"btn btn---form btn-login"}>
                        Login
                    </button>
            </form>
        </div>

    );
};

export default LoginForm;