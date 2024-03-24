import './App.css';
import { BrowserRouter, NavLink, Route, Routes, Outlet, Link, useParams } from 'react-router-dom';
import React, { useState } from 'react';

function Home() {
    return (
        <div>
            <h2>여기는 Home 화면 입니다.</h2>
        </div>
    );
}

const contents = [
    { id: 1, title: 'HTML', desc: 'HTML 공부' },
    { id: 2, title: 'PYTHON', desc: 'PYTHON 공부' },
    { id: 3, title: 'BIGDATA', desc: 'BIGDATA 공부' },
];

function Topics() {
    const list = [];
    for (let i = 0; i < contents.length; i++) {
        list.push(
            <li key={contents[i].id}>
                <NavLink to={`/topics/${contents[i].id}`}>{contents[i].title}</NavLink>
            </li>
        );
    }
    return (
        <div>
            <h2>여기는 Topics 화면 입니다.</h2>
            <ul>{list}</ul>
            <Outlet></Outlet> {/* 하위 컴포넌트가 보여질 부분 */}
        </div>
    );
}

function Topic() {
    const { id } = useParams();
    return (
        <div>
            <h2>Topic화면 {id}</h2>
        </div>
    );
}

function Contact() {
    return (
        <div>
            <h2>여기는 Contact 화면 입니다.</h2>
        </div>
    );
}

function Login() {
    const [user, setUser] = useState({
        id: '',
        pw: '',
    });

    return (
        <div>
            <h2>여기는 Login 화면 입니다.</h2>
            아이디 :
            <input
                type="text"
                onChange={(e) => {
                    setUser({ id: e.target.value, pw: user.pw });
                }}
            />
            <br />
            비밀번호 :
            <input
                type="password"
                onChange={(e) => {
                    setUser({ id: user.id, pw: e.target.value });
                }}
            />
            <br />
            <Link to={`/login/result/${user.id}/${user.pw}`}>로그인</Link>
            <Outlet></Outlet>
        </div>
    );
}

function LoginResult() {
    const { id, pw } = useParams();
    console.log(`id: ${id}, pw: ${pw}`);

    return (
        <div>
            <p>아이디 : {id}</p>
            <p>비밀번호 : {pw}</p>
        </div>
    );
}

function App() {
    return (
        <div className="App">
            <BrowserRouter>
                <div>
                    <h1>react-router-dom 예제</h1>
                    <ul>
                        <li>
                            <NavLink to={'/'}>Home</NavLink>
                        </li>
                        <li>
                            <NavLink to={'/topics'}>Topics</NavLink>
                        </li>
                        <li>
                            <NavLink to={'/contact'}>Contact</NavLink>
                        </li>
                        <li>
                            <NavLink to={'/login'}>Login</NavLink>
                        </li>
                    </ul>
                </div>
                <Routes>
                    <Route path="/" element={<Home />}></Route>
                    <Route path="/topics/" element={<Topics />}>
                        <Route path=":id" element={<Topic />}></Route>
                    </Route>

                    <Route path="/contact" element={<Contact />}></Route>
                    <Route path="/login/" element={<Login />}>
                        <Route path="result/:id/:pw" element={<LoginResult />}></Route>
                    </Route>
                </Routes>
            </BrowserRouter>
        </div>
    );
}

export default App;
