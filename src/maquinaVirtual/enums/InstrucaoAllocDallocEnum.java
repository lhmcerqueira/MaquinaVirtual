package maquinaVirtual.enums;

public enum InstrucaoAllocDallocEnum {
	ALLOC("NEG",""),
	DALLOC("","");
	private String instrucao;
	private String comentario;
	
	private InstrucaoAllocDallocEnum(String instrucao, String comentario) {
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
		for(InstrucaoAllocDallocEnum instAllocDalloc: InstrucaoAllocDallocEnum.values()) {
			if(instAllocDalloc.getInstrucao().equals(instrucao))
				return true;
		}
		return false;
	}
}
