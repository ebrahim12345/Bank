package bank.serviceImpl;

import bank.exceptions.ResourceNotFoundException;
import bank.repositories.AccountRepository;
import bank.service.AccountService;
import ir.bank.domain.account.Account;
import ir.bank.domain.account.AccountInput;
import ir.bank.dto.AccountDto;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class AccountServiceImpl implements AccountService {


    @Autowired
    private AccountRepository accountRepository;


    @Override // create an account
    public Account createAccount(AccountInput input) throws Exception {

        Account createAccount = new Account().fromDto(input);
        LocalDateTime currentDate =  LocalDateTime.now();
        if (input.getAccountNumber() == null) {
            throw new Exception("insert account number please!");
        }
        if (input.getAccountType() == null) {
            throw new Exception("insert account type please!");
        }
        if (input.getAccountBalanceAmount() == null) {
            throw new Exception("insert account balance amount please!");
        }
        if (input.getAccountInterestRate() == null) {
            throw new Exception("insert account interest rate please!");
        }
        if (input.getPersonId() == null) {
            throw new Exception("insert person id  please!");
        }
        createAccount.setCreatedAt(currentDate);
        // save account's information
        return accountRepository.save(createAccount);
    }


    @Override // update an account
    public Long updateAccount(AccountDto dto) throws Exception {
        LocalDateTime updateDate = LocalDateTime.now();

        Account account = accountRepository.findById(dto.getId())
                .orElseThrow(() -> new ResourceNotFoundException("account id ", dto.getId()));

        if (dto.getAccountNumber() != null)
            account.setAccountNumber(dto.getAccountNumber());
        if (dto.getAccountType() != null)
            account.setAccountType(dto.getAccountType());
        if (dto.getAccountInterestRate() != null)
            account.setAccountBalanceAmount(dto.getAccountBalanceAmount());
        if (dto.getAccountBalanceAmount() != null)
            account.setAccountBalanceAmount(dto.getAccountBalanceAmount());
        if (dto.getPersonId() != null)
            account.setPersonId(dto.getPersonId());
        account.setUpdatedAt(updateDate);
        // update account's information
        accountRepository.save(account);
        return account.getId();
    }


    @SneakyThrows
    @Override //deleting an account
    public HttpStatus deleteAccount(Long id) {
        // delete an account's
        accountRepository.delete(accountRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("account id ", id)));
        return HttpStatus.OK;
    }


    @Override // find all accounts
    public List<Account> findAllAccount() throws Exception {
        // print list of account
        return accountRepository.findAll();
    }


    @Override // find an account by it's id
    public Account getOneAccount(Long accountId) throws Exception {
        return accountRepository.findById(accountId)
                .orElseThrow(() -> new ResourceNotFoundException("account ", accountId));
    }


    @Override // find an account by account number
    public Account findAccountByAccountNumber(Integer accountNumber) throws Exception {
        try {
            return accountRepository.findAccountByAccountNumber(accountNumber);
        } catch (Exception e) {
            throw new ResourceNotFoundException("account number : " + accountNumber);
        }
    }


    @Scheduled(fixedDelay = 31, initialDelay = 30, timeUnit = TimeUnit.DAYS)
    public void calculateAccountInterest() {
//        System.out.println((LocalTime.now()) + " calculate interest rate");

        List<Account> findInterest = accountRepository.findAll();

        for (Account account : findInterest) {
            if (account.getId() != null) {
                LocalDateTime currentDate = LocalDateTime.now();
//              after 1 months
                LocalDateTime calculateDate = currentDate.now().plusMinutes(10);

                Double calculateInterest = (((account.getAccountBalanceAmount() * account.getAccountInterestRate()) / 100 ) / 12 );
                account.setInterest(calculateInterest);
//             account.setUpdatedAt(calculateDate);
            }
            accountRepository.save(account);
            System.out.println((LocalTime.now()) + " calculate interest rate");

        }
    }
}




