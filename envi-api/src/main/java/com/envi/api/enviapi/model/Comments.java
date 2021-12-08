package com.envi.api.enviapi.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Comments {
    @Id @GeneratedValue private Long id;
    private String name;
    private String comment;
}
