package ir.bank.dto;

import ir.bank.domain.person.PersonInput;
import ir.bank.domain.person.PersonOutput;
import ir.bank.domain.person.Person;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.DynamicUpdate;


@DynamicUpdate
@Getter
@Setter
@Accessors(chain = true)
public class PersonDto {

    private Long id;
    private String personFirstName;
    private String personLastName;
    private String personSocialCode;
    private String personMobileNumber;
    private String personAddress;
    private String personEmailAddress;


    // setting person properties from person output class
    public PersonOutput toDto() {
        PersonOutput output = new PersonOutput();
        output.setPersonFirstName(personFirstName);
        output.setPersonLastName(personLastName);
        output.setPersonSocialCode(personSocialCode);
        output.setPersonMobileNumber(personMobileNumber);
        output.setPersonAddress(personAddress);
        output.setPersonEmailAddress(personEmailAddress);
        return output;
    }


    // setting person properties from person input class
    public Person fromDto(PersonInput input) {
        Person person = new Person();
        person.setPersonFirstName(input.getPersonFirstName());
        person.setPersonLastName(input.getPersonLastName());
        person.setPersonSocialCode(input.getPersonSocialCode());
        person.setPersonMobileNumber(input.getPersonMobileNumber());
        person.setPersonAddress(input.getPersonAddress());
        person.setPersonEmailAddress(input.getPersonEmailAddress());
        return person;

    }
}