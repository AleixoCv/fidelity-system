package src.br.gov.cesarschool.fidelidade;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;

import javax.swing.JOptionPane;

import org.eclipse.swt.SWT;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

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
			TelaManutencaCliente window = new TelaManutencaCliente();
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
		shell.setSize(538, 396);
		shell.setText("SWT Application");
		
		Label lblCdigo = new Label(shell, SWT.NONE);
		lblCdigo.setBounds(39, 35, 70, 20);
		lblCdigo.setText("C\u00F3digo");
		
		Label lblNome = new Label(shell, SWT.NONE);
		lblNome.setBounds(39, 84, 70, 20);
		lblNome.setText("Nome");
		
		Label lblPreo = new Label(shell, SWT.NONE);
		lblPreo.setBounds(39, 138, 70, 20);
		lblPreo.setText("Pre\u00E7o");
		
		Label lblEstoque = new Label(shell, SWT.NONE);
		lblEstoque.setBounds(39, 191, 70, 20);
		lblEstoque.setText("Estoque");
		
		Label lblTipo = new Label(shell, SWT.NONE);
		lblTipo.setBounds(39, 244, 70, 20);
		lblTipo.setText("Tipo");
		
		txtCodigo = new Text(shell, SWT.BORDER);
		txtCodigo.setBounds(128, 35, 78, 26);
		formToolkit.adapt(txtCodigo, true, true);
		Button btnBuscar = new Button(shell, SWT.NONE);
		this.btnBuscar = btnBuscar;
		btnBuscar.setBounds(319, 30, 90, 30);
		formToolkit.adapt(btnBuscar, true, true);
		btnBuscar.setText("Buscar");
		
		Combo cmbTipo = new Combo(shell, SWT.NONE);
		this.cmbTipo = cmbTipo;
		cmbTipo.setEnabled(false);
		cmbTipo.setItems(new String[] {"Eletr\u00F4nicos", "Linha branca", "Computadores e celulares"});
		cmbTipo.setBounds(129, 241, 243, 28);
		formToolkit.adapt(cmbTipo);
		formToolkit.paintBordersFor(cmbTipo);
		
		Button btnNovo = new Button(shell, SWT.NONE);
		this.btnNovo = btnNovo;
	
		btnNovo.setBounds(223, 31, 90, 30);
		formToolkit.adapt(btnNovo, true, true);
		btnNovo.setText("Novo");
		
		txtNome = new Text(shell, SWT.BORDER);
		txtNome.setEnabled(false);
		txtNome.setBounds(128, 84, 281, 26);
		formToolkit.adapt(txtNome, true, true);
		
		txtPreco = new Text(shell, SWT.BORDER);
		txtPreco.setEditable(true);
		txtPreco.setEnabled(false);
		txtPreco.setText("");
		txtPreco.setBounds(128, 138, 106, 26);
		formToolkit.adapt(txtPreco, true, true);
		
		txtEstoque = new Text(shell, SWT.BORDER);
		txtEstoque.setEnabled(false);
		txtEstoque.setBounds(128, 191, 78, 26);
		formToolkit.adapt(txtEstoque, true, true);
		
		
		Button btnIncluiralterar = new Button(shell, SWT.NONE);
		btnIncluiralterar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				Long codigo = obterCodigo();
				Double preco = obterPreco();
				Integer estoque = obterEstoque();
				if(codigo == null || preco == null || estoque == null) {
					return;
				}
			Cliente prod = newCliente(codigo, txtNome.getText(), 
						preco, estoque, 
						TipCliente.obterPorCodigo(cmbTipo.getSelectionIndex()));
				String mensagem = null;
				if (btnIncluiralterar.getText().equals("Incluir")) {
					mensagem = ClienteMediator.incluir(prod);
				} else {
					mensagem = ClienteMediator.alterar(prod);
				}
				if (mensagem == null) {
					JOptionPane.showMessageDialog(null, 
							"Cliente incluído/alterado com sucesso!");		
					acaoVoltar();
				} else {
					JOptionPane.showMessageDialog(null, 
							mensagem);										
				}
			}
		});
		this.btnIncluiralterar = btnIncluiralterar;
		btnIncluiralterar.setEnabled(false);
		btnIncluiralterar.setBounds(75, 309, 106, 30);
		formToolkit.adapt(btnIncluiralterar, true, true);
		btnIncluiralterar.setText("Incluir/Alterar");
		
		Button btnLimpar = new Button(shell, SWT.NONE);
		this.btnLimpar = btnLimpar;
		btnLimpar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				limpar();
			}
		});
		
		btnLimpar.setEnabled(false);
		btnLimpar.setBounds(202, 309, 90, 30);
		formToolkit.adapt(btnLimpar, true, true);
		btnLimpar.setText("Limpar");
		
		Button btnVoltar = new Button(shell, SWT.NONE);
		this.btnVoltar = btnVoltar; 
		btnVoltar.setEnabled(false);
		btnVoltar.setBounds(319, 309, 90, 30);
		formToolkit.adapt(btnVoltar, true, true);
		btnVoltar.setText("Voltar");
		btnNovo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				Long codigo = obterCodigo();
				if (codigo == null) {
					return;
				}				
			Cliente prod =ClienteMediator.buscar(codigo);				
				if (prod != null) {
					JOptionPane.showMessageDialog(null, 
							"Cliente já existente!");		
					return;
				}
				desabilitarElementosAcesso();
				habilitarElementosDetalhe();
				btnIncluiralterar.setText("Incluir");
			}
		});
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				Long codigo = obterCodigo();
				if (codigo == null) {
					return;
				}
			Cliente prod =ClienteMediator.buscar(codigo);
				if (prod == null) {
					JOptionPane.showMessageDialog(null, 
							"Cliente não encontrado!");		
					return;
				} else {
					txtNome.setText(prod.getNome());
					txtPreco.setText(prod.getPreco() + "");
					txtEstoque.setText(prod.getEstoque() + "");
					cmbTipo.select(prod.getTipo().getCodigo());					
				}
				desabilitarElementosAcesso();
				habilitarElementosDetalhe();
				btnIncluiralterar.setText("Alterar");
			}
		});
		btnVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				acaoVoltar();
			}
		});
	}
	private Long obterCodigo() {
		Long codigo = null;
		try {
			codigo = Long.parseLong(txtCodigo.getText().trim());
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, 
					"Formato de código inválido!");
			
		}	
		return codigo;
	}
	private Double obterPreco() {
		Double preco = null;
		try {
			preco = Double.parseDouble(txtPreco.getText().trim());
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, 
					"Formato de preço inválido!");
			
		}	
		return preco;
	}
	private Integer obterEstoque() {
		Integer estoque = null;
		try {
			estoque = Integer.parseInt(txtEstoque.getText().trim());
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, 
					"Formato de estoque inválido!");
			
		}	
		return estoque;
	}	
	private void limpar() {
		txtNome.setText("");
		txtPreco.setText("");
		txtEstoque.setText("");
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
		txtCodigo.setText("");
		limpar();
		desabilitarElementosDetalhe();
		habilitarElementosAcesso();		
	}
}