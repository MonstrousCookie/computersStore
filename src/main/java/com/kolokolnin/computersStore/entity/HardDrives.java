package com.kolokolnin.computersStore.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
//TODO: @Data можно убрать, это overkill
@Data
@Entity
@Table(name = "hard_drive")
public class HardDrives extends ProductProperties {
    @Column(name = "capacity")
    private Long capacity;
}
