package br.gov.cesarschool.fidelidade.cliente.tela;

import java.awt.Button;
import java.awt.Label;
import java.awt.event.MouseAdapter;

import javax.swing.JOptionPane;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.w3c.dom.Text;

import br.gov.cesarschool.fidelidade.cliente.entidade.Cliente;
import br.gov.cesarschool.fidelidade.cliente.negocio.ClienteMediator;

public class TelaManutencaoCliente {

	protected Shell shell;
	private final FormToolkit formToolkit = new FormToolkit(Display.getDefault());
	private Text txtCodigo;
	private Text txtNome;
	private Text txtPreco;
	private Text txtEstoque;
	private Combo cmbTipo;
	private Button btnNovo;
	private Button btnBuscar;
	private Button btnIncluiralterar;
	private Button btnLimpar;
	private Button btnVoltar;
	
	

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			TelaManutencaoCliente window = new TelaManutencaoCliente();
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
		
	}
	
	private void limpar() {
		txtNome.setTextContent("");
		txtPreco.setTextContent("");
		txtEstoque.setTextContent("");
		cmbTipo.deselectAll();		
	}
	
	private void habilitarElementosDetalhe() {
		txtNome.setEnabled(true);
		txtPreco.setEnabled(true);
		txtEstoque.setEnabled(true);
		cmbTipo.setEnabled(true);
		btnIncluiralterar.setEnabled(true);
		btnLimpar.setEnabled(true);
		btnVoltar.setEnabled(true);						
	}
	
	private void desabilitarElementosDetalhe() {
		txtNome.setEnabled(false);
		txtPreco.setEnabled(false);
		txtEstoque.setEnabled(false);
		cmbTipo.setEnabled(false);
		btnIncluiralterar.setEnabled(false);
		btnLimpar.setEnabled(false);
		btnVoltar.setEnabled(false);						
	}
	
	private void habilitarElementosAcesso() {
		txtCodigo.setEnabled(true);
		btnNovo.setEnabled(true);
		btnBuscar.setEnabled(true);
	}
	
	private void desabilitarElementosAcesso() {
		txtCodigo.setEnabled(false);
		btnNovo.setEnabled(false);
		btnBuscar.setEnabled(false);
	}
	
	private void acaoVoltar() {
		txtCodigo.setTextContent("");
		limpar();
		desabilitarElementosDetalhe();
		habilitarElementosAcesso();		
	}
}