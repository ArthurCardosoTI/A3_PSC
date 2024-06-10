package parte.arthur.validacoes;

import parte.arthur.a3.PagamentoCredito;
import parte.arthur.a3.PagamentoDebito;

public class ValidarCartao {
    public static boolean validade(PagamentoCredito pagamento) {
        return pagamento.getNomeTitular().matches("[A-Z\\s]+") &&
               pagamento.getDataValidade().matches("\\d{2}/\\d{2}") &&
               pagamento.getCvv().matches("\\d{3}") &&
               pagamento.getNumeroCartao().matches("\\d{16}");
    }

    public static boolean validade(PagamentoDebito pagamento) {
        return pagamento.getNomeTitular().matches("[A-Z\\S]+") &&
               pagamento.getDataValidade().matches("\\d{2}/\\d{2}") &&
               pagamento.getCvv().matches("\\d{3}") &&
               pagamento.getNumeroCartao().matches("\\d{16}");
    }
}