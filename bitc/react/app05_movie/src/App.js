import './App.css';
import Home from './routers/Home';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import Navigation from './component/Navigation';
import About from './routers/About';

function App() {
    return (
        <BrowserRouter>
            <Navigation />
            <Routes>
                <Route path={'/'} element={<Home />} />
                <Route path={'/about'} element={<About />} />
            </Routes>
        </BrowserRouter>
    );
}

export default App;
