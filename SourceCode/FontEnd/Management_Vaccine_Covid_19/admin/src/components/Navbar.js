import React, { useState } from "react";
import { Button } from "./Button";
import { Link } from "react-router-dom";
import "./Navbar.css";
import Dropdown from "./Dropdown";

function Navbar() {
  const [click, setClick] = useState(false);
  const [dropdown, setDropdown] = useState(false);

  const handleClick = () => setClick(!click);
  const closeMobileMenu = () => setClick(false);

  const onMouseEnter = () => {
    if (window.innerWidth < 960) {
      setDropdown(false);
    } else {
      setDropdown(true);
    }
  };

  const onMouseLeave = () => {
    if (window.innerWidth < 960) {
      setDropdown(false);
    } else {
      setDropdown(false);
    }
  };

  return (
    <>
      <nav className="navbar">
        <Link to="/" className="navbar-logo" onClick={closeMobileMenu}>
          <img
            src="https://tiemchungcovid19.gov.vn/assets/portal/img/u7.png"
            alt="covid19"
            width="50px"
          />
        </Link>
        <Link to="/" className="navbar-logo" onClick={closeMobileMenu}>
          <h1
            style={{
              fontSize: "16px",
              width: "270px",
              alignItems: "center",
              textAlign: "center",
              color: "#ff0000",
            }}
          >
            CỔNG THÔNG TIN PHÒNG COVID19 TỈNH THỪA THIÊN HUẾ
          </h1>
        </Link>
        <div className="menu-icon" onClick={handleClick}>
          <i className={click ? "fas fa-times" : "fas fa-bars"} />
        </div>
        <ul className={click ? "nav-menu active" : "nav-menu"}>
          <li className="nav-item">
            <Link to="/" className="nav-links" onClick={closeMobileMenu}>
              Trang chủ
            </Link>
          </li>

          <li className="nav-item">
            <Link
              to="/quan-ly-vacxin-index"
              className="nav-links"
              onClick={closeMobileMenu}
            >
              Quản lý vacxin
            </Link>
          </li>
          <li className="nav-item">
            <Link
              to="/quan-ly-loai-vacxin-index"
              className="nav-links"
              onClick={closeMobileMenu}
            >
              Quản lý loại vacxin
            </Link>
          </li>
          <li
            className="nav-item"
            onMouseEnter={onMouseEnter}
            onMouseLeave={onMouseLeave}
          >
            <Link
              to="/danh-sach-dang-ky-tiem"
              className="nav-links"
              onClick={closeMobileMenu}
            >
              Quản lý danh sách <i className="fas fa-caret-down" />
            </Link>
            {dropdown && <Dropdown />}
          </li>

          <li className="nav-item">
            <Link
              to="/quan-ly-lich-tiem-index"
              className="nav-links"
              onClick={closeMobileMenu}
            >
              Quản lý lịch tiêm
            </Link>
          </li>
          <li>
            <Link
              to="/dang-ky"
              className="nav-links-mobile"
              onClick={closeMobileMenu}
            >
              Đăng ký
            </Link>
          </li>
        </ul>
        <Button />
      </nav>
    </>
  );
}

export default Navbar;
