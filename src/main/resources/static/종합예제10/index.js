console.log("index.js loaded");

const 전체조회 = async () => {
    //1. 어디에
    const tbody = document.querySelector("#boardTable");
    //2. 무엇을
    let html = "";
    
    const response = await axios.get("/board"); // 서버와 통신
    const data = response.data; // 통신 결과 내용물 확인 
    data.forEach(element => {
        html += `<tr>
                    <td>${element.bno}</td>
                    <td><a href="detail.html?bno=${element.bno}">${element.btitle}</a></td>
                    <td>${element.bcontent}</td>
                    <td>${element.createDate}</td>
                </tr>`;
    });
    //3. 출력
    tbody.innerHTML = html;
}
전체조회();
 
 	
// 3] 개별 수정 
const onUpdate = async( bno )=>{ // 1] 수정할 번호를 매개변수로 받는다.
    // 1) 새로운 수정할 내용 입력받기 
    const bcontent = prompt("수정할 내용");
    // 2) 객체(Body) 구성 , 속성명과 대입할 값의 변수명이 같다면 속성명 생략
    const obj = { bno , bcontent } // vs { "bno" : bno , "bcontent" : bcontent }
    // 3) axios 이용하여 서버에게 수정할 요청 후 응답 받기 
    const response = await axios.put( "/board" , obj );
    const data = response.data;
    // 4) 결과 제어
    if( data == true ){ 
        alert("수정 성공");
        onFindAll(); // **** 화면 새로고침 ****
    }else{ alert("수정 실패"); }
}