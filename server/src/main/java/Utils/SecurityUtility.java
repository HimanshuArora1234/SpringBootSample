package Utils;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SecurityUtility {
	
	@Value("${application.secretKey}")
    private String secretKey;
	
	public String encode(String data) throws Exception {
		SecretKeySpec key = new SecretKeySpec(secretKey.getBytes(), "AES");
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.ENCRYPT_MODE, key);
	    byte[] encryptedMessage = cipher.doFinal(data.getBytes());
	    return new String(encryptedMessage);
	}
	
	public String decode(String data) throws Exception {
		SecretKeySpec key = new SecretKeySpec(secretKey.getBytes(), "AES");
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.DECRYPT_MODE, key);
	    byte[] decryptedMessage = cipher.doFinal(data.getBytes());
	    return new String(decryptedMessage);
	}
}
