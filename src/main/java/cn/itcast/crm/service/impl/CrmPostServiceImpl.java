package cn.itcast.crm.service.impl;
import java.util.List;

import cn.itcast.crm.dao.CrmPostDao;
import cn.itcast.crm.domain.CrmPost;
import cn.itcast.crm.service.CrmPostService;

public class CrmPostServiceImpl implements CrmPostService {
    //定义PostDao属性和其setter方法
    private CrmPostDao crmPostDao;
    public void setCrmPostDao(CrmPostDao crmPostDao) {
        this.crmPostDao = crmPostDao;
    }
    // 通过部门id查询所有职务
    public List<CrmPost> findAll(String depId) {
        return crmPostDao.findAll(depId);
    }
    // 查询所有职务
    public List<CrmPost> findAll() {
        return crmPostDao.findAll();
    }
    // 通过id查询职务
    public CrmPost findById(String postId) {
        return crmPostDao.findById(postId);
    }
    //添加或修改职务
    public void saveOrEdit(CrmPost crmPost) {
        crmPostDao.saveOrUpdate(crmPost);
    }
}
