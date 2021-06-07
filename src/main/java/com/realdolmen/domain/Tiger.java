package com.realdolmen.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
public class Tiger implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name; //moet private staan, encapsulation

    @Temporal(TemporalType.DATE)
    private Date birthDate;

    @Enumerated(EnumType.STRING)
    private Behavior behavior;

    @Transient
    private int age;

    @ManyToOne
    private Country country; //ManyToOne relationShip

    @OneToMany(fetch = FetchType.EAGER)
    private List<Food> foods = new ArrayList<>(); //better to initiate it already (create an object), so we don't get any NullPointerException if we try to call it.

    public String getName() { //getter
        return name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Behavior getBehavior() {
        return behavior;
    }

    public void setBehavior(Behavior behavior) {
        this.behavior = behavior;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Food> getFoods() {
        return foods;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public void setFoods(List<Food> foods) {
        this.foods = foods;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Tiger.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("name='" + name + "'")
                .add("birthDate=" + birthDate)
                .add("behavior=" + behavior)
                .add("age=" + age)
                .add("country=" + country)
                .add("foods=" + foods)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tiger tiger = (Tiger) o;
        return age == tiger.age && Objects.equals(id, tiger.id) && Objects.equals(name, tiger.name) && Objects.equals(birthDate, tiger.birthDate) && behavior == tiger.behavior && Objects.equals(country, tiger.country) && Objects.equals(foods, tiger.foods);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, birthDate, behavior, age, country, foods);
    }
}
