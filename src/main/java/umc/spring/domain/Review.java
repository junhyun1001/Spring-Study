package umc.spring.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.spring.domain.common.BaseEntity;

import java.util.List;

@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
public class Review extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String body;

    @Column(scale = 1)
    private Float score;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;

    @OneToMany(mappedBy = "review", cascade = CascadeType.ALL)
    private List<ReviewImage> reviewImageList;

    public void setMember(Member member) {
        if (this.member != null) {
            member.getReviewList().remove(this);
        }
        this.member = member;
        member.getReviewList().add(this);
    }

    public void setStore(Store store) {
        if (this.store != null) {
            store.getReviewList().remove(this);
        }
        this.store = store;
        store.getReviewList().add(this);
    }

}
