package maquinaVirtual.instrucoes;

import maquinaVirtual.enums.InstrucaoInicioFimEnum;

public class InstrucaoInicioFim {
	public static void executa(String instrucao,boolean lerArquivo) {
		InstrucaoInicioFimEnum instEnum = InstrucaoInicioFimEnum.valueOf(instrucao);
		switch(instEnum) {
		case START:
			//S:=s + 1;
			break;			
		case HLT:
			lerArquivo = false;
			break;
		}
	}
}
