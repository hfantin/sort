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

let inicio = new Date().getTime();
let potencia = process.argv[2] || 1;
console.log(potencia);
let lista = [...Array(10 ** potencia).keys()].map(i => i + 1);
let embaralhada = shuffle(lista);
let ordenada = embaralhada.sort((a, b) => a - b);
let fim = new Date().getTime();
let tempo = (fim - inicio) / 1000; // em ms

console.log(tempo + " s");

