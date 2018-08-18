package maquinaVirtual.gui;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import maquinaVirtual.utils.AbridorDeArquivos;

import java.io.FileNotFoundException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class InterfaceMaquinaVirtual {

	protected Shell shell;
	private Text text;

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
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(33, 59, 199, 101);
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				AbridorDeArquivos abridorDeArquivos = new AbridorDeArquivos();
				try {
					abridorDeArquivos.abrirArquivo();
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
				text.setText(abridorDeArquivos.getArquivo());
			}
		});
		btnNewButton.setBounds(65, 240, 145, 25);
		btnNewButton.setText("ler arquivo");

	}
}
