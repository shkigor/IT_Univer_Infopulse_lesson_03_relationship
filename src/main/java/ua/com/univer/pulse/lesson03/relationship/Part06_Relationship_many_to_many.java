package ua.com.univer.pulse.lesson03.relationship;

import org.hibernate.SessionFactory;
import ua.com.univer.pulse.lesson03.relationship.entity.manytomany.Bank;
import ua.com.univer.pulse.lesson03.relationship.entity.manytomany.Client;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

/**
 * Реализация связи many-to-many возможна двумя способами.
 * 1. Первый способ использование аннотации @ManyToMany
 */
public class Part06_Relationship_many_to_many {
    public static void main(String[] args) {
        SessionFactory sessionFactory =
                (SessionFactory) Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");

        EntityManager entityManager = sessionFactory.createEntityManager();

        entityManager.getTransaction().begin();

        // many to many
        Client cl1 = new Client();
        cl1.setName("vasya");
        Client cl2 = new Client();
        cl2.setName("petya");

        Bank b1 = new Bank();
        b1.setName("Oval");
        Bank b2 = new Bank();
        b2.setName("Privat");

        cl1.getBanks().add(b1);
        cl1.getBanks().add(b2);

        cl2.getBanks().add(b2);
        cl2.getBanks().add(b1);

        entityManager.persist(b1);
        entityManager.persist(b2);
        entityManager.persist(cl1);
        entityManager.persist(cl2);

        entityManager.getTransaction().commit();

        // NEXT TRANSACTION
        entityManager.getTransaction().begin();
        List<Client> clientList = entityManager
                .createQuery("select c from ua.com.univer.pulse.lesson03.relationship.entity.manytomany.Client c join c.banks b where b.name = :name", Client.class)
                .setParameter("name", "Oval").getResultList();

        System.out.println("====== Clients =======");
        for (Client client : clientList) {
            System.out.println(client.getName());
        }

        System.out.println();
        for (Bank bank : clientList.get(0).getBanks()) {
            System.out.println(clientList.get(0).getName());
            System.out.println(bank.getName());
        }

        entityManager.getTransaction().commit();

        entityManager.close();
        sessionFactory.close();

//        // Lazy error
//        for (Bank bank : clientList.get(0).getBanks()) {
//            System.out.println(clientList.get(0).getName());
//            System.out.println(bank.getName());
//        }
    }
}
