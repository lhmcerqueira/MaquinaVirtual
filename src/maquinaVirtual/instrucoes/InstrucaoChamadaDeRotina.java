package maquinaVirtual.instrucoes;

import java.util.List;

import maquinaVirtual.enums.InstrucaoChamadaDeRotinaEnum;
import maquinaVirtual.moldels.ConjuntoIndices;
import maquinaVirtual.moldels.LinhaArquivo;

public class InstrucaoChamadaDeRotina {
	public static ConjuntoIndices executa(String instrucao, List<String> elementosLinha, String[] pilhaDeMemoria, int indiceMemoria, int indiceArquivo,
			List<LinhaArquivo> arquivo,Integer returnfGlobal) {
		InstrucaoChamadaDeRotinaEnum instEnum = InstrucaoChamadaDeRotinaEnum.valueOf(instrucao);
		switch(instEnum) {
		case CALL:
			indiceMemoria++;
			pilhaDeMemoria[indiceMemoria]=String.valueOf(indiceArquivo);
			
			indiceArquivo = pegaIndice(elementosLinha, indiceArquivo, arquivo);
			return retronaConjunto(indiceMemoria, indiceArquivo);
		case RETURN:
			indiceArquivo = Integer.parseInt(pilhaDeMemoria[indiceMemoria])+1;
			indiceMemoria--;
			return retronaConjunto(indiceMemoria, indiceArquivo);
			
		case RETURNF:
			returnfGlobal = Integer.parseInt(pilhaDeMemoria[indiceMemoria]);
			System.out.println("O valor do retorno da funcao eh " + returnfGlobal);
			if (elementosLinha.size()>1) {
				int m = Integer.parseInt(elementosLinha.get(1));
				int n = Integer.parseInt(elementosLinha.get(2));
				for (int k = n - 1; k >= 0; k--) {
					pilhaDeMemoria[m + k] = pilhaDeMemoria[indiceMemoria];
					indiceMemoria--;
				} 
			}
			indiceArquivo = Integer.parseInt(pilhaDeMemoria[indiceMemoria-1])+1;
			
			if (elementosLinha.size()==1) {
				pilhaDeMemoria[indiceMemoria] = pilhaDeMemoria[indiceMemoria - 2];
			}
			indiceMemoria++;
			pilhaDeMemoria[indiceMemoria] = String.valueOf(returnfGlobal);

				
				
				return retronaConjunto(indiceMemoria, indiceArquivo);
		
		default: 
			return null;
		}

	}

	private static int pegaIndice(List<String> elementosLinha, int indiceArquivo, List<LinhaArquivo> arquivo) {
		for(int i=0; i < arquivo.size(); i++) {
			if(arquivo.get(i).getLinha().contains(elementosLinha.get(1))
					&& arquivo.get(i).getLinha().contains("NULL")) {
				indiceArquivo = i;
				break;
			}
		}
		return indiceArquivo;
	}
	
	private static ConjuntoIndices retronaConjunto(int indiceMemoria, int indiceArquivo) {
		ConjuntoIndices conjunto = new ConjuntoIndices();
		conjunto.setIndiceArquivo(indiceArquivo);
		conjunto.setIndiceMemoria(indiceMemoria);
		return conjunto;
	}

}
