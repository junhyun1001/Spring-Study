package umc.spring.service.mission;

import org.springframework.data.domain.Page;
import umc.spring.domain.Mission;

public interface MissionQueryService {

    Page<Mission> getMissionListByStore(long storeId, int page);

}
