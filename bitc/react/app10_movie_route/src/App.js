import './App.css';
import Home from './routers/Home';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import Navigation from './components/Navigation';
import About from './routers/About';
import Detail from './routers/Detail';
import MovieDetail from './routers/MovieDetail';

function App() {
    return (
        <div className="App">
            <BrowserRouter>
                <Navigation />
                <Routes>
                    <Route path={'/'} element={<Home />} />
                    <Route path={'/about'} element={<About />} />
                    <Route path={'/detail'} element={<Detail />} />
                    {/* <Route path={'/movie/:id'} element={<MovieDetail />} /> */}
                    <Route path="/movie">
                        <Route path=":id" element={<MovieDetail />}></Route>
                    </Route>
                </Routes>
            </BrowserRouter>
        </div>
    );
}

export default App;
