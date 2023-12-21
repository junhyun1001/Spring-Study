package umc.spring.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.Mission;
import umc.spring.domain.Store;
import umc.spring.domain.mapping.MemberMission;

import java.util.List;

public interface MissionRepository extends JpaRepository<Mission, Long> {

    Page<Mission> findAllByStore(Store store, Pageable pageable);

//    Page<Mission> findAllByIdIn(List<Long> missionIdList, Pageable pageable);

    Page<Mission> findAllByMemberMissionListIn(List<MemberMission> memberMissionList, Pageable pageable);

}
