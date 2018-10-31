package service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.YaorongdaService;
import utils.SignUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class YaorongdaDemo implements YaorongdaService {

    private static Logger logger = LoggerFactory.getLogger(YaorongdaDemo.class);
    public static final String action = "http://localhost:8080/";
    public static final String publickey = "b34f27d250bcf4c5836fae9414a158db";
//    b34f27d250bcf4c5836fae9414a158db
//    5f239b3ec98b2a4fcd93274d7a6ebeed
    @Override
    public String createAcction(String userId, String merchantId) {
        //把参数放到MAP中
        Map map=new HashMap<>();
        map.put("userid", userId);
        //获取sign值
         String sign= SignUtil.genSign(publickey, SignUtil.createLinkString(SignUtil.paraFilter(map)));
        System.out.println(sign);
        String result = sendPost(action + "api/user", "userId=" + userId + "&merchantId=" + merchantId + "&sign=" + sign + "");
        return result;
    }

    @Override
    public String addlegal_entities(String accountId, String merchantId, String address, String companyType, String dob, String expiryDate, String idNumber, String industry, String issueAgency, String issueDate, String name, String sanctionScreeningImage, String businessLicenseImage, String ownerIdCardImage, String pepVerificationImage, String PersonAddress, String PersonDob,
                                    String PersonexpiryDate, String PersonIdNumber, String PersonIssueAgency, String PersonIssueDate, String PersonName, String region, String type, String verificationDocumentsA, String verificationDocumentsB ) {
        //把参数放到MAP中
        Map map=new HashMap<>();
        map.put("meichantId", merchantId);
        map.put("accountId", accountId);
        map.put("address", address);
        map.put("company_type", companyType);
        map.put("dob", dob);
        map.put("expiry_date",expiryDate);
        map.put("id_number",idNumber);
        map.put("industry",industry);
        map.put("issue_agency", issueAgency);
        map.put("issue_date", issueDate);
        map.put("name",name);
        map.put("sanction_screening_image",sanctionScreeningImage);
        map.put("business_license_image", businessLicenseImage);
        map.put("owner_id_card_image", ownerIdCardImage);
        map.put("pep_verification_image",pepVerificationImage);
        map.put("Paddress", PersonAddress);
        map.put("Pdob", PersonDob);
        map.put("Pexpiry_date", PersonexpiryDate);
        map.put("Pid_number",PersonIdNumber);
        map.put("Pissue_agency", PersonIssueAgency);
        map.put("Pissue_date", PersonIssueDate);
        map.put("region",region);
        map.put("type", type);
        map.put("verification_documentsA",verificationDocumentsA);
        map.put("verification_documentsB",verificationDocumentsB);
        //获取sign值
        String sign= SignUtil.genSign(publickey, SignUtil.createLinkString(SignUtil.paraFilter(map)));
        System.out.println(SignUtil.createLinkString(SignUtil.paraFilter(map)));
        System.out.println(sign);
        String result = sendPost(action + "api/user/" + accountId + "/legal_entities", "merchantId=" + merchantId + "&address=" + address + "&companyType=" + companyType + "&dob=" + dob + "&expiryDate=" + expiryDate + "&idNumber=" + idNumber + "&industry=" + industry + "&issueAgency=" + issueAgency + "&issueDate=" + issueDate + "&name=" + name + "&sanctionScreeningImage=" + sanctionScreeningImage + "&businessLicenseImage=" + businessLicenseImage + "&ownerIdCardImage=" + ownerIdCardImage + "&pepVerificationImage=" + pepVerificationImage + "&PersonAddress=" + PersonAddress + "&PersonDob=" + PersonDob + "" +
                "&PersonexpiryDate=" + PersonexpiryDate + "&PersonIdNumber=" + PersonIdNumber + "&PersonIssueAgency=" + PersonIssueAgency + "&PersonIssueDate=" + PersonIssueDate + "&PersonName=" + PersonName + "&region=" + region + "&type=" + type + "&verificationDocumentsA=" + verificationDocumentsA + "&verificationDocumentsB=" + verificationDocumentsB + "&sign=" + sign + "");
        return result;
    }

    @Override
    public String edit_legal_entities(String accountId, String legalId, String merchantId, String address, String company_type, String dob, String expiry_date, String id_number, String industry, String issue_agency, String issue_date, String name, String region, String type, String verificationDocumentsA, String verificationDocumentsB) {
        //把参数放到MAP中
        Map map=new HashMap<>();
        map.put("merchantId",merchantId);
        map.put("accountId", accountId);
        map.put("address",address);
        map.put("company_type", company_type);
        map.put("id_number", id_number);
        map.put("industry", industry);
        map.put("issue_agency", issue_agency);
        map.put("issue_date", issue_date);
        map.put("name",name);
        map.put("region",region);
        map.put("type",type);
        map.put("verification_documentsA", verificationDocumentsA);
        map.put("verification_documentsB", verificationDocumentsB);
        //获取sign值
        String sign= SignUtil.genSign(publickey, SignUtil.createLinkString(SignUtil.paraFilter(map)));
        System.out.println(SignUtil.createLinkString(SignUtil.paraFilter(map)));
        System.out.println(sign);
        String result = sendPut(action + "api/user/" + accountId + "/legal_entities/" + legalId + "", "merchantId=" + merchantId + "&sign=" + sign + "&address=" + address + "&companyType=" + company_type + "&dob=" + dob + "&expiryDate=" + expiry_date + "&idNumber=" + id_number + "&industry=" + industry + "&issueAgency=" + issue_agency + "&issueDate=" + issue_date + "&name=" + name + "&region=" + region + "&type=" + type + "&verificationDocumentsA=" + verificationDocumentsA + "&verificationDocumentsB=" + verificationDocumentsB + "");
        return result;
    }


    @Override
    public String rate_controller(String from_currency, String to_currency,String merchantId) {
        //把参数放到MAP中
        Map map=new HashMap<>();
        map.put("meichantId", merchantId);
        map.put("formCurrency",from_currency);
        map.put("toCurrency",to_currency);

        //获取sign值
        String sign= SignUtil.genSign(publickey, SignUtil.createLinkString(SignUtil.paraFilter(map)));
        System.out.println(sign);
        String result=sendGet(action+"api/exchange_rate","fromCurrency="+from_currency+"&toCurrency="+to_currency+"&sign="+sign+"&merchantId="+merchantId+"");
        return result;
    }

    @Override
    public String query_transactions(String accountId,String merchantId, String page, String size) {
        //把参数放到MAP中
        Map map=new HashMap<>();
        map.put("meichantId", merchantId);
        map.put("accountId",accountId);
        map.put("page",page);
        map.put("size",size);

        //获取sign值
        String sign= SignUtil.genSign(publickey, SignUtil.createLinkString(SignUtil.paraFilter(map)));
        System.out.println(sign);
        String result=sendGet(action+"api/user/"+accountId+"/transactions","merchantId="+merchantId+"&sign="+sign+"&page="+page+"&size="+size+"");
        return result;
    }

    @Override
    public String query_transactions_detailed(String accountId, String txId,String merchantId) {
        //把参数放到MAP中
        Map map=new HashMap<>();
        map.put("meichantId", merchantId);
        map.put("accountId", accountId);
        map.put("txid",txId);
        //获取sign值
        String sign= SignUtil.genSign(publickey, SignUtil.createLinkString(SignUtil.paraFilter(map)));
        System.out.println(sign);
        String result=sendGet(action+"api/user/"+accountId+"/transactions/"+txId+"","merchantId="+merchantId+"&sign="+sign+"");
        return result;
    }

    @Override
    public String withdraw_preview(String accountId,String merchantId,String amount,String bankAccountId,String currency,String outwardCurrency) {
        //把参数放到MAP中
        Map map=new HashMap<>();
        map.put("meichantId", merchantId);
        map.put("accountId",accountId);
        map.put("amount",amount);
        map.put("bank_account_id", bankAccountId);
        map.put("currency", currency);
        map.put("outward_currency",outwardCurrency);
        //获取sign值
        String sign= SignUtil.genSign(publickey, SignUtil.createLinkString(SignUtil.paraFilter(map)));
        System.out.println(sign);
        String result=sendPost(action+"api/user/"+accountId+"/withdraw_preview","merchantId="+merchantId+"&sign="+sign+"&amount="+amount+"&bankAccountId="+bankAccountId+"&currency="+currency+"&outwardCurrency="+outwardCurrency+"");
        return result;
    }

    @Override
    public String withdraw(String accountId,String merchantId,String amount,String bankAccountId,String currency,String outwardCurrency) {
        //把参数放到MAP中
        Map map=new HashMap<>();
        map.put("meichantId", merchantId);
        map.put("accountId",accountId);
        map.put("amount",amount);
        map.put("bank_account_id", bankAccountId);
        map.put("currency", currency);
        map.put("outward_currency",outwardCurrency);
        //获取sign值
        String sign= SignUtil.genSign(publickey, SignUtil.createLinkString(SignUtil.paraFilter(map)));
        System.out.println(sign);
        String result=sendPost(action+"api/user/"+accountId+"/withdraw","merchantId="+merchantId+"&sign="+sign+"&amount="+amount+"&bankAccountId="+bankAccountId+"&currency="+currency+"&outwardCurrency="+outwardCurrency+"");
        return result;
    }

    @Override
    public String addvirtual_bank_account_applications(String accoutnId, String merchantId,String accessId,String accountHolderName,String accountNumber,String bankName,String accountLegalEntityId,String region,String secretKey,String sellerId,String storeName,String purposeType) {
        //把参数放到MAP中
        Map map=new HashMap<>();
        map.put("merchantId",merchantId);
        map.put("accountId",accoutnId);
        map.put("access_id", accessId);
        map.put("bank_account_holder_name", accountHolderName);
        map.put("bank_account_number", accountNumber);
        map.put("bank_name",bankName);
        map.put("legal_entity_id",accountLegalEntityId);
        map.put("region", region);
        map.put("secret_key", secretKey);
        map.put("seller_id",sellerId);
        map.put("store_name", storeName);
        map.put("bankAccountConnectPurposetype", purposeType);
        //获取sign值
        String sign= SignUtil.genSign(publickey, SignUtil.createLinkString(SignUtil.paraFilter(map)));
        System.out.println(SignUtil.createLinkString(SignUtil.paraFilter(map)));
        System.out.println(sign);
        String result=sendPost(action+"api/user/"+accoutnId+"/virtual_bank_account_applications","merchantId="+merchantId+"&sign="+sign+"&accessId="+accessId+"&accountHolderName="+accountHolderName+"&accountNumber="+accountNumber+"&bankName="+bankName+"&accountLegalEntityId="+accountLegalEntityId+"&region="+region+"&secretKey="+secretKey+"&sellerId="+sellerId+"&storeName="+storeName+"&purposeType="+purposeType+"&encode=utf-8");
        return result;
    }

    @Override
    public String query_Virtual_Bank_Account_ApplicationList(String accountId,String merchantId) {
        //把参数放到MAP中
        Map map=new HashMap<>();
        map.put("meichantId", merchantId);
        map.put("accountId",accountId);
        //获取sign值
        String sign= SignUtil.genSign(publickey, SignUtil.createLinkString(SignUtil.paraFilter(map)));
        System.out.println(sign);
        String result=sendGet(action+"api/user/"+accountId+"/virtual_bank_account_applications","merchantId="+merchantId+"&sign="+sign+"");
        return result;
    }

    @Override
    public String bindbank_account(String accountId, String merchantId,String accountHolderName,String accountNumber,String bankBranchName,String bankName,String bicNumber,String currency,String accessId,String purposeRegion) {
        //把参数放到MAP中
        Map map=new HashMap<>();
        map.put("meichantId",merchantId);
        map.put("accountId", accountId);
        map.put("bank_account_holder_name",accountHolderName);
        map.put("bank_account_number",accountNumber);
        map.put("bank_branch_name", bankBranchName);
        map.put("bank_name", bankName);
        map.put("bic_number",bicNumber);
        map.put("currency",currency);
        map.put("access_id",accessId);
        map.put("bankAccountConnectregionRegion",purposeRegion );
        //获取sign值
        String sign= SignUtil.genSign(publickey, SignUtil.createLinkString(SignUtil.paraFilter(map)));
        System.out.println(SignUtil.createLinkString(SignUtil.paraFilter(map)));
        System.out.println(sign);
        String result=sendPost(action+"api/user/"+accountId+"/bank_accounts","merchantId="+merchantId+"&sign="+sign+"&accountHolderName="+accountHolderName+"&accountNumber="+accountNumber+"&bankBranchName="+bankBranchName+"&bankName="+bankName+"&bicNumber="+bicNumber+"&currency="+currency+"&accessId="+accessId+"&purposeRegion="+purposeRegion+"");
        return result;
    }

    @Override
    public String querybalance(String accountId,String merchantId) {
        //把参数放到MAP中
        Map map=new HashMap<>();
        map.put("meichantId", merchantId);
        map.put("accountId",accountId);
        //获取sign值
        String sign= SignUtil.genSign(publickey, SignUtil.createLinkString(SignUtil.paraFilter(map)));
        System.out.println(SignUtil.createLinkString(SignUtil.paraFilter(map)));
        System.out.println(sign);
        String result=sendGet(action+"api/user/"+accountId+"/balance","merchantId="+merchantId+"&sign="+sign+"");
        return result;
    }

    @Override
    public String setAccountFee_rates(String currency, String feeRate, String accountId,String merchantId) {
        //把参数放到MAP中
        Map map=new HashMap<>();
        map.put("meichantId",merchantId);
        map.put("accountId", accountId);
        map.put("currency", currency);
        map.put("feeRate", feeRate);
        //获取sign值
        String sign= SignUtil.genSign(publickey, SignUtil.createLinkString(SignUtil.paraFilter(map)));
        System.out.println(SignUtil.createLinkString(SignUtil.paraFilter(map)));
        System.out.println(sign);
        String result=sendPut(action+"api/user/"+accountId+"/fee_rates","merchantId="+merchantId+"&sign="+sign+"&feeRate="+feeRate+"&currency="+currency+"");
        return result;
    }


    /**
     * 向指定 URL 发送POST方法的请求
     *
     * @param url   发送请求的 URL
     * @param param 请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return 所代表远程资源的响应结果
     */
    public static String sendPost(String url, String param) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数
            out.print(param);

            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！" + e);
            e.printStackTrace();
        }
        //使用finally块来关闭输出流、输入流
        finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 向指定 URL 发送POST方法的请求
     *
     * @param url   发送请求的 URL
     * @param param 请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return 所代表远程资源的响应结果
     */
    public static String sendPut(String url, String param) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
//            URLConnection conn = realUrl.openConnection();

            HttpURLConnection conn = (HttpURLConnection)realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 发送PUT请求必须设置如下两行
            conn.setRequestMethod("PUT");
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数
            out.print(param);

            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应

            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;

            }
        } catch (Exception e) {
            System.out.println("发送 PUT 请求出现异常！" + e);
            e.printStackTrace();
        }
        //使用finally块来关闭输出流、输入流
        finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }
    /**
     * 向指定URL发送GET方法的请求
     *
     * @param url
     *            发送请求的URL
     * @param param
     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return URL 所代表远程资源的响应结果
     */
    public static String sendGet(String url, String param) {
        String result = "";
        BufferedReader in = null;
        try {
            String urlNameString = url + "?" + param;
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
//            for (String key : map.keySet()) {
//                System.out.println(key + ":" + map.get(key));
//            }
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }

}
