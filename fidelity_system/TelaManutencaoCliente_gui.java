import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Text;

public class TelaManutencaoCliente_gui {

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
        Display display = new Display();
        TelaManutencaoCliente_gui window = new TelaManutencaoCliente_gui();
        window.open(display);
        display.dispose();
    }

    /**
     * Open the window.
     */
    public void open(Display display) {
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
        shell.setSize(450, 300);
        shell.setText("Tela Manutenção Cliente");

        txtCodigo = new Text(shell, SWT.BORDER);
        txtCodigo.setBounds(10, 10, 200, 25);

        txtNome = new Text(shell, SWT.BORDER);
        txtNome.setBounds(10, 41, 200, 25);

        txtPreco = new Text(shell, SWT.BORDER);
        txtPreco.setBounds(10, 72, 200, 25);

        txtEstoque = new Text(shell, SWT.BORDER);
        txtEstoque.setBounds(10, 103, 200, 25);

        cmbTipo = new Combo(shell, SWT.NONE);
        cmbTipo.setBounds(10, 134, 200, 25);

        btnNovo = new Button(shell, SWT.NONE);
        btnNovo.setBounds(10, 165, 90, 25);

        btnBuscar = new Button(shell, SWT.NONE);
        btnBuscar.setBounds(106, 165, 90, 25);

        btnIncluiralterar = new Button(shell, SWT.NONE);
        btnIncluiralterar.setBounds(10, 196, 90, 25);

        btnLimpar = new Button(shell, SWT.NONE);
        btnLimpar.setBounds(106, 196, 90, 25);

        btnVoltar = new Button(shell, SWT.NONE);
        btnVoltar.setBounds(202, 196, 90, 25);

        // Resto do código...

        shell.open();
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
