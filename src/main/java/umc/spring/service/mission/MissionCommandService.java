package umc.spring.service.mission;

import umc.spring.domain.Mission;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.dto.mission.MissionRequest;

public interface MissionCommandService {

    Mission registerMission(long storeId, MissionRequest.RegisterMissionDto registerMissionDto);

    MemberMission challengeMission(long missionId, long memberId);

    MemberMission completeMission(long missionId, long memberId);
}
