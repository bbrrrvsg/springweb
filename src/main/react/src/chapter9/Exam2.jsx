import { useState } from "react";


function WriteForm(props){
    //event 객체란 해당이벤트가 발생했을때 그이벤트 정보를 담고 있는 객체 
    return(<>
    <form onSubmit={(event)=>{
        event.preventDefault(); //기존 전송방식 제거 
        console.log("이벤트객체 :",  event);
        // 리액트는 쿼리샐랙트방식 하지 않는다 
        console.log("이벤트발생한 주체:" , event.target) // <form>
        console.log(event.target.gubun); // <form> --> <select> 
        let gubun = event.target.gubun;
        let title = event.target.title.value; // <form> -> <input> 
        // vs let title = document.queryselector('.title').value;
        props.writeAction(gubun,title); // 부모 컴포넌트로 부터 받은 함수에 입력받은 구분과 타이틀 대입라여 함수 실행 


    }}>
        <select name="gubun">
            <option value="front">프론트앤드</option>
            <option value="back">백엔드</option>
        </select>
        <input type="text" name="title" />
        <input type="submit" value="추가" />
    </form>
    </>)
}


export default function Exam2(props){
    const {message,seetMessage} = useState("폼값 전송 진행 중 ");

    // 자식에게 전달할 람수 
    const writeAction =(gubun,title)=>{
        if(gubun !=''&&title!=''){
            let fromValue = `검증완료폼값 : ${gubun},${title}`
            seetMessage()
        }
    }
    return(<>
        <h3>135p</h3>
        <WriteForm/>
    </>)
}