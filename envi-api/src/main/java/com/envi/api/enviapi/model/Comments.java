package com.envi.api.enviapi.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="COMMENTS")
public class Comments {
    @Id @GeneratedValue private Long id;
    private String name;
    private String comment;
    @ManyToOne
    @JoinColumn(name="cart_id", nullable=false)
    private Data cart;
}
