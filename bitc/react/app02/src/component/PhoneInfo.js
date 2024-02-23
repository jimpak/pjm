import { Component } from 'react';

class PhoneInfo extends Component {
    handleRemove = () => {
        const { info, onRemove } = this.props;
        // 부모에 있는 handleRemove() 호출
        onRemove(info.id);
    };
    render() {
        const { id, name, phone } = this.props.info;
        return (
            <div>
                <div>id : {id}</div>
                <div>name : {name}</div>
                <div>phone : {phone}</div>
                <button onClick={this.handleRemove}>삭제</button>
                <br />
                <br />
            </div>
        );
    }
}

export default PhoneInfo;
