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
            <td>
                <i class="fas fa-trash action-icon" onclick="deleteAcademicStaff('${academicStaff.academicStaffId}')"></i>
                <i class="fas fa-edit action-icon update" onclick="updateAcademicStaff('${academicStaff.academicStaffId}', '${academicStaff.academicEmail}', '${academicStaff.name}', '${academicStaff.birthdate}', '${academicStaff.position}', '${academicStaff.address}', '${academicStaff.faculty}', '${academicStaff.imgUrl}')"></i>
            </td>
        `;
        tbody.appendChild(row);
    });
}

function filterAcademicStaffs() {
    const query = document.getElementById("searchAcademicStaff").value.toLowerCase();
    const filteredAcademicStaffs = allAcademicStaffs.filter(academicStaff => academicStaff.name.toLowerCase().includes(query));
    displayAcademicStaffs(filteredAcademicStaffs);
}

async function deleteAcademicStaff(academicStaffId) {
    const baseURL = `http://localhost:8080/academicStaff/delete/${academicStaffId}`;
    try {
        const response = await fetch(baseURL, { method: 'DELETE' });
        if (response.ok) {
            alert("Academic staff member deleted successfully");
            fetchAcademicStaff(); // Refresh the student list
        } else {
            console.error("Failed to delete academic staff member");
        }
    } catch (error) {
        console.error("Error occurred while deleting the academic staff member data: " + error);
    }
}

function updateAcademicStaff(academicStaffId, academicEmail, name, birthdate, position, address, faculty, imgUrl) {
    window.location.href = `../UpdateAcademicStaff/index.html?academicStaffId=${academicStaffId}&academicEmail=${academicEmail}&name=${name}&birthdate=${birthdate}&position=${position}&address=${address}&faculty=${faculty}&imgUrl=${imgUrl}`;
}
