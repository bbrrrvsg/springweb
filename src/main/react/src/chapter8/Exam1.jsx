import reactLogo from "../assets/sdsd.png" // 이미지2
import "./index.css" // 현재 컴포넌트에 전통 css 파일 호출




export default function Exam1(props){
    const myStyle = {
        color: "white",
        backgroundColor: "DodgerBlue",
        padding: "10px",
        fontFamily: "Verdana"
    }
    const iwidth = {maxWidth: '300px'}
// 조심할점 : max-width --> maxwidth 하이픈(-) 대신에 카멜표현식 사용한다
    return(<>   
        <h3>스타일과 이미지 127p</h3>
        <ol>
            <li style={{color: "red"}}>프론트앤드</li>
            <ul>
                <li><img src="/img/dsds.png" style={iwidth} /></li>
                <li><img src={reactLogo} style={iwidth} /></li>
                <li><img src="https://placehold.co/600x400" /></li>
            </ul>
            <li className="backEnd">백엔드</li>
            <ul>
                <li id="backEndSub">java</li>
                <li className="warning">oracle</li>
                <li style={myStyle}>JSP</li>
            </ul>
        </ol>
    </>)
}