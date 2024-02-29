import './App.css';
import Home from './routers/Home';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import Navigation from './component/Navigation';
import About from './routers/About';
import Detail from './routers/Detail';
import Poster from './routers/Poster';

function App() {
    return (
        <BrowserRouter>
            <Navigation />
            <Routes>
                <Route path={'/'} element={<Home />} />
                <Route path={'/about'} element={<About />} />
                <Route path={'/detail'} element={<Detail />} />
                <Route path={'/poster'} element={<Poster />} />
            </Routes>
        </BrowserRouter>
    );
}

export default App;
