package bank.service;


import ir.bank.domain.bankTransaction.BankTransactionInput;
import org.springframework.http.HttpStatus;

public interface BankTransactionService {

    //  money transformation service
    Long transferMoney(BankTransactionInput input) throws Exception;

    //  withdraw service
    Long withdraw(BankTransactionInput input) throws Exception;

    //  deposit service
    Long deposit(BankTransactionInput input) throws Exception;

}
