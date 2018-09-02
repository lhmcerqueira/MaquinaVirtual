package maquinaVirtual.instrucoes;

import maquinaVirtual.enums.InstrucaoAritimeticaEnum;
import maquinaVirtual.enums.InstrucaoCompararEnum;

public class InstrucaoComparar {
	public static int executa(String instrucao, String[] elementosLinha, String[] pilhaDeMemoria, int indiceMemoria) {

		
		InstrucaoCompararEnum instEnum = InstrucaoCompararEnum.valueOf(instrucao);
		int valor1 = Integer.parseInt(pilhaDeMemoria[indiceMemoria-1]);
		int valor2 = Integer.parseInt(pilhaDeMemoria[indiceMemoria]);
		int resultado = 0;
		switch(instEnum) {
		case CDIF:
			resultado =	(valor1 != valor2? 1 : 0);
			break;
		case CEQ:
			resultado =	(valor1 == valor2? 1 : 0);
			break;
		case CMA:
			resultado =	(valor1 > valor2? 1 : 0);
			break;
		case CME:
			resultado =	(valor1 < valor2? 1 : 0);
			break;
		case CMEQ:
			resultado =	(valor1 <= valor2? 1 : 0);
			break;
		case CMAQ:
			resultado =	(valor1 >= valor2? 1 : 0);
			break;
		}
		pilhaDeMemoria[indiceMemoria-1]= String.valueOf(resultado);
		return indiceMemoria--;
	}
}
