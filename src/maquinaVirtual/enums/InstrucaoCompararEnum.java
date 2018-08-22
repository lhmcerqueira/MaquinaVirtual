package maquinaVirtual.enums;

public enum InstrucaoCompararEnum {
	CME("INV",""),
	CMA("AND",""),
	CEQ("OR",""),
	CDIF("AND",""),
	CMEQ("OR",""),
	CMMQ("NEG","");
	private String instrucao;
	private String comentario;
	
	private InstrucaoCompararEnum(String instrucao, String comentario) {
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
		for(InstrucaoCompararEnum instComparar: InstrucaoCompararEnum.values()) {
			if(instComparar.getInstrucao().equals(instrucao))
				return true;
		}
		return false;
	}
}
