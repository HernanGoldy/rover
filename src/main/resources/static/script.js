// Creo una función para ubicar el Rover y colocar algunas piedras en el mapa
function crearMapa() {
    // Hacer un llamado al backend para que nos traiga toda esta información
    moverRover(1, 1);
    crearRoca(2, 1);
    crearRoca(1, 3);
    crearRoca(4, 5);
    crearRoca(6, 6);
}

function moverRover(y, x) {
    document.getElementById("rover").style.top = (y * 100) + "px";
    document.getElementById("rover").style.left = (x * 100) + "px";
}

function crearRoca(y, x) {
    var roca = document.createElement("img");
    //roca.setAttribute("src", "images/rock.png");
    //roca.setAttribute("class", "roca");
    roca.src = "images/rock.png";
    roca.className = "roca";

    var contenedor = document.getElementById("container");
    contenedor.appendChild(roca);

    roca.style.top = (y * 100) + "px";
    roca.style.left = (x * 100) + "px";
}