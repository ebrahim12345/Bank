package bank.serviceImpl;


import bank.repositories.AccountRepository;
import bank.repositories.BankTransactionRepository;
import bank.service.BankTransactionService;
import ir.bank.domain.account.Account;
import ir.bank.domain.bankTransaction.BankTransaction;
import ir.bank.domain.bankTransaction.BankTransactionInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalTime;
import java.util.Date;


@Service
public class BankTransactionServiceImpl implements BankTransactionService {


    @Autowired
    private BankTransactionRepository bankTransactionRepository;

    @Autowired
    private AccountRepository accountRepository;




    @Override //  money transformation process implementation
    public Long transferMoney(BankTransactionInput input) throws Exception {

        if (input.getFromAccountNumber() == null)
            throw new Exception("لطفا شماره حساب مبدا را وارد نمایید !");
        Account fromAccount = accountRepository.findByAccountNumber(input.getFromAccountNumber())
                .orElseThrow(() -> new Exception(" شماره حساب مبدا یافت نشد !"));

        if (input.getToAccountNumber() == null)
            throw new Exception("لطفا شماره حساب مقصد را وارد نمایید !");
        Account toAccount = accountRepository.findByAccountNumber(input.getToAccountNumber())
                .orElseThrow(() -> new Exception(" شماره حساب مقصد یافت نشد !"));
        Date currentDate = new Date();
        BankTransaction bankTransaction = new BankTransaction();
        if (fromAccount.getAccountBalanceAmount() != null && fromAccount.getAccountBalanceAmount() > input.getTransferAmountMoney() - 1)
            try {
                Integer fromBalance, toBalance;
                fromBalance = fromAccount.getAccountBalanceAmount();
                toBalance = toAccount.getAccountBalanceAmount();
                fromBalance -= input.getTransferAmountMoney();
                toBalance += input.getTransferAmountMoney();
                fromAccount.setAccountBalanceAmount(fromBalance);
                toAccount.setAccountBalanceAmount(toBalance);
                bankTransaction.setTransactionDate(currentDate);
                bankTransaction.setTransferAmountMoney(input.getTransferAmountMoney());
                bankTransaction.setFromAccountNumber(fromAccount.getAccountNumber());
                bankTransaction.setToAccountNumber(toAccount.getAccountNumber());
                bankTransactionRepository.save(bankTransaction);
            } catch (Exception e) {
                throw new IOException(" خطا!   موجودی کافی نمی باشد. ");
            }
        bankTransactionRepository.save(bankTransaction);
        return bankTransaction.getId();
    }


    @Override // deposit process implementation
    public Long deposit(BankTransactionInput input) throws Exception {
        Account depositTo = accountRepository.findByAccountNumber(input.getToAccountNumber())
                .orElseThrow(() -> new Exception("  شماره حساب مورد نظر یافت نشد !"));
        BankTransaction bankTransaction = new BankTransaction();
        Account account = new Account();
        Date currentDate = new Date();
        if (depositTo.getAccountNumber() == null)
            throw new Exception("شماره حساب خالی است");
        if (input.getDepositAmountMoney() == null)
            throw new Exception("مبلغ واریز خالی است");
        if (input.getDepositAmountMoney() <= 0)
            throw new Exception("مبلغ واریز نامعتبر است!");
        if (depositTo.getAccountBalanceAmount() != null)
            try {
                Integer accountBalance = depositTo.getAccountBalanceAmount();
                accountBalance += input.getDepositAmountMoney();
                bankTransaction.setToAccountNumber(depositTo.getAccountNumber());
                bankTransaction.setDepositAmountMoney(input.getDepositAmountMoney());
                depositTo.setAccountBalanceAmount(accountBalance);
                bankTransaction.setTransactionDate(currentDate);
                bankTransactionRepository.save(bankTransaction);
                accountRepository.save(depositTo);
            } catch (Exception ex) {
                throw new Exception("خطا!   حساب مورد نظر غیر فعال است!");
            }
        bankTransactionRepository.save(bankTransaction);
        return bankTransaction.getId();
    }


    @Override  // withdraw  process implementation
    public Long withdraw(BankTransactionInput input) throws Exception {
//        Date currentDate = new Date();
        BankTransaction bankTransaction = new BankTransaction();
        if (input.getFromAccountNumber() == null)
            throw new Exception("لطفا شماره حساب را وارد نمایید !");
        Account withdrawFrom = accountRepository.findByAccountNumber(input.getFromAccountNumber())
                .orElseThrow(() -> new Exception("  شماره حساب مورد نظر یافت نشد !"));
        if (input.getWithdrawAmountMoney() == null)
            throw new Exception("مبلغ برداشت را وارد نمایید !");
        if (input.getWithdrawAmountMoney() <= 0)
            throw new Exception("مبلغ برداشت نامعتبر است !");

        if (withdrawFrom.getAccountBalanceAmount() > input.getWithdrawAmountMoney() - 1)
            try {
                Integer accountBalance = withdrawFrom.getAccountBalanceAmount();
                accountBalance -= input.getWithdrawAmountMoney();
                bankTransaction.setFromAccountNumber(withdrawFrom.getAccountNumber());
                bankTransaction.setWithdrawAmountMoney(input.getWithdrawAmountMoney());
                withdrawFrom.setAccountBalanceAmount(accountBalance);
                bankTransaction.setTransactionDate(new Date());
                bankTransactionRepository.save(bankTransaction);
                accountRepository.save(withdrawFrom);
            } catch (Exception exception) {
                throw new Exception("موجودی کافی نمی باشد!");
            }
        bankTransactionRepository.save(bankTransaction);
        return bankTransaction.getId();
    }

}