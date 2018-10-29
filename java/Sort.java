package sort;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Sort {

	
	public static void main(String[] args) {
		 long inicio = System.currentTimeMillis();
		 int total = (int) Math.pow(10d, 7d);
		 List lista =  IntStream.range(0, total).boxed().collect(Collectors.toList());
		 System.out.println("embaralhando lista...");
		 Collections.shuffle(lista);
//	     System.out.println(lista);
		 System.out.println("ordenando lista...");
	     lista.sort(Comparator.naturalOrder());
//	     System.out.println(lista);
	     System.out.println("tempo total=" + (System.currentTimeMillis() - inicio) + " ms");
	}
}