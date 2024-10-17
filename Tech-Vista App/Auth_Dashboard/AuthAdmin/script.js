document.getElementById("loginBtn").addEventListener("click", function() {
    document.getElementById("auth-right").innerHTML = `<iframe src="./Login/index.html" frameborder="0"></iframe>`;
});

document.getElementById("signupBtn").addEventListener("click", function() {
    document.getElementById("auth-right").innerHTML = `<iframe src="./SignUp/index.html" frameborder="0"></iframe>`;
});
