package umc.spring.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.spring.apipayload.ApiResponse;
import umc.spring.converter.MemberMissionConverter;
import umc.spring.converter.MissionConverter;
import umc.spring.domain.Mission;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.dto.mission.MissionRequest;
import umc.spring.dto.mission.MissionResponse;
import umc.spring.service.mission.MissionCommandService;
import umc.spring.service.mission.MissionQueryService;
import umc.spring.validation.validator.PageValidator;

@RestController
@RequestMapping("/missions")
@RequiredArgsConstructor
public class MissionController {

    private final MissionCommandService missionCommandService;
    private final MissionQueryService missionQueryService;

    @PostMapping("/stores/{storeId}")
    public ApiResponse<MissionResponse.RegisterMissionResultDto> registerMission(@RequestBody @Valid MissionRequest.RegisterMissionDto registerMissionDto, @PathVariable long storeId) {
        Mission mission = missionCommandService.registerMission(storeId, registerMissionDto);
        return ApiResponse.onSuccess(MissionConverter.toRegisterMissionResultDto(mission));
    }

    @PatchMapping("/{missionId}/challenges/members/{memberId}")
    public ApiResponse<MissionResponse.MissionDto> challengeMission(@PathVariable long missionId, @PathVariable long memberId) {
        MemberMission memberMission = missionCommandService.challengeMission(missionId, memberId);
        return ApiResponse.onSuccess(MemberMissionConverter.toChallengeMissionReulstDto(memberMission));
    }

    @GetMapping("/stores/{storeId}")
    @Operation(summary = "특정 가게의 미션 목록 조회 API", description = "특정 가게의 미션 목록을 조회하는 API이며, query String으로 page 번호를 주세요.")
    @ApiResponses(
            {
                    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공"),
                    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "STORE401", description = "존재하지 않는 가게입니다."),
                    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "PAGE400", description = "잘못된 페이지 요청입니다.")
            }
    )
    @Parameters(
            {
                    @Parameter(name = "storeId", description = "가게의 아이디, path variable 입니다.")
            }
    )
    public ApiResponse<?> getMissionByStore(@PathVariable long storeId, @RequestParam int page) {
        page = PageValidator.adjustPageNumber(page);
        missionQueryService.getMissionListByStore(storeId, page);
        return ApiResponse.onSuccess(MissionConverter.)
    }

}
