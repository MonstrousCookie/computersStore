package com.kolokolnin.computersStore.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

//TODO: @Data можно убрать, это overkill
@Data
@Table(name = "desktop_computer")
@NoArgsConstructor
@Entity
public class DesktopComputers extends ProductProperties {
    @Column(name = "form_factor")
    private FormFactor formFactor;

    //TODO: лучше выпилить то, что не используется
    public enum FormFactor {
        DESKTOP,
        NETTOP,
        MONOBLOCK
    }
}
