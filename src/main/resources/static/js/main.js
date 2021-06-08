let auditClick = false;
let checkElement = null;
let removeClickValue = true;
let checkClickElement = false;

function checkHover(element) {
    let id = element.getAttribute("data-Myid");
    let create_at = element.getAttribute("data-createdAt");
    let update_at = element.getAttribute("data-modifiedAt");
    if(!auditClick) {
        document.querySelector(".controlElement").style.display = "block";
        document.getElementById("infoId").innerHTML = id;
        document.getElementById("infoCreateAt").innerHTML = create_at;
        document.getElementById("infoUpdateAt").innerHTML = update_at;
    }
}

function checkLeave(){
    if(!auditClick)
        document.querySelector(".controlElement").style.display = "none";
}

function checkClick(element){
    let elem = element.getAttribute("data-id");
    let id = element.getAttribute("data-Myid");
    let create_at = element.getAttribute("data-createdAt");
    let update_at = element.getAttribute("data-modifiedAt");
    if((checkElement === elem || checkElement === null) && removeClickValue) {
        auditClick = !auditClick;
        if (auditClick) {
            element.classList.add("clickTH");
            checkElement = elem;
            checkClickElement = true;
        }
        else {
            element.classList.remove("clickTH");
            checkElement = null;
            checkClickElement = false;
        }
        document.getElementById("infoId").innerHTML = id;
        document.getElementById("infoCreateAt").innerHTML = create_at;
        document.getElementById("infoUpdateAt").innerHTML = update_at;
    }
    removeClickValue = true;
}

function removeClick(){
    if(!checkClickElement) {
        removeClickValue = false;
        auditClick = false;
        checkElement = null;
        document.querySelectorAll(".tbl-content table tr").forEach(elem => elem.classList.remove("clickTH"));
    }
}

function copyID(){
    navigator.clipboard.writeText(document.getElementById("infoId").textContent)
        .then(
            getMessage()
        )
        .catch(err => {
            console.log('Something went wrong', err);
        });

}