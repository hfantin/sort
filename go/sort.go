package main

import (
	"fmt"
	"math"
	"math/rand"
	"os"
	"sort"
	"strconv"
	"time"
)

func main() {
	inicio := time.Now()
	if len(os.Args) != 2 {
		fmt.Println("Informe a potencia")
		os.Exit(1)
	}
	potencia, err := strconv.ParseFloat(os.Args[1], 64)
	if err != nil {
		fmt.Printf("valor invalido")
		os.Exit(1)
	}
	total := math.Pow(10, potencia)

	fmt.Printf("Ordenador de listas - JAVASCRIPT\n")
	fmt.Printf("ordena lista com tamanho %.2f (10^%.2f)\n", potencia, total)
	totalInt := int(total)

	list := rand.Perm(totalInt)
	fmt.Printf("embaralhando...\n")
	for i := range list {
		list[i]++
	}
	fmt.Printf("ordenando...\n")
	sort.Ints(list)
	tempoExecucao := time.Since(inicio)
	fmt.Printf("tempo total %s \n", tempoExecucao)

}
