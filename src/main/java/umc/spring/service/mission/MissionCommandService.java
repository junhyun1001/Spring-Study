package umc.spring.service.mission;

import umc.spring.domain.Mission;
import umc.spring.dto.mission.MissionRequest;

public interface MissionCommandService {

    Mission registerMission(long storeId, MissionRequest.RegisterMissionDto registerMissionDto);

}
