package bank.repositories;

import ir.bank.domain.account.Account;
import ir.bank.domain.person.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface PersonRepository extends JpaRepository<Person, Long>, JpaSpecificationExecutor<Person> {


    List<Person> findAll();
    @Query("SELECT p FROM Person p WHERE p.personMobileNumber =:personMobileNumber")
    Person findAccountByPersonMobileNumber(@Param("personMobileNumber") String personMobileNumber);

    Person findPersonById(@Param("id") Long id);

    Optional<Person> findById(Long id);


}






