package projetoCripto;

public class Descriptografar {
	public static String descriptografa(int chave, String texto) {
		////--Variável para armazenar o texto criptografado--////	
	StringBuilder textoDecifrado = new StringBuilder();
		////--Variável com tamanho do texto que será cifrado--////
	int tamanhoText = texto.length();
	
	////--Laço para descriptografar 1 caracter por vez--////
	for(int i=0; i < tamanhoText; i++) {
		////--Verifica se o caracter digitado é uma letra do alfabeto e checa o índice a que ela pertence--////
		if(Character.isAlphabetic(texto.charAt(i))) {
			if (Character.isUpperCase(texto.charAt(i)))  
			{ 
				////--Se o caracter digitado for uma letra do alfabeto e caixa alta, executará este trecho--////
				char letra = (char)(((int)texto.charAt(i) + (26-chave) - 65) % 26 + 65); 		
				textoDecifrado.append(letra); 
			} 
			  
			else
			{ 
				 ////--Se o caracter digitado for uma letra do alfabeto e caixa baixa, executará este trecho--////
				char letra = (char)(((int)texto.charAt(i) + (26-chave) - 97) % 26 + 97);		 
				textoDecifrado.append(letra);  	
			}
		} else {
			////--Caso não satisfaça nenhuma das condições acima, a variável apenas armazenará o índice do caracter--////
			textoDecifrado.append(texto.charAt(i));
		}

	}
	////--Metódo retornará conteúdo da variável convertido para string--////
	return textoDecifrado.toString();
	}
}
