import { Link } from 'react-router-dom';
import { Button, Card } from 'react-bootstrap';

const Movie = ({ year, id, title, summary, poster, genres }) => {
    return (
        <Card style={{ width: '18rem' }}>
            <Card.Img variant="top" src={poster} alt={title} title={title} />
            <Card.Body>
                <Card.Title>{id}</Card.Title>
                <Card.Title>{title}</Card.Title>
                <Card.Title>{year}</Card.Title>
                <Card.Text>
                    <ul className="movie__genres">
                        {genres.map((genre, index) => {
                            return <li key={index}>{genre}</li>;
                        })}
                    </ul>
                </Card.Text>
                <Card.Text>
                    <p>{summary.slice(0, 100)}...</p>
                </Card.Text>
                <Link to="/detail" state={{ year, title, summary, poster, genres }}>
                    <Button variant="primary">View</Button>
                </Link>
                <Link to={`/movie/${id}`} state={{ year, id, title, summary, poster, genres }}>
                    <Button variant="primary">MovieDetail</Button>
                </Link>
            </Card.Body>
        </Card>
    );
};

export default Movie;
