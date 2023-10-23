package bank.api;

import bank.service.AccountService;
import ir.bank.domain.account.Account;
import ir.bank.domain.account.AccountInput;
import ir.bank.dto.AccountDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;



@CrossOrigin(origins = "*")
@RestController
@ControllerAdvice
@RequestMapping("api/account")
@Controller
// account controller class which has HTTP methods for account services
public class AccountController {


    @Autowired
    private AccountService accountService;


    // create an account
    @PostMapping(value = "createAccount", headers = "Accept=application/json;charset = UTF-8")
    public ResponseEntity createAccount(
            @RequestBody AccountInput input) throws Exception {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.accountService.createAccount(input));
    }


    //  update an account
    @PutMapping(value = "updateAccount", headers = "Accept=application/json;charset=UTF-8")
    public ResponseEntity<Account> updateAccount(
            @RequestBody AccountDto dto) throws Exception {
        return new ResponseEntity
                (accountService.updateAccount(dto), HttpStatus.OK);
    }


    //  delete an account
    @DeleteMapping(value = "deleteAccount/{id}")
    public ResponseEntity<HttpStatus> deleteAccount(@PathVariable Long id) throws Exception {
        accountService.deleteAccount(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    //  find an account by it's id
    @RequestMapping(value = "findAccountById/{id}", method = RequestMethod.GET)
    public ResponseEntity<Account> findAccountById(@PathVariable Long id) throws Exception {
        return new ResponseEntity<>(accountService.getOneAccount(id), HttpStatus.OK);
    }


    //  find all accounts
    @RequestMapping(value = "/findAllAccount", method = RequestMethod.GET)
    public ResponseEntity<AccountDto> findAllAccount() throws Exception {
        if (accountService.findAllAccount().size() < 1) {
            throw new Exception("accounts list is empty !");
        }
        return new ResponseEntity(accountService.findAllAccount().stream(), HttpStatus.OK);
    }


    //  find account by account number
    @RequestMapping(value = "/findAccountByAccountNumber/{accountNumber}", method = RequestMethod.GET)
    public Account findAccountByAccountNumber(@PathVariable Integer accountNumber) throws Exception {
        return accountService.findAccountByAccountNumber(accountNumber);
    }
}
