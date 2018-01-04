package cn.itcast.crm.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * 职务管理
 */
public class CrmPost implements java.io.Serializable {
    private String postId; //职务id
    private String postName; //职务名称
    private CrmDepartment crmDepartment; //与部门关联的属性
    private Set<CrmUser> crmUsers = new HashSet<CrmUser>();//与用户关联的属性

    public CrmDepartment getCrmDepartment() {
        return crmDepartment;
    }

    public Set<CrmUser> getCrmUsers() {
        return crmUsers;
    }

    public String getPostId() {
        return postId;
    }

    public String getPostName() {
        return postName;
    }

    public void setCrmDepartment(CrmDepartment crmDepartment) {
        this.crmDepartment = crmDepartment;
    }

    public void setCrmUsers(Set<CrmUser> crmUsers) {
        this.crmUsers = crmUsers;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }
}

