import React, { useState } from "react";
import { Table } from "react-bootstrap";
// import { Link } from "react-router-dom";
import "./css/danhsachdangkytiem.css";
export default function Danhsachhuytiem() {
  const [myhuyen, setMyHuyen] = useState("Quảng Điền");
  const [myxa, setMyXa] = useState("Quảng Phú");
  const [myngaytiem, setNgayTiem] = useState("10/03/2022");

  const handleChange1 = (event) => {
    setMyHuyen(event.target.value);
  };
  const handleChange2 = (event) => {
    setMyXa(event.target.value);
  };
  const handleChange3 = (event) => {
    setNgayTiem(event.target.value);
  };
  return (
    <div className="container">
      <h2 className="header-name"> Danh sách hủy tiêm </h2>
      <div className="form-input-danh-sach">
        <div className="danh-sach-input">
          <p>Huyện</p>
          <form className="category-vacxin">
            <select
              value={myhuyen}
              onChange={handleChange1}
              className="info-danh-sach"
            >
              <option value="Loại 1">Quảng Điền</option>
              <option value="Loại 2">Phong Điền</option>
              <option value="Loại 3">TT Sịa</option>
              <option value="Loại 4">Phú Lộc</option>
            </select>
          </form>
        </div>
        <div className="danh-sach-input">
          <p>Xã</p>
          <form className="category-vacxin">
            <select
              value={myxa}
              onChange={handleChange2}
              className="info-danh-sach"
            >
              <option value="Loại 1">Quảng Phú</option>
              <option value="Loại 2">Quảng Vinh</option>
              <option value="Loại 3">An Lỗ</option>
              <option value="Loại 4">Phú Lễ</option>
            </select>
          </form>
        </div>
        <div className="danh-sach-input">
          <p>Ngày tiêm</p>
          <form className="category-vacxin">
            <select
              value={myngaytiem}
              onChange={handleChange3}
              className="info-danh-sach"
            >
              <option value="Loại 1">10/03/2022</option>
              <option value="Loại 2">20/03/2022</option>
              <option value="Loại 3">01/04/2022</option>
              <option value="Loại 4">15/04/2022</option>
            </select>
          </form>
        </div>
      </div>

      <div>
        <p className="name-list">Danh sách</p>
      </div>

      {/* Button */}
      {/* <div className="btn-vacxin">
        <div className="reset-btn btn-format">
          <FaUndo />
          <i className="text-btn">Nhập lại</i>
        </div>
        <div className="update-btn btn-format">
          <FaPlusCircle />
          <i className="text-btn">Cập nhật</i>
        </div>
      </div> */}
      <div className="table-vacxin">
        <Table id="customer">
          <thead>
            <tr>
              <th>STT</th>
              <th>Họ và tên</th>
              <th>CMND/CCCD</th>
              <th>Số điện thoại</th>
              <th>Mũi tiêm</th>
              <th>Huyện</th>
              <th>Xã</th>
              <th>Địa điểm tiêm</th>
              <th>Ngày tiêm</th>
              <th>Tên vacxin</th>
              <th>Trạng thái</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>1</td>
              <td>Hồ Xuân Nhật Minh</td>
              <td>191996500</td>
              <td>0795948755</td>
              <td>Mũi 1</td>
              <td>Quảng Điền</td>
              <td>Quảng Vinh</td>
              <td>Trạm y tế Xã Quảng Vinh</td>
              <td>21/3/2022 - 9h30</td>
              <td>Pfize</td>
              <td>Huỷ tiêm</td>
            </tr>
            <tr>
              <td>2</td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
            </tr>
            <tr>
              <td>3</td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
            </tr>
            <tr>
              <td>4</td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
            </tr>
            <tr>
              <td>5</td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
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
