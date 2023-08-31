package ir.bank.domain.account;


import com.fasterxml.jackson.annotation.JsonFormat;
import ir.bank.domain.person.Person;
import ir.bank.enums.AccountType;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;


@Getter
@Setter
@Entity
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@Table(name = "account" , uniqueConstraints = { @UniqueConstraint(columnNames = "account_number")})
public class Account implements Serializable {


    @Id // this field's value will be generated by hibernate sequence
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "account_number")
    private Integer accountNumber;

    @Column(name = "account_balance_amount")
    private Integer accountBalanceAmount;

    @Column(name = "account_interest_rate")
    private Double accountInterestRate;

    @Column(name = "interest")
    private Double interest;

    @Enumerated(EnumType.STRING)
    @Column(name = "account_type")
    private AccountType accountType;

    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Person.class)
    @JoinColumn(name = "person_Id", foreignKey = @ForeignKey(name = "fk_person_Id"))
    private Person personId;


    // setting person properties from account output class
    public AccountOutput toDto() {
        AccountOutput output = new AccountOutput();
        output.setAccountNumber(accountNumber);
        output.setAccountBalanceAmount(accountBalanceAmount);
        output.setAccountInterestRate(accountInterestRate);
        output.setAccountType(accountType);
        output.setCreatedAt(createdAt);
        output.setUpdatedAt(updatedAt);
        output.setPersonId(personId);
        output.setInterest(interest);
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
        account.setUpdatedAt(input.getUpdatedAt());
        account.setPersonId(input.getPersonId());
        account.setInterest(input.getInterest());
        return account;
    }

}

