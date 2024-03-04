import { useState } from 'react';

const InsertBoard = ({ insertBoard }) => {
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

    return (
        <div>
            <h3>InsertBoard</h3>
            <input type="text" placeholder="제목" onChange={getValue} name="title" />
            <br />
            <br />
            <textarea name="content" cols="60" rows="10" onChange={getValue}></textarea>
            <br />
            <button onClick={() => insertBoard(formContent)}>입력</button>
        </div>
    );
};

export default InsertBoard;
