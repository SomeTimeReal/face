import org.junit.Test;
import service.YaorongdaService;
import service.impl.YaorongdaDemo;
import utils.SignUtil;

import java.util.HashMap;
import java.util.Map;

public class APItest {
    public static final String publickey = "b34f27d250bcf4c5836fae9414a158db";

    //开户
    @Test
    public void adduser() {
        YaorongdaService yaorongdaService = new YaorongdaDemo();
        //把参数放到MAP中
        Map map=new HashMap<>();
        map.put("userid", "44654313");
        //获取sign值
        String sign = SignUtil.genSign(publickey, SignUtil.createLinkString(SignUtil.paraFilter(map)));
        System.out.println(sign);
        String result = yaorongdaService.createAcction("44654313", "60067", sign);
        System.out.println(result);
    }

    //添加实名
    @Test
    public void addLegal() {
        YaorongdaService yaorongdaService = new YaorongdaDemo();
        Map map = new HashMap();
      /*  map.put("meichantId", merchant.getMerchantId());
        map.put("accountId", account.getAccountId());
        map.put("address", legalEntity.getAddress());
        map.put("company_type", legalEntity.getCompanyType());
        map.put("dob", legalEntity.getDob());
        map.put("expiry_date", legalEntity.getExpiryDate());
        map.put("id_number", legalEntity.getIdNumber());
        map.put("industry", legalEntity.getIndustry());
        map.put("issue_agency", legalEntity.getIssueAgency());
        map.put("issue_date", legalEntity.getIssueDate());
        map.put("name", legalEntity.getName());
        map.put("sanction_screening_image", legalEntity.getSanctionScreeningImage());
        map.put("business_license_image", legalEntity.getBusinessLicenseImage());
        map.put("owner_id_card_image", legalEntity.getOwnerIdCardImage());
        map.put("pep_verification_image", legalEntity.getPepVerificationImage());
        map.put("Paddress", personEntity.getPersonAddress());
        map.put("Pdob", personEntity.getPersonDob());
        map.put("Pexpiry_date", personEntity.getPersonexpiryDate());
        map.put("Pid_number", personEntity.getPersonIdNumber());
        map.put("Pissue_agency", personEntity.getPersonIssueAgency());
        map.put("Pissue_date", personEntity.getPersonIssueDate());
        map.put("region", legalEntity.getRegion());
        map.put("type", legalEntity.getType());
        map.put("verification_documentsA", legalEntity.getVerificationDocumentsA());
        map.put("verification_documentsB", legalEntity.getVerificationDocumentsB());*/
        String sign = SignUtil.genSign(publickey, SignUtil.createLinkString(SignUtil.paraFilter(map)));
        String result = yaorongdaService.addlegal_entities("acct_f0DuoJqtASfrOp9dOgESJu7JE4smDF3O", "60067", "陕西省宝鸡市", "有限责任公司", "20180710", "20200710", "91610301MA6XEMYL2B", "软件开发", "宝鸡市高新区工商管理局", "20180710", "宝鸡市耀荣达科技有限公司", "http://easypay-legal-entity.oss-cn-shenzhen.aliyuncs.com/sfepay/123123.png?Expires=1851599266&OSSAccessKeyId=LTAIfUcdtdNy3D4x&Signature=E0YXI4r9gXxJcmdbtDoFFx8ULRI%3D",
                "http://easypay-legal-entity.oss-cn-shenzhen.aliyuncs.com/sfepay/123123.png?Expires=1851599266&OSSAccessKeyId=LTAIfUcdtdNy3D4x&Signature=E0YXI4r9gXxJcmdbtDoFFx8ULRI%3D",
                "http://easypay-legal-entity.oss-cn-shenzhen.aliyuncs.com/sfepay/123123.png?Expires=1851599266&OSSAccessKeyId=LTAIfUcdtdNy3D4x&Signature=E0YXI4r9gXxJcmdbtDoFFx8ULRI%3D",
                "http://easypay-legal-entity.oss-cn-shenzhen.aliyuncs.com/sfepay/123123.png?Expires=1851599266&OSSAccessKeyId=LTAIfUcdtdNy3D4x&Signature=E0YXI4r9gXxJcmdbtDoFFx8ULRI%3D",
                "陕西省宝鸡市", "19920105", "20190110", "610302199201053016", "陕西省宝鸡市渭滨区高家镇派出所", "20060110",
                "林伟", "CN", "PERSON", "http://easypay-legal-entity.oss-cn-shenzhen.aliyuncs.com/sfepay/123123.png?Expires=1851599266&OSSAccessKeyId=LTAIfUcdtdNy3D4x&Signature=E0YXI4r9gXxJcmdbtDoFFx8ULRI%3D",
                "http://easypay-legal-entity.oss-cn-shenzhen.aliyuncs.com/sfepay/123123.png?Expires=1851599266&OSSAccessKeyId=LTAIfUcdtdNy3D4x&Signature=E0YXI4r9gXxJcmdbtDoFFx8ULRI%3D",
                "1395f5fe81802c34ec796e492cda0690");
        System.out.println(result);
    }

