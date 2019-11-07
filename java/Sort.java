
import java.util.Arrays;
import util.Util;
import java.text.NumberFormat;
import java.util.Locale;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Sort {

	private static final NumberFormat nf = NumberFormat.getNumberInstance(new Locale("pt", "BR"));	
	public static void main(String[] args) {
		System.out.println("Ordenador de listas - JAVA");
		long inicio = System.nanoTime();
		Double potencia = 3D;
		if(args.length > 0){
		 	 potencia = Double.valueOf(args[0]);
		}
		int total = (int) Math.pow(10d, potencia);
		System.out.println("ordena lista com tamanho "+total +" (10^" + potencia + ")");
		System.out.println("criando lista...");
		int [] lista = new int[total];
		for (int i=0; i < total; i++){
			 lista[i] = i;
		}
		System.out.println("embaralhando lista...");
		Util.shuffle(lista);
		System.out.println("ordenando lista...");
		Arrays.sort(lista);
		long tempoTotal = System.nanoTime() - inicio;
		System.out.println("tempo total=" + nf.format(tempoTotal) + " ns");
		gravarArquivo(lista);
	}

	private static void gravarArquivo(int [] data) {
		System.out.println("gravando arquivo output.txt");
		long inicio = System.nanoTime();
		BufferedWriter writer = null;
		try
		{
			writer = new BufferedWriter( new FileWriter("output.txt"));
			for (int item : data){
				writer.write(item + ", ");
			}
		} catch ( IOException e){
			System.out.println("Error - " + e.toString());
		} finally {
			try {
				if ( writer != null)
				writer.close( );
			} catch ( IOException e){
				System.out.println("Error - " + e.toString());
			}
			long tempoTotal = System.nanoTime() - inicio;
			System.out.println("tempo=" + nf.format(tempoTotal) + " ns");
		}
	}
	
}


