import { useState, useEffect } from 'react';
import axios from 'axios';
import { Link } from 'react-router-dom';


export default function board(props){


    // axios 로 부터 받은 게시물들을 저장하는 상태변수 
    const [list, setList] = useState([]); // 초기값은 빈 배열
    // axios 
    const findAll = async()=>{

        try{
            const response = await axios.get(
                "http://localhost:8080/api/board/list");
            const data = response.data;
            setList(data);
        }catch( error ){console.log( error );}
    }

    // [3] axios 실행 시점 , 화면 컴포넌트 이 열리면 
    useEffect( ()=>{ findAll(); }, [] );

    return (<>
        <div>게시판 페이지</div>
        <table border="1">
            <thead>
                <tr>
                    <th>글번호</th>
                    <th>글제목</th>
                    <th>작성자</th>
                    <th>작성일</th>
                </tr>
            </thead>
            <tbody>
                {/* { jsx 문법 시작 */}
                {
                    list.map(board =>{
                        return(
                            <tr>
                                <td>{board.bno}</td>
                                <td><Link to={`/board/view?bno=${board.bno}`}>{board.btitle}</Link></td>
                                <td>{board.mname}</td>
                                <td>{board.createDate}</td>
                            </tr>
                        )
                    })
                }
                {/* } jsx 문법 끝  */}
            </tbody>
        </table>
    </>)

}