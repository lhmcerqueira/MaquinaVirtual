package maquinaVirtual.enums;

public enum InstrucaoAritimeticaEnum {
	ADD("",""),
	SUB("",""),
	MULT("",""),
	DIVI("","");
	private String instrucao;
	private String comentario;
	
	private InstrucaoAritimeticaEnum(String instrucao, String comentario) {
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
		for(InstrucaoAritimeticaEnum instAririmetica: InstrucaoAritimeticaEnum.values()) {
			if(instAririmetica.getInstrucao().equals(instrucao))
				return true;
		}
		return false;
	}
	
}
