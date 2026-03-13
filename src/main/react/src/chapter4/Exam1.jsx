
// 컴포넌트를 만드는 방법 
// 1. 해당폴더를 오른쪽 클릭 -> New -> File 
// 2, 첫글자가 대문자로 시작하는 .jsx 파일확장자로 생성한다. 
// 예] Exam1.jsx
// 3. function 컴포넌트명(){}
// 4. 컴포넌트 내 return(<>jsx분법</>)
// 5. 파일내 내보내기 할 컴포넌트 1개 , export default 컴포넌트명

function FrontComp(props){
    console.log(props);
    const liRows = []; 
    for(let i=0; i<props.propData1.length; i++){
        liRows.push(
        <li key={i}>{props.propData1[i]}</li>
    );}
    return(<>
        <li>{props.frTitle}</li>
        <ul>{liRows}</ul>
    </>)
} // c end 

const BackComp = ({propData2 , baTitle}) => {
    const {a,b} = {a:10, b:20}; // 구조 분해 , 
    // 즉] 객체내 값들을 각 변수로 분해 , a속벙 b속성 ㄹ로 분해한다
    console.log(a); // 구조분해 한 변수를 사용한다 
    // 즉] props는 객체인데 , const {propData2, baTitle} = props; // 구조분해로 props객체내 propData2와 baTitle을 분해한다 
    const liRows = [];
    let keyCnt = 0;
    for(let row of propData2){
        liRows.push(
            <li key={keyCnt++}>{row}</li>
        );
    }
    return(
        <>
            <li>{baTitle}</li>
            <ul>{liRows}</ul>
        </>
    );
}

// (1) 구조분해 없이 여러개 속성을 한꺼번에 받기 
function MyComponent(props){
    //props 에 존재하지 않는 속성명은 출력 되지 않는다 < 상위 컴포넌트
    return(<>
    <p>
        {props.p1},{props.p2},{props.p3},{props.p4},{props.p5}
    </p>
        </>)
}

//(2) 구조분해 사용하여 필요한 속성 받기 
function MyComponent2({p1,p3}){
    return(<>
    <p>
        {p1},{p3}
    </p>
        </>)
}

function Exam1(){
    const frontData = ['리액트','뷰','앵귤러'];
    const backData = ['스프링','노드','장고'];
    return(<>
        <h3>프롭스 예제 p.87</h3>
        <ol>
        <FrontComp propData1={frontData} frTitle="프론트앤드"></FrontComp>
        <BackComp propData2={backData} baTitle="백앤드"></BackComp>
        </ol>
        <h3>props 객체 p.90</h3>
        <MyComponent p1={"리액트"} p2="뷰" p3="앵귤러" p4="스프링" p5="노드"></MyComponent>
        <MyComponent2 p1={"리액트"} p2="뷰" p3="앵귤러" p4="스프링" p5="노드"></MyComponent2>
    </>)
}
export default Exam1;