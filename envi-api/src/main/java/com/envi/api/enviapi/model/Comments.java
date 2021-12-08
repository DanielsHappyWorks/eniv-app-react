package com.envi.api.enviapi.model;

import lombok.*;

import javax.persistence.*;

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
    @ManyToOne
    @JoinColumn(name="data_id", nullable=false)
    private Data data;
}
