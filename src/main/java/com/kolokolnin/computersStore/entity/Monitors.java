package com.kolokolnin.computersStore.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
//TODO: @Data можно убрать, это overkill
@Data
@Table(name = "monitor")
public class Monitors extends ProductProperties {
    @Column(name = "diagonal")
    private Long diagonal;
}
