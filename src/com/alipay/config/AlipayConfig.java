package com.alipay.config;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2016080600181850";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCtLGeX9+qfFbSt1Oe18Nfif+De5nsHawdEOKe/RYZkSYPvy+M1WcnQs5tcTsMIMRT1TcLs2eFnDvmndzfxuWKkhPDRllJ5oMh5fXt28cXOk2gXIDLWUkHttrp46nMzH+2J4bENaVc+pNAUUZ03MuowIQcJrRnCT6Jqi13LIFk5AKzQLO1OdJPUPkBhMB89JQ9A2GN2VcBHQ7AqawocozkzZeud1hxx7KgM7+p31uuZPKAXnUc7lx+7BZ62pNkCezzAkMqyeQ8Z8GxcWPL8YVcpnsCSPMiIIIPE0Xp9JS7btiSZZ3ztXMwBNM76aDgV/N0SWUARjrblgCZ56amxp7GXAgMBAAECggEAf83Iuog2OKg9SxlY1JblzPyRig/Rdn0PxNKHQoteDr+OxrfTfHlCj2suWqaqG26VyCBWnpSCXJvZtjUvLY+i9EZEsHlfbvIxYjAwoWz3jmiNppuVyUS18WktH7XvxShoF51gHMTEpa/e/U/qVmWWHmURm5uL6jL5a+ZlF1dNYdodetrA7CNs3+Rkde9YIBroDWDHZ+TulchDaMiPGViKcUAM7ZNPFjUNwSHlb1hwyJXd2PXyIcd1E3ONXiuwys6Pmi27Q7WlVWSq29VRs1VnzRwh04uOgf1+PQq3C37gXXoSoKgw1GnRktYvKGLkvJExg39B4jnnSYbc580HIqjqyQKBgQDd1IHKFhYgJNMvnhN9LlW+AjmH1NETPucvGwmum5G6o+5IcSY6nhPM4yPhKDrya8qNnK+TrUvNfAXqa0OD9P8YAA7HKy4IR8pDny/d8nFHGHPam1iaK6dsUxvuVf3vxTgKTxF0FENJjYB5KxpuP4HBHAOYXWdtrw1bjwZzv1FS3QKBgQDH2TSW09hTSTIaD1tKJs1eZrLyDEYIRcfSPeZDC91zZMGwXcmmS8LxoA1Tfpbi341m+fVYAwvhuxjqRyE1mY8Jc+hi0v36agnUlGeLtkR/xonc+/BOiJ2RnHsmnQ69v+IUPfe1NP2uBPUzBEpbpgURPDkI2K4+/A6FtxDBlFCNAwKBgQCe/pqMOupe3aYUgiub1KMWDkgn6Ex2i+Ztp+Z3pP99k9PNTnRFHVo5xy/HSOt/J+1FNOHPai1juZoP3BPHN8nC7P+ql3Nl8fayIx3O6d9xQsB/FksaLWHRzXu+hxn8ShIRqXxsA736sRY9Qryt+ozI2YhmI8RnJEnhrxDD04O5bQKBgQCMLxVPk2xUB60IUKtVmWBHjryJQwjA9snS9S6W6zS8o/mlkDRJ3SzytrWCUvLeU7fpev6ZbRGhls9ETv7BjWSjWdWxtJUJWeZpYmw7uW/VPVwpUeRgAj6dDGnqTRMxEO8yCcG/L1ue/MVOsvzByvQVAex0AyI+9intq9sqHrJeJwKBgCaFoI9RZs5xETVPbuBkjGEaquYKP25xnvW1+2h4o3FZg1WnRcjc5UJOB8THKHM10DDybwial29okCb3/+SJ73jynmTTkUWmjYVRiMYr1KAVal4PGhdZRDPfVMOjtMzTmflMqYMCTXeSi+rRkZpodwyckicBKIk273u8xQzQfiKo";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA25mTf5sezX8w1BkkNwYzdghcAVLFDlEldcr3t8adW7zOQ6cNzlNJlTGVBPCWnuAs/HUlVUDWJXg5bDnlL+8PWZXusBEI3OL8k/wpOCnCOxJ70jpOnombe6U0OGJpYvQCbuhM33S+K0EfKFPKT6fBBlO9mYErGe9dChcC/9CYEUiR3YxsQ7tCEJImkUxoh0/PeOH8IraTfqBTPKVMyIkosBhbu9DzHqyKRSgbwSQJ9CB6DK02MADpGafYewav1EKnlsvwYn0x5n5jSP3hzS/os8/49suW2hUZJXkW7IuKj9Byw+ee6lXam7hjSaCGzaXhYpvxtjiI162YNI2pT9swfQIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://工程公网访问地址/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://127.0.0.1:8080/goodplus/returnurl";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "D:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

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

