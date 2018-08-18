package maquinaVirtual.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JFileChooser;

import maquinaVirtual.moldels.LinhaArquivo;

public class AbridorDeArquivos {

	/*
	 * String que contem o arquivo lido e separado por linhas
	 */
	private List<LinhaArquivo> arquivo;
	
	public AbridorDeArquivos() {
		this.arquivo = new ArrayList<>();
	}
	
	public List<LinhaArquivo> getArquivo() {
		return arquivo;
	}

	/**
	 * Metodo que abre o arquivo selecionado, ele usa o componente
	 * JfileChooser e armazena o que foi lido no atributo String
	 * arquivo
	 * @throws FileNotFoundException
	 */
	public List<LinhaArquivo> abrirArquivo() throws FileNotFoundException {
		JFileChooser  jFileChooser = new JFileChooser();
		StringBuilder strbldr = new StringBuilder();
		
		//Assim que o arquivo é escolhido o leitor começa a armazenar as linhas.
		if(jFileChooser.showOpenDialog(null) == jFileChooser.APPROVE_OPTION) {
			File file = jFileChooser.getSelectedFile();
			Scanner input = new Scanner(file);
			int numeroLinha=0;
			while(input.hasNext()) {
				//linhas sendo armazendas
				this.arquivo.add(new LinhaArquivo(input.nextLine(), numeroLinha,false));
				numeroLinha++;
			}
			input.close();	
		} else {
			this.arquivo.add(new LinhaArquivo("Nenhum arquivo foi selecionado",0,false));
		}
		return arquivo;	
	}
}
