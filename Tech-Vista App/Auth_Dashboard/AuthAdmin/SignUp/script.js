async function handleSubmit(event) {
    event.preventDefault();

    const name = document.getElementById("name").value;
    const email = document.getElementById("email").value;
    const phone = document.getElementById("phone").value;
    const password = document.getElementById("password").value;

    const adminData = { name, email, phone, password };
    const baseURL = "http://localhost:8080/admin/register";

    try {
        const response = await fetch(baseURL, {
            method: "POST",
            headers: {
                'Content-Type': "application/json"
            },
            body: JSON.stringify(adminData)
        });

        if (response.ok) {
            alert("Admin data Added Successfully");
            document.querySelector('.signupForm').reset();
            window.parent.document.getElementById("auth-right").innerHTML = `<iframe src="./Login/index.html" frameborder="0"></iframe>`;
        } else {
            const errorData = await response.json();
            alert("Error: " + errorData.message);
        }
    } catch (error) {
        console.error("Error while adding the admin data: ", error);
    }
}
