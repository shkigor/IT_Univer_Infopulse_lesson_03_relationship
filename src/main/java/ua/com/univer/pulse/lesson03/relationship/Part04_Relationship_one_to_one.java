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


        entityManager.getTransaction().commit();

        entityManager.close();

        sessionFactory.close();

    }
}
