package ua.com.univer.pulse.lesson03.relationship;

import org.hibernate.SessionFactory;
import ua.com.univer.pulse.lesson03.relationship.entity.onetoone.Address;
import ua.com.univer.pulse.lesson03.relationship.entity.onetoone.User;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 * Если таблица состоит из 100 полей. Очень удобно разбить на две таблицы и
 * между ними сделать связь one to one, так будет работать быстрее.
 *
 * Например вы делаете часто запросы и вам не нужно всегда все 100 полей, а нужна какая-то часть,
 * тогда все держать в одной таблице не разумно
 *
 */
public class Part04_Relationship_one_to_one {
    public static void main(String[] args) {
        SessionFactory sessionFactory =
                (SessionFactory) Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");

        EntityManager entityManager = sessionFactory.createEntityManager();

        entityManager.getTransaction().begin();


        // one to one
        Address address = new Address();
        address.setCity("Kiev");


        User user = new User();
        user.setName("Igor");
        user.setLastName("Shklyar");
        user.setAddress(address);

        // если не написать mappedBy
        // тогда необходимо добавить user в address,
        // тем самым обеспечивается двухсторонняя связь
        // в этом случае поиск будет работать быстрее
        address.setUser(user);

        entityManager.persist(address);
        entityManager.persist(user);



        // one to many
//        Student st1 =new Student();
//        st1.setName("vasya");
//        Student st2 =new Student();
//        st2.setName("petya");
//
//        Teacher teacher = new Teacher();
//        teacher.setName("Ivan Vladimirovich");
//
//        teacher.getStudents().add(st1);
//        teacher.getStudents().add(st2);
//
//        st1.setTeacher(teacher);
//        st2.setTeacher(teacher);
//
//
//        entityManager.persist(st1);
//        entityManager.persist(st2);
//        entityManager.persist(teacher);



//        // many to many
//        Client cl1 = new Client();
//        cl1.setName("vasya");
//        Client cl2 = new Client();
//        cl2.setName("petya");
//
//        Bank b1 = new Bank();
//        b1.setName("Oval");
//        Bank b2 = new Bank();
//        b2.setName("Privat");
//
//        cl1.getBanks().add(b1);
//        cl1.getBanks().add(b2);
//
//        cl2.getBanks().add(b2);
//        cl2.getBanks().add(b1);
//
//        entityManager.persist(b1);
//        entityManager.persist(b2);
//        entityManager.persist(cl1);
//        entityManager.persist(cl2);
//
//        entityManager.getTransaction().commit();
//
//
//        entityManager.getTransaction().begin();
//        List<Client> clientList = entityManager.createQuery("select c from lesson3.entity.manytomany.Client c join c.banks b where b.name = :name", Client.class)
//                .setParameter("name", "Oval").getResultList();
//
//       for (Client b : clientList) {
//           System.out.println(b.getName());
//       }
//
//        for (Bank b : clientList.get(0).getBanks()) {
//            System.out.println(clientList.get(0).getName());
//            System.out.println(b.getName());
//        }
//
//        entityManager.getTransaction().commit();
//
//
//        entityManager.close();
//
//        // Lazy error
////        for (Bank b : clientList.get(0).getBanks()) {
////            System.out.println(clientList.get(0).getName());
////            System.out.println(b.getName());
////        }
//        sessionFactory.close();




//        // many to many 2
//
//        entityManager.getTransaction().begin();
//
//        Client cl1 = new Client();
//        cl1.setName("vasya");
//        Client cl2 = new Client();
//        cl2.setName("petya");
//
//        Bank b1 = new Bank();
//        b1.setName("Oval");
//        Bank b2 = new Bank();
//        b2.setName("Privat");
//
//        cl1.setBank(b1);
//        cl1.setBank(b2);
//
//        cl2.setBank(b1);
//        cl2.setBank(b2);
//
//        entityManager.persist(b1);
//        entityManager.persist(b2);
//        entityManager.persist(cl1);
//        entityManager.persist(cl2);

        entityManager.getTransaction().commit();

        entityManager.close();

        sessionFactory.close();

    }
}
