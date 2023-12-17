package bank.service;


import ir.bank.domain.bankTransaction.BankTransactionInput;

public interface BankTransactionService <T>{

    //  money transformation service
    T transferMoney(BankTransactionInput input) throws Exception;

    //  withdraw service
    T withdraw(BankTransactionInput input) throws Exception;

    //  deposit service
    T deposit(BankTransactionInput input) throws Exception;

}
