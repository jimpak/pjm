import { useState } from 'react';

const Say = () => {
    const [message, setMessage] = useState('start');
    const [color, setColor] = useState('black');

    const onClickEnter = () => {
        setMessage('반갑습니다');
        setColor('blue');
    };

    const onClickLeave = () => {
        setMessage('안녕히가세요');
        setColor('green');
    };

    const changeColor = (color) => {
        setColor(color);
    };

    return (
        <div>
            {
                // 입장이면 message에 반갑습니다, 퇴장이면 message에 안녕히가세요.
            }
            <h1 style={{ color }}>{message}</h1>
            <button onClick={onClickEnter}>입장</button>
            <button onClick={onClickLeave}>퇴장</button>
            <button onClick={() => changeColor('red')}>빨강</button>
            <button onClick={() => changeColor('blue')}>파랑</button>
            <button onClick={() => changeColor('pink')}>핑크</button>
            <button onClick={() => changeColor('black')}>검정</button>
        </div>
    );
};

export default Say;
