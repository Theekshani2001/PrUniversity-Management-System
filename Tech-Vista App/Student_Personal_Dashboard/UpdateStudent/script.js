
document.addEventListener("DOMContentLoaded", () => {
    const urlParams = new URLSearchParams(window.location.search);


    document.getElementById("updatedId").value = urlParams.get('studentId');
    document.getElementById("updatedName").value = urlParams.get('name');
    document.getElementById("updatedPersonalMail").value = urlParams.get('personalMail');
    document.getElementById("updatedAddress").value = urlParams.get('address');
    document.getElementById("updatedBirthdate").value = urlParams.get("birthdate");
    document.getElementById("updatedPhone").value = urlParams.get("phone");
    document.getElementById("updatedFaculty").value = urlParams.get("faculty");
    document.getElementById("updatedImgUrl").value = urlParams.get("imgUrl");
});


async function updateStudent(event) {
    event.preventDefault();

    const studentId= document.getElementById("updatedId").value;
    const name = document.getElementById("updatedName").value;
    const personalMail = document.getElementById("updatedPersonalMail").value;
    const address = document.getElementById("updatedAddress").value;
    const birthdate = document.getElementById("updatedBirthdate").value;
    const phone = document.getElementById("updatedPhone").value;
    const faculty = document.getElementById("updatedFaculty").value;
    const imgUrl = document.getElementById("updatedImgUrl").value;

    const studentPersonalData = { studentId,name,personalMail, address,birthdate,phone,faculty,imgUrl};



    console.log("this is your updated student data "+ JSON.stringify(studentPersonalData));

    const baseURL = "http://localhost:8080/studentPersonalProfile/update"

    try{
        const response = await fetch(baseURL, {
            method: "PUT",
            headers: {
                'Content-Type': "application/json"
            },
            body: JSON.stringify(studentPersonalData)
        });
        if(response.ok) {
            alert("Student updated successfully");
            window.location.href = "../ViewStudents/index.html";
        }

    } catch (error) {
        console.log("error is coming while updating the student" + error);
        document.querySelector('.updatedForm').reset();
    }

}
