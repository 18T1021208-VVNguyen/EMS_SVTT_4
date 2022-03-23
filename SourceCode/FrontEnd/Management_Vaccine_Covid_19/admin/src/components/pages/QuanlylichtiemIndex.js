import React, { useState } from "react";
import { FaUndo, FaPlusCircle, FaRegEdit, FaTrashAlt } from "react-icons/fa";
import "./css/quanlyvacxin.css";
import { Table } from "react-bootstrap";
import { Link } from "react-router-dom";

export default function QuanlylichtiemIndex() {
  const [myHuyen, setMyHuyen] = useState("Quảng Điền");
  const [myXa, setMyXa] = useState("Quảng Phú");
  const [myVaccine, setMyVacXin] = useState("Vaccine1");

  const handleChange = (event) => {
    setMyHuyen(event.target.value);
    setMyXa(event.target.value);
    setMyVacXin(event.target.value);
  };
  return (
    <div className="container">
      <h2 className="header-name"> Quản lý lịch tiêm</h2>
      <form>
        <div className="form-input">
          <div className="infomation-input">
            <p>
              Ngày tiêm <b className="important">(*):</b>
            </p>
            <form action="">
              <input
                type="datetime-local"
                id="birthdaytime"
                name="birthdaytime"
                className="info-vacxin"
              />
            </form>
          </div>
          <div className="infomation-input">
            <p>
              Huyện <b className="important">(*):</b>
            </p>
            <form className="category-vacxin">
              <select
                value={myHuyen}
                onChange={handleChange}
                className="info-vacxin"
              >
                <option value="Quảng Điền">Quảng Điền</option>
                <option value="Phong Điền">Phong Điền</option>
                <option value="Thành phố Huế">Thành phố Huế</option>
                <option value="Thị xã Hương Trà">Thị xã Hương Trà</option>
              </select>
            </form>
          </div>
          <div className="infomation-input">
            <p>
              Xã <b className="important">(*):</b>
            </p>
            <form className="category-vacxin">
              <select
                value={myXa}
                onChange={handleChange}
                className="info-vacxin"
              >
                <option value="Quảng Phú">Quảng Phú</option>
                <option value="Quảng Vinh">Quảng Vinh</option>
                <option value="Quảng Lợi">Quảng Lợi</option>
                <option value="Quảng Công">Quảng Công</option>
              </select>
            </form>
          </div>
        </div>

        <div className="form-input">
          <div className="infomation-input">
            <p>
              Điạ điểm tiêm <b className="important">(*):</b>
            </p>
            <input type="text" className="ma-input info-vacxin"/>
          </div>
          <div className="infomation-input">
            <p>
              Tên vắc xin<b className="important">(*):</b>
            </p>
            <form className="category-vacxin">
              <select
                value={myVaccine}
                onChange={handleChange}
                className="info-vacxin"
              >
                <option value="Vaccine1">Vaccine1</option>
                <option value="Vaccine2">Vaccine2</option>
                <option value="Vaccine3">Vaccine3</option>
                <option value="Vaccine4">Vaccine14</option>
              </select>
            </form>
          </div>
          
        </div>

        {/* Button */}
        <div className="btn-vacxin">
          <button className="reset-btn btn-format">
            <FaUndo />
            <i className="text-btn">Nhập lại</i>
          </button>
          <button className="update-btn btn-format">
            <FaPlusCircle />
            <i className="text-btn">Tạo lịch</i>
          </button>
        </div>
       </form>
      <div className="table-vacxin">
        <Table id="customer">
          <thead>
            <tr>
              <th>STT</th>
              <th>Huyện</th>
              <th>Xã</th>
              <th>Địa điểm tiêm</th>
              <th>Thời gian tiêm</th>
              <th>Tên vắc xin</th>
              <th>Action</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>1</td>
              <td>Quảng Điền</td>
              <td>Quảng Vinh </td>
              <td>Trạm y tế </td>
              <td>23/3/2022 - 9h30</td>
              <td>Pfize</td>
              <td>
                <div className="action">
                  <Link to="/quan-ly-lich-tiem-edit">
                    <button className="edit-btn">
                      <FaRegEdit />
                    </button>
                  </Link>
                  <button className="delete-btn">
                    <FaTrashAlt />
                  </button>
                </div>
              </td>
            </tr>
            <tr>
              <td>2</td>
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
            </tr>
            <tr>
              <td>4</td>
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
            </tr>
          </tbody>
        </Table>
      </div>
    </div>
  );
}
