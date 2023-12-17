package bank.api;


import bank.repositories.BankTransactionRepository;
import bank.service.BankTransactionService;
import ir.bank.domain.account.Account;
import ir.bank.domain.bankTransaction.BankTransaction;
import ir.bank.domain.bankTransaction.BankTransactionInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

import org.springframework.stereotype.Controller;


@Controller
@RestController
@ControllerAdvice
@CrossOrigin(origins = "*")
@RequestMapping("api/bankTransaction")

// bank transaction controller class which has HTTP methods for bank transaction services
public class BankTransactionController {


    @Autowired
    private BankTransactionService bankTransactionService;


    @Autowired
    private BankTransactionRepository bankTransactionRepository;


    //  money transformation process http method
    @PostMapping(value = "bankTransaction", headers = "Accept=application/json;charset = UTF-8")
    public ResponseEntity bankTransaction(
            @RequestBody BankTransactionInput input) throws Exception {
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.bankTransactionService.transferMoney(input));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }


    //  deposit process http method
    @PostMapping(value = "deposit", headers = "Accept=application/json;charset = UTF-8")
    public ResponseEntity deposit(
            @RequestBody BankTransactionInput input) throws Exception {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.bankTransactionService.deposit(input));
    }


    // withdraw process http method
    @PostMapping(value = "withdraw", headers = "Accept=application/json;charset = UTF-8")
    public ResponseEntity withdraw(
            @RequestBody BankTransactionInput input) throws Exception {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.bankTransactionService.withdraw(input));
    }

}
