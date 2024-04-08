/* Header.js */
import React from 'react';
import {Link} from "react-router-dom";

const Header = () => {
    return (
        <header>
            <Link to="/">Home</Link>
            &nbsp;&nbsp; | &nbsp;&nbsp;
            <Link to="/signup">Sign Up</Link>
            &nbsp;&nbsp; | &nbsp;&nbsp;
            <Link to="/signin">Sign In</Link>
            &nbsp;&nbsp; | &nbsp;&nbsp;
            <Link to="/createAdmin">CafeAdmin생성하기 개발용</Link>
            <hr/>
        </header>
    );
};

export default Header;