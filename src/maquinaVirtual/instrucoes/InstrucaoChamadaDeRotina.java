package maquinaVirtual.instrucoes;

import maquinaVirtual.enums.InstrucaoChamadaDeRotinaEnum;

public class InstrucaoChamadaDeRotina {
	public static void executa(String instrucao, String[] elementosLinha, String[] pilhaDeMemoria, int indiceMemoria, int indiceArquivo) {
		InstrucaoChamadaDeRotinaEnum instEnum = InstrucaoChamadaDeRotinaEnum.valueOf(instrucao);
		switch(instEnum) {
		case CALL:
			//S:=s + 1;
			pilhaDeMemoria[indiceMemoria]=String.valueOf(indiceArquivo);
			indiceArquivo = Integer.parseInt(elementosLinha[1]);
			break;
		case RETURN:
			indiceArquivo = Integer.parseInt(pilhaDeMemoria[indiceMemoria]);
			indiceMemoria--;
			break;

		}

	}

}
