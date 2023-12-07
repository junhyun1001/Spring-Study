package umc.spring.converter;

import umc.spring.domain.Mission;
import umc.spring.dto.mission.MissionRequest;
import umc.spring.dto.mission.MissionResponse;

import java.time.temporal.ChronoUnit;

public class MissionConverter {

    public static Mission toMission(MissionRequest.RegisterMissionDto registerMissionDto) {
        return Mission.builder()
                .reward(registerMissionDto.getReward())
                .deadline(registerMissionDto.getDeadline())
                .missionSpec(registerMissionDto.getMissionSpec())
                .build();
    }

    public static MissionResponse.RegisterMissionResultDto toRegisterMissionResultDto(Mission mission) {

        long remainingDay = ChronoUnit.DAYS.between(mission.getCreatedAt(), mission.getDeadline());

        return MissionResponse.RegisterMissionResultDto.builder()
                .missionId(mission.getId())
                .storeName(mission.getStore().getName())
                .reward(mission.getReward())
                .remainingDay(remainingDay)
                .missionSpec(mission.getMissionSpec())
                .build();
    }
}
