package maquinaVirtual.gui;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import maquinaVirtual.moldels.LinhaArquivo;
import maquinaVirtual.utils.AbridorDeArquivos;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Label;


public class InterfaceMaquinaVirtual {

	protected Shell shell;
	private Table table;
	private List<LinhaArquivo> arquivo;
	private Table table_1;
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
		shell.setSize(782, 424);
		shell.setText("SWT Application");
		
		String[] legendaTabela = {"linha","instrução"};
		
		table = new Table(shell, SWT.CHECK| SWT.BORDER | SWT.FULL_SELECTION | SWT.V_SCROLL);
		table.setBounds(10, 41, 241, 272);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		for (int i = 0; i < legendaTabela.length; i++) {
		    TableColumn column = new TableColumn(table, SWT.NULL);
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
						TableItem item = new TableItem(table, SWT.NULL);
						item.setText(0,String.valueOf(arquivo.get(i).getNumeroLinha()));
						item.setText(1,arquivo.get(i).getLinha());
					}
					 for (int i = 0; i < legendaTabela.length; i++) {
					      table.getColumn(i).pack();
					    }
			
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
				
			}
		});
	
		table_1 = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table_1.setBounds(257, 222, 85, 91);
		table_1.setHeaderVisible(true);
		table_1.setLinesVisible(true);
		
		Label lblBreakpoint = new Label(shell, SWT.NONE);
		lblBreakpoint.setBounds(272, 201, 55, 15);
		lblBreakpoint.setText("Breakpoint");
		
	    table.addListener(SWT.Selection, new Listener() {
	        public void handleEvent(Event event) {
	        	  TableItem item = (TableItem) event.item;
	          if (event.detail == SWT.CHECK && item.getChecked()) {
	            TableItem itemBreakpoint = new TableItem(table_1, SWT.NULL);
	            itemBreakpoint.setText(0, item.getText(0));
	          } else if(event.detail == SWT.CHECK && !item.getChecked()) {
	             for(TableItem tItem : table_1.getItems()) {
	            	 if(tItem.getText(0).equals(item.getText(0))) {
	            		 table_1.remove(table_1.indexOf(tItem));
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
		
		Button btnExecutarPassoA = new Button(shell, SWT.NONE);
		btnExecutarPassoA.setBounds(106, 320, 145, 25);
		btnExecutarPassoA.setText("Executar passo a passo");
		
	

	}
}
