package cn.itcast.crm.service.impl;

import java.util.List;

import cn.itcast.crm.dao.CrmDepartmentDao;
import cn.itcast.crm.domain.CrmDepartment;
import cn.itcast.crm.service.CrmDepartmentService;

public class CrmDepartmentServiceImpl implements CrmDepartmentService {
    //定义crmDepartmentDao属性和其setter方法
    private CrmDepartmentDao crmDepartmentDao;

    public void setCrmDepartmentDao(CrmDepartmentDao
                                            crmDepartmentDao) {
        this.crmDepartmentDao = crmDepartmentDao;
    }

    //查询所有部门
    public List<CrmDepartment> findAllDepartment() {
        return this.crmDepartmentDao.findAll();
    }

    //保存或编辑
    public void saveOrEdit(CrmDepartment crmDepartment) {
        this.crmDepartmentDao.saveOrUpdate(crmDepartment);
    }

    //通过id查询部门
    public CrmDepartment findById(String depId) {
        return this.crmDepartmentDao.findById(depId);
    }
}
