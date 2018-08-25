package maquinaVirtual.moldels;

import java.util.List;

import maquinaVirtual.enums.InstrucaoAritimeticaEnum;

public class InstrucaoAritimetica {

	public static void executa(String instrucao, String[] elementosLinha, List<String> pilhaDeMemoria, int indiceMemoria) {
		
		InstrucaoAritimeticaEnum instEnum = InstrucaoAritimeticaEnum.valueOf(instrucao);
		int operando1 = Integer.parseInt(pilhaDeMemoria.get(indiceMemoria-1));
		int operando2 = Integer.parseInt(pilhaDeMemoria.get(indiceMemoria));
		int resultado = 0;
		switch(instEnum) {
		case ADD:
			resultado = operando1 + operando2;
			break;
		case SUB:
			resultado = operando1 - operando2;
			break;
		case MULT:
			resultado = operando1 - operando2;
			break;
		case DIVI:
			resultado = operando1 / operando2;
			break;
		}
		pilhaDeMemoria.add(indiceMemoria-1, String.valueOf(resultado));
	}
}
