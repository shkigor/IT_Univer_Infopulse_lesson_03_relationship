package ua.com.univer.pulse.lesson03.relationship.entity.manytomany2;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by IT-UNIVER3 on 08.04.2017.
 */
@Entity
@Table(name = "client_bank2")
public class ClientBank implements Serializable {

    @Id
    @ManyToOne
    private Client client;

    @Id
    @ManyToOne
    private Bank bank;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }
}

