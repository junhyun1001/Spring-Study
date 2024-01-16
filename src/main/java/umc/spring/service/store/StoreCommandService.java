package umc.spring.service.store;

import umc.spring.domain.Store;
import umc.spring.dto.store.StoreRequest;

public interface StoreCommandService {

    Store registerStore(StoreRequest.RegisterDto registerDto);

}
