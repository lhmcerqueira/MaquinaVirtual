package maquinaVirtual.instrucoes;

import java.util.List;

import maquinaVirtual.enums.InstrucaoDesvioEnum;
import maquinaVirtual.moldels.ConjuntoIndices;
import maquinaVirtual.moldels.LinhaArquivo;

public class InstrucaoDesvio {
	public static ConjuntoIndices executa(String instrucao, List<String> elementosLinha, String[] pilhaDeMemoria, int indiceMemoria, int indiceArquivo, List<LinhaArquivo> arquivo) {
		InstrucaoDesvioEnum instEnum = InstrucaoDesvioEnum.valueOf(instrucao);
		
		switch(instEnum) {
		case JMP:
			indiceArquivo = pegaIndiceJump(elementosLinha, indiceArquivo, arquivo);

			return retornaConjuntoIndices(indiceMemoria, indiceArquivo);
		case JMPF:
			if(Integer.parseInt(pilhaDeMemoria[indiceMemoria])==0) {
				
				indiceArquivo = pegaIndiceJump(elementosLinha, indiceArquivo, arquivo);
			}else {
				indiceArquivo++;
			}
			indiceMemoria--;
			return retornaConjuntoIndices(indiceMemoria, indiceArquivo);
		default:
			return null;
		}

	}

	private static int pegaIndiceJump(List<String> elementosLinha, int indiceArquivo, List<LinhaArquivo> arquivo) {
		for(int i=0; i < arquivo.size(); i++) {
			if(arquivo.get(i).getLinha().contains(elementosLinha.get(1))
					&& arquivo.get(i).getLinha().contains("NULL")) {
				indiceArquivo = i;
				break;
			}
		}
		return indiceArquivo;
	}

	private static ConjuntoIndices retornaConjuntoIndices(int indiceMemoria, int indiceArquivo) {
		ConjuntoIndices conjunto = new ConjuntoIndices();
		conjunto.setIndiceArquivo(indiceArquivo);
		conjunto.setIndiceMemoria(indiceMemoria);
		return conjunto;
	}
}
