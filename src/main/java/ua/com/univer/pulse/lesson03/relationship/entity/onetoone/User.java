package ua.com.univer.pulse.lesson03.relationship.entity.onetoone;

import javax.persistence.*;

/**
 * Created by IT-UNIVER3 on 08.04.2017.
 */
@Entity // Можно и здесь указать имя таблицы, к которой мы привязываем сущность
@Table(name = "myusers")
@SequenceGenerator(name = "generator1",initialValue = 30,allocationSize = 100)
public class User {
    @Id
    @GeneratedValue(generator = "generator1", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "firstname")
    private String name;

    @Column(name = "lastname")
    private String lastName;

    @OneToOne(fetch = FetchType.LAZY)
    /**
     * @JoinColumn - Создай колонку с именем address_id, которая обеспечивает связь в таблице myusers
     */
    @JoinColumn(name = "address_id")
    private Address address;

    public User() {
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}

