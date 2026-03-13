
import { createRoot } from 'react-dom/client'
import './index.css'
import App from './App.jsx'
const root = document.querySelector('#root')

// *기존 코드 
// createRoot(document.getElementById('root')).render(
//     <App />
// )

//const root = document.querySelector('#root')
//createRoot(root).render( <App />)

//createRoot(root).render( <h1>안녕하세요<h1/>)

// vs root.innerHTML = '<h1>안녕하세요</h1>'


// //chapter4 예제
// import Exam1 from './chapter4/Exam1.jsx' // 컴포넌트 불러오기  
// createRoot(root).render(
//     <Exam1 />
// )

// chapter 5 예제 
import Exam2 from './chapter9/Exam2.jsx'
createRoot(root).render(<Exam2/>)