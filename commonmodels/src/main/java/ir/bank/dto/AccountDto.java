package ir.bank.dto;

import ir.bank.domain.account.AccountInput;
import ir.bank.domain.account.AccountOutput;
import ir.bank.domain.person.Person;
import ir.bank.enums.AccountType;
import ir.bank.domain.account.Account;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Getter
@Setter
@Accessors(chain = true)
public class AccountDto {


    private Long id;
    private Integer accountNumber;
    private Integer accountBalanceAmount;
    private Double accountInterestRate;
    private AccountType accountType;
    private LocalDateTime createdAt;
    private Person personId;



    // setting person properties from account output class
    public AccountOutput toDto() {
        AccountOutput output = new AccountOutput();
        output.setAccountNumber(accountNumber);
        output.setAccountBalanceAmount(accountBalanceAmount);
        output.setAccountInterestRate(accountInterestRate);
        output.setAccountType(accountType);
        output.setCreatedAt(createdAt);
        return output;
    }


    // setting person properties from account input class
    public Account fromDto(AccountInput input) {
        Account account = new Account();
        account.setAccountNumber(input.getAccountNumber());
        account.setAccountBalanceAmount(input.getAccountBalanceAmount());
        account.setAccountInterestRate(input.getAccountInterestRate());
        account.setAccountType(input.getAccountType());
        account.setCreatedAt(input.getCreatedAt());
        return account;
    }
}



