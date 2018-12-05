package maquinaVirtual.instrucoes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import org.eclipse.swt.widgets.Text;

import maquinaVirtual.enums.InstrucaoEntradaSaidaEnum;

public class InstrucaoEntradaSaida {
	public static int executa(String instrucao, List<String> elementosLinha, String[] pilhaDeMemoria, int indiceMemoria,
			Text janelaSaida) {
		InstrucaoEntradaSaidaEnum instEnum = InstrucaoEntradaSaidaEnum.valueOf(instrucao);
		switch(instEnum) {
		case RD:
			System.out.println("próximo valor de entrada");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String entrada = new String();
			try {
				 entrada = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			indiceMemoria++;
			pilhaDeMemoria[indiceMemoria]=entrada;
			return indiceMemoria;
			
		case PRN:
			System.out.println(pilhaDeMemoria[indiceMemoria]);
			janelaSaida.setText(pilhaDeMemoria[indiceMemoria]);
			return indiceMemoria-1;
		default : 
			return 0;
		}

	}
}
