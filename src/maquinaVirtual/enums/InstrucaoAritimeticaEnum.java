package maquinaVirtual.enums;

public enum InstrucaoAritimeticaEnum {
	ADD("ADD",""),
	SUB("SUB",""),
	MULT("MULT",""),
	DIVI("DIVI","");
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
	public static boolean contains(String instrucao) {
		for(InstrucaoAritimeticaEnum instAririmetica: InstrucaoAritimeticaEnum.values()) {
			if(instAririmetica.getInstrucao().equals(instrucao))
				return true;
		}
		return false;
	}
	
}
