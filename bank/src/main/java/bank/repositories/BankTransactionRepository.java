package bank.repositories;

import ir.bank.domain.account.Account;
import ir.bank.domain.bankTransaction.BankTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface BankTransactionRepository extends JpaRepository < BankTransaction , Integer >, JpaSpecificationExecutor <BankTransaction> {

    List <BankTransaction> findAll ();


//    @Query("SELECT a FROM Account a WHERE a.accountNumber = :accountNumber")
//    public Account findAccountByFromAccountNumber(@Param("accountNumber") Integer accountNumber);
//
//    @Query("SELECT a FROM Account a WHERE a.accountNumber = :accountNumber")
//    public Account findAccountByToAccountNumber(@Param("accountNumber") Integer accountNumber);

    Optional<Account> findByFromAccountNumber(Integer accountNumber);
    Optional<Account> findByToAccountNumber(Integer accountNumber);

}