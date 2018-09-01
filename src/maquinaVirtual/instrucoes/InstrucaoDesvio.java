package maquinaVirtual.instrucoes;

import maquinaVirtual.enums.InstrucaoDesvioEnum;

public class InstrucaoDesvio {
	public static void executa(String instrucao, String[] elementosLinha, String[] pilhaDeMemoria, int indiceMemoria, int indiceArquivo) {
		InstrucaoDesvioEnum instEnum = InstrucaoDesvioEnum.valueOf(instrucao);
		
		switch(instEnum) {
		case JMP:
			jump(elementosLinha,indiceArquivo);
			break;
		case JMPF:
			if(Integer.parseInt(pilhaDeMemoria[indiceMemoria])==0) {
				jump(elementosLinha,indiceArquivo);
			}else {
				indiceArquivo++;
			}
			indiceMemoria--;
			break;

		}

	}

	private static void jump(String[] elementosLinha,int indiceArquivo) {
		indiceArquivo = Integer.parseInt(elementosLinha[1]);
	}
	
}
