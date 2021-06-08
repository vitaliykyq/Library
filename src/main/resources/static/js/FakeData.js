let obj = {
    "id": "60b6cb1ed3f8fa77032ff7da",
    "name": "Гаррі Поттер і філософський камінь",
    "author": "Joanne",
    "number_pages": 826,
    "genre": ["фентезі", "Роман"],
    "price": 120,
    "quantity": 6,
    "purchase": "21.03.2021",
    "language": "UK",
    "create_at": "Wed Jun 02 03:04:46 EEST 2021",
    "update_at": "Wed Jun 02 03:04:46 EEST 2021",
}

let obj2 = {
    "id": "40363b663592fb579665f99f",
    "name": "Шерлок Холмс",
    "author": "Joanne",
    "number_pages": 629,
    "genre": "детективні розповіді",
    "price": 120,
    "quantity": 6,
    "purchase": "21.03.2021",
    "language": "UK",
    "create_at": "Fir Jun 03 07:04:46 EEST 2020",
    "update_at": "",
}


let table = document.querySelector(".tbl-content tbody");

let info = "<tr onmouseenter='checkHover(obj)' onclick='checkClick(obj, this)'>\n";



let button12 = "<div class=\"content\">\n" +
    "    <div class=\"buttons\">\n" +
    "        <div id=\"five\" class=\"button\" onclick='removeClick()'>" + obj.author + "</div>\n" +
    "    </div>\n" +
    "</div>\n"

info += "<td>" + obj.name + "</td>\n";
info += "<td>" + button12 + "</td>\n";
info += "<td>" + obj.number_pages + "</td>\n";
info += "<td>" + obj.genre + "</td>\n";
info += "<td>" + obj.price + "</td>\n";
info += "<td>" + obj.quantity + "</td>\n";
info += "<td>" + obj.purchase + "</td>\n";
info += "<td>" + obj.language + "</td>\n";
info += "<tr>\n";

info += "<tr onmouseenter='checkHover(obj2)' onclick='checkClick(obj2, this)' >\n";
info += "<td>" + obj2.name + "</td>\n";
info += "<td>" + obj2.author + "</td>\n";
info += "<td>" + obj2.number_pages + "</td>\n";
info += "<td>" + obj2.genre + "</td>\n";
info += "<td>" + obj2.price + "</td>\n";
info += "<td>" + obj2.quantity + "</td>\n";
info += "<td>" + obj2.purchase + "</td>\n";
info += "<td>" + obj2.language + "</td>\n";
info += "<tr>\n";



let result = "";

for(let i = 0; i < 40; i++){
    result+= info
}

table.innerHTML = result;