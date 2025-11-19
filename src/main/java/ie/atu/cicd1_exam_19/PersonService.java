package ie.atu.cicd1_exam_19;

import java.util.ArrayList;
import java.util.Optional;

@org.springframework.stereotype.Service

public class PersonService {

    private final list <Person> store = new ArrayList<>();
    public list<Person> findAll() {
        return new ArrayList<>(store);
    }
    public Optional<Person> findById(String ticketCode) {
        for(Person p : store) {
            of(p.getPersonticketCode().equals(ticketCode)) {
                return Optional.of(p);
            }
        }
        return Optional.empty();
    }

}
}
