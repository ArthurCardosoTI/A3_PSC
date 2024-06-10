package parte.arthur.a3;

public class PagamentoBoleto extends Pagamento{
    private String NomePagador;
    private String DocumentoPagador;
    private String EnderecoPagador;

    public PagamentoBoleto(double valor, String NomeTitular, String EmpresaVendedora, int parcelas,
                          String NomePagador, String DocumentoPagador, String EnderecoPagador) {
            super(valor, NomeTitular, EmpresaVendedora, MetodosPagamentos.BOLETO, parcelas);
            this.NomePagador = NomePagador;
            this.DocumentoPagador = DocumentoPagador;
            this.EnderecoPagador = EnderecoPagador;
    }

    public String getNomePagador() {
        return NomePagador;
    }

    public void setNomePagador(String nomePagador) {
        NomePagador = nomePagador;
    }

    public String getDocumentoPagador() {
        return DocumentoPagador;
    }

    public void setDocumentoPagador(String documentoPagador) {
        DocumentoPagador = documentoPagador;
    }

    public String getEnderecoPagador() {
        return EnderecoPagador;
    }

    public void setEnderecoPagador(String enderecoPagador) {
        EnderecoPagador = enderecoPagador;
    }

    public String geradorBoleto() {
        return "34191.79001 01043.510047 91020.150008 5 83620000000000" + (int) (getParcelas() * 100);
    }
}