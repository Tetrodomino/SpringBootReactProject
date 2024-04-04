import React, { useState } from 'react';
import axios from 'axios';
import './App.css';

function App() {

  const [form, setForm] =  useState({uid: '', uname: ''});
  const handleChange = (event) => {
    const { name, value} = event.target; // input의 값을 가져옴
    setForm({...form, [name]: value}) // input의 값에 따라 form의 값 변경
  }
  const handleSubmit = (event) => {
    event.preventDefault();
    const params = new URLSearchParams(); // form의 데이터를 파라메터로 전달하기 위해 필요
    params.append('uid', form.uid);
    params.append('uname', form.uname);
    console.log(params);
    axios.post('/rp/react/form', params) // params를 다른 주소에 보내기
      .then(res => {
        console.log(res);
      });
  }

  return (
    <div className="App">
      <form onSubmit={handleSubmit}>
        <label htmlFor='uid'>id: </label>
        <input type="text" id="uid" name="uid" value={form.uid}
        onChange={handleChange}
        /> <br />
        <label htmlFor='uname'>이름: </label>
        <input type="text" id="uname" name="uname" value={form.uname}
        onChange={handleChange}
        /> <br />
        <button>제출</button>
      </form>
    </div>
  );
}

export default App;
