var numero;
var numeroAuxiliar = 0;
var numeroResultado = 0;
var ultimo = "";
function boton(valor) {
    var visor = document.getElementById("visor");
    var inputValue = document.getElementById("visor").value;
    if (ultimo == "d") {
        numeroAuxiliar = numeroAuxiliar / parseInt(inputValue);
    }
    if (ultimo != "i") {
        if (inputValue == "0") {
            visor.setAttribute('value', String(valor));
        }
        else {
            visor.setAttribute('value', "".concat(inputValue) + String(valor));
        }
        var cadena = "".concat(inputValue) + String(valor);
        numero = parseInt(cadena);
    }
    imprimir();
}
function btn_suma() {
    var visor = document.getElementById("visor");
    var m = document.getElementById("visor").value;
    if (m != "" && ultimo != "i") {
        numeroAuxiliar = numeroAuxiliar + parseInt(m);
    }
    numero = 0;
    if (numeroAuxiliar != 0) {
        visor.setAttribute('value', "");
    }
    else {
        visor.setAttribute('value', String(numeroAuxiliar));
    }
    ultimo = "s";
    imprimir();
}
function btn_resta() {
    var visor = document.getElementById("visor");
    var m = document.getElementById("visor").value;
    if (m != "" && ultimo != "i" && numeroAuxiliar != 0) {
        numeroAuxiliar = numeroAuxiliar - parseInt(m);
    }
    numero = 0;
    if (numeroAuxiliar != 0) {
        visor.setAttribute('value', "");
    }
    else {
        visor.setAttribute('value', String(numeroAuxiliar));
    }
    ultimo = "r";
    imprimir();
}
function btn_divide() {
    var visor = document.getElementById("visor");
    var m = document.getElementById("visor").value;
    if (m != "" && ultimo != "i") {
        if (!(numeroAuxiliar == 0)) {
            numeroAuxiliar = numeroAuxiliar / parseInt(m);
        }
    }
    numero = 0;
    if (numeroAuxiliar != 0) {
        visor.setAttribute('value', "");
    }
    else {
        visor.setAttribute('value', String(numeroAuxiliar));
    }
    ultimo = "d";
    imprimir();
}
function btn_igual() {
    var visor = document.getElementById("visor");
    var m = document.getElementById("visor").value;
    if (m != "") {
        switch (ultimo) {
            case "s":
                numeroAuxiliar = numeroAuxiliar + parseInt(m);
                break;
            case "r":
                numeroAuxiliar = numeroAuxiliar - parseInt(m);
                break;
            case "d":
                numeroAuxiliar = numeroAuxiliar / parseInt(m);
                break;
        }
    }
    visor.setAttribute('value', String(numeroAuxiliar));
    ultimo = "i";
    imprimir();
}
function reset() {
    var visor = document.getElementById("visor");
    visor.setAttribute('value', "0");
    numero = 0;
    numeroAuxiliar = 0;
    ultimo = "res";
}
function imprimir() {
    console.log("Valor de numero:" + numero);
    console.log("Valor de auxiliar:" + numeroAuxiliar);
}
