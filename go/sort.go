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

	fmt.Printf("potencia %.2f total: %.2f \n", potencia, total)
	totalInt := int(total)

	// lista := make([]int, totalInt)
	// for i := range lista {
	// 	lista[i] = i
	// 	fmt.Printf("%d \n", i)
	// }
	list := rand.Perm(totalInt)
	for i, _ := range list {
		list[i]++
	}
	// fmt.Printf("lista embaralhada %d\n", list)
	sort.Ints(list)
	// fmt.Printf("lista ordenada: %d\n", list)
	tempo_execucao := time.Since(inicio)
	fmt.Printf("tempo total %s \n", tempo_execucao)

}
