/* Home.js */
import React, {useState} from 'react';
import axios from "axios";

const CreateAdmin = () => {
    const [formData, setFormData] = useState({
        name:'',
        email:'',
        password:'',
        passwordConfirm:''
    })

    const changed = (e) =>{
        const {name, value} = e.target;
        setFormData({...formData, [name]: value});
    }

    const submit = async (e) =>{
        e.preventDefault();
        try
        {
            const response = await axios.post("http://localhost:8080/admin/signup", formData);
            console.log(response.data);
        }catch (error){
            console.error("Error signup form", error);
        }
    }

    return (
        <form onSubmit={submit}>
            <label>
                <input type={"text"} name={"email"} placeholder={"EMAIL"} value={formData.email} onChange={changed}/>
                <input type={"password"} name={"password"} placeholder={"PASSWORD"} value={formData.password}
                       onChange={changed}/>
                <input type={"password"} name={"passwordConfirm"} placeholder={"PASSWORD CONFIRM"}
                       value={formData.passwordConfirm} onChange={changed}/>
                <input type={"text"} name={"name"} value={formData.name} placeholder={"NAME"} onChange={changed}/>
            </label>
            <button type={"submit"}>Sign Up</button>
        </form>

    );
};

export default CreateAdmin;