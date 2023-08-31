package ir.bank.domain.person;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;


@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@Data
public class PersonOutput {

    private Long id;
    private String personFirstName;
    private String personLastName;
    private String personSocialCode;
    private String personMobileNumber;
    private String personAddress;
    private String personEmailAddress;

//    public List<Account> accounts;


    public PersonOutput(
            Long id,
            String personFirstName,
            String personLastName,
            String personSocialCode,
            String personMobileNumber,
            String personAddress,
            String personEmailAddress


    ) {
        this.id = id;
        this.personFirstName = personFirstName;
        this.personLastName = personLastName;
        this.personSocialCode = personSocialCode;
        this.personMobileNumber = personMobileNumber;
        this.personAddress = personAddress;
        this.personEmailAddress = personEmailAddress;


    }
}

