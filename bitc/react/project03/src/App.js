import { Link, Route, Routes } from 'react-router-dom';
import './App.css';
import Home from './pages/Home';
import Diary from './pages/Diary';
import Edit from './pages/Edit';
import New from './pages/New';
import React, { useEffect, useReducer, useRef, useState } from 'react';
import axios from 'axios';

// const mockData = [
//     {
//         id: 'mock1',
//         date: new Date().getTime() - 1,
//         content: 'mock1',
//         emotionId: 1,
//     },
//     {
//         id: 'mock2',
//         date: new Date().getTime() - 2,
//         content: 'mock2',
//         emotionId: 2,
//     },
//     {
//         id: 'mock3',
//         date: new Date().getTime() - 3,
//         content: 'mock3',
//         emotionId: 3,
//     },
// ];

function reducer(state, action) {
    switch (action.type) {
        case 'INIT': {
            return action.data;
        }
        case 'CREATE': {
            return [action.data, ...state];
        }
        case 'UPDATE': {
            return state.map((it) => (String(it.id) === String(action.data.id) ? { ...action.data } : it));
        }
        case 'DELETE': {
            return state.filter((it) => String(it.id) !== String(action.targetId));
        }
        default: {
            return state;
        }
    }
}

function App() {
    const [isDataLoaded, setIsDataLoaded] = useState(false);
    const [data, dispatch] = useReducer(reducer, []);
    // const idRef = useRef(0);

    useEffect(() => {
        axios.get('/diary/list').then((resp) => {
            console.log('axios list:', resp.data);
            dispatch({
                type: 'INIT',
                data: resp.data,
            });
            setIsDataLoaded(true);
        });

        //     dispatch({
        //         type: 'INIT',
        //         data: mockData,
        //     });
        //     setIsDataLoaded(true);
    }, []);

    const onCreate = (date, content, emotionId) => {
        axios
            .post('/diary/insert', {
                date: date,
                content: content,
                emotionId: emotionId,
            })
            .then((resp) => {
                console.log('insert');
                dispatch({
                    type: 'CREATE',
                    data: {
                        id: resp.data.id,
                        date: resp.data.date,
                        content: resp.data.content,
                        emotionId: resp.data.emotionId,
                    },
                });
            });
        // dispatch({
        //     type: 'CREATE',
        //     data: {
        //         id: idRef.current,
        //         content,
        //         emotionId,
        //     },
        // });
        // idRef.current += 1;
    };

    const onUpdate = (targetId, date, content, emotionId) => {
        axios
            .put(`/diary/update/${targetId}`, {
                id: targetId,
                date: date,
                content: content,
                emotionId: emotionId,
            })
            .then((resp) => {
                dispatch({
                    type: 'UPDATE',
                    data: {
                        id: targetId,
                        date: resp.data.date,
                        content: resp.data.content,
                        emotionId: resp.data.emotionId,
                    },
                });
            });
        //     dispatch({
        //         type: 'UPDATE',
        //         data: {
        //             id: targetId,
        //             date: new Date(date).getTime(),
        //             content,
        //             emotionId,
        //         },
    };

    const onDelete = (targetId) => {
        axios.delete(`/diary/delete/${targetId}`).then(() => {
            dispatch({
                type: 'DELETE',
                targetId,
            });
        });

        // dispatch({
        //     type: 'DELETE',
        //     targetId,
        // });
    };

    if (!isDataLoaded) {
        return <div>데이터를 불러오는 중입니다</div>;
    } else {
        return (
            <DiaryStateContext.Provider value={data}>
                <DiaryDispatchContext.Provider
                    value={{
                        onCreate,
                        onUpdate,
                        onDelete,
                    }}
                >
                    <div className="App">
                        <Routes>
                            <Route path="/" element={<Home />} />
                            <Route path="/new" element={<New />} />
                            <Route path="/diary/:id" element={<Diary />} />
                            <Route path="/edit/:id" element={<Edit />} />
                        </Routes>
                        <div>
                            <Link to={'/'}>Home</Link>
                            <Link to={'/new'}>New</Link>
                            <Link to={'/diary'}>Diary</Link>
                            <Link to={'/edit'}>Edit</Link>
                        </div>
                    </div>
                </DiaryDispatchContext.Provider>
            </DiaryStateContext.Provider>
        );
    }
}

export const DiaryStateContext = React.createContext();
export const DiaryDispatchContext = React.createContext();
export default App;
