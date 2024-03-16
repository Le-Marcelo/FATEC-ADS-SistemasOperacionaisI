package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ArquivoController {

	public ArquivoController() {
		super();
	}
	
	//Função para ler arquivo que esta localizado em "path" com o "nome"
	public void lerArquivo(String path, String nome) throws IOException{
		File arquivo = new File(path, nome);
		
		if(arquivo.exists() && arquivo.isFile()) {
			FileInputStream fluxo = new FileInputStream(arquivo);
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			
			while(linha != null) {
				String vetorLinha[] = linha.split(",");
				if(vetorLinha[2].equals("Fruits")) {
					System.out.println(String.format("[%s \t\t %s \t\t %s]", vetorLinha[0], vetorLinha[1], vetorLinha[3]));
				}
				linha = buffer.readLine();
			}
			
			buffer.close();
			leitor.close();
			fluxo.close();
			
		}else {
			throw new IOException("Arquivo inválido.");
			
		}
	}

}
