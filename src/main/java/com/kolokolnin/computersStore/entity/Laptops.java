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
@Table(name = "laptop")
public class Laptops extends ProductProperties{
    @Column(name = "screen_inch")
    private ScreenInch screenInch;

    //TODO: лучше выпилить то, что не используется
    public enum ScreenInch {
        INCH_13,
        INCH_14,
        INCH_15,
        INCH_17,
    }

}
