package maquinaVirtual.instrucoes;

import java.util.List;

public class InstrucaoAtribuicao {
	public static int executa(String instrucao, List<String> elementosLinha, String[] pilhaDeMemoria, int indiceMemoria) {
		pilhaDeMemoria[Integer.parseInt(elementosLinha.get(1))]= pilhaDeMemoria[indiceMemoria];
		return indiceMemoria-1;
	}
}
