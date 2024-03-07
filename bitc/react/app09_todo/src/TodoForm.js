import { useState } from 'react';
import { Form, Button } from 'react-bootstrap';

const TodoForm = ({ insertTodo }) => {
    const [formContent, setFormContent] = useState({
        name: '',
        subject: '',
        summary: '',
    });
    const getValue = (e) => {
        setFormContent({
            ...formContent,
            [e.target.name]: e.target.value,
        });
    };

    return (
        <div>
            <h3>TodoForm</h3>

            <Form>
                <Form.Group className="mb-3" controlId="formGroupEmail">
                    <Form.Label>Name</Form.Label>
                    <Form.Control type="text" name="name" placeholder="name" onChange={getValue} />
                </Form.Group>
                <Form.Group className="mb-3" controlId="formGroupEmail">
                    <Form.Label>Subject</Form.Label>
                    <Form.Control type="text" name="subject" placeholder="subject" size="50" onChange={getValue} />
                </Form.Group>
                <Form.Group className="mb-3" controlId="formGroupEmail">
                    <Form.Label>Summary</Form.Label>
                    <Form.Control
                        as="textarea"
                        placeholder="summary"
                        rows={5}
                        name="summary"
                        cols="50"
                        onChange={getValue}
                    />
                </Form.Group>
                <Button variant="success" onClick={() => insertTodo(formContent)}>
                    추가
                </Button>{' '}
            </Form>

            <br />
            <hr />
        </div>
    );
};

export default TodoForm;
