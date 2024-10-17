async function handleSubmit(event) {
    event.preventDefault();


    const memberName = document.getElementById("memberName").value;
    const societyName = document.getElementById("societyName").value;
    const imgUrl = document.getElementById("imgUrl").value;

    const societyMemberData = { memberName,societyName,imgUrl};



    console.log("this is your society member data "+ JSON.stringify(societyMemberData));

    const baseURL = "http://localhost:8080/societyMember/add"

    try{
        const response = await fetch(baseURL, {
            method: "POST",
            headers: {
                'Content-Type': "application/json"
            },
            body: JSON.stringify(societyMemberData)
        });

        if(response.ok) {
            alert("Society member data Added Successfully");
            document.querySelector('.societyMember-form').reset();
            window.location.href = "../ViewSocietyMembers/index.html";
        }
    } catch (error) {
        console.log("error is coming while adding the society member data" + error);
        document.querySelector('.societyMember-form').reset();
    }

}
