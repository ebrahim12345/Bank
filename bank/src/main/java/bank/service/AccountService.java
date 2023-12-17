package bank.service;

import ir.bank.domain.account.Account;
import ir.bank.domain.account.AccountInput;
import ir.bank.dto.AccountDto;
import org.springframework.http.HttpStatus;

import java.util.Collection;


public interface AccountService<T> {

        T createAccount(AccountInput input) throws Exception;

        HttpStatus deleteAccount(Long id) ;

        T updateAccount(AccountDto dto) throws Exception;

        Collection<? super T> findAllAccount() throws Exception;

        T getOneAccount(Long accountId) throws Exception;

        T findAccountByAccountNumber(Integer accountNumber) throws Exception;


}



