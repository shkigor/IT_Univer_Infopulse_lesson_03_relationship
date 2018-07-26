package ua.com.univer.pulse.lesson03.relationship.entity.manytomany2;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IT-UNIVER3 on 08.04.2017.
 */
@Entity
@Table(name = "bank2")
public class Bank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "bank")
    private List<ClientBank> clientBanks = new ArrayList<ClientBank>();

    public void setClient(Client client) {
        ClientBank cb = new ClientBank();
        cb.setClient(client);
        cb.setBank(this);
        clientBanks.add(cb);
    }

    public List<Client> getClient() {
        List<Client> clients = new ArrayList<Client>();
        for (ClientBank cb : clientBanks) {
            clients.add(cb.getClient());
        }

        return clients;
    }

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


}
