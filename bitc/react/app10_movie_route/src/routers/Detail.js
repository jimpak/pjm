import { useLocation } from 'react-router-dom';
import { Card } from 'react-bootstrap';

const Detail = () => {
    const location = useLocation();
    console.log({ location });

    return (
        <Card style={{ width: '25rem' }}>
            <Card.Img variant="top" src={location.state.poster} alt={location.state.title} />
            <Card.Body>
                <Card.Title>{location.state.title}</Card.Title>
                <Card.Title>{location.state.year}</Card.Title>
                <Card.Text>
                    <ul style={{ width: '25rem' }}>
                        {location.state.genres.map((genre, index) => {
                            return <li key={index}>{genre}</li>;
                        })}
                    </ul>
                </Card.Text>
                <Card.Text>
                    <p>{location.state.summary}...</p>
                </Card.Text>
            </Card.Body>
        </Card>
    );
};

export default Detail;
