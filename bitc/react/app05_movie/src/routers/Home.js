import { Component } from 'react';
import axios from 'axios';
import './Home.css';
import Movie from '../component/Movie';

class Home extends Component {
    state = {
        isLoading: true,
        movies: [],
    };

    // // javascript의 fetch를 사용하여 영화정보 가져오기.
    // getMovies = () => {
    //     fetch('https://yts.mx/api/v2/list_movies.json?sort_by=rating')
    //         .then((res) => res.json())
    //         .catch((err) => console.log(err))
    //         .then((res) => {
    //             console.log(res.data.movies);
    //             console.log('movie_count:', res.data.movie_count);
    //             console.log('page_number:', res.data.page_number);
    //             this.setState({ isLoading: false, movies: res.data.movies });
    //         });
    // };

    // axios를 활용하여 영화정보 가져오기.
    getMovies = () => {
        axios.get('https://yts.mx/api/v2/list_movies.json?sort_by=rating').then((res) => {
            console.log('res axios', res.data.data.movies);
            console.log('movie_count axios:', res.data.data.movie_count);
            console.log('page_number axios:', res.data.data.page_number);
            this.setState({ isLoading: false, movies: res.data.data.movies });
        });
    };

    componentDidMount() {
        console.log('componentDidMount');
        this.getMovies();
    }

    render() {
        const { isLoading, movies } = this.state;

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
                                <Movie
                                    key={movie.id}
                                    year={movie.year}
                                    title={movie.title}
                                    summary={movie.summary}
                                    poster={movie.medium_cover_image}
                                    genres={movie.genres}
                                />
                            );
                        })}
                    </div>
                )}
            </section>
        );
    }
}

export default Home;
