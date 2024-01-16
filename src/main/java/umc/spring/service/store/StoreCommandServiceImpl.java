package umc.spring.service.store;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.apipayload.code.status.ErrorStatus;
import umc.spring.converter.StoreConverter;
import umc.spring.domain.Region;
import umc.spring.domain.Store;
import umc.spring.dto.store.StoreRequest;
import umc.spring.exception.handler.RegionHandler;
import umc.spring.repository.RegionRepository;
import umc.spring.repository.StoreRepository;

@Service
@RequiredArgsConstructor
public class StoreCommandServiceImpl implements StoreCommandService {

    private final StoreRepository storeRepository;
    private final RegionRepository regionRepository;

    @Override
    public Store registerStore(StoreRequest.RegisterDto registerDto) {

        // 1. Store 객체 생성
        Store store = StoreConverter.toStore(registerDto);

        // 2. 지역 찾기
        String ctpv = registerDto.getCtpvNm();
        String sgg = registerDto.getSggNm();
        String emd = registerDto.getEmdNm();

        Region region = regionRepository.findByAddress(ctpv, sgg, emd).orElseThrow(() -> new RegionHandler(ErrorStatus.REGION_NOT_FOUND));

        // 3. 연관관계 설정
        store.setRegion(region);

        // 4. 영속화
        storeRepository.save(store);

        return store;
    }

}
