package ir.bank.dto;

import ir.bank.domain.account.Account;
import ir.bank.domain.bankTransaction.BankTransaction;
import ir.bank.domain.bankTransaction.BankTransactionInput;
import ir.bank.domain.bankTransaction.BankTransactionOutput;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;


@JsonIgnoreProperties
@Getter
@Setter
public class BankTransactionDto {

    private Long id;
    private Integer fromAccountNumber;
    private Integer toAccountNumber;
    private Integer transferAmountMoney;
    private Integer depositAmountMoney;
    private Integer withdrawAmountMoney;
    private Date transactionDate;

    private List<Account> accounts;



    // setting person properties from bank transaction output class
    public BankTransactionOutput toDto() {
        BankTransactionOutput output = new BankTransactionOutput();
        output.setFromAccountNumber(fromAccountNumber);
        output.setToAccountNumber(toAccountNumber);
        output.setTransferAmountMoney(transferAmountMoney);
        output.setDepositAmountMoney(depositAmountMoney);
        output.setWithdrawAmountMoney(withdrawAmountMoney);
        output.setTransactionDate(transactionDate);
        return output;
    }


    // setting person properties from bank transaction input class
    public BankTransaction fromDto(BankTransactionInput input) {
        BankTransaction bankTransaction = new BankTransaction();
        bankTransaction.setId(input.getId());
        bankTransaction.setFromAccountNumber(input.getFromAccountNumber());
        bankTransaction.setToAccountNumber(input.getToAccountNumber());
        bankTransaction.setTransferAmountMoney(input.getTransferAmountMoney());
        bankTransaction.setDepositAmountMoney(input.getDepositAmountMoney());
        bankTransaction.setWithdrawAmountMoney(input.getWithdrawAmountMoney());
        bankTransaction.setTransactionDate(input.getTransactionDate());
        return bankTransaction;
    }
}


