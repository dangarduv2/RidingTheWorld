var numero;
var numeroAuxiliar;
var numeroResultado;
function boton(valor) {
    var visor = document.getElementById("visor");
    var inputValue = document.getElementById("visor").value;
    visor.setAttribute('value', "".concat(inputValue) + String(valor));
    var cadena = "".concat(inputValue) + String(valor);
    numero = parseInt(cadena);
    console.log(numeroAuxiliar);
}
function btn_suma() {
    var visor = document.getElementById("visor");
    var inputValue = document.getElementById("visor").value;
    visor.setAttribute('value', "");
    numeroAuxiliar = numero;
    numero = 0;
    console.log(numero);
    console.log(numeroAuxiliar);
}
