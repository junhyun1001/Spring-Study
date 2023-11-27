package umc.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.apipayload.ApiResponse;
import umc.spring.converter.TempConverter;
import umc.spring.dto.TempResponse;

@RestController
@RequestMapping("/temp")
public class TempController {

    @GetMapping("/test")
    public ApiResponse<TempResponse.TempTestDto> testApi() {
        return ApiResponse.onSuccess(TempConverter.toTempTestDto());
    }

}
