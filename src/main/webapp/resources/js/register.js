
// 등록 버튼 클릭 시 호출
function goRegister(){
    let title = document.getElementById("title").value;
    let price = parseInt(document.getElementById("price").value);
    let author = document.getElementById("author").value;
    let page = parseInt(ocument.getElementById("page").value);

    // javascript object
    // key : value
    let formData={
        title:title,
        price:price,
        author:author,
        page:page
    };

    // JSON.stringify : form 데이터가 -> json으로 변경되어 -> server로 전송 됨
    fetch("http://localhost:8081/weberp/api/books", {
        method: "POST",
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify(formData)
    })
        .then(function (response) {
            if (!response.ok) {
                throw new Error("execute error!!");
            }
            location.href = "/web-erp/restList";  // 등록이 성공 후 다시 리스트페이지로 이동
        })
        .catch(function (error) {
            console.log("error : ", error);
        });
}