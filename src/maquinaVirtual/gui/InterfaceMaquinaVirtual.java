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


public class InterfaceMaquinaVirtual {

	protected Shell shell;
	private Table table;
	private List<LinhaArquivo> arquivo;
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
		btnNewButton.setBounds(10, 10, 145, 25);
		
		btnNewButton.setText("ler arquivo");

	}
}
