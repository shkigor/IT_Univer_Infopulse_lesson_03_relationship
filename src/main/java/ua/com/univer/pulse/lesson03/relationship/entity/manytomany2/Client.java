package ua.com.univer.pulse.lesson03.relationship.entity.manytomany2;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IT-UNIVER3 on 08.04.2017.
 */
@Entity
@Table(name = "client2")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "client")
    private List<ClientBank> clientBanks = new ArrayList<>();

    public void setBank(Bank bank) {
        ClientBank cb = new ClientBank();
        cb.setBank(bank);
        cb.setClient(this);
        clientBanks.add(cb);
    }

    public List<Bank> getBank() {
        List<Bank> banks = new ArrayList<>();
        for (ClientBank cb : clientBanks) {
            banks.add(cb.getBank());
        }
        return banks;
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

