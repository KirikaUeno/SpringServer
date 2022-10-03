const cathodeTemperature = document.getElementById("cathode-temperature");
const cathodeVoltage = document.getElementById("cathode-voltage");
const cathodeCurrent = document.getElementById("cathode-current");
const cathodeUptime = document.getElementById("cathode-uptime");
const filamentVoltage = document.getElementById("filament-voltage");
const filamentCurrent = document.getElementById("filament-current");
const power = document.getElementById("power");
const pressure = document.getElementById("pressure");
const piTemperature = document.getElementById("pi-temperature");
const cathodeOn = document.getElementById("cathode-on");
const filamentOn = document.getElementById("filament-on");
const cathodeVoltageInput = document.getElementById("cathode-voltage-input");
const cathodeCurrentInput = document.getElementById("cathode-current-input");

console.log(cathodeCurrentInput);

cathodeOn.addEventListener("change", function(){
    var xmlHttp = new XMLHttpRequest();
    xmlHttp.open( "GET", "http://127.0.0.1:8080/cathodeOnCheckBox", false);
    xmlHttp.send( null );
    console.log(xmlHttp.responseText);
});

filamentOn.addEventListener("change", function(){
    var xmlHttp = new XMLHttpRequest();
    xmlHttp.open( "GET", "http://127.0.0.1:8080/filamentOnCheckBox", false);
    xmlHttp.send( null );
    console.log(xmlHttp.responseText);
});

cathodeVoltageInput.addEventListener("change", function(){
    console.log(cathodeVoltageInput.nodeValue);
    var xmlHttp = new XMLHttpRequest();
    xmlHttp.open( "GET", "http://127.0.0.1:8080/cathodeVoltage?value="+cathodeVoltageInput.value, false);
    xmlHttp.send( null );
    console.log(xmlHttp.responseText);
});

cathodeCurrentInput.addEventListener("change", function(){
    console.log(cathodeCurrentInput.nodeValue);
    var xmlHttp = new XMLHttpRequest();
    xmlHttp.open( "GET", "http://127.0.0.1:8080/cathodeCurrent?value="+cathodeCurrentInput.value, false);
    xmlHttp.send( null );
    console.log(xmlHttp.responseText);
});


function updateInfo() {
    var xmlHttp = new XMLHttpRequest();
    xmlHttp.open( "GET", "http://127.0.0.1:8080/getupdates", false);
    xmlHttp.send( null );
    console.log(xmlHttp.responseText);
    var words = xmlHttp.responseText.split("||");
    cathodeTemperature.innerText = words[0];
    cathodeVoltage.innerText = words[1];
    cathodeCurrent.innerText = words[2];
    cathodeUptime.innerText = words[3];
    filamentVoltage.innerText = words[4];
    filamentCurrent.innerText = words[5];
    power.innerText = words[6];
    pressure.innerText = words[7];
    piTemperature.innerText = words[8];
    setTimeout(updateInfo, 1000);
}

setTimeout(updateInfo, 1000);