function validateRegistration() {
    let name = document.getElementById("name").value;
    let email = document.getElementById("email").value;
    if (name === "" || !email.includes("@")) {
        alert("Enter valid name and email.");
        return false;
    }
    return true;
}

function loadInternships() {
    fetch("ajax/internshipList.jsp")
        .then(res => res.text())
        .then(data => document.getElementById("internshipDropdown").innerHTML = data);
}
