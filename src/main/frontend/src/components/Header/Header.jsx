import { Link } from "react-router-dom"
import React, {useContext} from 'react'
import './Header.css'
import {LoginContext} from "../../contexts/LoginContextProvider";

const Header = () => {
    //isLogin : 로그인 여부 T F
    const {isLogin, login, logout} = useContext(LoginContext)
    return (
        <header>
            <div className={"logo"}>
                <Link to="/">
                    LimJaeHyeon
                </Link>
            </div>

            <div className={"util"}>
                {
                    !isLogin
                    ?
                    //     비로그인 시
                    <ul>
                        <li><Link to="/login">SIGN IN</Link></li>
                        <li><Link to="/join">SIGN UP</Link></li>
                    </ul>
                    :
                    //     로그인 시
                    <ul>
                        <li><Link to="/user">MY PAGE</Link></li>
                        <li>
                            <button className="link" onClick={()=>logout()}>SIGN OUT</button>
                        </li>
                    </ul>
                }
            </div>
        </header>
    )
}

export default Header;
