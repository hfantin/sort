package sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sort {

	
	public static void main(String[] args) {
		 long inicio = System.currentTimeMillis();
		 Double potencia = 3D;
		 if(args.length > 0){
		 	 potencia = Double.valueOf(args[0]);
		 }
		 int total = (int) Math.pow(10d, potencia);
		 System.out.println("Ordenador de listas - JAVA");
		 System.out.println("ordena lista com tamanho "+total +" (10^" + potencia + ")");
		 System.out.println("criando lista...");
		 List lista = new ArrayList<Integer>(); // IntStream.range(0, total).boxed().collect(Collectors.toList());
		 for(int i = 0; i < total; i++){
			 lista.add(i);
		 }
		 System.out.println("embaralhando lista...");
		 Collections.shuffle(lista);
		 System.out.println("ordenando lista...");
	     lista.sort(Comparator.naturalOrder());
	     System.out.println("tempo total=" + (System.currentTimeMillis() - inicio) + " ms");
	}
}