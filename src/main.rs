use std::io;
use std::time::{Instant};
use rand::{thread_rng, Rng};
use std::fs::File;
use std::io::prelude::*;

fn main() {
    let now = Instant::now();
    let base: u32 = 10;
    let mut input = String::new();
    println!("******************* ordenador de listas *******************");
    println!("Digite a quantidade de elementos(10 ^ x): ");
    io::stdin().read_line(&mut input).expect("Falha na leitura da linha");
    let potencia: u32 = input.trim().parse::<u32>().unwrap();
    let total = base.pow(potencia);
    let mut lista: Vec<u32> = (0..total).collect();

    println!("ordena lista com tamanho {} (10^{})", lista.len(), potencia);

    // embaralha lista
    println!("embaralhando...");
    thread_rng().shuffle(&mut lista);

    // println!("lista original: {:?}", lista);
    println!("ordenando...");
    lista.sort();
    // println!("lista ordenada: {:?}", lista);
    println!("tempo total: {}s", now.elapsed().as_secs());
    // grava arquivo
    println!("gravando arquivo de resultado");
    let mut f = File::create("resultado.txt").unwrap();
     for i in &lista{
        write!(f, "{:?}\r\n", *i).expect("Unable to write data");
    }
}