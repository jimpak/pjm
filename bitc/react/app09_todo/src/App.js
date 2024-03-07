import { useEffect, useState } from 'react';
import './App.css';
import TodoForm from './TodoForm';
import TodoList from './TodoList';
import axios from 'axios';

function App() {
    const [listContent, setListContent] = useState([]);

    // 삭제
    const deleteTodo = (num) => {
        axios.delete('/api/delete/' + num, {}).then(() => {
            alert('삭제 성공');
            setListContent(listContent.filter((todo) => todo.num !== num));
        });
    };

    // 추가하기
    const insertTodo = (data) => {
        console.log('추가 데이터 : ', data);
        axios
            .post('/api/insert', {
                name: data.name,
                subject: data.subject,
                summary: data.summary,
            })
            .then((resp) => {
                console.log('resp : ', resp);
                setListContent(
                    listContent.concat({
                        name: resp.data.name,
                        subject: resp.data.subject,
                        summary: resp.data.summary,
                    })
                );
            });
    };

    // 전체보기
    const listTodo = () => {
        axios.get('/api/list').then((resp) => {
            console.log(resp.data);
            setListContent(resp.data);
        });
    };

    useEffect(() => {
        listTodo();
    }, []);

    return (
        <div className="App">
            <TodoForm insertTodo={insertTodo} />
            <TodoList list={listContent} deleteTodo={deleteTodo} />
        </div>
    );
}

export default App;
