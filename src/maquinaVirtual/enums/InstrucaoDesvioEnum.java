package maquinaVirtual.enums;

public enum InstrucaoDesvioEnum {
	JMP("JMP",""),
	JMPF("JMPF","");
	private String instrucao;
	private String comentario;
	
	private InstrucaoDesvioEnum(String instrucao, String comentario) {
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
		for(InstrucaoDesvioEnum instDesvio: InstrucaoDesvioEnum.values()) {
			if(instDesvio.getInstrucao().equals(instrucao))
				return true;
		}
		return false;
	}
}
