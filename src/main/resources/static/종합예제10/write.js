
const 등록 = async () => {
    const bwriterInput = document.querySelector(".bwriterInput");
    const btitleInput = document.querySelector(".btitleInput");
    const bcontentInput = document.querySelector(".bcontentInput");

    const bwriter = bwriterInput.value;
    const btitle = btitleInput.value;
    const bcontent = bcontentInput.value;

    const object = {
        bwriter: bwriter,
        btitle: btitle,
        bcontent: bcontent
    };
    const response = await axios.post("/board", object);
    const data = response.data;
    if(data == true){
        alert("등록 성공");
        location.href = "index.html";
    } else {
        alert("등록 실패");
    }





}

