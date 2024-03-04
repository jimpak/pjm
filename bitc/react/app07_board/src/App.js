import { useEffect, useState } from 'react';
import './App.css';
import BoardForm from './BoardForm';
import BoardList from './BoardList';
import axios from 'axios';

function App() {
    const [listContent, setListContent] = useState([]);

    // 삭제
    const deleteBoard = (num) => {
        axios.delete('/api/delete/' + num, {}).then(() => {
            alert('삭제 성공');
            setListContent(listContent.filter((board) => board.num !== num));
        });
    };

    // 전체보기
    const listBoard = () => {
        axios.get('/api/list').then((resp) => {
            console.log(resp.data);
            setListContent(resp.data);
        });
    };

    // 추가하기
    const insertBoard = (data) => {
        console.log('추가 데이터 : ', data);
        axios
            .post('/api/insert', {
                title: data.title,
                content: data.content,
            })
            .then((resp) => {
                console.log('resp : ', resp);
                setListContent(
                    listContent.concat({
                        num: resp.data.num,
                        title: resp.data.title,
                        content: resp.data.content,
                    })
                );
            });
    };

    // BoardList 컴포넌트가 마운트 될 때 자동으로 listBoard 함수 실행
    useEffect(() => {
        listBoard();
    }, []);

    return (
        <div className="App">
            <h1>app07_board</h1>
            <hr />
            <BoardForm insertBoard={insertBoard} />
            <BoardList list={listContent} deleteBoard={deleteBoard} />
        </div>
    );
}

export default App;
