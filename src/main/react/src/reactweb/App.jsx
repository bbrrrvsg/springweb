import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Login from './page/member/Login';
import Header from './components/Header';
import Write from './page/board/Write';
import Signup from './page/member/Signup';
import Board from './page/board/Board';
import View from './page/board/View';
import Chat from './page/chat/Chat';


export default function App(props) {

    return (<>
        <div id="wrap">
            <Header />
            <Routes>
                { /* 본문들 */}
                <Route path="/" element={<div></div>} />  {/* ← 이거만 추가 */}
                <Route path="/member/signup" element={<Signup />} />
                <Route path="/member/login" element={<Login />} />
                <Route path="/board/write" element={<Write />} />
                <Route path="/board" element={<Board />} />
                <Route path="/board/view" element={<View />} />
                <Route path="/chat" element={<Chat />} />

            </Routes>
            { /* 푸터 */}
        </div>
    </>)
}


