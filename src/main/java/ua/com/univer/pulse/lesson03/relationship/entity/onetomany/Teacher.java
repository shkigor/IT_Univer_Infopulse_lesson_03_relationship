package ua.com.univer.pulse.lesson03.relationship.entity.onetomany;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IT-UNIVER3 on 08.04.2017.
 */
@Entity
@Table(name = "teacher")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    /**
     * Если мы хотим обратную связь, есть два пути как это сделать:
     * 1. Посредством запросов без создания каких либо дополнительных таблиц.
     * В этом случае необходимо написать в аннотации @OneToMany mappedBy = "teacher"
     *
     * 2. Другой вариант не писать mappedBy = "teacher". (teacher - это поле в классе Student)
     * Таким образом создается дополнительная таблица, что уменьшает кол-во запросов, чтобы получить список студентов.
     * выборка данных будет осуществляться быстрее, но вставка, удаление медленней.
     *
     */
//    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "teacher")
    private List<Student> students = new ArrayList<Student>();

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

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
