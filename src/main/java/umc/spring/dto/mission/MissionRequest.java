package umc.spring.dto.mission;

import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public class MissionRequest {

    @Getter
    public static class RegisterMissionDto {

        private int reward; // 미션 수행시 받을 수 있는 포인트

        @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
        private LocalDateTime deadline; // 미션 마감기한

        private String missionSpec; // 미션 내용

    }

}
