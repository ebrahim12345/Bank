package ir.bank.enums;

public enum AccountType {
    // 0, 1, 2, 3
    Saving(1),
    Checking(2),
    MoneyMarket(3),
    CertificateOfDeposit(4);


    private int code;

    AccountType(int code) {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
