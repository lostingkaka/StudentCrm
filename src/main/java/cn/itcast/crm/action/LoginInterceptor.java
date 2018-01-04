package cn.itcast.crm.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.Interceptor;

import cn.itcast.crm.domain.CrmUser;

//登录拦截器action
public class LoginInterceptor implements Interceptor {
    private static final long serialVersionUID = 485808940993312203L;

    //初始化
    public void init() {
    }

    //拦截
    public String intercept(ActionInvocation invocation) throws Exception {
        //判读session是否存在用户
        CrmUser crmUser = (CrmUser) ActionContext.getContext()
                .getSession().get("loginCrmUser");
        if (crmUser == null) {
            /**显示友好 start*/
            // 判断父类是否是 ActionSupport，
            //如果是，具有addFieldError 可以设置提示信息
            Object actionObj = invocation.getAction();
            if (actionObj instanceof ActionSupport) {
                ActionSupport actionSupport = (ActionSupport) actionObj;
                actionSupport.addFieldError("userLogon", "请登录");
            }
            /**显示友好 end*/
            return "nonLogin";
        }
        //放行
        return invocation.invoke();
    }

    //销毁
    public void destroy() {
    }
}
