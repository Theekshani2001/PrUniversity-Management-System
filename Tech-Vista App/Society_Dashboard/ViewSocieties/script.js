document.addEventListener("DOMContentLoaded", () => {
    fetchSociety();

    const searchInput = document.getElementById("searchSociety");
    searchInput.addEventListener("input", filterSocieties);
});

let allSocieties = [];
async function fetchSociety() {
    try {
        const response = await fetch('http://localhost:8080/society/all');
        if (response.ok) {
            allSocieties = await response.json();
            displaySocieties(allSocieties);
        } else {
            console.error("Failed to fetch society data");
        }
    } catch (error) {
        console.error("Error occurred while fetching the society data: " + error);
    }
}

// Display students in the table
function displaySocieties(societies) {
    const tbody = document.getElementById("tbody");
    tbody.innerHTML = ''; // Clear existing table content

    societies.forEach(society => {
        const row = document.createElement("tr");
        row.innerHTML = `
            <td>${society.societyId}</td>
            <td>${society.societyName}</td>
            <td>${society.description}</td>
            <td>${society.numOfSocietyMembers}</td>
            <td>${society.teacherInCharge}</td>
            <td><img src="${society.imgUrl}" alt="${society.societyName}'s logo"></td>
            <td>
                <i class="fas fa-trash action-icon" onclick="deleteSociety('${society.societyId}')"></i>
                <i class="fas fa-edit action-icon update" onclick="updateSociety('${society.societyId}', '${society.societyName}', '${society.description}', '${society.numOfSocietyMembers}', '${society.teacherInCharge}', '${society.imgUrl}')"></i>
            </td>
        `;
        tbody.appendChild(row);
    });
}
function filterSocieties() {
    const query = document.getElementById("searchSociety").value.toLowerCase();
    const filteredSocieties = allSocieties.filter(society => society.societyName.toLowerCase().includes(query));
    displaySocieties(filteredSocieties);
}




// Delete a student
async function deleteSociety(societyId) {
    const baseURL = `http://localhost:8080/society/delete/${societyId}`;
    try {
        const response = await fetch(baseURL, { method: 'DELETE' });
        if (response.ok) {
            alert("Society deleted successfully");
            fetchSociety(); // Refresh the student list
        } else {
            console.error("Failed to delete society");
        }
    } catch (error) {
        console.error("Error occurred while deleting the society data: " + error);
    }
}

function updateSociety(societyId, societyName,description,numOfSocietyMembers,teacherInCharge, imgUrl) {
    window.location.href = `../UpdateSociety/index.html?societyId=${societyId}&societyName=${societyName}&description=${description}&numOfSocietyMembers=${numOfSocietyMembers}&teacherInCharge=${teacherInCharge}&imgUrl=${imgUrl}`;
}
