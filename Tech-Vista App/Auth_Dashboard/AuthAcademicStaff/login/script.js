async function handleSubmit(event) {
    event.preventDefault();

    const userName = document.getElementById("userName").value;
    const academicEmail = document.getElementById("academicEmail").value;

    const baseURL = `http://localhost:8080/academicStaff/login/${userName}/${academicEmail}`;

    try {
        const response = await fetch(baseURL, {
            method: "GET",
            headers: {
                'Content-Type': "application/json"
            }
        });

        if (response.ok) {
            const admin = await response.json();
            alert("Login Successful! Welcome, " + admin.name);
            document.querySelector('.loginForm').reset();
            window.parent.location.href = "../../../View_Dashboard/index.html";
        } else {
            alert("Login failed! Please check your credentials.");
            document.querySelector('.loginForm').reset();
        }
    } catch (error) {
        console.error("Error during login:", error);
        alert("An error occurred during login. Please try again.");
    }
}
