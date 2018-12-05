package maquinaVirtual.instrucoes;

import java.util.List;

import maquinaVirtual.enums.InstrucaoAritimeticaEnum;

public class InstrucaoAritimetica {

	public static int executa(String instrucao, List<String> elementosLinha, String[] pilhaDeMemoria, int indiceMemoria) {
		
		InstrucaoAritimeticaEnum instEnum = InstrucaoAritimeticaEnum.valueOf(instrucao);
		int operando1 = Integer.parseInt(pilhaDeMemoria[indiceMemoria-1]);
		int operando2 = Integer.parseInt(pilhaDeMemoria[indiceMemoria]);
		int resultado = 0;
		switch(instEnum) {
		case ADD:
			resultado = operando1 + operando2;
			break;
		case SUB:
			resultado = operando1 - operando2;
			break;
		case MULT:
			resultado = operando1 * operando2;
			break;
		case DIVI:
			resultado = operando1 / operando2;
			break;
		}
		pilhaDeMemoria[indiceMemoria-1]= String.valueOf(resultado);
		return indiceMemoria-1;
	}
}
