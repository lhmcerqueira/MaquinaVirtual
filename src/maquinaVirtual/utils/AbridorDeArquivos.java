package maquinaVirtual.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFileChooser;

public class AbridorDeArquivos {

	/*
	 * String que contem o arquivo lido da pasta selecionada
	 */
	private String arquivo;
	
	public AbridorDeArquivos() {
		this.arquivo = new String();
	}
	
	public String getArquivo() {
		return arquivo;
	}

	/**
	 * Metodo que abre o arquivo selecionado, ele usa o componente
	 * JfileChooser e armazena o que foi lido no atributo String
	 * arquivo
	 * @throws FileNotFoundException
	 */
	public void abrirArquivo() throws FileNotFoundException {
		JFileChooser  jFileChooser = new JFileChooser();
		StringBuilder strbldr = new StringBuilder();
		
		if(jFileChooser.showOpenDialog(null) == jFileChooser.APPROVE_OPTION) {
			File file = jFileChooser.getSelectedFile();
			Scanner input = new Scanner(file);
		}
	}
	//https://www.youtube.com/watch?v=0KvzuUW6Frc
}
