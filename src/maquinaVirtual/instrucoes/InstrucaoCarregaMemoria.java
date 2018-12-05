package maquinaVirtual.instrucoes;

import java.util.List;

import maquinaVirtual.enums.InstrucaoCarregaMemoriaEnum;

public class InstrucaoCarregaMemoria {
	public static int executa(String instrucao, List<String> elementosLinha, String[] pilhaDeMemoria, int indiceMemoria) {
		InstrucaoCarregaMemoriaEnum instEnum = InstrucaoCarregaMemoriaEnum.valueOf(instrucao);
		switch(instEnum) {
		case LDC:
			indiceMemoria++;
			pilhaDeMemoria[indiceMemoria]=elementosLinha.get(1);
			return indiceMemoria;
		case LDV:
			indiceMemoria++;
			pilhaDeMemoria[indiceMemoria]=pilhaDeMemoria[Integer.parseInt(elementosLinha.get(1))];
			return indiceMemoria;
		default: 
			return 0;
		}

	}
}
