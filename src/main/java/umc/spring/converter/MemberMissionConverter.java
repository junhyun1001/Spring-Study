package umc.spring.converter;

import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.Store;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.dto.mission.MissionResponse;

import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class MemberMissionConverter {

    public static List<MemberMission> toMemberMissionList(List<Member> memberList, Mission mission) {

        return memberList.stream()
                .map(member -> MemberMission.builder().member(member).mission(mission).build())
                .collect(Collectors.toList());

    }

    public static MissionResponse.MyMissionDto toChallengeMissionReulstDto(MemberMission memberMission) {

        Mission mission = memberMission.getMission();
        Store store = mission.getStore();

        long remainingDay = ChronoUnit.DAYS.between(mission.getCreatedAt(), mission.getDeadline());

        return MissionResponse.MyMissionDto.builder()
                .missionId(mission.getId())
                .storeName(store.getName())
                .missionSpec(mission.getMissionSpec())
                .reward(mission.getReward())
                .remainingDay(remainingDay)
                .missionStatus(memberMission.getMissionStatus())
                .build();

    }

    public static MissionResponse.CompleteMissionDto toCompleteMissionResultDto(MemberMission memberMission) {

        Mission mission = memberMission.getMission();
        Store store = mission.getStore();

        long uuidNumber = ThreadLocalRandom.current().nextLong(0, Long.MAX_VALUE);

        return MissionResponse.CompleteMissionDto.builder()
                .missionId(mission.getId())
                .storeName(store.getName())
                .reward(mission.getReward())
                .uuidNumber(uuidNumber)
                .build();

    }

}
