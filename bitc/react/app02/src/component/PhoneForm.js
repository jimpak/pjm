import { Component } from 'react';

class PhoneForm extends Component {
    state = {
        name: '',
        phone: '',
    };

    handleSubmit = (e) => {
        e.preventDefault();
        this.props.onCreate(this.state);
        this.setState({
            name: '',
            phone: '',
        });
    };
    // 이름, 전화번호 입력시 호출
    handleChange = (e) => {
        console.log(e.target.name + ':' + e.target.value);
        this.setState({
            [e.target.name]: e.target.value,
        });
    };

    render() {
        return (
            <div>
                <form onSubmit={this.handleSubmit}>
                    <input placeholder="이름" name="name" onChange={this.handleChange} value={this.state.name} />
                    <input placeholder="전화번호" name="phone" onChange={this.handleChange} value={this.state.phone} />
                    <button type="submit">등록</button>
                </form>
            </div>
        );
    }
}

export default PhoneForm;
