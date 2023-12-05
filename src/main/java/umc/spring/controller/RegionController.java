package umc.spring.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.apipayload.ApiResponse;
import umc.spring.converter.StoreConverter;
import umc.spring.domain.Store;
import umc.spring.dto.store.StoreRequest;
import umc.spring.dto.store.StoreResponse;
import umc.spring.service.store.StoreCommandService;

@RestController
@RequestMapping("/stores")
@RequiredArgsConstructor
public class RegionController {

    private final StoreCommandService storeCommandService;

    @PostMapping
    public ApiResponse<StoreResponse.RegisterResultDto> registerStore(@RequestBody StoreRequest.RegisterDto registerDto) {
        Store store = storeCommandService.registerStore(registerDto);
        return ApiResponse.onSuccess(StoreConverter.toRegisterResultDto(store));
    }

}
