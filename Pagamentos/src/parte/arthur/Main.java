package parte.arthur;

import parte.arthur.a3.PagamentoBoleto;
import parte.arthur.a3.PagamentoCredito;
import parte.arthur.a3.PagamentoDebito;
import parte.arthur.a3.PagamentoPix;
import parte.arthur.servicos.PagamentoServicos;

public class Main {
    public static void main(String[] args) {
        PagamentoServicos pagamentoServicos = new PagamentoServicos();

        PagamentoCredito pagamentoCredito = new PagamentoCredito(0, null, null, 0, null, null, null, null);
        pagamentoServicos.processoPagamento(pagamentoCredito);

        PagamentoDebito pagamentoDebito = new PagamentoDebito(0, null, null, null, null, null, null);
        pagamentoServicos.processoPagamento(pagamentoDebito);

        PagamentoPix pagamentoPix = new PagamentoPix(0, null, null);
        pagamentoServicos.processoPagamento(pagamentoPix);

        PagamentoBoleto pagamentoBoleto = new PagamentoBoleto(0, null, null, 0, null, null, null);
        pagamentoServicos.processoPagamento(pagamentoBoleto);
    }
}
