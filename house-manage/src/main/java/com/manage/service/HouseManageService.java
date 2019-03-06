package com.manage.service;
import java.util.Map;

import com.house.entity.Page;

public interface HouseManageService {
    Map<String,Object> getAuditingHouse(Page page);
}
