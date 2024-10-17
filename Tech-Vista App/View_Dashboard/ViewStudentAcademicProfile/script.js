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

