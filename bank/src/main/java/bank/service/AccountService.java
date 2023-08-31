package bank.service;

import ir.bank.domain.account.Account;
import ir.bank.domain.account.AccountInput;
import ir.bank.dto.AccountDto;
import org.springframework.http.HttpStatus;

import java.util.List;



public interface AccountService<I,O> {

        Account createAccount(AccountInput input) throws Exception;

        HttpStatus deleteAccount(Long id) ;

        Long updateAccount(AccountDto dto) throws Exception;

        List<AccountDto> findAllAccount() throws Exception;

        Account getOneAccount(Long accountId) throws Exception;

        Account findAccountByAccountNumber(Integer accountNumber) throws Exception;

//         void calculateAccountInterest();

}



