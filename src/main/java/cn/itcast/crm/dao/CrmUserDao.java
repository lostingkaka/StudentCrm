package cn.itcast.crm.dao;

import cn.itcast.crm.domain.CrmUser;

public interface CrmUserDao extends BaseDao<CrmUser> {
    // 通过登录名和密码查询用户
    public CrmUser find(CrmUser crmUser);
}
