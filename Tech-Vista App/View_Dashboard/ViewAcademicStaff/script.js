document.addEventListener("DOMContentLoaded", () => {
    fetchAcademicStaff();


    const searchInput = document.getElementById("searchAcademicStaff");
    searchInput.addEventListener("input", filterAcademicStaffs);
});

let allAcademicStaffs = [];

async function fetchAcademicStaff() {
    try {
        const response = await fetch('http://localhost:8080/academicStaff/all');
        if (response.ok) {
            allAcademicStaffs = await response.json();
            displayAcademicStaffs(allAcademicStaffs);
        } else {
            console.error("Failed to fetch academic staff data");
        }
    } catch (error) {
        console.error("Error occurred while fetching the academic staff data: " + error);
    }
}

function displayAcademicStaffs(academicStaffs) {
    const tbody = document.getElementById("tbody");
    tbody.innerHTML = ''; // Clear existing table content

    academicStaffs.forEach(academicStaff => {
        const row = document.createElement("tr");
        row.innerHTML = `
            <td>${academicStaff.academicStaffId}</td>
            <td>${academicStaff.academicEmail}</td>
            <td>${academicStaff.name}</td>
            <td>${academicStaff.birthdate}</td>
            <td>${academicStaff.position}</td>
            <td>${academicStaff.address}</td>
            <td>${academicStaff.faculty}</td>
            <td><img src="${academicStaff.imgUrl}" alt="${academicStaff.name}'s profile"></td>
        `;
        tbody.appendChild(row);
    });
}

function filterAcademicStaffs() {
    const query = document.getElementById("searchAcademicStaff").value.toLowerCase();
    const filteredAcademicStaffs = allAcademicStaffs.filter(academicStaff => academicStaff.name.toLowerCase().includes(query));
    displayAcademicStaffs(filteredAcademicStaffs);
}

