package ir.bank.domain.account;

import ir.bank.domain.person.Person;
import ir.bank.domain.person.PersonOutput;
import com.fasterxml.jackson.annotation.JsonInclude;
import ir.bank.enums.AccountType;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;


@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@Data
public class AccountOutput {

    private Long id;
    private Integer accountNumber;
    private Integer accountBalanceAmount;
    private Double accountInterestRate;
    private AccountType accountType;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private List<Account> accounts;
    private Person personId;
    private PersonOutput personOutput;
    private Double interest;


    public AccountOutput(
            Integer accountNumber,
            Integer accountBalanceAmount,
            Double accountInterestRate,
            AccountType accountType,
            PersonOutput personOutput,
            Double interest,
            LocalDateTime createdAt,
            LocalDateTime updatedAt

    ) {
        this.accountNumber = accountNumber;
        this.accountBalanceAmount = accountBalanceAmount;
        this.accountInterestRate = accountInterestRate;
        this.accountType = accountType;
        this.interest = interest;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.personOutput = personOutput;
    }
}

