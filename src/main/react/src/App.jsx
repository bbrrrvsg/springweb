
/* [1] 프론트 관련 컴포넌트 */
function FrontComp(){ // 생성방법1 : function 컴포넌트명(){}
  return(<>
    <li>프론트엔드</li>
        <ul>
            <li>HTML5</li>
            <li>CSS3</li>
            <li>JavaScript</li>
            <li>jQuery</li>
        </ul>
  </>) // 생성 방법2 : 컴포넌트 내 return (<>HTML코드</>) : JSX 문법

}

/* [2] 백엔드 관련 컴포넌트 */
const BackComp = () => { // 생성방법2 : const 컴포넌트명 = () => {}
    return(<>
        <li>백엔드</li>
        <ul>
            <li>Java</li>
            <li>Spring</li>
            <li>Spring Boot</li>
            <li>MyBatis</li>
        </ul>
    </>)
}

/* [3] 폼 관련 컴포넌트 */
let FormComp = () => {
    return(
    <>
    <form action="">
        <select name="" id="">
            <option value="front">프론트엔드</option>
             <option value="back">백엔드</option>
        </select>
         <input type="text" name="title"/>
         <input type="submit" value="추가"/>
    </form>   
    </>
    )
}
/* [4] 여러 컴포넌트 호출/참조 하는 컴포넌트 */
function App() {
  return (
    <>
    <h2>react - 기본</h2>
    <ol>
        <FrontComp />
        <BackComp />
        <BackComp />
    </ol>
    
    <FormComp />
    
    </>
  )
}


export default App