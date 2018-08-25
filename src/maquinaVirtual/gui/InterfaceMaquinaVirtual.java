package maquinaVirtual.gui;

import java.io.FileNotFoundException;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

import maquinaVirtual.enums.InstrucaoAllocDallocEnum;
import maquinaVirtual.enums.InstrucaoAritimeticaEnum;
import maquinaVirtual.enums.InstrucaoAtribuicaoEnum;
import maquinaVirtual.enums.InstrucaoCarregaMemoriaEnum;
import maquinaVirtual.enums.InstrucaoChamadaDeRotinaEnum;
import maquinaVirtual.enums.InstrucaoCompararEnum;
import maquinaVirtual.enums.InstrucaoDesvioEnum;
import maquinaVirtual.enums.InstrucaoEntradaSaidaEnum;
import maquinaVirtual.enums.InstrucaoInicioFimEnum;
import maquinaVirtual.enums.InstrucaoNullEnum;
import maquinaVirtual.enums.InstrucaoOperadorLogicoEnum;
import maquinaVirtual.moldels.LinhaArquivo;
import maquinaVirtual.utils.AbridorDeArquivos;


public class InterfaceMaquinaVirtual {

	protected Shell shell;
	private Table tabelaInstruoes;
	private List<LinhaArquivo> arquivo;
	private List<String> pilhaDeMemoria;
	private int indiceMemoria;
	private Table tableaBreakpoint;
	private Table table_4;
	private Text janelaEntrada;
	private Text janelaSaida;
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			InterfaceMaquinaVirtual window = new InterfaceMaquinaVirtual();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(782, 532);
		shell.setText("SWT Application");
		
		String[] legendaTabela = {"linha","instrução"};
		
		tabelaInstruoes = new Table(shell, SWT.CHECK| SWT.BORDER | SWT.FULL_SELECTION | SWT.V_SCROLL);
		tabelaInstruoes.setBounds(10, 41, 445, 272);
		tabelaInstruoes.setHeaderVisible(true);
		tabelaInstruoes.setLinesVisible(true);
		
		for (int i = 0; i < legendaTabela.length; i++) {
		    TableColumn column = new TableColumn(tabelaInstruoes, SWT.NULL);
		    column.setText(legendaTabela[i]);
		}
		

		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				AbridorDeArquivos abridorDeArquivos = new AbridorDeArquivos();
				try {
					arquivo = abridorDeArquivos.abrirArquivo();
					for(int i =0 ;i<arquivo.size();i++) {
						TableItem item = new TableItem(tabelaInstruoes, SWT.NULL);
						item.setText(0,String.valueOf(arquivo.get(i).getNumeroLinha()));
						item.setText(1,arquivo.get(i).getLinha());
					}
					 for (int i = 0; i < legendaTabela.length; i++) {
					      tabelaInstruoes.getColumn(i).pack();
					    }
			
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
				
			}
		});
	
		tableaBreakpoint = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		tableaBreakpoint.setBounds(344, 379, 62, 104);
		tableaBreakpoint.setHeaderVisible(true);
		tableaBreakpoint.setLinesVisible(true);
		
		Label lblBreakpoint = new Label(shell, SWT.NONE);
		lblBreakpoint.setBounds(344, 358, 62, 15);
		lblBreakpoint.setText("Breakpoint");
		
	    tabelaInstruoes.addListener(SWT.Selection, new Listener() {
	        public void handleEvent(Event event) {
	        	  TableItem item = (TableItem) event.item;
	          if (event.detail == SWT.CHECK && item.getChecked()) {
	            TableItem itemBreakpoint = new TableItem(tableaBreakpoint, SWT.NULL);
	            itemBreakpoint.setText(0, item.getText(0));
	          } else if(event.detail == SWT.CHECK && !item.getChecked()) {
	             for(TableItem tItem : tableaBreakpoint.getItems()) {
	            	 if(tItem.getText(0).equals(item.getText(0))) {
	            		 tableaBreakpoint.remove(tableaBreakpoint.indexOf(tItem));
	            	 }
	             }
	          }
	        }
	      });
		btnNewButton.setBounds(10, 10, 145, 25);
		
		btnNewButton.setText("ler arquivo");
		
		Button btnExecutar = new Button(shell, SWT.NONE);
		btnExecutar.setBounds(10, 320, 75, 25);
		btnExecutar.setText("Executar");
		btnExecutar.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				checkArquivo();
				for (LinhaArquivo linha : arquivo) {
					String[] elementosLinha = linha.getLinha().split("\\s+");
					
					String instrucao = elementosLinha[0];
					
					if(InstrucaoNullEnum.contains(instrucao)) {
						
					} else if(InstrucaoAllocDallocEnum.contains(instrucao)) {
						
					} else if(InstrucaoDesvioEnum.contains(instrucao)) {
						
					} else if(InstrucaoCompararEnum.contains(instrucao)) {
						
					} else if(InstrucaoChamadaDeRotinaEnum.contains(instrucao)) {
						
					} else if(InstrucaoCarregaMemoriaEnum.contains(instrucao)) {
						
					} else if(InstrucaoAtribuicaoEnum.contains(instrucao)) {
						
					} else if(InstrucaoAritimeticaEnum.contains(instrucao)) {
						
					} else if(InstrucaoEntradaSaidaEnum.contains(instrucao)) {
						
					} else if(InstrucaoInicioFimEnum.contains(instrucao)) {
						
					} else if(InstrucaoOperadorLogicoEnum.contains(instrucao)) {
						
					} else {
						//TODO criar cenário de erro!
					}
				}
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		Button btnExecutarPassoA = new Button(shell, SWT.NONE);
		btnExecutarPassoA.setBounds(106, 320, 145, 25);
		btnExecutarPassoA.setText("Executar passo a passo");
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setBounds(35, 358, 91, 15);
		lblNewLabel.setText("Janela de entrada");
		
		Label label = new Label(shell, SWT.NONE);
		label.setText("Janela de saída");
		label.setBounds(195, 358, 84, 15);
		
		table_4 = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table_4.setBounds(576, 41, 145, 429);
		table_4.setHeaderVisible(true);
		table_4.setLinesVisible(true);
		
		Label lblContedoDaPilha = new Label(shell, SWT.NONE);
		lblContedoDaPilha.setBounds(568, 20, 165, 15);
		lblContedoDaPilha.setText("Conte\u00FAdo da pilha de mem\u00F3ria");
		
		janelaEntrada = new Text(shell, SWT.BORDER);
		janelaEntrada.setBounds(10, 379, 145, 104);
		
		janelaSaida = new Text(shell, SWT.BORDER);
		janelaSaida.setBounds(168, 379, 145, 104);
		
	}

	private void checkArquivo() {
		if(null == arquivo || arquivo.isEmpty()) {
			 MessageBox messageBox = new MessageBox(shell, SWT.ICON_WARNING | SWT.OK);
		        
		        messageBox.setText("Aviso");
		        messageBox.setMessage("Nenhum arquivo selecionado");
		        int buttonID = messageBox.open();
		        
		      
		}
	}
}
