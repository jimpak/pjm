import './TodoEditor.css';
import { useState, useRef } from 'react';

const TodoEditor = ({ onCreate }) => {
    const [content, setContent] = useState('');
    const inputRef = useRef();

    // input에 value 입력
    const onChangeContent = (e) => {
        setContent(e.target.value);
    };

    // 추가 버튼 출릭
    const onSubmit = () => {
        if (!content) {
            inputRef.current.focus();
            return;
        }
        onCreate(content);
        setContent('');
    };

    return (
        <div className="TodoEditor">
            <h4>새로운 Todo 작성하기</h4>
            <div className="editor_wrapper">
                <input placeholder="새로운 Todo...." value={content} ref={inputRef} onChange={onChangeContent} />
                <button onClick={onSubmit}>추가</button>
            </div>
        </div>
    );
};

export default TodoEditor;
