async function handleSubmit(event) {
    event.preventDefault();

    const name = document.getElementById("name").value;
    const academicMail = document.getElementById("academicMail").value;
    const faculty = document.getElementById("faculty").value;
    const degree = document.getElementById("degree").value;
    const currentGPA = document.getElementById("currentGPA").value;
    const academicYear = document.getElementById("academicYear").value;
    const imgUrl = document.getElementById("imgUrl").value;

    const studentAcademicData = {name,academicMail,faculty,degree,currentGPA,academicYear,imgUrl};



    console.log("this is your student academic data "+ JSON.stringify(studentAcademicData));

    const baseURL = "http://localhost:8080/studentAcademicProfile/add"

    try{
        const response = await fetch(baseURL, {
            method: "POST",
            headers: {
                'Content-Type': "application/json"
            },
            body: JSON.stringify(studentAcademicData)
        });

        if(response.ok) {
            alert("Student academic data Added Successfully");
            document.querySelector('.studentAcademic-form').reset();
            window.location.href = "../ViewStudentAcademicProfiles/index.html";
        }
    } catch (error) {
        console.log("error is coming while adding the student academic data" + error);
        document.querySelector('.studentAcademic-form').reset();
    }

}
