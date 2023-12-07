package umc.spring.service.mission;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.apipayload.code.status.ErrorStatus;
import umc.spring.converter.MemberMissionConverter;
import umc.spring.converter.MissionConverter;
import umc.spring.domain.Mission;
import umc.spring.domain.Store;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.dto.mission.MissionRequest;
import umc.spring.exception.handler.MemberMissionHandler;
import umc.spring.exception.handler.StoreHandler;
import umc.spring.repository.MemberMissionRepository;
import umc.spring.repository.MemberRepository;
import umc.spring.repository.MissionRepository;
import umc.spring.repository.StoreRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MissionCommandServiceImpl implements MissionCommandService {

    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository;
    private final MemberRepository memberRepository;
    private final MemberMissionRepository memberMissionRepository;

    @Override
    public Mission registerMission(long storeId, MissionRequest.RegisterMissionDto registerMissionDto) {

        Mission mission = MissionConverter.toMission(registerMissionDto);

        Store store = storeRepository.findById(storeId).orElseThrow(() -> new StoreHandler(ErrorStatus.STORE_NOT_FOUND));

        mission.setStore(store);

        // 미션을 모든 회원에게 추가하기
        List<MemberMission> memberMissionList = MemberMissionConverter.toMemberMissionList(memberRepository.findAll(), mission);

        memberMissionRepository.saveAll(memberMissionList);

        return missionRepository.save(mission);

    }

    @Override
    public MemberMission challengeMission(long missionId, long memberId) {

        MemberMission memberMission = memberMissionRepository.findByMissionIdAndMemberId(missionId, memberId).orElseThrow(() -> new MemberMissionHandler(ErrorStatus.MEMBER_MISSION_NOT_FOUND));

        if (memberMission.getMissionStatus() == MissionStatus.INPROGRESS) {
            throw new MemberMissionHandler(ErrorStatus.MEMBER_MISSION_ALREADY_INPROGRESS);
        }
        memberMission.setMissionStatus();

        return memberMissionRepository.save(memberMission);

    }

}
