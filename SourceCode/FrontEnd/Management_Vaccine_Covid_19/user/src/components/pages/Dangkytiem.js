import React, { useState } from "react";
import { FaSyringe } from "react-icons/fa";
import "./css/dangkytiem.css";
import { Table } from "react-bootstrap";
import { Link } from "react-router-dom";

export default function Dangkytiem() {
  const [muitiem, setMuiTiem] = useState("1");
  const [huyen, setHuyen] = useState("Quảng Điền");
  const [xa, setXa] = useState("Quảng Phú");

  const handleChange = (event) => {
    setMuiTiem(event.target.value);
  };
  const handleChange1 = (event) => {
    setHuyen(event.target.value);
  };
  const handleChange2 = (event) => {
    setXa(event.target.value);
  };
  return (
    <div className="container">
      <h2 className="header-name"> Đăng ký tiêm </h2>
      <div className="form-input">
        <div>
          <p style={{ color: "red" }}>
            Chú ý: Nếu bạn chưa khai báo lịch sử tiêm vui lòng cập nhật.
            <u style={{ color: "blue" }}>Tại đây</u>
          </p>
        </div>
        <div>
          <p style={{ marginTop: "16px", marginBottom: "16px" }}>
            Mũi tiêm gần nhất: Mũi 3 - 2h30 - 15/03/2022
          </p>
        </div>

        <div className="infomation-input">
          <p>
            Mũi tiêm <b className="important">(*):</b>
          </p>
          <form className="category-vacxin">
            <select
              value={muitiem}
              onChange={handleChange}
              className="info-vacxin"
            >
              <option value="Loại 1">1</option>
              <option value="Loại 2">2</option>
              <option value="Loại 3">3</option>
              <option value="Loại 4">4</option>
            </select>
          </form>
        </div>
        <div className="infomation-input">
          <p>
            Huyện <b className="important">(*):</b>
          </p>
          <form className="category-vacxin">
            <select
              value={huyen}
              onChange={handleChange1}
              className="info-vacxin"
            >
              <option value="Loại 1">Quảng Điền</option>
              <option value="Loại 2">Phong Điền</option>
              <option value="Loại 3">Phú Lộc</option>
            </select>
          </form>
        </div>
        <div className="infomation-input">
          <p>
            Xã <b className="important">(*):</b>
          </p>
          <form className="category-vacxin">
            <select value={xa} onChange={handleChange2} className="info-vacxin">
              <option value="Loại 1">Quảng Phú</option>
              <option value="Loại 2">Quảng Vinh</option>
              <option value="Loại 3">An Lỗ</option>
              <option value="Loại 4">TT Sịa</option>
            </select>
          </form>
        </div>
      </div>
      <div className="table-vacxin">
        <div
          style={{
            padding: "8px",
            width: "200px",
            border: "1px solid #ccc",
            backgroundColor: "#4d4d4d",
            color: "white",
            textAlign: "center",
          }}
        >
          Danh sách lịch tiêm
        </div>
        <Table id="customer">
          <thead>
            <tr>
              <th>Huyện</th>
              <th>Xã</th>
              <th>Địa điểm tiêm</th>
              <th>Ngày bắt đầu tiêm</th>
              <th>Tên Vacxin</th>
              <th>Action</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
              <td>
                <Link to="/dang-ky-tiem-edit">
                  <button className="dang-ky-btn">
                    <FaSyringe /> Đăng ký
                  </button>
                </Link>
              </td>
            </tr>
            <tr>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
            </tr>
            <tr>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
            </tr>
            <tr>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
            </tr>
            <tr>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
            </tr>
          </tbody>
        </Table>
      </div>
    </div>
  );
}
