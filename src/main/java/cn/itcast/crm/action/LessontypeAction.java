package cn.itcast.crm.action;

import java.util.List;

import cn.itcast.crm.domain.CrmLessontype;
import cn.itcast.crm.service.CrmLessontypeService;

public class LessontypeAction {

    private CrmLessontype crmLessontype = new CrmLessontype();

    public CrmLessontype getModel() {
        return this.crmLessontype;
    }

    //2 service
    private CrmLessontypeService crmLessontypeService;

    public void setCrmLessontypeService(CrmLessontypeService crmLessontypeService) {
        this.crmLessontypeService = crmLessontypeService;
    }

    /**
     * 查询所有--分页
     *
     * @return
     */
    public List<CrmLessontype> findAll() {

        return this.crmLessontypeService.findAll();

    }

    //打开添加或修改页面
    public CrmLessontype addOrEditUI() {

        return this.crmLessontypeService.findById(this.getModel().getLessonTypeId());

    }

    public String addOrEdit() {
        this.crmLessontypeService.addOrEditLessontype(this.getModel());
        return "addOrEdit";
    }

}
