package data_model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

/**
 * @author Pavel Romanov 25.12.2022
 */

@Builder
@Getter
@Setter
public class User {
    private String firstName;
    private String lastName;
    private String email;
    private String age;
    private String salary;
    private String department;
}
