import "./App.css";
import Navbar from "./components/Navbar";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import Trangchu from "./components/pages/Trangchu";
import Quanlyvacxin from "./components/pages/Quanlyvacxin";
import Quanlyloaivacxin from "./components/pages/Quanlyloaivacxin";
import QuanlyloaivacxinIndex from "./components/pages/QuanlyloaivacxinIndex";
import Danhsachdangkytiem from "./components/pages/Danhsachdangkytiem";
import Danhsachdatiem from "./components/pages/Danhsachdatiem";
import Danhsachhuytiem from "./components/pages/Danhsachhuytiem";
import Quanlylichtiem from "./components/pages/Quanlylichtiem";
import SignUp from "./components/pages/SignUp";
import QuanlyvacxinIndex from "./components/pages/QuanlyvacxinIndex";
import QuanlylichtiemIndex from "./components/pages/QuanlylichtiemIndex";

function App() {
  return (
    <Router>
      <Navbar />
      <Routes>
        <Route path="/" exact element={<Trangchu />} />
        <Route
          path="/quan-ly-vacxin-index"
          exact
          element={<QuanlyvacxinIndex />}
        />
        <Route path="/quan-ly-vacxin-edit" exact element={<Quanlyvacxin />} />
        <Route
          path="/quan-ly-loai-vacxin-index"
          exact
          element={<QuanlyloaivacxinIndex />}
        />
        <Route
          path="/quan-ly-loai-vacxin-edit"
          exact
          element={<Quanlyloaivacxin />}
        />
        <Route
          path="/danh-sach-dang-ky-tiem"
          exact
          element={<Danhsachdangkytiem />}
        />

        <Route
          path="/quan-ly-lich-tiem-index"
          exact
          element={<QuanlylichtiemIndex />}
        />

        <Route
          path="/quan-ly-lich-tiem-edit"
          exact
          element={<Quanlylichtiem />}
        />
        <Route path="/danh-sach-da-tiem" exact element={<Danhsachdatiem />} />
        <Route path="/danh-sach-huy-tiem" exact element={<Danhsachhuytiem />} />
        <Route path="/quan-ly-lich-tiem" exact element={<Quanlylichtiem />} />
        <Route path="/dang-ky" exact element={<SignUp />} />
      </Routes>
    </Router>
  );
}

export default App;
