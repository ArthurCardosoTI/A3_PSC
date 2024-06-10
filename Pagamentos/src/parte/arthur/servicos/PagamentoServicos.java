package parte.arthur.servicos;

import java.io.IOException;
import java.util.Base64;

import com.google.zxing.WriterException;

import parte.arthur.a3.Pagamento;
import parte.arthur.a3.PagamentoBoleto;
import parte.arthur.a3.PagamentoCredito;
import parte.arthur.a3.PagamentoDebito;
import parte.arthur.a3.PagamentoPix;
import parte.arthur.validacoes.ValidarCartao;

public class PagamentoServicos {
    public boolean processoPagamento(Pagamento pagamento) {
        switch (pagamento.getMetodosPagamentos()) {
            case CARTAO_CREDITO:
                return processoPagamentoCredito((PagamentoCredito) pagamento);
            
            case CARTAO_DEBITO:
                return processoPagamentoDebito((PagamentoDebito) pagamento);

            case PIX:
                return processoPagamentoPix((PagamentoPix) pagamento);
            
            case BOLETO:
                return processoPagamentoBoleto((PagamentoBoleto) pagamento);
        
            default:
                return false;
        }
    }

    private boolean processoPagamentoCredito(PagamentoCredito pagamento) {
        if (pagamento.getParcelas() > 12) {
            System.out.println("Número máximo de parcelas é 12");
            return false;
        }

        if (!ValidarCartao.validade(pagamento)) {
            System.out.println("Número do cartão de crédito inválido");
            return false;
        }

        double valorTotal = pagamento.getValor();
        double jurosMensal = 0.1;
        for (int i = 1; i < pagamento.getParcelas(); i++) {
            valorTotal += valorTotal * jurosMensal;
        }

        System.out.println("Processo pagamento de " + pagamento.getValor() + " em " + pagamento.getParcelas() + 
            " vezes no cartão crédito com juros sera: " + valorTotal);
        return false;
    }

    private boolean processoPagamentoDebito(PagamentoDebito pagamento) {
        if (!ValidarCartao.validade(pagamento)) {
            System.out.println("Dados do cartão de débito inválido.");
            return false;
        }

        System.out.println("Processando pagamento de " + pagamento.getValor() + " no cartão de débito.");
        return true;
    }

    private boolean processoPagamentoPix(PagamentoPix pagamento) {
        System.out.println("Processando pagamento de " + pagamento.getValor() + " via PIX.");
        System.out.println("Código Pix para copiar: " + pagamento.getCodidoPix());
        try{
            byte[] qrCode = pagamento.gerarQRCode();
            String base64QRCode = Base64.getEncoder().encodeToString(qrCode);
            System.out.println("QR Code (Base64): " + base64QRCode);
        } 
        catch (WriterException | IOException e) {
            System.out.println("Erro ao gerar QR Code: " + e.getMensagem());
            return false;
        }

        return false;
    }

    private boolean processoPagamentoBoleto(PagamentoBoleto pagamento) {
        if (pagamento.getParcelas() > 12) {
            System.out.println("Número máximo de parcelas para boleto é 12.");
            return false;
        }

        double valorTotal = pagamento.getValor();
        double jurosMensal = 0.01;
        for (int i = 1; i < pagamento.getParcelas(); i++); {
            valorTotal += valorTotal * jurosMensal;
        }

        System.out.println("Processo pagamento de " + pagamento.getValor() + " em " + pagamento.getParcelas()
            + " vezes no boleto com juros é: " + valorTotal);
        
        System.out.println("Código de barras é: " + pagamento.geradorBoleto());
        return true;
    }
}
