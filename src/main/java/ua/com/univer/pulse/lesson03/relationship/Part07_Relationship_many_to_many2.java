package ua.com.univer.pulse.lesson03.relationship;

import org.hibernate.SessionFactory;
import ua.com.univer.pulse.lesson03.relationship.entity.manytomany2.Bank;
import ua.com.univer.pulse.lesson03.relationship.entity.manytomany2.Client;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 * Реализация связи many-to-many возможна двумя способами.
 * 1. Первый способ использование аннотации @ManyToMany
 * 2. Второй способ с использованием промежуточной сущности ClientBank
 */
public class Part07_Relationship_many_to_many2 {
    public static void main(String[] args) {
        SessionFactory sessionFactory =
                (SessionFactory) Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");

        EntityManager entityManager = sessionFactory.createEntityManager();

        // many to many 2
        entityManager.getTransaction().begin();

        Client client1 = new Client();
        client1.setName("vasya");
        Client client2 = new Client();
        client2.setName("petya");

        Bank bank1 = new Bank();
        bank1.setName("Oval");
        Bank bank2 = new Bank();
        bank2.setName("Privat");

        client1.setBank(bank1);
        client1.setBank(bank2);

        client2.setBank(bank1);
        client2.setBank(bank2);

        entityManager.persist(bank1);
        entityManager.persist(bank2);
        entityManager.persist(client1);
        entityManager.persist(client2);

        entityManager.getTransaction().commit();
        entityManager.close();
        sessionFactory.close();

    }
}
