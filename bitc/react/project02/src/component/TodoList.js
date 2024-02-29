import { useState } from 'react';
import TodoItem from './TodoItem';
import './TodoList.css';

const TodoList = ({ todos, onUpdate, onDelete }) => {
    // console.log(todos);
    const [search, setSearch] = useState('');
    const onChangeSearch = (e) => {
        setSearch(e.target.value);
    };
    const getSearchResult = () => {
        return search === ''
            ? todos
            : todos.filter((todo) => todo.content.toLowerCase().includes(search.toLowerCase()));
    };

    return (
        <div className="TodoList">
            <h3>TodoList</h3>
            <input onChange={onChangeSearch} value={search} className="searchbar" placeholder="검색어를 입력하세요" />
            <div className="list_wrapper">
                {
                    getSearchResult().map((todo) => {
                        return <TodoItem key={todo.id} onUpdate={onUpdate} onDelete={onDelete} {...todo} />;
                    })

                    // todos.map((todo) => {
                    //     return <TodoItem key={todo.id} onUpdate={onUpdate} onDelete={onDelete} {...todo} />;
                    // })
                }
            </div>
        </div>
    );
};

export default TodoList;
