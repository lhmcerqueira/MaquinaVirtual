package maquinaVirtual.moldels;

/** 
 *Essa classe será utilizada como lista para armazenar o aquivo  
 */
public class LinhaArquivo {
	
	private String linha;
	private int numeroLinha;
	private boolean breakpoint;
	
	public LinhaArquivo(String linha, int numeroLinha,boolean breakpoint) {
		super();
		this.linha = linha;
		this.numeroLinha = numeroLinha;
		this.breakpoint = breakpoint;
	}
	public String getLinha() {
		return linha;
	}
	public void setLinhas(String linha) {
		this.linha = linha;
	}
	public int getNumeroLinha() {
		return numeroLinha;
	}
	public void setNumeroLinha(int numeroLinha) {
		this.numeroLinha = numeroLinha;
	}
	public boolean isBreakpoint() {
		return breakpoint;
	}
	public void setBreakpoint(boolean breakpoint) {
		this.breakpoint = breakpoint;
	}
}
