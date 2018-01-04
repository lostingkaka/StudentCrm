package cn.itcast.crm.service.impl;

import cn.itcast.crm.dao.CrmUserDao;
import cn.itcast.crm.domain.CrmUser;
import cn.itcast.crm.service.CrmUserService;
import cn.itcast.crm.util.StringUtils;

public class CrmUserServiceImpl implements CrmUserService {
    //定义crmUserDao属性及其setter方法
    private CrmUserDao crmUserDao;

    public void setCrmUserDao(CrmUserDao crmUserDao) {
        this.crmUserDao = crmUserDao;
    }

    /**
     * 用户登录
     */
    public CrmUser login(CrmUser crmUser) {
        //密码需要加密
        String logonPwd = StringUtils.getMD5Value(crmUser.getLogonPwd());
        crmUser.setLogonPwd(logonPwd);
        return this.crmUserDao.find(crmUser);
    }
}
