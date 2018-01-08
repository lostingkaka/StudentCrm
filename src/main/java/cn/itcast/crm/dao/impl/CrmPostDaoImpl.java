package cn.itcast.crm.dao.impl;

import java.util.List;
import cn.itcast.crm.dao.CrmPostDao;
import cn.itcast.crm.domain.CrmPost;

//职务DAO接口实现类
public class CrmPostDaoImpl extends BaseDaoImpl<CrmPost>
        implements CrmPostDao {
    //通过部门id查询所有职务
    public List<CrmPost> findAll(String depId) {
        String hql = "from CrmPost p where p.crmDepartment.depId = ?";
        return (List<CrmPost>) this.getHibernateTemplate().find(hql, depId);
    }
}
