import Button from 'react-bootstrap/Button';
import Card from 'react-bootstrap/Card';

const TodoItem = ({ num, name, subject, summary, deleteTodo }) => {
    return (
        <div>
            <Card style={{ width: '20rem' }}>
                <Card.Body>
                    <Card.Title>TodoItem</Card.Title>
                    <Card.Text>
                        번호 : {num}
                        <br />
                        name : {name}
                        <br />
                        subject : {subject}
                        <br />
                        summary : {summary}
                        <br />
                    </Card.Text>
                    <Button variant="danger" onClick={() => deleteTodo(num)}>
                        삭제
                    </Button>
                </Card.Body>
            </Card>
        </div>
    );
};

export default TodoItem;
