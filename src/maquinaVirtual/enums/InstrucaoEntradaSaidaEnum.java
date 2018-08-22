package maquinaVirtual.enums;

public enum InstrucaoEntradaSaidaEnum {
	RD("NEG",""),
	PRN("","");
	private String instrucao;
	private String comentario;
	
	private InstrucaoEntradaSaidaEnum(String instrucao, String comentario) {
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
		for(InstrucaoEntradaSaidaEnum instEntradaSaida: InstrucaoEntradaSaidaEnum.values()) {
			if(instEntradaSaida.getInstrucao().equals(instrucao))
				return true;
		}
		return false;
	}
}
