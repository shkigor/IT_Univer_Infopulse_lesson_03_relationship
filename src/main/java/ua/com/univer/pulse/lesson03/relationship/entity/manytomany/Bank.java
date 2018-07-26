package ua.com.univer.pulse.lesson03.relationship.entity.manytomany;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IT-UNIVER3 on 08.04.2017.
 */
@Entity
@Table(name = "bank")
public class Bank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    /**
     * Если не написать mappedBy = "banks" в аннотации @ManyToMany(fetch = FetchType.LAZY, mappedBy = "banks"),
     * то вместо одной таблицы, будут две: одна будет называть client_bank, другая bank_client
     *
     */
//    @ManyToMany(fetch = FetchType.LAZY)
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "banks")
    private List<Client> clients = new ArrayList<Client>();


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

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }
}
