async function handleSubmit(event) {
    event.preventDefault();

    const societyName = document.getElementById("societyName").value;
    const description = document.getElementById("description").value;
    const numOfSocietyMembers = document.getElementById("numOfSocietyMembers").value;
    const teacherInCharge = document.getElementById("teacherInCharge").value;
    const imgUrl = document.getElementById("imgUrl").value;

    const societyData = { societyName,description,numOfSocietyMembers,teacherInCharge,imgUrl};



    console.log("this is your society data "+ JSON.stringify(societyData));

    const baseURL = "http://localhost:8080/society/add"

    try{
        const response = await fetch(baseURL, {
            method: "POST",
            headers: {
                'Content-Type': "application/json"
            },
            body: JSON.stringify(societyData)
        });

        if(response.ok) {
            alert("Society data Added Successfully");
            document.querySelector('.society-form').reset();
            window.location.href = "../ViewSocieties/index.html";
        }
    } catch (error) {
        console.log("error is coming while adding the society data" + error);
        document.querySelector('.society-form').reset();
    }

}
