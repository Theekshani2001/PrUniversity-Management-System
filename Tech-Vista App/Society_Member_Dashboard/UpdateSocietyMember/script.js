
document.addEventListener("DOMContentLoaded", () => {
    const urlParams = new URLSearchParams(window.location.search);


    document.getElementById("updatedId").value = urlParams.get('societyMemberId');
    document.getElementById("updatedMemberName").value = urlParams.get('memberName');
    document.getElementById("updatedSocietyName").value = urlParams.get('societyName');
    document.getElementById("updatedImgUrl").value = urlParams.get("imgUrl");
});


async function updateSocietyMember(event) {
    event.preventDefault();

    const societyMemberId= document.getElementById("updatedId").value;
    const memberName = document.getElementById("updatedMemberName").value;
    const societyName = document.getElementById("updatedSocietyName").value;
    const imgUrl = document.getElementById("updatedImgUrl").value;

    const societyMemberData = { societyMemberId,memberName,societyName,imgUrl};



    console.log("this is your updated society member data "+ JSON.stringify(societyMemberData));

    const baseURL = "http://localhost:8080/societyMember/update"

    try{
        const response = await fetch(baseURL, {
            method: "PUT",
            headers: {
                'Content-Type': "application/json"
            },
            body: JSON.stringify(societyMemberData)
        });
        if(response.ok) {
            alert("Society member updated successfully");
            window.location.href = "../ViewSocietyMembers/index.html";
        }

    } catch (error) {
        console.log("error is coming while updating the society member" + error);
        document.querySelector('.updatedForm').reset();
    }

}
