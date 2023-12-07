package umc.spring.dto.mission;

import lombok.Builder;
import lombok.Getter;

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

}
