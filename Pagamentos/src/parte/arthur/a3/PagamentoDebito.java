package parte.arthur.a3;

public class PagamentoDebito extends Pagamento{
    
    private String NomeTitular;
    private String DataValidade;
    private String cvv;
    private String NumeroCartao;

    public PagamentoDebito(double valor, String EmpresaVendedora, MetodosPagamentos metodosPagamentos,
                            String NomeTitular, String DataValidade, String cvv, String NumeroCartao) {
        super(valor, NomeTitular, EmpresaVendedora, metodosPagamentos.CARTAO_DEBITO, 1);

        this.NomeTitular = NomeTitular;
        this.DataValidade = DataValidade;
        this.cvv = cvv;
        this.NumeroCartao = NumeroCartao;
    }

    public String getNomeTitular() {
        return NomeTitular;
    }

    public void setNomeTitular(String nomeTitular) {
        NomeTitular = nomeTitular;
    }

    public String getDataValidade() {
        return DataValidade;
    }

    public void setDataValidade(String dataValidade) {
        DataValidade = dataValidade;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getNumeroCartao() {
        return NumeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        NumeroCartao = numeroCartao;
    }    
}
