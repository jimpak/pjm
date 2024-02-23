import logo from './logo.svg';
import './App.css';
import './css/Form.css';
import { Component } from 'react';
import TodoForm from './component/TodoForm';
import TodoList from './component/TodoList';

class App extends Component {
    id = 4;
    state = {
        input: '',
        todos: [
            { id: 0, text: '치킨먹기1', checked: false },
            { id: 1, text: '치킨먹기2', checked: true },
            { id: 2, text: '치킨먹기3', checked: false },
            { id: 3, text: '치킨먹기4', checked: true },
        ],
    };

    // 추가
    handleCreate = () => {
        const { input, todos } = this.state;
        this.setState({
            input: '',
            todos: todos.concat({
                id: this.id++,
                text: input,
                checked: false,
            }),
        });
    };

    // 엔터키로 추가
    handleKeyPress = (e) => {
        // 눌러진 키가 enter 라면
        if (e.key == 'Enter') {
            this.handleCreate();
        }
    };

    handleChange = (e) => {
        this.setState({
            input: e.target.value,
        });
    };

    // 삭제
    handleRemove = (id) => {
        const { todos } = this.state;
        const nextTodos = todos.filter((todo) => todo.id !== id);
        this.setState({
            todos: nextTodos,
        });
    };

    // 토글
    handleToggle = (id) => {
        // console.log('toggle id : ', id);
        const { todos } = this.state;
        const index = todos.findIndex((todo) => todo.id === id);
        const selected = todos[index];

        const nextTodos = [...todos];
        nextTodos[index] = {
            ...selected,
            checked: !selected.checked,
        };

        this.setState({
            todos: nextTodos,
        });
    };

    render() {
        return (
            <div className="todo-list">
                <TodoForm
                    value={this.state.input}
                    onCreate={this.handleCreate}
                    onChange={this.handleChange}
                    onKeyPress={this.handleKeyPress}
                />
                <TodoList todos={this.state.todos} onRemove={this.handleRemove} onToggle={this.handleToggle} />
            </div>
        );
    }
}

export default App;
