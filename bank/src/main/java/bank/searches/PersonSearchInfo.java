package bank.searches;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;


@Getter
@Setter
@Accessors(chain = true)
public class PersonSearchInfo {

    private String personFirstName;
    private String personLastName;
    private String personSocialCode;
    private String personMobileNumber;
    private String personAddress;
    private String personEmailAddress;
    private String search;
    private Integer count;
    private Integer pageNumber;


}
