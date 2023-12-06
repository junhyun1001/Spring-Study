package umc.spring.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.spring.apipayload.ApiResponse;
import umc.spring.converter.MissionConverter;
import umc.spring.domain.Mission;
import umc.spring.dto.mission.MissionRequest;
import umc.spring.dto.mission.MissionResponse;
import umc.spring.service.mission.MissionCommandService;

@RestController
@RequestMapping("/missions")
@RequiredArgsConstructor
public class MissionController {

    private final MissionCommandService missionCommandService;

    @PostMapping("/stores/{storeId}")
    public ApiResponse<MissionResponse.RegisterMissionResultDto> registerMission(@RequestBody @Valid MissionRequest.RegisterMissionDto registerMissionDto, @PathVariable long storeId) {
        Mission mission = missionCommandService.registerMission(storeId, registerMissionDto);
        return ApiResponse.onSuccess(MissionConverter.toRegisterMissionResultDto(mission));
    }

}
