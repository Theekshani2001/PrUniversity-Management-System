async function handleSubmit(event) {
    event.preventDefault();

    const academicEmail = document.getElementById("academicEmail").value;
    const name = document.getElementById("name").value;
    const birthdate = document.getElementById("birthdate").value;
    const address = document.getElementById("address").value;
    const position = document.getElementById("position").value;
    const faculty = document.getElementById("faculty").value;
    const imgUrl = document.getElementById("imgUrl").value;

    const academicStaffData = { academicEmail,name,birthdate,position,address,faculty,imgUrl};



    console.log("this is your academic staff data "+ JSON.stringify(academicStaffData));

    const baseURL = "http://localhost:8080/academicStaff/add"

    try{
        const response = await fetch(baseURL, {
            method: "POST",
            headers: {
                'Content-Type': "application/json"
            },
            body: JSON.stringify(academicStaffData)
        });

        if(response.ok) {
            alert("Academic staff data Added Successfully");
            document.querySelector('.academicStaff-form').reset();
            window.location.href = "../ViewAcademicStaff/index.html";
        }
    } catch (error) {
        console.log("error is coming while adding the academic staff data" + error);
        document.querySelector('.academicStaff-form').reset();
    }

}
