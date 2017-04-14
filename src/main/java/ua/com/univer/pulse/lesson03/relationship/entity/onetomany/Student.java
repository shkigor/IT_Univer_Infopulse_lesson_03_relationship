package ua.com.univer.pulse.lesson03.relationship.entity.onetomany;

import javax.persistence.*;

/**
 * Created by IT-UNIVER3 on 08.04.2017.
 */
@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    /**
     * У нас есть студент, который связан с учителем.
     * Т.е. у студента может быть только один преподаватель, тогда
     * как у учителя  может быть много студентов.
     *
     * Фактически в таблице создается дополнительное поле teacher_id, которое есть foreign key
     */
    @ManyToOne(fetch = FetchType.EAGER)
    private Teacher teacher;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
