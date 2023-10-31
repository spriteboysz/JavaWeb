let ajaxReq;

function checkUserName() {
    // 1. 创建AJAX请求对象
    if (window.XMLHttpRequest) {
        ajaxReq = new XMLHttpRequest();
    } else {
        ajaxReq = new ActiveXObject("Microsoft.XMLHTTP");
    }
    console.log("------" + ajaxReq.readyState)
    console.log("1")
    // 2. 封装AJAX请求数据
    const userName = document.getElementById("userName").value;
    ajaxReq.open("GET", "CheckUserNameServlet?userName=" + userName, true)
    console.log(">>>>>" + ajaxReq.readyState)
    // 3. 回调函数
    ajaxReq.onreadystatechange = callback;
    // 4. 发送请求
    ajaxReq.send(null);
}

function callback() {
    if (ajaxReq.readyState === 4 && ajaxReq.status === 200) {
        const result = ajaxReq.responseText;
        console.log(result);
        document.getElementById("tipsLabel").innerHTML = result;
    }
}