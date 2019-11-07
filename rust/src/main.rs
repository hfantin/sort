extern crate rand;

use std::io;
use std::env;
use std::time::{Instant};
use rand::{thread_rng,Rng};
use std::fs::File;
use std::io::prelude::*;
use std::process;

fn main() {
    // parametros da linha de comando
    let args: Vec<String> = env::args().collect();
    let gravar = args.len() > 1 && args[1] == "gravar";

    
    println!("Ordenador de listas - RUST");
    let potencia = le_console();
    
    let now = Instant::now();

    let mut lista = gerar_lista(10, potencia);
    println!("ordena lista com tamanho {} (10^{})", lista.len(), potencia);

    /* outros testes com array */
    // let mut rng = rand::thread_rng();
    // let total = (10 as u32).pow(potencia);
    // let mut array = Vec::new();
    // for i in 0..total {
    //     //array[i] = rng.gen::<i32>();
    //     array.push(i);
    // }
    // println!("{:?}", array);

    println!("embaralhando...");
    thread_rng().shuffle(&mut lista);

    grava_arquivo(&mut lista, "input.txt", gravar);

    println!("ordenando...");
    lista.sort();

    let tempo_total = now.elapsed();
    let sec = (tempo_total.as_secs() as f64) + (tempo_total.subsec_nanos() as f64 / 1000_000_000.0);

    // println!("tempo total: {}s e {} ns", tempo_total.as_secs(), decimal_mark(tempo_total.subsec_nanos().to_string()));
    println!("tempo total: {}s", sec);

    grava_arquivo(&mut lista, "output.txt", gravar);
}

// fn decimal_mark(s: String) -> String {
//     let mut result = String::with_capacity(s.len() + ((s.len() - 1) / 3));
//     let mut i = s.len();
//     for c in s.chars() {
//         result.push(c);
//         i -= 1;
//         if i > 0 && i % 3 == 0 {
//             result.push('.');
//         }
//     }
//     result
// }

fn gerar_lista(base: u32, potencia: u32) -> Vec<u32> {
    let total = base.pow(potencia);
    (0..total).collect()
}

fn le_console() -> u32 {
    println!("Digite a quantidade de elementos(10 ^ x): ");
    let mut input = String::new();
    io::stdin().read_line(& mut input).expect("Falha na leitura da linha");
    let is_number = &input.trim().parse::<u32>();
    match is_number {
        Ok(value) => *value, 
        Err(e) => {
            // eprintln!("erro: {:?}", e);
            // 1
            // panic!("{}", e)
            println!("{:?}", e);
            process::exit(1)
        },
    }
}

fn grava_arquivo(lista: &mut Vec<u32>, arquivo: &str, gravar: bool) {
    if gravar {
        println!("gravando arquivo {}", arquivo);
        let mut f = File::create(arquivo).unwrap();
        for i in lista {
            write!(f, "{:?}\r\n", * i).expect("Unable to write data");
        }
    }

}