    //编辑实名
    @Test
    public void updateLegal() {
        YaorongdaService yaorongdaService = new YaorongdaDemo();
        String result = yaorongdaService.edit_legal_entities("acct_f0DuoJqtASfrOp9dOgESJu7JE4smDF3O", "legal_acRKYmzeVw1aoOm5T4VEXCgUFm5h7KJ9", "60067", "宝鸡市高新区", "有限责任公司", "2018-07", "2020-06", "91610301MA6XEMYL2B", "计算机软件",
                "宝鸡市高新区工商管理局", "2018-07", "宝鸡市啤酒厂", "CN", "PERSON", "http://easypay-legal-entity.oss-cn-shenzhen.aliyuncs.com/sfepay/123123.png?Expires=1851599266&OSSAccessKeyId=LTAIfUcdtdNy3D4x&Signature=E0YXI4r9gXxJcmdbtDoFFx8ULRI%3D",
                "http://easypay-legal-entity.oss-cn-shenzhen.aliyuncs.com/sfepay/123123.png?Expires=1851599266&OSSAccessKeyId=LTAIfUcdtdNy3D4x&Signature=E0YXI4r9gXxJcmdbtDoFFx8ULRI%3D",
                "b5d9b73dee037c14eabbfe478784a4b9");
        System.out.println(result);
    }

    //汇率查询
    @Test
    public void exchangeRate() {
        YaorongdaService yaorongdaService = new YaorongdaDemo();
        String result = yaorongdaService.rate_controller("CNY", "USD", "606B01A6540001F39A8B2A3A08CAFC8B", "60067");
        System.out.println(result);
    }

    //查询账号交易列表
    @Test
    public void lookAllTrans() {
        YaorongdaService yaorongdaService = new YaorongdaDemo();
        String result = yaorongdaService.query_transactions("acct_KEHzzUsJ4ybmZUZzUEMgPjiVbBKQ7SdD", "60067", "dab0e22195188981cc2ae105fa18bdb2", "1", "10");
        System.out.println(result);
    }

    //查询账户交易详情
    @Test
    public void lookOneTran() {
        YaorongdaService yaorongdaService = new YaorongdaDemo();
        String result = yaorongdaService.query_transactions_detailed("acct_f0DuoJqtASfrOp9dOgESJu7JE4smDF3O", "tx_PlfIA99zPx5tqg2CcAMhdeyaG1zIXRqJcXhVU914vmXzKGTDw532rHxz4tYrvCKC", "60067", "0149a8d7febbfff5fd2f37afd90bada9");
        System.out.println(result);
    }

    //提现预览
    @Test
    public void withDrawFake() {
        YaorongdaService yaorongdaService = new YaorongdaDemo();
        String result = yaorongdaService.withdraw_preview("acct_Wx8NWesdW3aMQqFacSzbmlgRcXGntnY9", "60067", "3efd50ca5673fefa7634da4ade562527", "1", "ba_IyMlUN6b5xqW6Pil5ih00NDY2K861bA9", "USD", "CNY");
        System.out.println(result);
    }

    //提现
    @Test
    public void withDraw() {
        YaorongdaService yaorongdaService = new YaorongdaDemo();
        String result = yaorongdaService.withdraw("acct_Wx8NWesdW3aMQqFacSzbmlgRcXGntnY9", "60067", "3efd50ca5673fefa7634da4ade562527", "1", "ba_IyMlUN6b5xqW6Pil5ih00NDY2K861bA9", "USD", "CNY");
        System.out.println(result);
    }

    //申请虚拟银行账户
    @Test
    public void addvirtual_bank_account_applications() {
        YaorongdaService yaorongdaService = new YaorongdaDemo();
        String result = yaorongdaService.addvirtual_bank_account_applications("acct_KEHzzUsJ4ybmZUZzUEMgPjiVbBKQ7SdD", "60067", "aed1de6cc02ccc5e52fcf5e8e2dd3dd1", "123123", "林伟", "6222021001083153483", "中国工商银行", "legal_BMUUBo5K1uspY2J9Kk7RxLSqC9sbEoxc", "US", "547706346", "547706346", "547706346", "AMAZON");
        System.out.println(result);
    }

    //查看申请虚拟银行账户列表
    @Test
    public void virtual_bank_account_applications() {
        YaorongdaService yaorongdaService = new YaorongdaDemo();
        String result = yaorongdaService.query_Virtual_Bank_Account_ApplicationList("acct_KEHzzUsJ4ybmZUZzUEMgPjiVbBKQ7SdD", "60067", "69d5201f899ed446a295543561ee2764");
        System.out.println(result);
    }

    //绑定银行卡
    @Test
    public void bindbank_account() {
        YaorongdaService yaorongdaService = new YaorongdaDemo();
        String result = yaorongdaService.bindbank_account("acct_Wx8NWesdW3aMQqFacSzbmlgRcXGntnY9","60067","719fdedc6d146c3e3c31cbc53df29359","林伟","65121564613164","宝鸡支行","建设银行","ICBC","CNY","123123","CN");
        System.out.println(result);
    }

    //查询余额
    @Test
    public void querybalance() {
        YaorongdaService yaorongdaService = new YaorongdaDemo();
        String result = yaorongdaService.querybalance("acct_Wx8NWesdW3aMQqFacSzbmlgRcXGntnY9","60067","b6c42b809026a45066214efba8f42b71");
        System.out.println(result);
    }

    //设置费用
    @Test
    public void setAccountFee_rates() {
        YaorongdaService yaorongdaService = new YaorongdaDemo();
        String result = yaorongdaService.setAccountFee_rates("CNY","0.3","acct_Wx8NWesdW3aMQqFacSzbmlgRcXGntnY9","60097","23419a0d0c95eb243ccea1802cd7e828");
        System.out.println(result);
    }
}
