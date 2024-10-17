
document.addEventListener("DOMContentLoaded", () => {
    const urlParams = new URLSearchParams(window.location.search);


    document.getElementById("updatedId").value = urlParams.get('academicStaffId');
    document.getElementById("updatedAcademicEmail").value = urlParams.get('academicEmail');
    document.getElementById("updatedName").value = urlParams.get('name');
    document.getElementById("updatedBirthdate").value = urlParams.get("birthdate");
    document.getElementById("updatedPosition").value = urlParams.get("position");
    document.getElementById("updatedAddress").value = urlParams.get('address');
    document.getElementById("updatedFaculty").value = urlParams.get("faculty");
    document.getElementById("updatedImgUrl").value = urlParams.get("imgUrl");
});


async function updateAcademicStaff(event) {
    event.preventDefault();

    const academicStaffId= document.getElementById("updatedId").value;
    const academicEmail = document.getElementById("updatedAcademicEmail").value;
    const name = document.getElementById("updatedName").value;
    const birthdate = document.getElementById("updatedBirthdate").value;
    const position = document.getElementById("updatedPosition").value;
    const address = document.getElementById("updatedAddress").value;
    const faculty = document.getElementById("updatedFaculty").value;
    const imgUrl = document.getElementById("updatedImgUrl").value;

    const academicStaffData = { academicStaffId,academicEmail,name,birthdate,position,address,faculty,imgUrl};



    console.log("this is your updated academic staff data "+ JSON.stringify(academicStaffData));

    const baseURL = "http://localhost:8080/academicStaff/update"

    try{
        const response = await fetch(baseURL, {
            method: "PUT",
            headers: {
                'Content-Type': "application/json"
            },
            body: JSON.stringify(academicStaffData)
        });
        if(response.ok) {
            alert("Academic staff updated successfully");
            window.location.href = "../ViewAcademicStaff/index.html";
        }

    } catch (error) {
        console.log("error is coming while updating the c data" + error);
        document.querySelector('.updatedForm').reset();
    }

}
