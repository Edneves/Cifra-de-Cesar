package projetoCripto;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CriarArquivo {
	
	public static String escrever(String endereco, String txtConteudo) {
		
		FileWriter arq;
		try {
			
			arq = new FileWriter(endereco +".txt");
			PrintWriter gravarArq = new PrintWriter(arq);
			gravarArq.printf(txtConteudo);
			arq.close();

		} catch (IOException e1) { e1.printStackTrace(); }
			
		return txtConteudo;
	}	
}
