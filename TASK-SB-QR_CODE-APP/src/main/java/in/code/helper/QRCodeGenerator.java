package in.code.helper;

import java.awt.image.BufferedImage;

import org.springframework.stereotype.Component;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

@Component
public class QRCodeGenerator {

	public BufferedImage generateQRCode(String urlText) throws Exception {
		QRCodeWriter qrCodeWriter = new QRCodeWriter();
		BitMatrix bitMatrix = qrCodeWriter.encode(urlText, BarcodeFormat.QR_CODE, 200, 200);

		return MatrixToImageWriter.toBufferedImage(bitMatrix);
	}

}
