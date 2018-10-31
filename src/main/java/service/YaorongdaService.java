package service;

/**
 * 耀荣达接口
 */
public interface YaorongdaService {
    //账户开户
    public String createAcction(String userId,String merchantId);
    /**
     * 添加实名信息
     */
    public String addlegal_entities(String accountId,String merchantId,String address,String companyType,String dob,String expiryDate,String idNumber,
                                    String industry,String issueAgency,String issueDate,String name,String sanctionScreeningImage,String businessLicenseImage,
                                    String ownerIdCardImage,String pepVerificationImage,String PersonAddress,String PersonDob,String PersonexpiryDate,String PersonIdNumber,
                                    String PersonIssueAgency,String PersonIssueDate,String PersonName,String region,String type,String verificationDocumentsA,String verificationDocumentsB);
    /**
     * 编辑实名认证信息
     */
    public String edit_legal_entities(String accountId, String legalId,String merchantId,String address,String company_type,String dob,String expiry_date,String id_number,String industry,
                                      String issue_agency,String issue_date,String name,String region,String type,String verificationDocumentsA,String verificationDocumentsB);
    /**
     *汇率查询
     */
    public String rate_controller(String from_currency,String to_currency,String merchantId);
    /**
     * 查询账户交易列表
     */
    public String query_transactions(String accountId,String merchantId,String page,String size);
    /**
     * 查询账户交易详情
     */
    public String query_transactions_detailed(String accountId,String txId,String merchantId);

    /**
     * 提现预览
     */
    public String withdraw_preview(String accountId,String merchantId,String amount,String bankAccountId,String currency,String outwardCurrency);
    /**
     * 提现
     */
    public String withdraw(String accountId,String merchantId,String amount,String bankAccountId,String currency,String outwardCurrency);
    /**
     * 申请虚拟银行账户信息（带上完整的账户信息）
     */
    public String addvirtual_bank_account_applications(String accoutnId, String merchantId,String accessId,String accountHolderName,String accountNumber,String bankName,String accountLegalEntityId,String region,String secretKey,String sellerId,String storeName,String purposeType);

    /**
     * 查看申请虚拟银行账户信息银行账户列表
     */
    public String query_Virtual_Bank_Account_ApplicationList(String accountId,String merchantId);
    /**
     * 绑定银行账户
     */
    public String bindbank_account(String accountId, String merchantId,String accountHolderName,String accountNumber,String bankBranchName,String bankName,String bicNumber,String currency,String accessId,String purposeRegion);
    /**
     * 查询账户余额
     */
    public String querybalance(String accountId,String merchantId);
    /**
     * 设置用户的提现手续费率
     */
    public String setAccountFee_rates(String currency, String feeRate, String accountId,String merchantId);
}
