function FrontComp(props){
    return(<>   
    {/*JSX(return)에서 사용되는 (XML) 문법 에서 주석처리 하는 방법*/}
    <li>
        <a href="/" onClick={()=>{props.onMyEvent1();}}>프론트엔드</a>
    </li>
    <ul>
        <li>HTML5</li><li>css</li><li>js</li><li>jquery</li>
    </ul>
    
    </>)
}

function Exam2(){
    function 출력함수(){alert('출력된 메세지1')} // 선언적 함수 

    // 익명 함수? 이름이 없는 함수(재사용이 안된다 /  일회성 또는 이벤트 함수 )
    // 화살표함수 ? 이름이 없고 => 화살표 표현식 사용하는 함수 (주로 변수에 저장하여 재사용한다.) 
    return(<>   
    <h3>이벤트 처리 p 100</h3>
    <button onClick={출력함수}>리액트 버튼1</button>
    <button onClick={function(){alert('출력된 메세지2')}}>리액트 버튼2</button>
    <button onClick={()=>{alert('출력된 메세지3')}}>리엑트 버튼3</button>
    <FrontComp onMyEvent1={()=>{alert('프론트엔드 클릭됨');}}></FrontComp>
    </>)
}
export default Exam2;
/*
    리액트 이벤트에서 주의할점 
        1. onclick --> onClick , 합성 이벤트(리엑트가 핸들러/연결을 통해 이벤트 실행)
        2. onClick에서 함수 실행 하는 구조 아니고 **전달**하는 구조 
        1] 선언 , funtion 함수명(){}
        2] 호출 , 함수명()
        ** HTML : <button onclick="출력함수()">
        ** REACT : <button onclick={출력함수}>
*/  