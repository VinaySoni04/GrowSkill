package AlippoAssignment.GrowSkill.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "classes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Class {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate date;
    private LocalTime time;
    private String topic;
    private String zoomLink;

    @ManyToOne
    @JoinColumn
    private Course course;

    @OneToOne(mappedBy = "class", cascade = CascadeType.ALL)
    private Recording recording;
}
