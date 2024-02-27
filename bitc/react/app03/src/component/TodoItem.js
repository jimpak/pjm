import { Component } from 'react';
import '../css/TodoItem.css';

class TodoItem extends Component {
    render() {
        const { id, text, checked, onRemove, onToggle } = this.props;
        return (
            <div className="todo-item" onClick={() => onToggle(id)}>
                <div
                    className="remove"
                    onClick={(e) => {
                        e.preventDefault();
                        onRemove(id);
                    }}
                >
                    &times;
                </div>
                <div className={`todo-text ${checked && 'checked'}`}>
                    <div>{text}</div>
                </div>
                {checked && <div className="check-mark">&#x2713;</div>}
            </div>
        );
    }
}

export default TodoItem;