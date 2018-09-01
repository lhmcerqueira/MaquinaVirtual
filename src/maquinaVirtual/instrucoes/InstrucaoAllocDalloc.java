package maquinaVirtual.instrucoes;

import maquinaVirtual.enums.InstrucaoAllocDallocEnum;

public class InstrucaoAllocDalloc {
	public static void executa(String instrucao, String[] elementosLinha, String[] pilhaDeMemoria, int indiceMemoria) {
		InstrucaoAllocDallocEnum instEnum = InstrucaoAllocDallocEnum.valueOf(instrucao);
		int m = Integer.parseInt(elementosLinha[1]);
		int n = Integer.parseInt(elementosLinha[2]);
		switch(instEnum) {
		case ALLOC :
			for(int k = 0; k <= n-1; k++) {
				indiceMemoria++;
				pilhaDeMemoria[indiceMemoria] = pilhaDeMemoria[m+k];
			}
			break;
		case DALLOC:
			for(int k = n-1; k>= 0; k-- ) {
				pilhaDeMemoria[m+k] = pilhaDeMemoria[indiceMemoria];
				indiceMemoria--;
			}
			break;
		}
	}
}
