package maquinaVirtual.instrucoes;

public class InstrucaoAtribuicao {
	public static void executa(String instrucao, String[] elementosLinha, String[] pilhaDeMemoria, int indiceMemoria) {
		pilhaDeMemoria[Integer.parseInt(elementosLinha[1])]= pilhaDeMemoria[indiceMemoria];
		indiceMemoria--;
	}
}
