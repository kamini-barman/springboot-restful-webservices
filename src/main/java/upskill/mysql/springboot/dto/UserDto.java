package upskill.mysql.springboot.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Long id;

    //first name should not be null or empty
    @NotEmpty(message = "User first name should not be empty")
    private String firstName;

    //should not be null or empty
    @NotEmpty(message = "Last name should not be empty")
    private String lastName;

    //should not be null or empty
    //should be empty
    @NotEmpty(message = "Email should not be empty")
    @Email(message = "Email address should be valid")
    private String email;
}
