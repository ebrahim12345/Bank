package ir.bank.domain.person;

import lombok.Data;


@Data
public class PersonInput {

    private Long id;
    private String personFirstName;
    private String personLastName;
    private String personSocialCode;
    private String personMobileNumber;
    private String personAddress;
    private String personEmailAddress;


}
