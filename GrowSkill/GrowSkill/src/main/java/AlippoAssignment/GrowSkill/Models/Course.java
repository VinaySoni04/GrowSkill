package AlippoAssignment.GrowSkill.Models;

import AlippoAssignment.GrowSkill.Enums.Category;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "courses")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String courseName;
    private String description;
    private int duration; // In months
    @Enumerated(EnumType.STRING)
    private Category category;
    private int price; // In Rupees

    @ManyToOne
    @JoinColumn
    private Instructor instructor;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<Class> classes=new ArrayList<>();

    @OneToOne
    private Certificate certificate;
}
