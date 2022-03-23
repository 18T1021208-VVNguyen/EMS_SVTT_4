import "./App.css";
import Navbar1 from "./components/Navbar1";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import Trangchu from "./components/pages/Trangchu";
import DangkytiemEdit from "./components/pages/DangkytiemEdit";
import Hosocanhan from "./components/pages/Hosocanhan";
import Lichsutiem from "./components/pages/Lichsutiem";
import Dangxuat from "./components/pages/Dangxuat";
import Dangkytiem from "./components/pages/Dangkytiem";

function App() {
  return (
    <Router>
      <Navbar1 />
      <Routes>
        <Route path="/" exact element={<Trangchu />} />
        <Route path="/dang-ky-tiem" exact element={<Dangkytiem />} />
        {/* <Route path="/dang-ky-tiem-edit" exact element={<DangkytiemEdit />} /> */}
        <Route path="/dang-ky-tiem-edit" exact element={<DangkytiemEdit />} />
        <Route path="/ho-so-ca-nhan" exact element={<Hosocanhan />} />
        <Route path="/lich-su-tiem" exact element={<Lichsutiem />} />
        <Route path="/dang-xuat" exact element={<Dangxuat />} />
      </Routes>
    </Router>
  );
}

export default App;
