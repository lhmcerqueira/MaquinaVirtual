package maquinaVirtual.instrucoes;

import java.util.List;

import maquinaVirtual.enums.InstrucaoAllocDallocEnum;

public class InstrucaoAllocDalloc {
	public static int executa(String instrucao, List<String> elementosLinha, String[] pilhaDeMemoria, int indiceMemoria) {
		InstrucaoAllocDallocEnum instEnum = InstrucaoAllocDallocEnum.valueOf(instrucao);
		int m = Integer.parseInt(elementosLinha.get(1));
		int n = Integer.parseInt(elementosLinha.get(2));
		switch(instEnum) {
		case ALLOC :
			for(int k = 0; k <= n-1; k++) {
				indiceMemoria++;
				pilhaDeMemoria[indiceMemoria] = pilhaDeMemoria[m+k];
			}
			return indiceMemoria;
		case DALLOC:
			for(int k = n-1; k>= 0; k-- ) {
				pilhaDeMemoria[m+k] = pilhaDeMemoria[indiceMemoria];
				indiceMemoria--;
			}
			return indiceMemoria;
		default:
			return 0;
		}
	}
}
