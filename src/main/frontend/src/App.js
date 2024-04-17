import {BrowserRouter, Route, Routes} from "react-router-dom";
import Home from "./pages/Home";
import Login from "./pages/Login";
import Join from "./pages/Join";
import User from "./pages/User";
import Reserve from "./pages/Reserve";
import LoginContextProvider from "./contexts/LoginContextProvider";
import Beverage from "./pages/Beverage";
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
                  <Route path="/reserve" element={<Reserve/>}></Route>
                  <Route path="/beverage" element={<Beverage/>}></Route>
              </Routes>
          </LoginContextProvider>
      </BrowserRouter>
  )
}
export default App;