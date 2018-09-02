package maquinaVirtual.instrucoes;

import maquinaVirtual.enums.InstrucaoChamadaDeRotinaEnum;
import maquinaVirtual.moldels.ConjuntoIndices;

public class InstrucaoChamadaDeRotina {
	public static ConjuntoIndices executa(String instrucao, String[] elementosLinha, String[] pilhaDeMemoria, int indiceMemoria, int indiceArquivo) {
		InstrucaoChamadaDeRotinaEnum instEnum = InstrucaoChamadaDeRotinaEnum.valueOf(instrucao);
		switch(instEnum) {
		case CALL:
			indiceMemoria++;
			pilhaDeMemoria[indiceMemoria]=String.valueOf(indiceArquivo);
			indiceArquivo = Integer.parseInt(elementosLinha[1]);
			return retronaConjunto(indiceMemoria, indiceArquivo);
		case RETURN:
			indiceArquivo = Integer.parseInt(pilhaDeMemoria[indiceMemoria]);
			indiceMemoria--;
			return retronaConjunto(indiceMemoria, indiceArquivo);
		
		default: 
			return null;
		}

	}

	private static ConjuntoIndices retronaConjunto(int indiceMemoria, int indiceArquivo) {
		ConjuntoIndices conjunto = new ConjuntoIndices();
		conjunto.setIndiceArquivo(indiceArquivo);
		conjunto.setIndiceMemoria(indiceMemoria);
		return conjunto;
	}

}
