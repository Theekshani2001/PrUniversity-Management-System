document.addEventListener("DOMContentLoaded", () => {
    fetchStudentAcademicProfiles();

    // Search student event
    const searchInput = document.getElementById("searchStudentAcademicProfile");
    searchInput.addEventListener("input", filterStudentAcademicProfiles);
});

let allStudentAcademicProfiles = [];  // To hold the fetched students

// Fetch all students
async function fetchStudentAcademicProfiles() {
    try {
        const response = await fetch('http://localhost:8080/studentAcademicProfile/all');
        if (response.ok) {
            allStudentAcademicProfiles = await response.json();
            displayStudentAcademicProfiles(allStudentAcademicProfiles);
        } else {
            console.error("Failed to fetch students' academic data");
        }
    } catch (error) {
        console.error("Error occurred while fetching the students' academic data: " + error);
    }
}

// Display students in the table
function displayStudentAcademicProfiles(studentAcademicProfiles) {
    const tbody = document.getElementById("tbody");
    tbody.innerHTML = ''; // Clear existing table content

    studentAcademicProfiles.forEach(studentAcademicProfile => {
        const row = document.createElement("tr");
        row.innerHTML = `
            <td>${studentAcademicProfile.academicId}</td>
            <td>${studentAcademicProfile.name}</td>
            <td>${studentAcademicProfile.academicMail}</td>
            <td>${studentAcademicProfile.faculty}</td>
            <td>${studentAcademicProfile.degree}</td>
            <td>${studentAcademicProfile.currentGPA}</td>
            <td>${studentAcademicProfile.academicYear}</td>
            <td><img src="${studentAcademicProfile.imgUrl}" alt="${studentAcademicProfile.name}'s profile"></td>
            <td>
                <i class="fas fa-trash action-icon" onclick="deleteStudentAcademicProfile('${studentAcademicProfile.academicId}')"></i>
                <i class="fas fa-edit action-icon update" onclick="updateStudentAcademicProfile('${studentAcademicProfile.academicId}', '${studentAcademicProfile.name}', '${studentAcademicProfile.academicMail}', '${studentAcademicProfile.faculty}', '${studentAcademicProfile.degree}', '${studentAcademicProfile.currentGPA}', '${studentAcademicProfile.academicYear}', '${studentAcademicProfile.imgUrl}')"></i>
            </td>
        `;
        tbody.appendChild(row);
    });
}

// Search and filter students by name
function filterStudentAcademicProfiles() {
    const query = document.getElementById("searchStudentAcademicProfile").value.toLowerCase();
    const filteredStudentAcademicProfiles = allStudentAcademicProfiles.filter(studentAcademicProfile => studentAcademicProfile.name.toLowerCase().includes(query));
    displayStudentAcademicProfiles(filteredStudentAcademicProfiles);
}




// Delete a student
async function deleteStudentAcademicProfile(academicId) {
    const baseURL = `http://localhost:8080/studentAcademicProfile/delete/${academicId}`;
    try {
        const response = await fetch(baseURL, { method: 'DELETE' });
        if (response.ok) {
            alert("Student Academic Profile deleted successfully");
            fetchStudentAcademicProfiles();
        } else {
            console.error("Failed to delete student academic profile");
        }
    } catch (error) {
        console.error("Error occurred while deleting the student academic data: " + error);
    }
}

// Update student information
function updateStudentAcademicProfile(academicId, name, academicMail, faculty, degree, currentGPA, academicYear, imgUrl) {
    window.location.href = `../UpdateStudentAcademicProfile/index.html?academicId=${academicId}&name=${name}&academicMail=${academicMail}&faculty=${faculty}&degree=${degree}&currentGPA=${currentGPA}&academicYear=${academicYear}&imgUrl=${imgUrl}`;
}
