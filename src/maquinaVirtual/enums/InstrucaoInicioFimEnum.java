package maquinaVirtual.enums;

public enum InstrucaoInicioFimEnum {
	START("INV",""),
	HLT("NEG","");
	private String instrucao;
	private String comentario;
	
	private InstrucaoInicioFimEnum(String instrucao, String comentario) {
		this.instrucao = instrucao;
		this.comentario = comentario;
	}
	public String getInstrucao() {
		return instrucao;
	}
	public String getComentario() {
		return comentario;
	}
	public boolean contains(String instrucao) {
		for(InstrucaoInicioFimEnum instInicioFim: InstrucaoInicioFimEnum.values()) {
			if(instInicioFim.getInstrucao().equals(instrucao))
				return true;
		}
		return false;
	}
}
