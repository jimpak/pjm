import TodoItem from './TodoItem';
import { Container, Row, Col } from 'react-bootstrap';

const TodoList = ({ list, deleteTodo }) => {
    return (
        <div>
            <h3>TodoList</h3>
            <br />
            <Container>
                <Row xs={1} md={3} className="g-4">
                    {list.map((item) => (
                        <Col key={item.num}>
                            <TodoItem
                                key={item.num}
                                // board={item}
                                {...item}
                                deleteTodo={deleteTodo}
                            />
                        </Col>
                    ))}
                </Row>
            </Container>
        </div>
    );
};

export default TodoList;
