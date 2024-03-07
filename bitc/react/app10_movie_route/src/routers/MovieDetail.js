import { Container } from 'react-bootstrap';
import { useParams } from 'react-router-dom';

const MovieDetail = () => {
    const { id } = useParams();

    return (
        <Container>
            <h3>id : {id}</h3>
        </Container>
    );
};

export default MovieDetail;
