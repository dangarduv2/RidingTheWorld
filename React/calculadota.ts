
var numero :number;
var numeroAuxiliar :number;
var numeroResultado :number;



function boton(valor:number) {
    var visor:(HTMLElement|null)  = document.getElementById("visor");
    var inputValue = (<HTMLInputElement>document.getElementById("visor")).value;

        visor!.setAttribute('value', `${inputValue}`+ String(valor));
        var cadena = `${inputValue}`+ String(valor);

        numero = parseInt(cadena);
}


function btn_suma() {
    var visor:(HTMLElement|null)  = document.getElementById("visor");
    var inputValue = (<HTMLInputElement>document.getElementById("visor")).value;

    visor!.setAttribute('value', "");
    
    numeroAuxiliar= numero;
    numero=0;
}

