package umc.spring.service.mission;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import umc.spring.apipayload.code.status.ErrorStatus;
import umc.spring.domain.Mission;
import umc.spring.domain.Store;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.exception.handler.MemberHandler;
import umc.spring.exception.handler.StoreHandler;
import umc.spring.repository.MemberMissionRepository;
import umc.spring.repository.MissionRepository;
import umc.spring.repository.StoreRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MissionQueryServiceImpl implements MissionQueryService {

    private final StoreRepository storeRepository;
    private final MissionRepository missionRepository;
    private final MemberMissionRepository memberMissionRepository;

    @Override
    public Page<Mission> getMissionListByStore(long storeId, int page) {

        Store store = storeRepository.findById(storeId).orElseThrow(() -> new StoreHandler(ErrorStatus.STORE_NOT_FOUND));

        return missionRepository.findAllByStore(store, PageRequest.of(page, 10));

    }

    @Override
    public Page<Mission> getMyMissionInprogress(long memberId, int page) {

        List<MemberMission> memberMissionList = memberMissionRepository.findAllByMemberIdAndMissionStatus(memberId, MissionStatus.INPROGRESS).orElseThrow(() -> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));

        List<Long> missionIdList = memberMissionList.stream()
                .map(memberMission -> memberMission.getMission().getId())
                .toList();

        return missionRepository.findAllByIdIn(missionIdList, PageRequest.of(page, 10));

    }
}