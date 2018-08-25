package maquinaVirtual.enums;

public enum InstrucaoInicioFimEnum {
	START("START",""),
	HLT("HLT","");
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
	public static boolean contains(String instrucao) {
		for(InstrucaoInicioFimEnum instInicioFim: InstrucaoInicioFimEnum.values()) {
			if(instInicioFim.getInstrucao().equals(instrucao))
				return true;
		}
		return false;
	}
}
