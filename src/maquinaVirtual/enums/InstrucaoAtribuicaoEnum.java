package maquinaVirtual.enums;

public enum InstrucaoAtribuicaoEnum {
	STR("STR","");
	private String instrucao;
	private String comentario;
	
	private InstrucaoAtribuicaoEnum(String instrucao, String comentario) {
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
		for(InstrucaoAtribuicaoEnum instAtribuicao: InstrucaoAtribuicaoEnum.values()) {
			if(instAtribuicao.getInstrucao().equals(instrucao))
				return true;
		}
		return false;
	}
}
