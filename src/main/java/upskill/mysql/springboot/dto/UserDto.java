package upskill.mysql.springboot.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(
        description = "UserDto model"
)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Long id;

    @Schema(
            description = "User first name"
    )
    //first name should not be null or empty
    @NotEmpty(message = "User first name should not be empty")
    private String firstName;

    @Schema(
            description = "User last name"
    )
    //should not be null or empty
    @NotEmpty(message = "Last name should not be empty")
    private String lastName;

    @Schema(
            description = "User email address"
    )
    //should not be null or empty
    //should be empty
    @NotEmpty(message = "Email should not be empty")
    @Email(message = "Email address should be valid")
    private String email;
}
