document.addEventListener("click", function (event) {
    const dropdowns = document.querySelectorAll(".dropdown-content");
    dropdowns.forEach((dropdown) => {
        const parent = dropdown.parentNode;
        if (parent.contains(event.target)) {
            dropdown.style.display = dropdown.style.display === "block" ? "none" : "block";
        } else {
            dropdown.style.display = "none";
        }
    });
});
