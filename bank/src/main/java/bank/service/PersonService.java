package bank.service;

import bank.searches.PersonSearchInfo;
import bank.searches.ResponseList;
import ir.bank.domain.account.Account;
import ir.bank.domain.person.Person;
import ir.bank.domain.person.PersonInput;
import ir.bank.dto.PersonDto;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;

import java.util.List;


public interface PersonService<I, O> {

    Person createPerson(PersonInput input) throws Exception;

    HttpStatus deletePerson(Long id) ;

    Long updatePerson(PersonDto dto) throws Exception;

    List<Account> findAllPerson() throws Exception;

    Person getOnePerson(Long personId) throws Exception;

    ResponseList getPerson(PersonSearchInfo searchInfo);

}
