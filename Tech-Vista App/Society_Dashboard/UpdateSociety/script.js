
document.addEventListener("DOMContentLoaded", () => {
    const urlParams = new URLSearchParams(window.location.search);


    document.getElementById("updatedId").value = urlParams.get('societyId');
    document.getElementById("updatedSocietyName").value = urlParams.get('societyName');
    document.getElementById("updatedDescription").value = urlParams.get('description');
    document.getElementById("updatedNumOfSocietyMembers").value = urlParams.get('numOfSocietyMembers');
    document.getElementById("updatedTeacherInCharge").value = urlParams.get("teacherInCharge");
    document.getElementById("updatedImgUrl").value = urlParams.get("imgUrl");
});


async function updateSociety(event) {
    event.preventDefault();

    const societyId= document.getElementById("updatedId").value;
    const societyName = document.getElementById("updatedSocietyName").value;
    const description = document.getElementById("updatedDescription").value;
    const numOfSocietyMembers = document.getElementById("updatedNumOfSocietyMembers").value;
    const teacherInCharge = document.getElementById("updatedTeacherInCharge").value;
    const imgUrl = document.getElementById("updatedImgUrl").value;

    const societyData = { societyId,societyName,description,numOfSocietyMembers,teacherInCharge,imgUrl};



    console.log("this is your updated society data "+ JSON.stringify(societyData));

    const baseURL = "http://localhost:8080/society/update"

    try{
        const response = await fetch(baseURL, {
            method: "PUT",
            headers: {
                'Content-Type': "application/json"
            },
            body: JSON.stringify(societyData)
        });
        if(response.ok) {
            alert("Society updated successfully");
            window.location.href = "../ViewSocieties/index.html";
        }

    } catch (error) {
        console.log("error is coming while updating the society" + error);
        document.querySelector('.updatedForm').reset();
    }

}
