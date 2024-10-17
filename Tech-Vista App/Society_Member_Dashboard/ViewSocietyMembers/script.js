document.addEventListener("DOMContentLoaded", () => {
    fetchSocietyMember();

    const searchInput = document.getElementById("searchSocietyMember");
    searchInput.addEventListener("input", filterSocietyMembers);
});

let allSocietyMembers = [];
async function fetchSocietyMember() {
    try {
        const response = await fetch('http://localhost:8080/societyMember/all');
        if (response.ok) {
            allSocietyMembers = await response.json();
            displaySocietyMembers(allSocietyMembers);
        } else {
            console.error("Failed to fetch society member data");
        }
    } catch (error) {
        console.error("Error occurred while fetching the society member data: " + error);
    }
}

function displaySocietyMembers(societyMembers) {
    const tbody = document.getElementById("tbody");
    tbody.innerHTML = ''; // Clear existing table content

    societyMembers.forEach(societyMember => {
        const row = document.createElement("tr");
        row.innerHTML = `
            <td>${societyMember.societyMemberId}</td>
            <td>${societyMember.memberName}</td>
            <td>${societyMember.societyName}</td>
            <td><img src="${societyMember.imgUrl}" alt="${societyMember.memberName}'s profile"></td>
            <td>
                <i class="fas fa-trash action-icon" onclick="deleteSocietyMember('${societyMember.societyMemberId}')"></i>
                <i class="fas fa-edit action-icon update" onclick="updateSocietyMember('${societyMember.societyMemberId}', '${societyMember.memberName}', '${societyMember.societyName}', '${societyMember.imgUrl}')"></i>
            </td>
        `;
        tbody.appendChild(row);
    });
}
function filterSocietyMembers() {
    const query = document.getElementById("searchSocietyMember").value.toLowerCase();
    const filteredSocietyMembers = allSocietyMembers.filter(societyMember => societyMember.memberName.toLowerCase().includes(query));
    displaySocietyMembers(filteredSocietyMembers);
}

async function deleteSocietyMember(societyMemberId) {
    const baseURL = `http://localhost:8080/societyMember/delete/${societyMemberId}`;
    try {
        const response = await fetch(baseURL, { method: 'DELETE' });
        if (response.ok) {
            alert("Society member deleted successfully");
            fetchSocietyMember(); // Refresh the student list
        } else {
            console.error("Failed to delete society member");
        }
    } catch (error) {
        console.error("Error occurred while deleting the society member data: " + error);
    }
}

function updateSocietyMember(societyMemberId, memberName,societyName,imgUrl) {
    window.location.href = `../UpdateSocietyMember/index.html?societyMemberId=${societyMemberId}&memberName=${memberName}&societyName=${societyName}&imgUrl=${imgUrl}`;
}
