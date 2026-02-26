console.log("test.js exe ");

// [1] 타입 : js는 동적 타입이므로 
// 1. 기본자료/리터럴
console.log(3); console.log(true); console.log(3.14);
// 2. 배열
console.log([3,true,3.14,"안녕"]); // 배열
// 3. 객체/json
console.log({name:"홍길동", age:30}); // 객체
// 4. 함수 
function func1(){}

// [2] 다양한 함수 형식 
//function func2(){} // 선언적 함수 
//function (){} // 익명 함수
//() => {} // 화살표 함수(람다 표현식)   (리액트 표현)

//[3] 화살표함수는 익명이므로 변수에 저장한다. 
const func3 = ()=>{}

// ===================================================================================== // 

/*
     1] Axios
        1. 정의 : 대표적으로 비동기/동기 통신 함수 
            AXIOS(REACT) vs JS(FETCH) vs JQUERY(AJAX) 등
        2. 목적 : JS환경에서 서버와의 통신 
        3. 설치 : 
            1. HTML에 CDN 코드 추가한다. 
            2.  <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
        
        4. 사용법 
     
     
     
     
*/ 
// axios.HTTP메소드명("통신할주소") 

//[1] 
axios.get("http://localhost:8080/day03/task") 


// 프론트서버와 백엔드서버가 같다면 도메인 생략 
//[2] axios.HTTP메소드명().then( (response)=>{} )
axios.delete("/day03/task?name=유재석")
    .then((response)=>{console.log(response.data)}) // 응답데이터는 response.data에 저장된다.


//[3] axios.HTTP메소드명
axios
    .post("/day03/task?age=40")
    .then((response)=>{console.log(response.data)})
    .catch((error)=>{console.log(error)}) // 통신 실패시 실행되는 함수


//[4] asios.HTTP메소드명("통신할주소", Body데이터)
const obj = {name:"유재석", age:40}
axios
    .put("/day03/task?",obj)
    .then((response)=>{console.log(response.data)})
    .catch((error)=>{console.log(error)})


// * 비동기 통신이란? 요청 여러개 했을때 먼저 처리된 응답부터 실행 
//      즉] 먼저 처리된 로직부터 실행된다. 순서 보장 안함!! 
// * 동기 통신이란> 여러개 요청 했을때 먼저 요청한 로직이 응답 하는 순서대로 실행 
//      즉] 먼저 요청한 로직이 먼저 실행한다. 순서 보장한다! 

// [5] , 동기화 키워드 
const func5 = async () => {
    try{ // 1) 예외 처리 한다. 
         // 2) axios앞에 await 키워드 이용한 동기화 
         // 3) axios 결과를 변수에 저장
        const response =    
            await axios("/day03/task/axios?name=유재석"); 

            //4} 결과 확인 
            console.log(response.data);

    }catch(error){console.log(error)}
} // f end  
func5();
