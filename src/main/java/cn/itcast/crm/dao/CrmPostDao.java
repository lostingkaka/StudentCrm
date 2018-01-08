package cn.itcast.crm.dao;

import java.util.List;

import cn.itcast.crm.dao.BaseDao;
import cn.itcast.crm.domain.CrmPost;

/**
 * 职务DAO接口
 */
public interface CrmPostDao extends BaseDao<CrmPost> {
    //通过部门id查询职务
    List<CrmPost> findAll(String depId);
}
