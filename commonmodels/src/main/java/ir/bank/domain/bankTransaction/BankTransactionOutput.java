package ir.bank.domain.bankTransaction;

import ir.bank.domain.account.Account;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Date;
import java.util.List;


@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class BankTransactionOutput {

    private Long id;
    private Integer fromAccountNumber;
    private Integer toAccountNumber;
    private Integer transferAmountMoney;
    private Integer depositAmountMoney;
    private Integer withdrawAmountMoney;
    private Date transactionDate;
    private List<Account> accounts;


    public BankTransactionOutput(
            Long id,
            Integer fromAccountNumber,
            Integer toAccountNumber,
            Integer transferAmountMoney,
            Integer depositAmountMoney,
            Integer withdrawAmountMoney,
            Date transactionDate
    ) {

        this.id = id;
        this.fromAccountNumber = fromAccountNumber;
        this.toAccountNumber = toAccountNumber;
        this.transferAmountMoney = transferAmountMoney;
        this.depositAmountMoney = depositAmountMoney;
        this.withdrawAmountMoney = withdrawAmountMoney;
        this.transactionDate = transactionDate;
    }

    public BankTransactionOutput() {
    }
}

