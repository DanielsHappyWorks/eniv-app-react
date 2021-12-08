package com.envi.api.enviapi.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="DATA")
public class Data {
    @Id @GeneratedValue private Long id;
    private String name;
    private String description;
    private Long longitude;
    private Double latitude;
    private String author;
    @OneToMany(fetch=FetchType.EAGER, mappedBy = "data")
    private List<Comments> commentsList;
    private Long nextDate;
    private Long lastDate;
}
