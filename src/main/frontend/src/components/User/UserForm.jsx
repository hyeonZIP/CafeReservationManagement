import React, {useContext} from 'react'
import './UserForm.css'
import {LoginContext} from "../../contexts/LoginContextProvider";
const UserForm = ({userInfo, updateUser, deleteUser}) => {

    const onUpdate = (e) =>{
        e.preventDefault()

        const form = e.target;
        const idx = form.idx.value;
        const username = form.username.value;
        const password = form.password.value;
        const realname = form.realname.value;

        console.log(idx, username, password, realname);

        updateUser({idx, username, password, realname})
    }
    return (
        <div className={"form"}>
            <h2 className={"login-title"}>Join</h2>

            <form className={"login-form"} onSubmit={(e) => onUpdate(e)}>
                <div className={"disabled-component"}>
                    <label htmlFor={"name"}>idx</label>
                    <input type={"text"}
                           id={"idx"}
                           name={"idx"}
                           defaultValue={userInfo?.idx}/>
                </div>
                <div>
                    <label htmlFor={"name"}>Email</label>
                    <input type={"text"}
                           id={"username"}
                           placeholder={"EMAIL"}
                           name={"username"}
                           required
                           readOnly
                           defaultValue={userInfo?.username}/>
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
                    <label htmlFor={"name"}>Username</label>
                    <input type={"text"}
                           id={"realname"}
                           placeholder={"USER NAME"}
                           name={"realname"}
                           required
                           defaultValue={userInfo?.realname}/>
                </div>
                <button type={"submit"} className={"btn btn--form btn-login"}>
                    Update
                </button>
                <button type={"submit"} className={"btn btn--form btn-login"} onClick={() => deleteUser(userInfo?.idx)}>
                    Delete
                </button>
            </form>
        </div>

    );
};

export default UserForm;