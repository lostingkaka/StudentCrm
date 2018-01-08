package cn.itcast.crm.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.crm.domain.CrmDepartment;
import cn.itcast.crm.service.CrmDepartmentService;

/**
 * 部门Action
 */
public class DepartmentAction extends ActionSupport implements
        ModelDriven<CrmDepartment> {
    private static final long serialVersionUID = 6202379891993594521L;
    //定义departmentService属性及其setter方法，用于Spring注入
    private CrmDepartmentService crmDepartmentService;

    public void setCrmDepartmentService(
            CrmDepartmentService crmDepartmentService) {
        this.crmDepartmentService = crmDepartmentService;
    }

    // 使用模型驱动，封装数据
    private CrmDepartment crmDepartment = new CrmDepartment();

    public CrmDepartment getModel() {
        return crmDepartment;
    }

    //查询所有
    public String findAll() {
        List<CrmDepartment> allDepartment = crmDepartmentService
                .findAllDepartment();
        //  添加request （root） , 将通过 key获得
        ActionContext.getContext().getValueStack()
                .set("allDepartment", allDepartment);
        return "findAll";
    }

    //跳转到编辑或添加页
    public String preAddOrEdit() {
        if (this.getModel().getDepId() != null) {
            CrmDepartment Department = this.crmDepartmentService
                    .findById(this.getModel().getDepId());
            ActionContext.getContext().getValueStack().push(Department);
        }
        return "preAddOrEdit";
    }

    //添加或编辑后返回列表页
    public String addOrEdit() {
        this.crmDepartmentService.saveOrEdit(this.getModel());
        return "addOrEdit";
    }
}
