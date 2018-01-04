package cn.itcast.crm.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * 部门管理
 */
public class CrmDepartment implements java.io.Serializable {
    private String depId; //部门id
    private String depName; //部门名称
    private Set<CrmPost> crmPosts = new HashSet<CrmPost>(); //部门中的职位
    //此处省略各属性的getter和setter方法

    public Set<CrmPost> getCrmPosts() {
        return crmPosts;
    }

    public String getDepId() {
        return depId;
    }

    public String getDepName() {
        return depName;
    }

    public void setCrmPosts(Set<CrmPost> crmPosts) {
        this.crmPosts = crmPosts;
    }

    public void setDepId(String depId) {
        this.depId = depId;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }
}

