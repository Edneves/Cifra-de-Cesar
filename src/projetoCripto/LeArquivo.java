package projetoCripto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LeArquivo {
	public static String ler(String endereco) {
		
		String conteudo = "";
		
		try {  
			
	         FileReader fr = new FileReader(endereco);
	         BufferedReader bf = new BufferedReader(fr);
	         String linha = "" ; 
	         
	         try {
	                linha = bf.readLine();
	                while (linha != null) {
	                    conteudo += linha;
	                    linha = bf.readLine();
	                }
	                bf.close();

	            } catch (IOException e) {  conteudo = "Erro nao foi possivel ler o arquivo!"; }
	           
	     }catch (Exception e) { System.out.println("Erro "+ e.getMessage()); }
	         
		return conteudo;
	}
}
