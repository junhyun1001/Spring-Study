package umc.spring.service.mission;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.apipayload.code.status.ErrorStatus;
import umc.spring.converter.MissionConverter;
import umc.spring.domain.Mission;
import umc.spring.domain.Store;
import umc.spring.dto.mission.MissionRequest;
import umc.spring.exception.handler.StoreHandler;
import umc.spring.repository.MissionRepository;
import umc.spring.repository.StoreRepository;

@Service
@RequiredArgsConstructor
public class MissionCommandServiceImpl implements MissionCommandService {

    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository;

    @Override
    public Mission registerMission(long storeId, MissionRequest.RegisterMissionDto registerMissionDto) {

        Mission mission = MissionConverter.toMission(registerMissionDto);

        Store store = storeRepository.findById(storeId).orElseThrow(() -> new StoreHandler(ErrorStatus.STORE_NOT_FOUND));

        mission.setStore(store);

        return missionRepository.save(mission);

    }

}
