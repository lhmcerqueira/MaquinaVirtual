package maquinaVirtual.enums;

public enum InstrucaoCarregaMemoriaEnum {
	LDC("",""),
	LDV("","");
	private String instrucao;
	private String comentario;
	
	private InstrucaoCarregaMemoriaEnum(String instrucao, String comentario) {
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
		for(InstrucaoCarregaMemoriaEnum instCarregaMem: InstrucaoCarregaMemoriaEnum.values()) {
			if(instCarregaMem.getInstrucao().equals(instrucao))
				return true;
		}
		return false;
	}
	
}
