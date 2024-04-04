import React, { useEffect, useState } from 'react';
import axios from 'axios';
import logo from './logo.svg';
import './App.css';

function App() {
  // const [data, setData] = useState('');
  // useEffect(() => {
  //   axios.get('/rp/react/data')
  //     .then(res => {
  //       console.log(res);
  //       setData(res.data);
  //     })
  //     .catch(err => {
  //       console.log(err);
  //     });
  // }, []);
  // const [user, setUser] = useState({});
  // useEffect(() => {
  //   axios.get('/rp/react/json')
  //     .then(res => { // 원래는 json 데이터를 풀어야 하나 여기선 받으면서 자동으로 풀어줌
  //       setUser(res.data);
  //       console.log(res);
  //     })
  //     .catch(err => console.log(err));
  // }, []);

  const [users, setUsers] = useState([{}]);
  const [isLoading, setIsLoading] = useState(true);

  useEffect(() => {
    axios.get('/rp/react/users')
      .then(res => {
        setUsers(res.data);
        //console.log(res);
      })
      .catch(err => {
        console.log(err);
      });
  })
  console.log(users);
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <h3>{isLoading ? '로딩중' : ''}</h3>
        {/* <h3>
          받아온 값: {data ? data : '받아온 값이 없습니다'}
        </h3> */}
        {/* <h3>
          사용자 정보: uid={user.uid}, uname={user.uname}
        </h3> */}
        <h3>
          {users.map((user, idx) => (
            <div key={idx}>{user.uid}, {user.uname}, {user.insta}, {user.email}, {user.github}</div>
          ))}
        </h3>
      </header>
    </div>
  );
}

export default App;
