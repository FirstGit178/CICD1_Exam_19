package ie.atu.cicd1_exam_19;

import jakarta.validation.constraints.*;

public class Person {
    @NotBlank
    private String attendeeName;

    @Email
    private String email;

    @Pattern(regexp = "TK-[0-9]{4}")
    private String ticketCode;

    @Positive
    private int quantity;
}
