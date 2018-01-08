package cn.itcast.crm.service;

import java.util.List;

import cn.itcast.crm.domain.CrmLessontype;

public interface CrmLessontypeService {

    List<CrmLessontype> findAll();

    CrmLessontype findById(String lessonTypeId);

    void addOrEditLessontype(CrmLessontype model);

}
