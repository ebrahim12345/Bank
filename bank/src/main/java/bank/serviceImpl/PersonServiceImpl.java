package bank.serviceImpl;

import bank.exceptions.ResourceNotFoundException;
import bank.repositories.PersonRepository;
import bank.searches.PersonSearchInfo;
import bank.searches.PersonSpecification;
import bank.searches.ResponseList;
import bank.service.PersonService;
import ir.bank.domain.person.Person;
import ir.bank.domain.person.PersonInput;
import ir.bank.dto.PersonDto;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PersonSpecification personSpecification;
    private Integer defaultPageSize = 3;


    @Override // creating person
    public Person createPerson(PersonInput input) throws Exception {
        Person person = new Person().fromDto(input);

        if (input.getPersonEmailAddress() == null) {
            throw new Exception("insert email address please !");
        }
        if (input.getPersonFirstName() == null) {
            throw new Exception("insert name please !");
        }
        if (input.getPersonLastName() == null) {
            throw new Exception("insert family name please !");
        }
        if (input.getPersonSocialCode() == null) {
            throw new Exception("insert social code please !");
        }
        if (input.getPersonMobileNumber() == null) {
            throw new Exception("insert phone number please !");
        }
        if (input.getPersonAddress() == null) {
            throw new Exception("insert address please !");
        }
        // save person's information
        return personRepository.save(person);
    }

    @Override  //updating person
    public Long updatePerson(@RequestBody PersonDto dto) throws Exception {
        Person person = personRepository.findById(dto.getId())
                .orElseThrow(() -> new ResourceNotFoundException("personId ", dto.getId()));
        if (dto.getPersonFirstName() != null)
            person.setPersonFirstName(dto.getPersonFirstName());
        if (dto.getPersonLastName() != null)
            person.setPersonLastName(dto.getPersonLastName());
        if (dto.getPersonAddress() != null)
            person.setPersonAddress(dto.getPersonAddress());
        if (dto.getPersonSocialCode() != null)
            person.setPersonSocialCode(dto.getPersonSocialCode());
        if (dto.getPersonMobileNumber() != null)
            person.setPersonMobileNumber(dto.getPersonMobileNumber());
        // update person's information
        personRepository.save(person);
        return person.getId();
    }


    @SneakyThrows
    @Override //deleting a person
    public HttpStatus deletePerson(Long id) {
        // delete person's record
        personRepository.delete(personRepository.findById(id)
                .orElseThrow(() -> new Exception("person is not found !")));
        return HttpStatus.OK;
    }


    @Override // find a person
    public Person getOnePerson(Long personId) throws Exception {
        return personRepository.findById(personId)
                .orElseThrow(() -> new ResourceNotFoundException("person id ", personId));
    }


    @Override // find all people
    public List<Person> findAllPerson() throws Exception {
        try {
            // print list of people
            return personRepository.findAll();
        } catch (Exception e) {
            throw new Exception("people list is empty !");
        }
    }


    @Override // search person
    public ResponseList getPerson(PersonSearchInfo searchInfo) {
        List<Person> list = null;
        Page<Person> pages = null;
        if (searchInfo.getPageNumber() == null) {

            pages = new PageImpl<>(personRepository.findAll(personSpecification.getPerson(searchInfo)));
        } else {
            if (searchInfo.getCount() == null)
                searchInfo.setCount(defaultPageSize);
            Pageable paging = PageRequest.of(searchInfo.getPageNumber() - 1, searchInfo.getCount());
            pages = personRepository.findAll(personSpecification.getPerson(searchInfo), paging);
        }
        if (pages != null && pages.getContent() != null) {
            list = pages.getContent();
            if (list != null && list.size() > 0) {
                ResponseList responseList = new ResponseList();
                responseList.setTotalPage(pages.getTotalPages());
                responseList.setTotalCount(pages.getTotalElements());
                responseList.setPageNo(pages.getNumber() + 1);
                responseList.setResult(new ArrayList<>());
                for (Person person : list) {
                    responseList.getResult().add(person.toDto());
                }
                return responseList;
            }
        }
        return null;
    }
}





