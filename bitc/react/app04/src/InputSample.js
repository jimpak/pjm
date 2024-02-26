import { useState } from 'react';

const InputSample = () => {
    const [inputs, setInputs] = useState({
        name: '',
        nickname: '',
        phone: '',
    });
    const onChange = (e) => {
        setInputs({
            ...inputs,
            [e.target.name]: e.target.value,
        });
    };
    const onReset = () => {
        setInputs({
            name: '',
            nickname: '',
            phone: '',
        });
    };
    const { name, nickname, phone } = inputs;

    return (
        <div>
            <input name="name" placeholder="이름" onChange={onChange} value={name} />
            <input name="nickname" placeholder="닉네임" onChange={onChange} value={nickname} />
            <input name="phone" placeholder="전화번호" onChange={onChange} value={phone} />
            <button onClick={onReset}>초기화</button>
            <div>
                <b>소개 : </b>
                {name} // {nickname} // {phone}
            </div>
            <br />
            <br />
            <br />
            <hr />
        </div>
    );

    // const [name, setName] = useState('');
    // const [nickname, setNickname] = useState('');
    // const [phone, setPhone] = useState('');

    // const onReset = () => {
    //     setName('');
    //     setNickname('');
    //     setPhone('');
    // };
    // const onChangeName = (e) => {
    //     setName(e.target.value);
    // };
    // const onChangeNickname = (e) => {
    //     setNickname(e.target.value);
    // };
    // const onChangePhone = (e) => {
    //     setPhone(e.target.value);
    // };
    // return (
    //     <div>
    //         <input name="name" placeholder="이름" onChange={onChangeName} value={name} />
    //         <input name="nickname" placeholder="닉네임" onChange={onChangeNickname} value={nickname} />
    //         <input name="phone" placeholder="전화번호" onChange={onChangePhone} value={phone} />
    //         <button onClick={onReset}>초기화</button>
    //         <div>
    //             <b>소개 : </b>
    //             {name} // {nickname} // {phone}
    //         </div>

    //         <br />
    //         <br />
    //         <br />
    //         <hr />
    //     </div>
    // );
};

export default InputSample;
