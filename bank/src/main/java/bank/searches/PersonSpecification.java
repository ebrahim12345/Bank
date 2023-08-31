package bank.searches;

import ir.bank.domain.person.Person;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

@Component
public class PersonSpecification {

        public Specification<Person> getPerson(PersonSearchInfo searchInfo) {
            return (root, query, CriteriaBuilder) -> {
                List<Predicate> predicates = new ArrayList<>();


                if (searchInfo.getSearch()!= null) {
                    predicates.add(CriteriaBuilder.like(root.get("personFirstName"),"%" +searchInfo.getSearch()+ "%"));
                }
                if (searchInfo.getSearch()!= null) {
                    predicates.add(CriteriaBuilder.like(root.get("personLastName"),"%" +searchInfo.getSearch()+ "%"));
                }
                if (searchInfo.getSearch()!= null) {
                    predicates.add(CriteriaBuilder.like(root.get("personAddress"),"%" +searchInfo.getSearch()+ "%"));
                }
                if (searchInfo.getSearch()!= null) {
                    predicates.add(CriteriaBuilder.like(root.get("personSocialCode"),"%" +searchInfo.getSearch()+ "%"));
                }
                query.orderBy(CriteriaBuilder.asc(root.get("id")));
                return CriteriaBuilder.or(predicates.toArray(new Predicate[0]));

            };
        }


        public Specification<Person> getPersonWithAnd(PersonSearchInfo searchInfo) {
            return (root, query, CriteriaBuilder) -> {
                List<Predicate> predicates = new ArrayList<>();

                if (searchInfo.getPersonMobileNumber() != null) {
                    predicates.add(CriteriaBuilder.like(root.get("personMobileNumber"), "%" + searchInfo.getPersonMobileNumber()+ "%"));
                }
                if (searchInfo.getPersonEmailAddress() != null) {
                    predicates.add(CriteriaBuilder.like(root.get("personEmailAddress"), "%" + searchInfo.getPersonEmailAddress()+ "%"));
                }

                query.orderBy(CriteriaBuilder.asc(root.get("id")));
                return CriteriaBuilder.and(predicates.toArray(new Predicate[0]));

            };
        }
   }
