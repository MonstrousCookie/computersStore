package com.kolokolnin.computersStore.entity;

import jakarta.persistence.*;
import lombok.*;
@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
//TODO: @Data можно убрать, это overkill
@Data
//TODO: может назвать просто Product ?
public class ProductProperties {
    //TODO: я бы лучше использовал UUID в качестве ID продукта
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "serial_number")
    private Long serialNumber;
    @Column(name = "manufacturer")
    private String manufacturer;
    @Column(name = "price")
    private Long price;
    @Column(name = "units_in_stock")
    private Long unitsInStock;
}
