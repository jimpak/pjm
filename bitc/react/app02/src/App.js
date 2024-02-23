import logo from './logo.svg';
import { Component } from 'react';
import './App.css';
import PhoneForm from './component/PhoneForm';
import PhoneList from './component/PhoneList';

class App extends Component {
    id = 2;
    state = {
        information: [
            {
                id: 0,
                name: '홍길동',
                phone: '010-1111-1111',
            },
            {
                id: 1,
                name: '이순신',
                phone: '010-2222-2222',
            },
        ],
    };
    // 추가(기존 값에 추가)
    handleCreate = (data) => {
        console.log(data);
        const { information } = this.state;
        this.setState({
            information: information.concat({
                id: this.id++,
                ...data,
            }),
        });
    };

    // 삭제
    handleRemove = (id) => {
        const { information } = this.state;
        this.setState({
            information: information.filter((info) => info.id !== id),
        });
    };

    render() {
        return (
            <div>
                <hr />
                <PhoneForm onCreate={this.handleCreate} />
                <PhoneList data={this.state.information} onRemove={this.handleRemove} />
            </div>
        );
    }
}

export default App;
