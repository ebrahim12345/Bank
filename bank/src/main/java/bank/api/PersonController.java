package bank.api;


import bank.searches.PersonSearchInfo;
import bank.searches.ResponseList;
import bank.service.PersonService;
import ir.bank.domain.person.Person;
import ir.bank.domain.person.PersonInput;
import ir.bank.dto.PersonDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/person")
@Controller
// person controller class which has HTTP methods for person services
public class PersonController {

    @Autowired
    private PersonService personService;


    // create person
//    @ExceptionHandler(ConstraintViolationException.class)
    @PostMapping(value = "createPerson", headers = "Accept=application/json;charset = UTF-8")
    public ResponseEntity createPerson(
            @RequestBody PersonInput input) throws Exception {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.personService.create(input));
    }


    //  update person
    @PutMapping(value = "updatePerson", headers = "Accept=application/json;charset=UTF-8")
    public ResponseEntity<Person> updatePerson(
            @RequestBody PersonDto dto) throws Exception {
        return new ResponseEntity(personService.update(dto), HttpStatus.OK);
    }


    //  delete a person
    @DeleteMapping(value = "deletePerson/{id}")
    public ResponseEntity<HttpStatus> deletePerson(@PathVariable Long id) throws Exception {
        personService.deletePerson(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    //  get one person
    @RequestMapping(value = "findPersonById/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> findPersonById(@PathVariable Long id) throws Exception {
        return new ResponseEntity<>(personService.getOnePerson(id), HttpStatus.OK);
    }


    // search person by mobile number
    @RequestMapping(value = "findPersonByMobileNumber/{personMobileNumber}", method = RequestMethod.GET)
    public ResponseEntity<Object> findPersonByMobileNumber(@PathVariable String personMobileNumber){
        return new ResponseEntity<>(personService.searchPersonByMobileNumber(personMobileNumber), HttpStatus.OK);
    }


    //  get all people  TODO check this method
    @RequestMapping(value = "findAllPeople", method = RequestMethod.GET)
    public ResponseEntity<Person> findAllPeople() throws Exception {
        return new ResponseEntity(personService.findAll().stream().distinct(), HttpStatus.OK);// findAll().stream().distinct() to remove duplicate
    }


    //  search person information
    @PostMapping("getPerson")
    public ResponseList getPerson(@RequestBody PersonSearchInfo searchInfo) {
        return personService.getPerson(searchInfo);
    }
}

