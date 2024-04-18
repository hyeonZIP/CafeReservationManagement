import React from 'react'
import './JoinForm.css'
const JoinForm = ({join}) => {

    const onJoin=(e)=>{

        e.preventDefault()

        const form = e.target
        const username = form.username.value
        const password = form.password.value
        const realname = form.realname.value

        console.log(username, password, realname);

        join({username, password, realname})
    }
    return (
        <div className={"form"}>
            <h2 className={"login-title"}>Join</h2>

            <form className={"login-form"} onSubmit={(e) => onJoin(e)}>
                <div>
                    <label htmlFor={"name"}>Email</label>
                    <input type={"text"}
                           id={"email"}
                           placeholder={"EMAIL"}
                           name={"username"}
                           required/>
                </div>
                <div>
                    <label htmlFor={"name"}>Password</label>
                    <input type={"password"}
                           id={"password"}
                           placeholder={"PASSWORD"}
                           name={"password"}
                           required/>
                </div>
                <div>
                    <label htmlFor={"name"}>Password Check</label>
                    <input type={"password"}
                           id={"passwordCheck"}
                           placeholder={"PASSWORD CHECK"}
                           name={"passwordCheck"}
                           required/>
                </div>
                <div>
                    <label htmlFor={"name"}>Username</label>
                    <input type={"text"}
                           id={"passwordCheck"}
                           placeholder={"USER NAME"}
                           name={"realname"}
                           required/>
                </div>
                <button type={"submit"} className={"btn btn---form btn-login"}>
                    Join
                </button>
            </form>
        </div>

    );
};

export default JoinForm;