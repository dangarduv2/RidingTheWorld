
var numero :number;
var numeroAuxiliar :number =0;
var numeroResultado :number=0;
var ultimo :String ="";


function boton(valor:number) {
    var visor:(HTMLElement|null)  = document.getElementById("visor");
    var inputValue = (<HTMLInputElement>document.getElementById("visor")).value;

    

    if(ultimo!="i"){
        if(inputValue=="0"){
            visor!.setAttribute('value', String(valor));
    
        }else{
            visor!.setAttribute('value', `${inputValue}`+ String(valor));
        }
            var cadena = `${inputValue}`+ String(valor);
    
            numero = parseInt(cadena);
    }


        imprimir();
}


function btn_suma() {
    var visor:(HTMLElement|null)  = document.getElementById("visor");
    var m = (<HTMLInputElement>document.getElementById("visor")).value;

    if(m!="" && ultimo!="i"
    ){  if(ultimo=="d"){
        numeroAuxiliar = numeroAuxiliar/parseInt(m);
    }else if(ultimo=="d"){

    }else{
        numeroAuxiliar= numeroAuxiliar+parseInt(m);
    }
        
    }
    

    numero=0;
    if(numeroAuxiliar!=0){
        visor!.setAttribute('value', "");

    }else{
        visor!.setAttribute('value', String(numeroAuxiliar));
    }

    

     ultimo ="s";

     imprimir();
}


function btn_resta() {
    var visor:(HTMLElement|null)  = document.getElementById("visor");
    var m = (<HTMLInputElement>document.getElementById("visor")).value;

    if(m!="" && ultimo!="i" && numeroAuxiliar!=0){
        numeroAuxiliar= numeroAuxiliar-parseInt(m);
    }
    

    numero=0;
    if(numeroAuxiliar!=0){
        visor!.setAttribute('value', "");

    }else{
        visor!.setAttribute('value', String(numeroAuxiliar));
    }

    if(ultimo=="d"){
        numeroAuxiliar = numeroAuxiliar/parseInt(m);
    }
     ultimo ="r";

     imprimir();
}

function btn_multiplica() {
    var visor:(HTMLElement|null)  = document.getElementById("visor");
    var m = (<HTMLInputElement>document.getElementById("visor")).value;

    if(m!="" && ultimo!="i"){
            numeroAuxiliar= numeroAuxiliar*parseInt(m);
    }
    
    if(numero!=0 && numeroAuxiliar==0){
        numeroAuxiliar=numero;
    }
    numero=0;
    
    if(numeroAuxiliar!=0){
        visor!.setAttribute('value', "");

    }else{
        visor!.setAttribute('value', String(numeroAuxiliar));
    }

     ultimo ="m";

     imprimir();
}

function btn_divide() {
    var visor:(HTMLElement|null)  = document.getElementById("visor");
    var m = (<HTMLInputElement>document.getElementById("visor")).value;

    if(m!="" && ultimo!="i"){
            numeroAuxiliar= numeroAuxiliar/parseInt(m);
    }
    
    if(numero!=0 && numeroAuxiliar==0){
        numeroAuxiliar=numero;
    }
    numero=0;
    
    if(numeroAuxiliar!=0){
        visor!.setAttribute('value', "");

    }else{
        visor!.setAttribute('value', String(numeroAuxiliar));
    }

     ultimo ="d";

     imprimir();
}


function btn_igual() {
    var visor:(HTMLElement|null)  = document.getElementById("visor");
    var m = (<HTMLInputElement>document.getElementById("visor")).value;

    if(m!=""){
    switch(ultimo){
        case "s": numeroAuxiliar= numeroAuxiliar+parseInt(m); break;
        case "r": numeroAuxiliar= numeroAuxiliar-parseInt(m); break;
        case "d": numeroAuxiliar= numeroAuxiliar/parseInt(m); break;
        case "m": numeroAuxiliar= numeroAuxiliar*parseInt(m); break;
    }
}
    visor!.setAttribute('value', String(numeroAuxiliar));
    
    ultimo="i";
    imprimir();
}


function reset(){
    var visor:(HTMLElement|null)  = document.getElementById("visor");
    visor!.setAttribute('value', "0");
     numero =0;
     numeroAuxiliar =0;
     ultimo ="res";
}

function imprimir(){
    console.log("Valor de numero:"+numero);
    console.log("Valor de auxiliar:"+numeroAuxiliar);
}

