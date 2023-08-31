package bank.repositories;

import ir.bank.domain.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface AccountRepository extends JpaRepository<Account, Long>, JpaSpecificationExecutor<Account> {

    List<Account> findAll();

    Optional<Account> findById(Long id);

    @Query("SELECT a FROM Account a WHERE a.accountNumber = :accountNumber")
    Account findAccountByAccountNumber(@Param("accountNumber") Integer accountNumber);

    Optional<Account> findByAccountNumber(Integer accountNumber);

}






