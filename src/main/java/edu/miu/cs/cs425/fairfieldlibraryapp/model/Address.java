package edu.miu.cs.cs425.fairfieldlibraryapp.model;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
//@Data
@Entity
@Table(name = "addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer addressId;
    private String houseNo;
    private String street;
    private String city;
    private String state;
    private String zipCode;
    @OneToOne(mappedBy = "primaryAddress")
    private Publisher publisher;

    @Override
    public String toString() {
        return String.format("Address{addressId: %s, houseNo: %s, street: %s}", addressId, houseNo, street);
    }
}
