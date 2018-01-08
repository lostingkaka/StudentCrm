package cn.itcast.crm.service.impl;

import java.util.Date;
import java.util.List;

import cn.itcast.crm.dao.CrmClassDao;
import cn.itcast.crm.domain.CrmClass;
import cn.itcast.crm.service.CrmClassService;

public class CrmClassServiceImpl implements CrmClassService {
    // 定义crmClassDao属性及其setter方法
    private CrmClassDao crmClassDao;

    public void setCrmClassDao(CrmClassDao crmClassDao) {
        this.crmClassDao = crmClassDao;
    }

    // 查询所有
    public List<CrmClass> findAll() {
        return crmClassDao.findAll();
    }

    // 通过id查询
    public CrmClass findById(String classId) {
        return this.crmClassDao.findById(classId);
    }
    // 添加或更新
    public void saveOrEdit(CrmClass crmClass) {
        this.crmClassDao.saveOrUpdate(crmClass);
    }
    // 更新课表
    public void updateSchedule(CrmClass crmClass) {
        //获取班级
        CrmClass findClass = this.crmClassDao.findById(crmClass.getClassId());
        findClass.setUploadFilename(crmClass.getUploadFilename());
        findClass.setUploadPath(crmClass.getUploadPath());
        findClass.setUploadTime(new Date());
    }
}
