package cn.itcast.crm.service;

import java.util.List;

import cn.itcast.crm.domain.CrmDepartment;

public interface CrmDepartmentService {
    //查询所有部门
    public List<CrmDepartment> findAllDepartment();

    //添加或编辑
    public void saveOrEdit(CrmDepartment crmDepartment);

    // 通过id查询
    public CrmDepartment findById(String depId);
}
