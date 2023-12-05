package umc.spring.domain;

import jakarta.persistence.*;
import umc.spring.domain.common.BaseEntity;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Region extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 10)
    private String ctpvNm; // 시도명

    @Column(length = 10)
    private String sggNm; // 시군구명

    @Column(length = 10)
    private String emdNm; // 읍면동명

    @OneToMany(mappedBy = "region", cascade = CascadeType.ALL)
    private List<Store> storeList = new ArrayList<>();
}
