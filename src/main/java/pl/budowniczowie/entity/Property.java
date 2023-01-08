package pl.budowniczowie.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "property")
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_property")
    private Integer idProperty;

    @Column(name = "city")
    private String city;

    @Column(name = "room_number")
    private Integer roomNumber;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "id_company")
    private Company company;

    public Property() {
    }

    public Property(String city, Integer roomNumber) {
        this.city = city;
        this.roomNumber = roomNumber;
    }

    public Integer getIdProperty() {
        return idProperty;
    }

    public void setIdProperty(Integer idProperty) {
        this.idProperty = idProperty;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "Property{" +
                "idProperty=" + idProperty +
                ", city='" + city + '\'' +
                ", roomNumber=" + roomNumber +
                '}';
    }
}
