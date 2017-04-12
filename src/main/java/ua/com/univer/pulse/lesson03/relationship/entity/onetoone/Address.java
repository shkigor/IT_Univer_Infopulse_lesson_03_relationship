package ua.com.univer.pulse.lesson03.relationship.entity.onetoone;

import javax.persistence.*;

/**
 * Created by IT-UNIVER3 on 08.04.2017.
 */
@Entity
@Table(name = "address")
@SequenceGenerator(name = "generator1", initialValue = 30, allocationSize = 100)
public class Address {

    @Id
    @GeneratedValue(generator = "generator1", strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "city")
    private String city;

    /**
     * CascadeType.ALL
     * Если удалить в таблице address город Киев, то из таблицы нужно удалить все записи, которые ссылаются на Киев
     *
     * orphanRemoval - удалить сироту, т.е. удаляются записи в таблице myusers
     * orphanRemoval = false - запишет в таблицу myusers NULL в поле address_id (foreign key), а не удалит эту запись
     *
     * FetchType.LAZY - ленивая инициализация
     * только после вызова метода getUser() достанется User, т.е.
     * User инициализируется по запросу.
     *
     * FetchType.EAGER - сразу подтягивается User
     *
     * mappedBy - это имя поля в классе User
     * если не написать, то создадутся поля с именами address_id и user_id в двух таблицах,
     * а не только address_id в таблице myusers
     * тем самым обеспечивается двухсторонняя связь. В этом случае поиск будет работать быстрее
     *
     */
    //@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY, mappedBy = "address")
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
