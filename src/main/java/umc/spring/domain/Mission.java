package umc.spring.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import umc.spring.domain.common.BaseEntity;

import java.time.LocalDateTime;

@Entity
public class Mission extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int reward;

    private LocalDateTime deadline;

    private String missionSpec;

}
