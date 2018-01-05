package cn.itcast.crm.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.crm.domain.CrmUser;
import cn.itcast.crm.service.CrmUserService;

/**
 * 用户（员工）Action
 */
public class UserAction extends ActionSupport implements ModelDriven<CrmUser> {
    private static final long serialVersionUID = 1900957086513597761L;
    //封装数据
    private CrmUser crmUser = new CrmUser();

    public CrmUser getModel() {
        return crmUser;
    }

    //需要spring注入 service
    private CrmUserService crmUserService;

    public void setCrmUserService(CrmUserService crmUserService) {
        this.crmUserService = crmUserService;
    }

    /**
     * 登录
     */
    public String login() {
        //查询--校验账号与密码是否匹配，如果匹配存放session，如果不匹配，返回登录页提示
        CrmUser loginCrmUser = crmUserService.login(crmUser);
        if (loginCrmUser != null) {
            //登录成功
            ActionContext.getContext().getSession().put("CrmUser", loginCrmUser);
            return "login";
        }
        //没有成功
        this.addFieldError("logonName", "用户名或密码错误");
        return "input";
    }

    /**
     * 必须validate开头，后面跟着方法名，对特定的方法进行校验。
     */
    public void validateLogin() {
        //查询--校验账号与密码是否匹配，如果匹配存放session，如果不匹配，返回登录页提示
        CrmUser loginCrmUser = crmUserService.login(crmUser);
        if (loginCrmUser != null) {
            //登录成功
            ActionContext.getContext().getSession()
                    .put("CrmUser", loginCrmUser);
            return;
        }
        //没有成功
        this.addFieldError("logonName", "用户名或密码错误");
    }

    /**
     * 注销重新登陆
     */
    public String logout(){
        ActionContext.getContext().getSession().remove("loginCrmUser");
        return "login";
    }

    public CrmUser getCrmUser() {
        return crmUser;
    }

    public void setCrmUser(CrmUser crmUser) {
        this.crmUser = crmUser;
    }
}
