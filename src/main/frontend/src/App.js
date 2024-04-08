import { Route, Routes} from "react-router-dom";
import SignUp from "./routes/SignUp";
import SignIn from "./routes/SignIn";
import Home from "./routes/Home";
import CreateAdmin from "./routes/CreateAdmin";
function App() {


  return (
          <Routes>
            <Route path="/" element={<Home/>}/>
            <Route path="/signup" element={<SignUp/>}/>
            <Route path="/signin" element={<SignIn/>}/>
            <Route path="/createAdmin" element={<CreateAdmin/>}/>
          </Routes>
  )
}

export default App;