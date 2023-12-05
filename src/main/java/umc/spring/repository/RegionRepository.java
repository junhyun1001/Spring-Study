package umc.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import umc.spring.domain.Region;

import java.util.Optional;

public interface RegionRepository extends JpaRepository<Region, Long> {

    // JPA Query Method
//    Optional<Region> findByCtpvNmAndSggNmAndEmdNm(String ctpvNm, String sggNm, String emdNm);

    // JPQL Query
    @Query("SELECT r FROM Region r WHERE r.ctpvNm = :ctpv_nm AND r.sggNm = :sgg_nm AND r.emdNm = :emd_nm")
    Optional<Region> findByAddress(
            @Param("ctpv_nm") String ctpvNm,
            @Param("sgg_nm") String sggNm,
            @Param("emd_nm") String emdNm
    );

}
