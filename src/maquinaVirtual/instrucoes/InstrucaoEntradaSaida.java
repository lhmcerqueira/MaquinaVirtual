package maquinaVirtual.instrucoes;

import maquinaVirtual.enums.InstrucaoEntradaSaidaEnum;

public class InstrucaoEntradaSaida {
	public static int executa(String instrucao, String[] elementosLinha, String[] pilhaDeMemoria, int indiceMemoria) {
		InstrucaoEntradaSaidaEnum instEnum = InstrucaoEntradaSaidaEnum.valueOf(instrucao);
		switch(instEnum) {
		case RD:
			indiceMemoria++;
			pilhaDeMemoria[indiceMemoria]="pr�ximo valor de entrada";
			return indiceMemoria;
			
		case PRN:
			return indiceMemoria--;
		default : 
			return 0;
		}

	}
}
