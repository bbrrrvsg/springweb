//쿼리스트링이란? url 주소 뒤에 ? 로 매개변수 포함하는 경우 
//js에서 쿼리스트링의 값 가져오는 방법 
const bno = new URLSearchParams(location.search).get("bno"); //bno라는 이름의 쿼리스트링 값 가져오기
console.log("bno: " + bno);

const 개별조회 = async () => {
    const boardBox = document.querySelector("#boardBox");

    let html = "안녕";

    const response = await axios.get(`/board/one?bno=${bno}`);
    const data = response.data;
    console.log(data)
    html = ` 제목: <div>${data.btitle}</div>
            작성자/작성일: <div>${data.bwriter}/${data.createDate}</div>
            내용: <div>${data.bcontent}</div>
            <button onclick="수정(${data.bno})">수정</button>
            <button onclick="삭제(${data.bno})">삭제</button>`;

    boardBox.innerHTML = html;
}
개별조회();

const 삭제 = async (bno) => {
    //연재게시물을 삭제하기위해 현제 게시물 번호 확인 bno 
    //axios 이용하여 서버에게 게시물 삭제 요청 결과 받기 
    const response = await axios.delete(`/board?bno=${bno}`);
    const data = response.data;
    if( data == true ){ 
        alert("삭제 성공");
        location.href = "index.html"; // **** 화면 새로고침 ****
    }else{ alert("삭제 실패"); }
}

const 수정 = async (bno) => {

    const btitle = prompt("수정할 제목");
    const bcontent = prompt("수정할 내용");
    const bwriter = prompt("수정할 작성자");

    const obj = { bno, btitle, bcontent, bwriter };
    const response = await axios.put(`/board`, obj);
    const data = response.data;
    if( data == true ){ 
        alert("수정 성공");
        location.reload(); // **** 화면 새로고침 ****
    }else{ alert("수정 실패"); }

}

const 댓글등록 = async () => {
    const cinput = document.querySelector(".cinput");
    const ctextarea = document.querySelector(".ctextarea");

    const cwriter = cinput.value;
    const comment = ctextarea.value;

    const obj = {
        cwriter: cwriter,
        comment: comment,
        bno: bno
    };

    const response = await axios.post(`/chat`, obj);
    const data = response.data;
    console.log(data);
    if( data == true ){
        alert("댓글 등록 성공");
        location.reload(); // **** 화면 새로고침 ****
    }    else{ alert("댓글 등록 실패"); }

}

const 댓글목록 = async () => {
    const replyList = document.querySelector("#replyList");

    let html = "";

    const response = await axios.get(`/chat?bno=${bno}`);
    const data = response.data;

    data.forEach(element => {
        html += ` <div style="margin: 20px 0px;">
                <div><span>${element.cwriter}</span><span>${element.createDate}</span><span> <button onclick="댓글수정(${element.cno})">수정</button> <button onclick="댓글삭제(${element.cno})">삭제</button></span></div>
                <div> ${element.comment} </div>
            </div>`;
    });

    replyList.innerHTML = html;

}
댓글목록();

const 댓글삭제 = async (cno) => {
    const response = await axios.delete(`/chat?cno=${cno}`);
    const data = response.data;
    if( data == true ){
        alert("댓글 삭제 성공");
        location.reload(); // **** 화면 새로고침 ****
    }    else{ alert("댓글 삭제 실패"); }

}

const 댓글수정 = async (cno) => {
    const comment = prompt("수정할 댓글 내용");
    const obj = { cno, comment };
    const response = await axios.put(`/chat`, obj);
    const data = response.data;
    if( data == true ){
        alert("댓글 수정 성공");
        location.reload(); // **** 화면 새로고침 ****
    }    else{ alert("댓글 수정 실패"); }
}