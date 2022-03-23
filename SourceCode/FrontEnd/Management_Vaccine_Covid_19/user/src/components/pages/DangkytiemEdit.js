import React from "react";
import { FaTrash } from "react-icons/fa";
import "./css/dangkytiemedit.css";
import { Table } from "react-bootstrap";
import { Link } from "react-router-dom";

export default function DangkytiemEdit() {
  return (
    <div className="container">
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
          Mũi vừa tiêm
        </div>
        <Table id="customer">
          <thead>
            <tr>
              <th>Mũi tiêm</th>
              <th>Địa điểm tiêm</th>
              <th>Ngày tiêm</th>
              <th>Tên Vacxin</th>
              <th>Trạng thái</th>
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
                  <button className="huy-dang-ky-btn">
                    <FaTrash /> Hủy đăng ký
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
          </tbody>
        </Table>
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
            marginTop: "32px",
          }}
        >
          Lịch sử đăng ký
        </div>
        <Table id="customer">
          <thead>
            <tr>
              <th>Mũi tiêm</th>
              <th>Địa điểm tiêm</th>
              <th>Ngày tiêm</th>
              <th>Tên Vacxin</th>
              <th>Trạng thái</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>1</td>
              <td>Trạm y tế xã Quảng Phú</td>
              <td>2h - 10/2/2022</td>
              <td>COVID-19 Vaccine Moderna</td>
              <td>Đã tiêm</td>
            </tr>
            <tr>
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
            </tr>
          </tbody>
        </Table>
      </div>
    </div>
  );
}
