import { useEffect, useState } from 'react';
import axios from 'axios';
import './Home.css';

const Poster = () => {
    const [movies, setMovies] = useState([]);
    const [isLoading, setLoading] = useState(true);
    const getMovies = () => {
        axios.get('https://yts.mx/api/v2/list_movies.json?sort_by=rating').then((res) => {
            // console.log('res axios', res.data.data.movies);
            setMovies(res.data.data.movies);
            setLoading(false);
        });
    };
    // componentDidMount(), componentDidUpdate()
    useEffect(() => {
        getMovies();
    }, []);

    return (
        <section className="container">
            {isLoading ? (
                <div className="loader">
                    <span>isLoading</span>
                </div>
            ) : (
                <div className="movies">
                    {movies.map((movie) => {
                        return (
                            <img key={movie.id} src={movie.medium_cover_image} alt={movie.title} title={movie.title} />
                        );
                    })}
                </div>
            )}
        </section>
    );
};

export default Poster;
