package cn.itcast.crm.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.crm.domain.CrmDepartment;
import cn.itcast.crm.domain.CrmPost;
import cn.itcast.crm.service.CrmDepartmentService;
import cn.itcast.crm.service.CrmPostService;

/**
 * 职务Action
 */
public class PostAction extends ActionSupport
        implements ModelDriven<CrmPost> {
    private static final long serialVersionUID = -6311975880317481539L;
    //实现模型驱动方法
    private CrmPost crmPost = new CrmPost();

    public CrmPost getModel() {
        return crmPost;
    }

    // 定义crmPostService属性及其setter方法
    private CrmPostService crmPostService;

    public void setCrmPostService(CrmPostService crmPostService) {
        this.crmPostService = crmPostService;
    }

    // 定义crmDepartmentService属性及其getter和setter方法
    private CrmDepartmentService crmDepartmentService;

    public CrmDepartmentService getCrmDepartmentService() {
        return crmDepartmentService;
    }

    public void setCrmDepartmentService(CrmDepartmentService
                                                crmDepartmentService) {
        this.crmDepartmentService = crmDepartmentService;
    }

    //查询所有
    public String findAll() {
        List<CrmPost> allPost = crmPostService.findAll();
        ActionContext.getContext().getValueStack().set("allPost", allPost);
        return "findAll";
    }

    // 点击添加或编辑，进入添加或编辑页面
    public String preAddOrEdit() {
        //1 查询当前职务（编辑）
        if (this.getModel().getPostId() != null) {
            CrmPost findPost = this.crmPostService
                    .findById(this.getModel().getPostId());
            ActionContext.getContext().getValueStack().push(findPost);
        }
        // 2 查询所有部门
        List<CrmDepartment> allDepartment = this.getCrmDepartmentService()
                .findAllDepartment();
        // jsp 通过 "#key" 获得数据
        ActionContext.getContext().put("allDepartment", allDepartment);
        return "preAddOrEdit";
    }

    // 添加或编辑后保持数据
    public String addOrEdit() {
        this.crmPostService.saveOrEdit(this.getModel());
        return "addOrEdit";
    }

    /**
     * 通过部门id，使用ajax查询职务
     */
    public String ajaxGetPostion(){
        //获得部门id
        String depId = this.getModel().getCrmDepartment().getDepId();
        //通过部门id，查询所有职务
        List<CrmPost> allPost = this.crmPostService.findAll(depId);
        //将查询结果存放值栈中 , jsp 通过“key”获得
        ActionContext.getContext().getValueStack().set("allPost", allPost);
        return "ajaxGetPostion";
    }

}
