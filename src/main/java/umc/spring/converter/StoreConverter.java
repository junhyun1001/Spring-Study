package umc.spring.converter;

import umc.spring.domain.Store;
import umc.spring.dto.store.StoreRequest;
import umc.spring.dto.store.StoreResponse;

import java.util.ArrayList;

public class StoreConverter {

    public static Store toStore(StoreRequest.RegisterDto registerDto) {

        StringBuilder sb = new StringBuilder();

        String ctpvNm = registerDto.getCtpvNm(); // 서울특별시
        String sggNm = registerDto.getSggNm(); // 종로구
        String emdNm = registerDto.getEmdNm(); // 청운동
        String address = registerDto.getAddress(); // 지하문로28가길

        String fullAddress = String.valueOf(sb.append(ctpvNm).append(" ").append(sggNm).append(" ").append(emdNm).append(" ").append(address));

        return Store.builder()
                .name(registerDto.getName())
                .address(fullAddress)
                .missionList(new ArrayList<>())
                .build();
    }

    public static StoreResponse.RegisterResultDto toRegisterResultDto(Store store) {
        return StoreResponse.RegisterResultDto.builder()
                .fullAddress(store.getAddress())
                .build();
    }


}
