public class ResultadoInclusaoCliente{
    private long numeroFidelidade;
    private String mensagemErroValidacao;

    public static void ResultadoInclusaoCliente(long numero, String msg){
        this.numeroFidelidade = numero;
        this.mensagemErroValidacao = msg;
    }
    public long getNumeroFidelidade(){
        return numeroFidelidade;
    }

    public String getMensagemErroValidacao(){
        return mensagemErroValidacao;
    }
}