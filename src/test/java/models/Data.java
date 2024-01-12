package models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Data {
    private int id;
    private String first_name;
    private String middle_name;
    private String last_name;
    private String date_of_birth;

    public Data(Student student) {
        this.first_name = student.getFirst_name();
        this.middle_name = student.getMiddle_name();
        this.last_name = student.getLast_name();
        this.date_of_birth = student.getDate_of_birth();
    }
}