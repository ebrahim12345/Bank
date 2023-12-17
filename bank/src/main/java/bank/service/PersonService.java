package bank.service;

import bank.searches.PersonSearchInfo;
import bank.searches.ResponseList;
import ir.bank.domain.person.PersonInput;
import ir.bank.dto.PersonDto;
import org.springframework.http.HttpStatus;

import java.util.Collection;


public interface PersonService<T> {

    T create(PersonInput input) throws Exception;

    HttpStatus deletePerson(Long id) ;

    T update(PersonDto dto) throws Exception;

    Collection<? extends T> findAll() throws Exception;

    T getOnePerson(Long personId) throws Exception;

    ResponseList getPerson(PersonSearchInfo searchInfo);
    T searchPersonByMobileNumber(String personMobileNumber);

}
