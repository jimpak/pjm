import { useEffect, useState } from 'react';
import axios from 'axios';
import Movie from '../components/Movie';
import { Container, Spinner, Row, Col } from 'react-bootstrap';

const Home = () => {
    const [movies, setMovies] = useState([]);
    const [isLoading, setLoading] = useState(true);

    const getMovies = () => {
        axios.get('https://yts.mx/api/v2/list_movies.json?sort_by=rating').then((res) => {
            console.log('res axios', res.data.data.movies);
            console.log('movie_count axios:', res.data.data.movie_count);
            console.log('page_number axios:', res.data.data.page_number);
            setMovies(res.data.data.movies);
            setLoading(false);
        });
    };

    // componentDidMount(), componentDidUpdate()
    useEffect(() => {
        getMovies();
    }, []);

    return (
        <Container>
            {isLoading ? (
                <Spinner animation="border" role="status">
                    <span className="visually-hidden">Loading...</span>
                </Spinner>
            ) : (
                <Row>
                    {movies.map((movie) => {
                        return (
                            <Col md={4}>
                                <Movie
                                    key={movie.id}
                                    id={movie.id}
                                    year={movie.year}
                                    title={movie.title}
                                    summary={movie.summary}
                                    poster={movie.medium_cover_image}
                                    genres={movie.genres}
                                />
                            </Col>
                        );
                    })}
                </Row>
            )}
        </Container>
    );
};

export default Home;
