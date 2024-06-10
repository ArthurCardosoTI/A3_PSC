package parte.arthur.a3;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class PagamentoPix extends Pagamento{

    private String CodidoPix;

    public PagamentoPix(double valor, String NomeTitular, String EmpresaVendedora){
        super(valor, NomeTitular, EmpresaVendedora, MetodosPagamentos.PIX, 1);

        this.CodidoPix = CodidoPix;
    }

    public String getCodidoPix() {
        return CodidoPix;
    }

    private String GerarCodigoPix(){
        return "00020126580014BR.GOV.BCB.PIX0114" + getEmpresaVendedora() + "520400053039865802BR5925" + getNomeTitular() + "6009SAO PAULO61080540900062070503***6304";
    }

    public byte[] gerarQRCode () throws WriterException, IOException{
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix BitMatrix = qrCodeWriter.encode(CodidoPix, BarcodeFormat.QR_CODE, 200, 200);

        ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
        BufferedImage bufferedImage = MatrixToImageWriter.toBufferedImage(BitMatrix);
        ImageIO.write(bufferedImage, "PNG", pngOutputStream);
        return pngOutputStream.toByteArray();
    }
}