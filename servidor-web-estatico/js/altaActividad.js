const tocheck = Array.prototype.slice.call(document.querySelectorAll(".non-empty"));

function validateForm(elements) {
    for (const el of elements) {
        if (el.value != "") continue;
        return false;
    };
    return true;
}

const form = document.querySelector("#form");

document.querySelector("#submitBtn").addEventListener("click", (event)=> {
    event.preventDefault();
    form.classList.add("was-validated");
    if (validateForm(tocheck)) window.location.replace("homeLogueado.html");
})
