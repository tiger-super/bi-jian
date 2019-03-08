package com.manage.dao;


import org.springframework.stereotype.Repository;

import com.house.entity.AuditingFail;


@Repository
public interface AuditingManageDao {
	// 插入某个房源失败原因
	int insertAuditingReasonFromHouseId(AuditingFail auditingFail);
}
