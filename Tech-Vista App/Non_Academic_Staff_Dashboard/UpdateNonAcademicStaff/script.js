
document.addEventListener("DOMContentLoaded", () => {
    const urlParams = new URLSearchParams(window.location.search);


    document.getElementById("updatedId").value = urlParams.get('nonAcademicStaffId');
    document.getElementById("updatedNonAcademicStaffMail").value = urlParams.get('nonAcademicStaffMail');
    document.getElementById("updatedName").value = urlParams.get('name');
    document.getElementById("updatedBirthdate").value = urlParams.get("birthdate");
    document.getElementById("updatedPosition").value = urlParams.get("position");
    document.getElementById("updatedAddress").value = urlParams.get('address');
    document.getElementById("updatedImgUrl").value = urlParams.get("imgUrl");
});


async function updateNonAcademicStaff(event) {
    event.preventDefault();

    const nonAcademicStaffId= document.getElementById("updatedId").value;
    const nonAcademicStaffMail = document.getElementById("updatedNonAcademicStaffMail").value;
    const name = document.getElementById("updatedName").value;
    const birthdate = document.getElementById("updatedBirthdate").value;
    const position = document.getElementById("updatedPosition").value;
    const address = document.getElementById("updatedAddress").value;
    const imgUrl = document.getElementById("updatedImgUrl").value;

    const nonAcademicStaffData = { nonAcademicStaffId,nonAcademicStaffMail,name,birthdate,position,address,imgUrl};



    console.log("this is your updated non academic staff data "+ JSON.stringify(nonAcademicStaffData));

    const baseURL = "http://localhost:8080/nonAcademicStaff/update"

    try{
        const response = await fetch(baseURL, {
            method: "PUT",
            headers: {
                'Content-Type': "application/json"
            },
            body: JSON.stringify(nonAcademicStaffData)
        });
        if(response.ok) {
            alert("Non academic staff member updated successfully");
            window.location.href = "../ViewNonAcademicStaff/index.html";
        }

    } catch (error) {
        console.log("error is coming while updating the Non academic staff member data" + error);
        document.querySelector('.updatedForm').reset();
    }

}
