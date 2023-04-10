import br.gov.cesarschool.poo.fidelidade.cliente.DAO.ClienteDAO;
import br.gov.cesarschool.poo.fidelidade.cartao.negocio.CartaoFidelidadeMediator;
public class ClienteMediator{
    private ClienteDAO repositorioCliente;
    private CartaoFidelidadeMediator cartaoMediator;
    public ClienteMediator(){
        this.repositorioCliente = new ClienteDAO();
        this.cartaoMediator = new CartaoFidelidadeMediator();
    }

    public ResultadoInclusaoCliente incluir(Cliente cliente){
        // Métodos:
        // • public ResultadoInclusaoCliente incluir(Cliente cliente): deve validar os dados do
        // cliente recebidos no objeto. Se os dados estiverem válidos, deve incluir o cliente no
        // repositorioCliente, gerar cartão fidelidade através do cartaoMediator, e retornar um
        // objeto do tipo ResultadoInclusaoCliente com número do cartão fidelidade gerado e
        // mensagem de erro nula. Se algum dado estiver inválido, deve retornar um objeto do
        // tipo ResultadoInclusaoCliente com número do cartão fidelidade zero e mensagem
        // informando o que não foi validado.
        // • public String alterar(Cliente cliente): deve validar os dados do cliente recebidos no
        // objeto. Não é permitido alterar o cpf do cliente. Se os dados estiverem válidos, deve
        // alterar o cliente no repositorioCliente e retornar null. Se algum dado estiver inválido,
        // deve retornar mensagem informando o que não foi validado.
        // • private String validar(Cliente cliente): deve realizar a validação dos dados do cliente,
        // retornando null se os dados estiverem válidos, e uma mensagem pertinente caso
        // algum dado seja inválido. Este método deve ser utilizado pelos métodos incluir e
        // alterar. As regras de validação são:
        // o cpf: é obrigatório e deve ser um cpf válido. Usar a classe ValidadorCPF
        // implementada.
        // o nomeCompleto: é obrigatório. Usar a classe StringUtil implementada.
        // o sexo: é obrigatório.
        // o dataNascimento: é obrigatório e deve ser maior do que a data atual menos
        // 17 anos. Em outras palavras, a idade do cliente deve ser maior ou igual a 18.
        // o renda: deve ser maior ou igual a zero.
        // o endereco: é obrigatório, e deve ter as seguintes validações para os campos
        // específicos da classe Endereco:

        // ▪ logradouro: é obrigatório (usar a classe StringUtil implementada) e
        // deve ter pelo menos 4 caracteres.
        // ▪ numero: deve ser maior ou igual a zero.
        // ▪ cidade: é obrigatório. Usar a classe StringUtil implementada.
        // ▪ estado: é obrigatório. Usar a classe StringUtil implementada.
        // ▪ pais: é obrigatório. Usar a classe StringUtil implementada.
    }
}