package rca.restapi.year2B;

import jakarta.persistence.*;

import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int id;
private String name;
private int price;
}
