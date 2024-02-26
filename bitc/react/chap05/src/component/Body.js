import { useState, useRef } from 'react';

function Body({ children }) {
    const [state, setState] = useState({
        name: '',
        gender: '',
        birth: '',
        bio: '',
    });
    const handleOnChange = (e) => {
        console.log('현재 수정 대상:', e.target.name);
        console.log('수정값:', e.target.value);
        setState({
            ...state,
            [e.target.name]: e.target.value,
        });
    };

    // const [text, setText] = useState('');
    // const textRef = useRef();
    // const handleOnChange = (e) => {
    //     setText(e.target.value);
    // };
    // const handleOnClick = () => {
    //     if (text.length < 5) {
    //         textRef.current.focus();
    //     } else {
    //         alert(text);
    //         setText('');
    //     }
    // };

    return (
        <div>
            <div>
                <input name="name" placeholder="이름" value={state.name} onChange={handleOnChange} />
            </div>
            <div>
                <select name="gender" value={state.gender} onChange={handleOnChange}>
                    <option key={''}></option>
                    <option key={'남성'}>남성</option>
                    <option key={'여성'}>여성</option>
                </select>
            </div>
            <div>
                <input name="birth" type="date" value={state.birth} onChange={handleOnChange} />
            </div>
            <div>
                <textarea name="bio" value={state.bio} onChange={handleOnChange} />
            </div>
        </div>

        // <div>
        //     <input ref={textRef} value={text} onChange={handleOnChange} />
        //     <button onClick={handleOnClick}>작성완료</button>
        //     <div>{children}</div>
        //     <div>{text}</div>
        // </div>
    );
}

export default Body;
