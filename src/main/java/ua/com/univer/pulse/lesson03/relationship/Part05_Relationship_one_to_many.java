package ua.com.univer.pulse.lesson03.relationship;

import org.hibernate.SessionFactory;
import ua.com.univer.pulse.lesson03.relationship.entity.onetomany.Student;
import ua.com.univer.pulse.lesson03.relationship.entity.onetomany.Teacher;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Part05_Relationship_one_to_many {
    public static void main(String[] args) {
        SessionFactory sessionFactory =
                (SessionFactory) Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");

        EntityManager entityManager = sessionFactory.createEntityManager();

        entityManager.getTransaction().begin();


        // one to many
        Student student1 = new Student();
        student1.setName("vasya");
        Student student2 = new Student();
        student2.setName("petya");

        Teacher teacher = new Teacher();
        teacher.setName("Ivan Vladimirovich");

        // Если в классе Teacher указано в аннотации @OneToMany mappedBy = "teacher"
        // тогда следующий код teacher.getStudents().add(student1); писать не нужно
        //
        // Но если не указано mappedBy = "teacher", то необходимо добавить студентов student1 и student2 к учителю teacher,
        // тем самым обеспечивается двухсторонняя связь. В этом случае поиск будет работать быстрее
        //
        // Если не указано mappedBy = "teacher", то появится дополнительная таблица для обеспечения связей.
//        teacher.getStudents().add(student1);
//        teacher.getStudents().add(student2);

        student1.setTeacher(teacher);
        student2.setTeacher(teacher);


        entityManager.persist(student1);
        entityManager.persist(student2);
        entityManager.persist(teacher);

        entityManager.getTransaction().commit();

        entityManager.close();

        sessionFactory.close();

    }
}
