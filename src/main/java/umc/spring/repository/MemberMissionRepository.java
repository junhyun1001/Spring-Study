package umc.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.MemberMission;

import java.util.List;
import java.util.Optional;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {

    Optional<MemberMission> findByMissionIdAndMemberId(long missionId, long memberId);

    Optional<List<MemberMission>> findAllByMemberIdAndMissionStatus(long memberId, MissionStatus missionStatus);

}
