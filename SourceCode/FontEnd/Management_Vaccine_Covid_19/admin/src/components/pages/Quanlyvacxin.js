import React, { useState } from "react";
import { FaUndo, FaRegCheckCircle } from "react-icons/fa";
import "./css/quanlyvacxin.css";

export default function Quanlyvacxin() {
  const [myVacxin, setMyVacXin] = useState("Loại 1");

  const handleChange = (event) => {
    setMyVacXin(event.target.value);
  };
  return (
    <div className="container">
      <h2 className="header-name"> Sửa thông tin vacxin </h2>
      <form>
        <div className="form-input">
          <div className="infomation-input">
            <p>
              Mã vacxin <b className="important">(*):</b>
            </p>
            <input
              type="text"
              className="ma-input info-vacxin"
              placeholder="VC01"
              readOnly
            />
          </div>
          <div className="infomation-input">
            <p>
              Loại vacxin <b className="important">(*):</b>
            </p>
            <form className="category-vacxin">
              <select
                value={myVacxin}
                onChange={handleChange}
                className="info-vacxin"
              >
                <option value="Loại 1">Loại 1</option>
                <option value="Loại 2">Loại 2</option>
                <option value="Loại 3">Loại 3</option>
                <option value="Loại 4">Loại 4</option>
              </select>
            </form>
          </div>
          <div className="infomation-input">
            <p>
              Tên vacxin <b className="important">(*):</b>
            </p>
            <input type="text" className="ma-input info-vacxin" required/>
          </div>
        </div>

        <div className="form-input">
          <div className="infomation-input">
            <p>
              Ngày hết hạn <b className="important">(*):</b>
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
              Nhà sản xuất <b className="important">(*):</b>
            </p>
            <input type="text" className="ma-input info-vacxin" required />
          </div>
          <div className="infomation-input">
            <p>Mô tả :</p>
            <textarea type="text" className="ma-input note-vacxin" />
          </div>
        </div>

        {/* Button */}
        <div className="btn-vacxin">
          <button className="reset-btn btn-format">
            <FaUndo />
            <i className="text-btn">Nhập lại</i>
          </button>
          <button className="update-btn btn-format">
            <FaRegCheckCircle />
            <i className="text-btn">Cập nhật</i>
          </button>
        </div>
      </form>
    </div>
  );
}
