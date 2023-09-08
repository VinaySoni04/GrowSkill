package AlippoAssignment.GrowSkill.Models;

import AlippoAssignment.GrowSkill.Enums.Category;
import AlippoAssignment.GrowSkill.Enums.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "instructors")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    private int mobileNo;
    @Enumerated(EnumType.STRING)
    private Category specialization;
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @OneToMany(mappedBy = "instructor", cascade = CascadeType.ALL)
    private List<Course> courses=new ArrayList<>();
}
