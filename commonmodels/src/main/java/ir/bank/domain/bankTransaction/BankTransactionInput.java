package ir.bank.domain.bankTransaction;

import ir.bank.domain.account.Account;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;


@NoArgsConstructor
@Data
public class BankTransactionInput {

    private Long id;
    private Integer fromAccountNumber;
    private Integer toAccountNumber;
    private Integer transferAmountMoney;
    private Integer depositAmountMoney;
    private Integer withdrawAmountMoney;
    private Date transactionDate;
    private List<Account> accounts;

}

