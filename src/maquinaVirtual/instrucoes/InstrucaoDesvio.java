package maquinaVirtual.instrucoes;

import maquinaVirtual.enums.InstrucaoDesvioEnum;
import maquinaVirtual.moldels.ConjuntoIndices;

public class InstrucaoDesvio {
	public static ConjuntoIndices executa(String instrucao, String[] elementosLinha, String[] pilhaDeMemoria, int indiceMemoria, int indiceArquivo) {
		InstrucaoDesvioEnum instEnum = InstrucaoDesvioEnum.valueOf(instrucao);
		
		switch(instEnum) {
		case JMP:
			indiceArquivo = Integer.parseInt(elementosLinha[1]);
			return retornaConjuntoIndices(indiceMemoria, indiceArquivo);
		case JMPF:
			if(Integer.parseInt(pilhaDeMemoria[indiceMemoria])==0) {
				indiceArquivo = Integer.parseInt(elementosLinha[1]);
			}else {
				indiceArquivo++;
			}
			indiceMemoria--;
			return retornaConjuntoIndices(indiceMemoria, indiceArquivo);
		default:
			return null;
		}

	}

	private static ConjuntoIndices retornaConjuntoIndices(int indiceMemoria, int indiceArquivo) {
		ConjuntoIndices conjunto = new ConjuntoIndices();
		conjunto.setIndiceArquivo(indiceArquivo);
		conjunto.setIndiceMemoria(indiceMemoria);
		return conjunto;
	}
}
