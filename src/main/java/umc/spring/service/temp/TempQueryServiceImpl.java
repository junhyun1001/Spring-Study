package umc.spring.service.temp;

import org.springframework.stereotype.Service;
import umc.spring.apipayload.code.status.ErrorStatus;
import umc.spring.exception.temp.TempHandler;

@Service
public class TempQueryServiceImpl implements TempQueryService {

    @Override
    public void checkFlag(int flag) {
        if (flag == 2) {
            throw new TempHandler(ErrorStatus.TEMP_EXCEPTION);
        }
    }
}
