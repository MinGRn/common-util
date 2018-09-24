package com.mingrn.wechat.official;

import com.mingrn.wechat.official.util.CheckSignatureUtil;
import com.mingrn.wechat.official.util.GenerateAccessTokenUtil;
import com.mingrn.wechat.official.util.GenerateQrCodeUtil;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WechatOfficialApplication {

	public static void main(String[] args) {
		/*SpringApplication.run(WechatOfficialApplication.class, args);*/

		//检查Signature
		Boolean isSignature = CheckSignatureUtil.checkSignature("MinGRn", "1212", "121", "12");
		System.out.printf("签名校验: %s", isSignature);

		System.out.println("开始生成AssessToken");
		//生成 AssessToken
		GenerateAccessTokenUtil.generateAccessToken("wx5e9c3a075cd05832", "c97e954786ca95e4b586fba994c658f6");

		System.out.println("开始生成 QR Code");
		//生成二维码
		String assessToken = "13_u0LkVMrroDNrpo5sUkF-hKfO8yXPaGdKUYOoaKsQFUIBu2IcNpEnr-n0wEyp9xRkK2ZI-WcxCCVllWEkkx_k3KvEdYKRFduZdXUNzPFUXw9RkQqsb-nSqtUGIBey1UC_A1p8bNYOt3d998N7QGWeAAAEUK";
		GenerateQrCodeUtil.generateTempQR(assessToken, 3600, 1, "MinGRn");
	}
}