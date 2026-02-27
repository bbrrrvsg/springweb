console.log("index.js loaded");

//1] 전체 조회
const onFindAll =async () => {
    //1.어디에
    const tbody = document.querySelector("#boardTable tbody");
    //2.무엇을
    let html="";

        // 동기화 axios : 1. 현재 함수명 앞에 async 키워드 붙인다 2. axios 함수 앞에 await 키워드 붙인다 
        const response = await axios.get("/board"); // js에서 스프링 컨트롤러와 통신기술 
        const data = response.data; // 응답받은 데이터
        console.log(data);
    
        for(let i=0; i<data.length; i++){
            const board = data[i];
            html += `<tr>
                        <td>${board.bno}</td>
                        <td>${board.bcontent}</td>
                        <td>${board.bwriter}</td>
                        <td>${board.bdate}</td>
                        <td>
                            <button onclick="onDelete( ${ board.bno } )"> 삭제 </button>
                            <button onclick="onUpdate( ${ board.bno } )"> 수정 </button>
                        </td>
                     </tr>`

        }

    //3 출력
    tbody.innerHTML=html;
}
onFindAll(); 


//2] 등록
const onwrite = async () => {

    //1.dom객체 가져온다 
    const bcontentInput = document.querySelector("#bcontent");
    const bwriterInput = document.querySelector("#bwriter");

    //2.dom객체내 입력받은 값 꺼내기  
    const bcontent = bcontentInput.value;
    const bwriter = bwriterInput.value;

    //3.입력받은 값으로 객체 구성 
    const obj ={"bcontent":bcontent, "bwriter":bwriter};

    //4.aixios 이용하여 서버에게 저장 요청 
    const response = await axios.post("/board", obj);
    const data = response.data;
    if(data==true){
        alert("등록성공");
        bcontentInput.value=""; // 입력상자 비우기 
        bwriterInput.value="";
        onFindAll(); // 등록성공하면 전체조회 다시하기 랜더링  
    }
}


//3] 개별수정
const onUpdate = async (bno) => {
    //1) 새로운 수정할 내용 입력받기 
     const bcontent = prompt("수정할 내용 입력");
     //2) 입력받은 내용으로 객체 구성
     const obj = {"bno":bno, "bcontent":bcontent}; // vs {bno, bcontent}  // 객체의 key와 value의 이름이 같으면 하나로 줄여서 작성가능

     //3} axios 이용하여 서버에게 수정 요청/응답 받는다
     const response = await axios.put("/board", obj);
     const data = response.data;

     //4) 결과 흐름제어 
     if(data==true){
        alert("수정성공");
        onFindAll(); // 수정성공하면 전체조회 다시하기 랜더링
     }else{
        alert("수정실패");
     }
}


//4] 개별삭제
const onDelete = async (bno) => {
    //1.삭제할 게시물 번호 받는다

    //2.axios 이용하여 서버에게 삭제 요청/응답 박는다 
    const response = await axios.delete(`/board?bno=${bno}`);
    const data = response.data;

    //3.
    if(data==true){
        alert("삭제성공");
        onFindAll(); // 삭제성공하면 전체조회 다시하기 랜더링
    }else{
        alert("삭제실패");
    }
}