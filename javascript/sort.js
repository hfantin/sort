function shuffle(arra1) {
    let ctr = arra1.length;
    let temp;
    let index;
   while (ctr > 0) {
        index = Math.floor(Math.random() * ctr);
        ctr--;
        temp = arra1[ctr];
        arra1[ctr] = arra1[index];
        arra1[index] = temp;
    }
    return arra1;
}


console.log("Ordenador de listas - JAVASCRIPT");

let inicio = new Date().getTime();
const potencia = process.argv[2] || 1;
const total = 10 ** potencia;
console.log("ordena lista com tamanho "+total +" (10^" + potencia + ")");
console.log("criando lista...");
let lista = [...Array(total).keys()].map(i => i + 1);
console.log("embaralhando...");
let embaralhada = shuffle(lista);
console.log("ordenando...");
let ordenada = embaralhada.sort((a, b) => a - b);
let fim = new Date().getTime();
let tempo = (fim - inicio) / 1000; // em ms

console.log(tempo + " s");

