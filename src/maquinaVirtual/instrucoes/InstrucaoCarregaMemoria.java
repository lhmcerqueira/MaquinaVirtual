package maquinaVirtual.instrucoes;

import maquinaVirtual.enums.InstrucaoCarregaMemoriaEnum;

public class InstrucaoCarregaMemoria {
	public static void executa(String instrucao, String[] elementosLinha, String[] pilhaDeMemoria, int indiceMemoria) {
		InstrucaoCarregaMemoriaEnum instEnum = InstrucaoCarregaMemoriaEnum.valueOf(instrucao);
		switch(instEnum) {
		case LDC:
			//S:=s + 1;
			pilhaDeMemoria[indiceMemoria]=elementosLinha[1];
			break;
		case LDV:
			//S:=s + 1;
			pilhaDeMemoria[indiceMemoria]=pilhaDeMemoria[Integer.parseInt(elementosLinha[1])];
			break;

		}

	}
}
