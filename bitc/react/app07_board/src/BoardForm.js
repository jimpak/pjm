import { useState } from 'react';
import axios from 'axios';

const BoardForm = ({ insertBoard }) => {
    const [formContent, setFormContent] = useState({
        title: '',
        content: '',
    });
    const getValue = (e) => {
        setFormContent({
            ...formContent,
            [e.target.name]: e.target.value,
        });
    };
    const submitBoard = () => {
        axios
            .post('/api/insert', {
                title: formContent.title,
                content: formContent.content,
            })
            .then(() => {
                alert('등록완료');
                // listBoard();
            });
    };

    return (
        <div>
            <h3>BoardForm</h3>
            <input type="text" placeholder="제목" onChange={getValue} name="title" />
            <br />
            <br />
            <textarea name="content" cols="60" rows="10" onChange={getValue}></textarea>
            <br />
            <button onClick={submitBoard}>입력</button>
            <button onClick={() => insertBoard(formContent)}>입력(입력데이터만 추가)</button>
        </div>
    );
};

export default BoardForm;
