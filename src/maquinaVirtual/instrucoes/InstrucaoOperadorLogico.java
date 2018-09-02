package maquinaVirtual.instrucoes;

import maquinaVirtual.enums.InstrucaoOperadorLogicoEnum;

public class InstrucaoOperadorLogico {
public static void executa(String instrucao, String[] elementosLinha, String[] pilhaDeMemoria, int indiceMemoria) {
		
	InstrucaoOperadorLogicoEnum instEnum = InstrucaoOperadorLogicoEnum.valueOf(instrucao);
		int operando1 = Integer.parseInt(pilhaDeMemoria[indiceMemoria-1]);
		int operando2 = Integer.parseInt(pilhaDeMemoria[indiceMemoria]);
		int resultado = 0;
		switch(instEnum) {
		case INV:
			resultado = operando2 * -1;
			pilhaDeMemoria[indiceMemoria-1]= String.valueOf(resultado);
			break;
		case AND:
			resultado = (operando1 == 1 && operando2 == 1? 1 : 0);
			pilhaDeMemoria[indiceMemoria-1]= String.valueOf(resultado);
			indiceMemoria --;
			break;
		case OR:
			resultado = (operando1 == 1 || operando2 == 1? 1 : 0);;
			pilhaDeMemoria[indiceMemoria-1]= String.valueOf(resultado);
			indiceMemoria --;
			break;
		case NEG:
			resultado =  1 - operando2;
			pilhaDeMemoria[indiceMemoria-1]= String.valueOf(resultado);
			break;
		}
	}
}