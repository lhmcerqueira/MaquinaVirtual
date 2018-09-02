package maquinaVirtual.instrucoes;

import maquinaVirtual.enums.InstrucaoEntradaSaidaEnum;

public class InstrucaoEntradaSaida {
	public static String executa(String instrucao, String[] elementosLinha, String[] pilhaDeMemoria, int indiceMemoria) {
		InstrucaoEntradaSaidaEnum instEnum = InstrucaoEntradaSaidaEnum.valueOf(instrucao);
		switch(instEnum) {
		case RD:
			//S:=s + 1;
			pilhaDeMemoria[indiceMemoria]="próximo valor de entrada";
			return pilhaDeMemoria[indiceMemoria];
			
		case PRN:
			indiceMemoria--;
			return pilhaDeMemoria[indiceMemoria];

		default : 
			return"Nada na pilha";
		}

	}
}
