import {BrowserRouter, Route, Routes} from "react-router-dom";
import Home from "./pages/Home";
import Login from "./pages/Login";
import Join from "./pages/Join";
import User from "./pages/User";
import LoginContextProvider from "./contexts/LoginContextProvider";
function App() {
  return (
      // context와 props의 차이가 뭘까?
      <BrowserRouter>
          <LoginContextProvider>
              <Routes>
                  <Route path="/" element={<Home/>}></Route>
                  <Route path="/login" element={<Login/>}></Route>
                  <Route path="/join" element={<Join/>}></Route>
                  <Route path="/user" element={<User/>}></Route>
              </Routes>
          </LoginContextProvider>
      </BrowserRouter>
  )
}
export default App;