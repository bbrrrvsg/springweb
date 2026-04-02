import { Outlet } from "react-router-dom";


export default function CommonLayout( props ){
    return(<>
        <div>
            <div  > 
                Outlet 컴포넌트 알아보기
            </div>
            <div>
                <Outlet /> { /* 자식 컴포너트가 렌더링 될 위치 */}
            </div>
            <div  >
                공통 레이아웃
            </div>
        </div>
    </>)
}