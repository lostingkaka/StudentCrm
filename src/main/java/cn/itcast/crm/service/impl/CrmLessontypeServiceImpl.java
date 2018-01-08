package cn.itcast.crm.service.impl;

import java.util.List;

import cn.itcast.crm.dao.CrmLessontypeDao;
import cn.itcast.crm.domain.CrmLessontype;
import cn.itcast.crm.service.CrmLessontypeService;

public class CrmLessontypeServiceImpl implements CrmLessontypeService {

    private CrmLessontypeDao crmLessontypeDao;

    public void setCrmLessontypeDao(CrmLessontypeDao crmLessontypeDao) {
        this.crmLessontypeDao = crmLessontypeDao;
    }

    public List<CrmLessontype> findAll() {
        return crmLessontypeDao.findAll();
    }

    public CrmLessontype findById(String lessonTypeId) {

        return crmLessontypeDao.findById(lessonTypeId);
    }

    public void addOrEditLessontype(CrmLessontype model) {
        this.crmLessontypeDao.saveOrUpdate(model);
    }

}
