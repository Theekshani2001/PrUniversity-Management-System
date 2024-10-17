document.addEventListener("DOMContentLoaded", () => {
    fetchStudent();

    // Search student event
    const searchInput = document.getElementById("searchStudent");
    searchInput.addEventListener("input", filterStudents);
});

let allStudents = [];  // To hold the fetched students

// Fetch all students
async function fetchStudent() {
    try {
        const response = await fetch('http://localhost:8080/studentPersonalProfile/all');
        if (response.ok) {
            allStudents = await response.json();
            displayStudents(allStudents);
        } else {
            console.error("Failed to fetch students data");
        }
    } catch (error) {
        console.error("Error occurred while fetching the student data: " + error);
    }
}

// Display students in the table
function displayStudents(students) {
    const tbody = document.getElementById("tbody");
    tbody.innerHTML = ''; // Clear existing table content

    students.forEach(student => {
        const row = document.createElement("tr");
        row.innerHTML = `
            <td>${student.studentId}</td>
            <td>${student.name}</td>
            <td>${student.personalMail}</td>
            <td>${student.address}</td>
            <td>${student.birthdate}</td>
            <td>${student.phone}</td>
            <td>${student.faculty}</td>
            <td><img src="${student.imgUrl}" alt="${student.name}'s profile"></td>
            <td>
                <i class="fas fa-trash action-icon" onclick="deleteStudent('${student.studentId}')"></i>
                <i class="fas fa-edit action-icon update" onclick="updateStudent('${student.studentId}', '${student.name}', '${student.personalMail}', '${student.birthdate}', '${student.address}', '${student.phone}', '${student.faculty}', '${student.imgUrl}')"></i>
            </td>
        `;
        tbody.appendChild(row);
    });
}

// Search and filter students by name
function filterStudents() {
    const query = document.getElementById("searchStudent").value.toLowerCase();
    const filteredStudents = allStudents.filter(student => student.name.toLowerCase().includes(query));
    displayStudents(filteredStudents);
}




// Delete a student
async function deleteStudent(studentId) {
    const baseURL = `http://localhost:8080/studentPersonalProfile/delete/${studentId}`;
    try {
        const response = await fetch(baseURL, { method: 'DELETE' });
        if (response.ok) {
            alert("Student deleted successfully");
            fetchStudent(); // Refresh the student list
        } else {
            console.error("Failed to delete student");
        }
    } catch (error) {
        console.error("Error occurred while deleting the student data: " + error);
    }
}

// Update student information
function updateStudent(studentId, name, personalMail, birthdate, address, phone, faculty, imgUrl) {
    window.location.href = `../UpdateStudent/index.html?studentId=${studentId}&name=${name}&personalMail=${personalMail}&birthdate=${birthdate}&address=${address}&phone=${phone}&faculty=${faculty}&imgUrl=${imgUrl}`;
}
