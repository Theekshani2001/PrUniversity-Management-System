document.addEventListener("DOMContentLoaded", () => {
    fetchNonAcademicStaff();


    const searchInput = document.getElementById("searchNonAcademicStaff");
    searchInput.addEventListener("input", filterNonAcademicStaffs);
});

let allNonAcademicStaffs = [];

async function fetchNonAcademicStaff() {
    try {
        const response = await fetch('http://localhost:8080/nonAcademicStaff/all');
        if (response.ok) {
            allNonAcademicStaffs = await response.json();
            displayNonAcademicStaffs(allNonAcademicStaffs);
        } else {
            console.error("Failed to fetch non academic staff data");
        }
    } catch (error) {
        console.error("Error occurred while fetching the non academic staff data: " + error);
    }
}

function displayNonAcademicStaffs(nonAcademicStaffs) {
    const tbody = document.getElementById("tbody");
    tbody.innerHTML = ''; // Clear existing table content

    nonAcademicStaffs.forEach(nonAcademicStaff => {
        const row = document.createElement("tr");
        row.innerHTML = `
            <td>${nonAcademicStaff.nonAcademicStaffId}</td>
            <td>${nonAcademicStaff.nonAcademicStaffMail}</td>
            <td>${nonAcademicStaff.name}</td>
            <td>${nonAcademicStaff.birthdate}</td>
            <td>${nonAcademicStaff.position}</td>
            <td>${nonAcademicStaff.address}</td>
            <td><img src="${nonAcademicStaff.imgUrl}" alt="${nonAcademicStaff.name}'s profile"></td>
            <td>
                <i class="fas fa-trash action-icon" onclick="deleteNonAcademicStaff('${nonAcademicStaff.nonAcademicStaffId}')"></i>
                <i class="fas fa-edit action-icon update" onclick="updateNonAcademicStaff('${nonAcademicStaff.nonAcademicStaffId}', '${nonAcademicStaff.nonAcademicStaffMail}', '${nonAcademicStaff.name}', '${nonAcademicStaff.birthdate}', '${nonAcademicStaff.position}', '${nonAcademicStaff.address}', '${nonAcademicStaff.imgUrl}')"></i>
            </td>
        `;
        tbody.appendChild(row);
    });
}

function filterNonAcademicStaffs() {
    const query = document.getElementById("searchNonAcademicStaff").value.toLowerCase();
    const filteredNonAcademicStaffs = allNonAcademicStaffs.filter(nonAcademicStaff => nonAcademicStaff.name.toLowerCase().includes(query));
    displayNonAcademicStaffs(filteredNonAcademicStaffs);
}

async function deleteNonAcademicStaff(nonAcademicStaffId) {
    const baseURL = `http://localhost:8080/nonAcademicStaff/delete/${nonAcademicStaffId}`;
    try {
        const response = await fetch(baseURL, { method: 'DELETE' });
        if (response.ok) {
            alert("Non Academic staff member deleted successfully");
            fetchNonAcademicStaff();
        } else {
            console.error("Failed to delete non academic staff member");
        }
    } catch (error) {
        console.error("Error occurred while deleting the non academic staff member data: " + error);
    }
}

function updateNonAcademicStaff(nonAcademicStaffId, nonAcademicStaffMail, name, birthdate, position, address, imgUrl) {
    window.location.href = `../UpdateNonAcademicStaff/index.html?nonAcademicStaffId=${nonAcademicStaffId}&nonAcademicStaffMail=${nonAcademicStaffMail}&name=${name}&birthdate=${birthdate}&position=${position}&address=${address}&imgUrl=${imgUrl}`;
}
