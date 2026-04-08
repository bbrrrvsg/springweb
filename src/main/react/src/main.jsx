
import { createRoot } from 'react-dom/client'
import './index.css'
import {BrowserRouter} from 'react-router-dom'
// ** index.html 에서 root 가져오기 **
const root = document.querySelector('#root'); 




// react web 예제
import App from './reactweb/App.jsx';
createRoot( root ).render( 
    <BrowserRouter>
        <App/>
    </BrowserRouter>
 ) ; // root에 최초 컴포넌트 렌더링 하기



// // p1 예제
// import App from './practice1/App.jsx';
// createRoot( root ).render( 
//     <BrowserRouter>
//         <App/>
//     </BrowserRouter>
//  ) ; // root에 최초 컴포넌트 렌더링 하기







// // chapter 11 예제
// import Exam2 from './chapter11/Exam2.jsx';
// import {BrowserRouter} from 'react-router-dom'; // [1] 라이브러리 import 하기 

// // [2] 최초 렌더링 되는 컴포넌트에 BrowserRouter 감싼다.
// createRoot( root ).render( 
//     <BrowserRouter>  
//         <Exam2 />
//     </BrowserRouter>
// );

// chapter 10 예제
// import Exam1 from './chapter10/Exam1.jsx'
// createRoot( root ).render( <Exam1 /> );

// chapter 9 예제
// import Exam2 from './chapter9/Exam2.jsx';
// createRoot( root ).render( <Exam2 /> );

// chapter 8 예제
// import Exam1 from './chapter8/Exam1.jsx';
// createRoot( root ).render( <Exam1 /> );

// chapter 7 예제
// import Exam2 from './chapter7/Exam2.jsx';
// createRoot( root ).render( <Exam2 />)

// chapter 6 예제
// import Exam1 from './chapter6/Exam1.jsx';
// createRoot( root ).render( <Exam1 /> );

// chapter 5 예제
// import Exam2 from './chapter5/Exam2.jsx';
// createRoot( root ).render( <Exam2 /> );

// chapter 4 예제
// import Exam1 from './chapter4/Exam1.jsx' // 컴포넌트 불러오기 
// createRoot( root ).render( <Exam1 /> ) ; // root에 최초 컴포넌트 렌더링 하기

// * 기존코드
// createRoot(document.getElementById('root')).render( <App /> )

// [1] index.html( 싱글페이지 ) 에서 root 라는 id 갖는 div 호출 
// const root = document.querySelector('#root');

// [2] root 마크업에 렌더링(render)
// createRoot( root ).render( <h1> 안녕하세요! </h1> )
// vs root.innerHTML = "<h1> 안녕하세요! </h1>";