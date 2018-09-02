package maquinaVirtual.moldels;

public class ConjuntoIndices {

	private int indiceArquivo;
	private int indiceMemoria;
	public ConjuntoIndices() {
		
	}
	public ConjuntoIndices(int indiceArquivo, int indiceMemoria) {
		super();
		this.indiceArquivo = indiceArquivo;
		this.indiceMemoria = indiceMemoria;
	}
	public int getIndiceArquivo() {
		return indiceArquivo;
	}
	public void setIndiceArquivo(int indiceArquivo) {
		this.indiceArquivo = indiceArquivo;
	}
	public int getIndiceMemoria() {
		return indiceMemoria;
	}
	public void setIndiceMemoria(int indiceMemoria) {
		this.indiceMemoria = indiceMemoria;
	}
	
}
