function calculate(){
    var a,b,operationType, result, url;


    operationType = document.getElementById("op").value;
    a = document.getElementById("v1").value;
    b = document.getElementById("v2").value;
    result = document.getElementById("result");
    url = "http://localhost:9080/"+operationType+"?a="+a+"&b="+b;
console.log(operationType);
    fetch(url)
        .then(function (response) {
            return response.json();
        })
        .then(function (data) {
            result.value= data.result;

        })
        .catch(function (error) {
            console.log("Error: " + error);
        });
}
