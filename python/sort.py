from random import shuffle
import datetime

def main():
    print("Ordenador de listas - PYTHON")
    potencia = int(input("Digite a quantidade de elementos(10 ^ x):"))
    total  = 10 ** potencia
    start_time = datetime.datetime.now()
    lista = range(total)
    print("ordena lista com tamanho {} (10^{})".format(len(lista), potencia))
    # print('lista original: {}'.format(lista))
    print("embaralhando...")
    shuffle(lista)
    # print('lista embaralhada: {}'.format(lista))
    print("ordenando...")
    lista.sort()
    elapsed_time = datetime.datetime.now() - start_time
    # print('lista ordenada: {}'.format(lista))
    print('tempo total: {}:{}'.format(elapsed_time.seconds, elapsed_time.microseconds))

main()

