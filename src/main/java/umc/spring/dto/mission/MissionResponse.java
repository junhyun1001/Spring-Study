package umc.spring.dto.mission;

import lombok.Builder;
import lombok.Getter;
import umc.spring.domain.enums.MissionStatus;

public class MissionResponse {

    @Builder
    @Getter
    public static class RegisterMissionResultDto {

        private long missionId;

        private String storeName; // 식당 이름

//        private String foodCategory; // 카테고리 이름

        private String missionSpec; // 미션 내용

        private int reward; // 적립금

        private long remainingDay; // 미션 남은 기간

    }

    @Builder
    @Getter
    public static class MissionDto {

        private long missionId;

        private String storeName;

//        private String foodCategory;

        private String missionSpec;

        private int reward;

        private long remainingDay; // 미션 남은 기간

        private MissionStatus missionStatus; // 미션 상태

    }

}
