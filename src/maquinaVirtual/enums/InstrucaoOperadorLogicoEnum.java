package maquinaVirtual.enums;

public enum InstrucaoOperadorLogicoEnum {
	INV("INV",""),
	AND("AND",""),
	OR("OR",""),
	NEG("NEG","");
	private String instrucao;
	private String comentario;
	
	private InstrucaoOperadorLogicoEnum(String instrucao, String comentario) {
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
		for(InstrucaoOperadorLogicoEnum instOperadorLogico: InstrucaoOperadorLogicoEnum.values()) {
			if(instOperadorLogico.getInstrucao().equals(instrucao))
				return true;
		}
		return false;
	}
}
