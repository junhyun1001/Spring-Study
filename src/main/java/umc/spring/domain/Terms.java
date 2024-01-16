package umc.spring.domain;

import jakarta.persistence.*;
import umc.spring.domain.common.BaseEntity;

@Entity
public class Terms extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20)
    private String title;

    private String body;

    private Boolean optional;

}
