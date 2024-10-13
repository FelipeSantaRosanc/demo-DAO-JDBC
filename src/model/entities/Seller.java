package model.entities;

import java.io.Serializable;
import java.util.Date;


public class Seller implements Serializable {

    private int id;
    private String name;
    private String email;
    private Date birthday;
    private Double baseSalary;


    private Department department;


    public Seller() {

    }

    public Seller(int id, String name, String email, Date birthday, Double baseSalary, Department department) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.birthday = birthday;
        this.baseSalary = baseSalary;
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(Double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seller seller = (Seller) o;
        return id == seller.id;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    @Override
    public String toString() {
        return "Seller{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", birthday=" + birthday +
                ", baseSalary=" + baseSalary +
                ", department=" + department +
                '}';
    }
}
