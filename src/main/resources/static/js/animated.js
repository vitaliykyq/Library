let checkMessage = false;

let message = document.getElementById("blockMessage");

function getMessage(){
    if(!checkMessage) {
        console.log(message);
        message.style.animation = ".3s linear 0s 1 forwards showMessage";
        checkMessage = true;
        setTimeout(hideAnimatedMessage, 2000);
    }
}

function hideAnimatedMessage(){
    message.style.animation = ".3s linear 0s 1 forwards hideMessage";
    setTimeout(removeAnimatedMessage, 300);
}

function removeAnimatedMessage(){
    checkMessage = false;
}
