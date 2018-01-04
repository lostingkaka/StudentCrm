package cn.itcast.crm.dao.impl;

import java.util.List;

import cn.itcast.crm.dao.CrmUserDao;
import cn.itcast.crm.domain.CrmUser;

public class CrmUserDaoImpl extends BaseDaoImpl<CrmUser> implements CrmUserDao {
    // 登录时查询用户
    public CrmUser find(CrmUser crmUser) {
        //定义HQL
        String hql = new String("from CrmUser where logonName = ? and logonPwd = ?");
        //将传递的参数放入params数组中
        Object[] params = {crmUser.getLogonName(), crmUser.getLogonPwd()};
        //查询数据
        List<CrmUser> allUser = (List<CrmUser>) this.getHibernateTemplate().find(hql, params);
        //返回结果
        return allUser.size() == 0 ? null : allUser.get(0);
    }
}
