import './App.css';
import { useState, useRef } from 'react';
import Header from './component/Header';
import TodoEditor from './component/TodoEditor';
import TodoList from './component/TodoList';

const mockTodo = [
    {
        id: 0,
        isDone: false,
        content: 'React 공부하기',
        createdDate: new Date().getTime(),
    },
    {
        id: 1,
        isDone: false,
        content: '빨래 널기',
        createdDate: new Date().getTime(),
    },
    {
        id: 2,
        isDone: false,
        content: '노래 연습하기',
        createdDate: new Date().getTime(),
    },
];

function App() {
    const [todos, setTodo] = useState(mockTodo);
    const idRef = useRef(3);

    // 추가
    const onCreate = (content) => {
        const newItem = {
            id: idRef.current,
            isDone: false,
            content,
            createdDate: new Date().getTime(),
        };

        console.log('newItem:', newItem);
        setTodo([newItem, ...todos]);
        idRef.current += 1;
        console.log('todo:', todos);
    };

    // 수정
    const onUpdate = (targetId) => {
        setTodo(todos.map((todo) => (todo.id === targetId ? { ...todo, isDone: !todo.isDone } : todo)));
    };

    // 삭제
    const onDelete = (targetId) => {
        setTodo(todos.filter((todo) => todo.id !== targetId));
    };

    return (
        <div className="App">
            <Header />
            <TodoEditor onCreate={onCreate} />
            <TodoList todos={todos} onUpdate={onUpdate} onDelete={onDelete} />
        </div>
    );
}

export default App;
