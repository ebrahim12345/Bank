package ir.bank.domain.account;

import ir.bank.domain.person.Person;
import ir.bank.enums.AccountType;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class AccountInput {

    private Long id;
    private Integer accountNumber;
    private Integer accountBalanceAmount;
    private Double accountInterestRate;
    private AccountType accountType;
    private Double interest;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private List<Account> accounts;
    private Person personId;


}
