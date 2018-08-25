package maquinaVirtual.enums;

public enum InstrucaoNullEnum {

	NULL("NULL","Nada");
	private String instrucao;
	private String comentario;
	InstrucaoNullEnum(String instrucao, String comentario){
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
		for(InstrucaoNullEnum instNull: InstrucaoNullEnum.values()) {
			if(instNull.getInstrucao().equals(instrucao))
				return true;
		}
		return false;
	}
}
