
document.addEventListener("DOMContentLoaded", () => {
    const urlParams = new URLSearchParams(window.location.search);


    document.getElementById("updatedAcademicId").value = urlParams.get('academicId');
    document.getElementById("updatedName").value = urlParams.get('name');
    document.getElementById("updatedAcademicMail").value = urlParams.get('academicMail');
    document.getElementById("updatedFaculty").value = urlParams.get('faculty');
    document.getElementById("updatedDegree").value = urlParams.get("degree");
    document.getElementById("updatedCurrentGPA").value = urlParams.get("currentGPA");
    document.getElementById("updatedAcademicYear").value = urlParams.get("academicYear");


    document.getElementById("updatedImgUrl").value = urlParams.get("imgUrl");
});


async function updateStudentAcademicProfile(event) {
    event.preventDefault();

    const academicId= document.getElementById("updatedAcademicId").value;
    const name = document.getElementById("updatedName").value;
    const academicMail = document.getElementById("updatedAcademicMail").value;
    const faculty = document.getElementById("updatedFaculty").value;
    const degree = document.getElementById("updatedDegree").value;
    const currentGPA = document.getElementById("updatedCurrentGPA").value;
    const academicYear = document.getElementById("updatedAcademicYear").value;
    const imgUrl = document.getElementById("updatedImgUrl").value;

    const studentAcademicData = { academicId,name,academicMail,faculty,degree,currentGPA,academicYear,imgUrl};



    console.log("this is your updated student academic data "+ JSON.stringify(studentAcademicData));

    const baseURL = "http://localhost:8080/studentAcademicProfile/update"

    try{
        const response = await fetch(baseURL, {
            method: "PUT",
            headers: {
                'Content-Type': "application/json"
            },
            body: JSON.stringify(studentAcademicData)
        });
        if(response.ok) {
            alert("Student Academic Profile updated successfully");
            window.location.href = "../ViewStudentAcademicProfiles/index.html";
        }

    } catch (error) {
        console.log("error is coming while updating the student academic profile" + error);
        document.querySelector('.updatedForm').reset();
    }

}
