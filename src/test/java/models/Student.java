package models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Student {
    private String first_name;
    private String middle_name;
    private String last_name;
    private String date_of_birth;
}