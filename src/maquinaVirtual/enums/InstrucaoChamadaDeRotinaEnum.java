package maquinaVirtual.enums;

public enum InstrucaoChamadaDeRotinaEnum {
	CALL("NEG",""),
	RETURN("","");
	private String instrucao;
	private String comentario;
	
	private InstrucaoChamadaDeRotinaEnum(String instrucao, String comentario) {
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
		for(InstrucaoChamadaDeRotinaEnum instChamadaRotina: InstrucaoChamadaDeRotinaEnum.values()) {
			if(instChamadaRotina.getInstrucao().equals(instrucao))
				return true;
		}
		return false;
	}
}
