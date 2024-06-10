package parte.arthur.a3;

public abstract class Pagamento {

    private double valor;
    private String NomeTitular;
    private String EmpresaVendedora;
    private MetodosPagamentos metodosPagamentos;
    private int parcelas;

    public Pagamento(double valor, String NomeTitular, String EmpresaVendedora, MetodosPagamentos metodosPagamentos, int parcelas){
        this.valor = valor;
        this.NomeTitular = NomeTitular;
        this.EmpresaVendedora = EmpresaVendedora;
        this.metodosPagamentos = metodosPagamentos;
        this.parcelas = parcelas;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getNomeTitular() {
        return NomeTitular;
    }

    public void setNomeTitular(String nomeTitular) {
        NomeTitular = nomeTitular;
    }

    public String getEmpresaVendedora() {
        return EmpresaVendedora;
    }

    public void setEmpresaVendedora(String empresaVendedora) {
        EmpresaVendedora = empresaVendedora;
    }

    public MetodosPagamentos getMetodosPagamentos() {
        return metodosPagamentos;
    }

    public void setMetodosPagamentos(MetodosPagamentos metodosPagamentos) {
        this.metodosPagamentos = metodosPagamentos;
    }

    public int getParcelas() {
        return parcelas;
    }

    public void setParcelas(int parcelas) {
        this.parcelas = parcelas;
    }
}