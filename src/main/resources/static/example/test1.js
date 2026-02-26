
const obj = {ano:"1", studentName:"유재석", date:"2026-02-26", status:"출석"}

const func1 =async() => {
    try{
        const response = 
        await axios
        .post("/attendance", obj);

        console.log(response.data);

    }catch(error){console.log(error)}

    }// f end 



const func2 = async() => {
    try{
        const response = 
        await axios
        .get("/attendance?studentName=유재석&date=2026-02-26&status=출석");
        console.log(response.data);
    }catch(error){console.log(error)}
}


const func3 = async() => {
    try{
         const response =
         await axios
            .get("/attendance/detail?studentName=강호동&date=2026-02-26&status=출석");
        console.log(response.data);
    }catch(error){console.log(error)}
}

const func4 = async() => {
    try{
        const response = 
        await axios
        .delete("/attendance?ano=1");
        console.log(response.data);
    }catch(error){console.log(error)}
}

const func5 = async() => {
    
}