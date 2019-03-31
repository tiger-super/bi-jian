package com.house.pay.config;

import java.io.FileWriter;
import java.io.IOException;

public class AlipayConfig {
	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
		public static String app_id = "2016092700605361";
		
		// 商户私钥，您的PKCS8格式RSA2私钥
	    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQDI+3z4kSvN4fX2yiykOjslZG2oBhFCsVLhNmMrRhfit564U1gjHvIVuSyulaMAoiXSXIxLF7a+OiX9Qt8bkXrqlCiahNS4EppN6SxqnWLQADeAeAcOLPkT9cB+aSclY2Xm34l7ro9F5PQ6jnh3iwyk8pX4tfP019PzagHgyXYvV0AxTZvpE8LMOh5xtmSidFdoiq+BTwZ/Qyqye0Mq36H994WJLR1sL1jnwlRwgkeTB5DdDltdMXpFMBnk6zw7DylkteA2Rt0hHeewDLNNWpMFsMmk7BpWk3GasFFU0iKtBYvaJA+OlB/3LZEHjTruuP2HnCojX4Xx4S2j7vF4VPydAgMBAAECggEAZy3c2YtFrrubV2gxhNo0NR0awpDi2ZdJUj9mp/ejGYxk2oJHFDi11XssOjCt7wxPWHCUwZRaB8y4Zg2nlnKYZMdNFQ6uWhWKzAax+8XyzY/e7oAwNxHViW63tO3s39/ol58Y6LsT6LECxPERXWWwRxoW7gkTRhZrRGKetjUXDHPX4W+p2cTch2xe6uCu1F9E4PiZEvcZPVsK5dG4auVJm15dq1Kh6XFgIRD9e1xWkpijJ24Sphl2vNglF/HMAxMVKwCVKTo8qjNVG5GMNB4s9IrlQ3V1rke5yew7lyo8QZYXt+oTHrxZJWcCa1uaigAZ5DypcNU3ZXIUC3cooNwiIQKBgQD1+cwyw+89fP2/YPqS4O0wWKyL3AF+TvhwW3QGw5sCN51kv8/+bWbtLLupo7JuwkPtTKq0xPkKYl9DXtpA4OYpQpXMwyQU7JJQRE1u0tqK8iD4rVwo0oLO/OG2bxGgeyOBSn8oQ9+l7h1petGNU75ZrHad0NxrTQ3HDcc548xgtQKBgQDRLEkxveCf6Gz7U5p07XAae5M42tw8CxkAiF/mcQJ4CU9qHZGVFYnuuplaqyLvqGPYZj/rQXDKHAcU/eJDh+GNL4bBmkuuM9R/SU3xYn3FatgYIzlYkIpYkdiD+A14DbkYfi0AusuMMxvEV7jXQG3FP62kgdGp7cahHBehmw5lSQKBgQDDm3u0nzYgysYrrB54MWDOAqZsrm+Nl5VgHIofWuxpDfsfhJ4OMcgZMmqmU+RwyhIkosRZ7w4xINurAsJDt9Ww2B+ybzjBXwRXyoldaVacCkMIHyzb1dRqcJW6c4cr/ODWT3zhc2BmXv6KxD3iysbkHw9RHyg6OFONiTp2od4ExQKBgGGAqDnEjbFccXiR1vzMNSZTFiQ5eNGQRr5F05YidYkopdkMIXGCEcKzPorSHT3jm28i8oaiAYZknDR/x/m8nDnovoL+fmqchGA09l0fkQr2K/bMbI3JCoQQsAGMHhMpKm+tWSLu77TRmg7i6SmFQeXhMfrt/KKeUKmG48kT8xjpAoGAWFLaofb6zjH4yX1F+iuItyIcNICbPiOVnklpWY9AtgKnbmvstREtbZzSiwbBYsdHWDf+tWOwH/6Dd/F75X1YF8Vkz8dYHNi3TQ3oeaMtbpL0fMEfepjL4wbQNC5xKi4m4LJFiUaWHpAUdpa5PstdN4OZhHnVZDQQLOk//cyqzpk=";
		
		// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
	    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA62XYL1YS5MpsXrm78b4sTrZjtkC2eZM48uL/0nQgTd4Ca/YObz3G0gs18PwAfJ+FFCTbF1YmHcmo5X29abcnQ3cZWzpVuDXINv14mDEHo1kD2P8vAHxR4pxSZ0cEbN510akhRNtPzg0ICTYAbAHzWMC5dykvttJvHmkk1NTSF1hLzcrAeej4Bx4GOFvjqvJYjdaW9IRCOeAI3stZ74zT0RjZj/MzHIvpICp6TZENf3G7Jf/t23aUML4spJriFfY5jSPPXwZDgia9fCs0k4X+4rH3xUl7MceiYgbxGqIkc5uBeJf1WCheZ/ABaRLxVp8P5Y72SrcfpjQevAwIl24WkwIDAQAB";

		// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	/*
	 * public static String notify_url = "http://127.0.0.1:8088/house/show/notify";
	 */
		public static String notify_url = "http://47.106.244.224:8088/house/show/notify";
		// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	/*
	 * public static String return_url = "http://127.0.0.1:8088/house/show/return";
	 */
		public static String return_url = "http://47.106.244.224:8088/house/show/return";
		// 签名方式
		public static String sign_type = "RSA2";
		
		// 字符编码格式
		public static String charset = "utf-8";
		// 支付宝网关
		public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
		// 支付宝网关
		public static String log_path = "C:\\Users\\tiger\\Desktop\\log\\";


	    /** 
	     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
	     * @param sWord 要写入日志里的文本内容
	     */
	    public static void logResult(String sWord) {
	        FileWriter writer = null;
	        try {
	            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
	            writer.write(sWord);
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            if (writer != null) {
	                try {
	                    writer.close();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            }
	        }
	    }
}
