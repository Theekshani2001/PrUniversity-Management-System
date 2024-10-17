async function handleSubmit(event) {
    event.preventDefault();

    const nonAcademicStaffMail = document.getElementById("nonAcademicStaffMail").value;
    const name = document.getElementById("name").value;
    const birthdate = document.getElementById("birthdate").value;
    const address = document.getElementById("address").value;
    const position = document.getElementById("position").value;
    const imgUrl = document.getElementById("imgUrl").value;

    const nonAcademicStaffData = { nonAcademicStaffMail,name,birthdate,position,address,imgUrl};



    console.log("this is your non academic staff data "+ JSON.stringify(nonAcademicStaffData));

    const baseURL = "http://localhost:8080/nonAcademicStaff/add"

    try{
        const response = await fetch(baseURL, {
            method: "POST",
            headers: {
                'Content-Type': "application/json"
            },
            body: JSON.stringify(nonAcademicStaffData)
        });

        if(response.ok) {
            alert("Non Academic staff data Added Successfully");
            document.querySelector('.nonAcademicStaff-form').reset();
            window.location.href = "../ViewNonAcademicStaff/index.html";
        }
    } catch (error) {
        console.log("error is coming while adding the non academic staff data" + error);
        document.querySelector('.nonAcademicStaff-form').reset();
    }

}
