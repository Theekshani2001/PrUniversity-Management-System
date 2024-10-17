async function handleSubmit(event) {
    event.preventDefault();

    const name = document.getElementById("name").value;
    const personalMail = document.getElementById("personalMail").value;
    const address = document.getElementById("address").value;
    const birthdate = document.getElementById("birthdate").value;
    const phone = document.getElementById("phone").value;
    const faculty = document.getElementById("faculty").value;
    const imgUrl = document.getElementById("imgUrl").value;

    const studentPersonalData = { name,personalMail, address,birthdate,phone,faculty,imgUrl};



    console.log("this is your student personal data "+ JSON.stringify(studentPersonalData));

    const baseURL = "http://localhost:8080/studentPersonalProfile/add"

    try{
        const response = await fetch(baseURL, {
            method: "POST",
            headers: {
                'Content-Type': "application/json"
            },
            body: JSON.stringify(studentPersonalData)
        });

        if(response.ok) {
            alert("Student personal data Added Successfully");
            document.querySelector('.studentPersonal-form').reset();
            window.location.href = "../ViewStudents/index.html";
        }
    } catch (error) {
        console.log("error is coming while adding the student personal data" + error);
        document.querySelector('.studentPersonal-form').reset();
    }

}
