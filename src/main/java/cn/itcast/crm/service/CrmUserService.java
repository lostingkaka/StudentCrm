package cn.itcast.crm.service;

import cn.itcast.crm.domain.CrmUser;

public interface CrmUserService {
    //登录
    CrmUser login(CrmUser crmUser);
}
