package maquinaVirtual.instrucoes;

public class InstrucaoAtribuicao {
	public static int executa(String instrucao, String[] elementosLinha, String[] pilhaDeMemoria, int indiceMemoria) {
		pilhaDeMemoria[Integer.parseInt(elementosLinha[1])]= pilhaDeMemoria[indiceMemoria];
		return indiceMemoria--;
	}
}
