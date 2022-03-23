import React from "react";
import { FaUndo, FaRegEdit, FaTrashAlt, FaPlusCircle } from "react-icons/fa";
import "./css/quanlyloaivacxin.css";
import { Table } from "react-bootstrap";
import { Link } from "react-router-dom";

export default function Quanlyloaivacxin() {
  return (
    <>
      <div className="container">
        <h2 className="header-name"> Quản lý loại vacxin </h2>
        <form>
          <div className="form-input-vacxin">
            <div className="vacxin-input">
              <p>
                Mã loại vacxin <b className="key-important">(*):</b>
              </p>
              <input
                type="text"
                className="ma-input info-loai-vacxin"
                placeholder="Nhập mã loại"
                required
              />
            </div>

            <div className="vacxin-input">
              <p>
                Tên loại vacxin <b className="key-important">(*):</b>
              </p>
              <input 
                type="text" 
                placeholder="Nhập tên loại"
                className="ma-input info-loai-vacxin" 
                required />
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
              <i className="text-btn">Thêm mới</i>
            </button>
          </div>
        </form>

        {/* table */}

        <div className="table-vacxin">
          <Table id="customer">
            <thead>
              <tr>
                <th>STT</th>
                <th>Loại Vacxin</th>
                <th>Tên loại Vacxin</th>
                <th>Action</th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <td>1</td>
                <td></td>
                <td></td>
                <td>
                  <div className="action">
                    <Link to="/quan-ly-loai-vacxin-edit">
                      <button className="edit-btn-loai">
                        <FaRegEdit />
                      </button>
                    </Link>
                    <button className="delete-btn-loai">
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
              </tr>
              <tr>
                <td>3</td>
                <td></td>
                <td></td>
                <td></td>
              </tr>
              <tr>
                <td>4</td>
                <td></td>
                <td></td>
                <td></td>
              </tr>
              <tr>
                <td>5</td>
                <td></td>
                <td></td>
                <td></td>
              </tr>
            </tbody>
          </Table>
        </div>
      </div>
    </>
  );
}
