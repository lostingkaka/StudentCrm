package cn.itcast.crm.service;

import java.util.List;

import cn.itcast.crm.domain.CrmClass;

public interface CrmClassService {
    // 查询所有
    public List<CrmClass> findAll();
    // 通过id查询
    public CrmClass findById(String classId);
    // 添加或更新
    public void saveOrEdit(CrmClass crmClass);
    // 更新课表
    public void updateSchedule(CrmClass model);
}
