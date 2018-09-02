package maquinaVirtual.instrucoes;

import maquinaVirtual.enums.InstrucaoCarregaMemoriaEnum;

public class InstrucaoCarregaMemoria {
	public static int executa(String instrucao, String[] elementosLinha, String[] pilhaDeMemoria, int indiceMemoria) {
		InstrucaoCarregaMemoriaEnum instEnum = InstrucaoCarregaMemoriaEnum.valueOf(instrucao);
		switch(instEnum) {
		case LDC:
			indiceMemoria++;
			pilhaDeMemoria[indiceMemoria]=elementosLinha[1];
			return indiceMemoria;
		case LDV:
			indiceMemoria++;
			pilhaDeMemoria[indiceMemoria]=pilhaDeMemoria[Integer.parseInt(elementosLinha[1])];
			return indiceMemoria;
		default: 
			return 0;
		}

	}
}
