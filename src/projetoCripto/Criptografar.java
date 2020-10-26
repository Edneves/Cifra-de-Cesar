package projetoCripto;

public class Criptografar {
	public static String criptografa(int chave, String texto) {
		////--Vari�vel para armazenar o texto criptografado--////	
	StringBuilder textoCifrado = new StringBuilder();
		////--Vari�vel com tamanho do texto que ser� cifrado--////
	int tamanhoText = texto.length();
	
	////--La�o para criptografar 1 caracter por vez--////
	for(int i=0; i < tamanhoText; i++) {
		////--Verifica se o caracter digitado � uma letra do alfabeto e checa o �ndice a que ela pertence--////
		if(Character.isAlphabetic(texto.charAt(i))) {
		
			if (Character.isUpperCase(texto.charAt(i))) 
			{ 
				////--Se o caracter digitado for uma letra do alfabeto e caixa alta, executar� este trecho--////
				char letra = (char)(((int)texto.charAt(i) + chave - 65) % 26 + 65);	 
				textoCifrado.append(letra); 
			} 
			else
			{ 
				////--Se o caracter digitado for uma letra do alfabeto e caixa baixa, executar� este trecho--////
				char letra = (char)(((int)texto.charAt(i) + chave - 97) % 26 + 97);	 
				textoCifrado.append(letra);  	
			}
		} else {
			////--Caso n�o satisfa�a nenhuma das condi��es acima, a vari�vel apenas armazenar� o �ndice do caracter--////
			textoCifrado.append(texto.charAt(i));
		}

	}
	////--Met�do retornar� conte�do da vari�vel convertido para string--////
	return textoCifrado.toString();
	}
}
