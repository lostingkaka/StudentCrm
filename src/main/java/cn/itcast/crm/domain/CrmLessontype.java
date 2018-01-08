package cn.itcast.crm.domain;

import java.util.HashSet;
import java.util.Set;

public class CrmLessontype implements java.io.Serializable {

    // Fields

    private String lessonTypeId;
    private Double lessonCost;
    private Integer total;
    private String remark;
    private String lessonName;
    private Set<CrmClass> crmClasses = new HashSet<CrmClass>();

    private String startTotal;   //总学时（范围开始）
    private String endTotal;   //总学时（范围结束）

    private String startLessonCost;   //课程费用
    private String endLessonCost;   //课程费用

    public String getStartTotal() {
        return startTotal;
    }

    public void setStartTotal(String startTotal) {
        this.startTotal = startTotal;
    }

    public String getEndTotal() {
        return endTotal;
    }

    public void setEndTotal(String endTotal) {
        this.endTotal = endTotal;
    }

    public String getStartLessonCost() {
        return startLessonCost;
    }

    public void setStartLessonCost(String startLessonCost) {
        this.startLessonCost = startLessonCost;
    }

    public String getEndLessonCost() {
        return endLessonCost;
    }

    public void setEndLessonCost(String endLessonCost) {
        this.endLessonCost = endLessonCost;
    }

    public String getLessonTypeId() {
        return lessonTypeId;
    }

    public void setLessonTypeId(String lessonTypeId) {
        this.lessonTypeId = lessonTypeId;
    }

    public Double getLessonCost() {
        return lessonCost;
    }

    public void setLessonCost(Double lessonCost) {
        this.lessonCost = lessonCost;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public void setCrmClasses(Set<CrmClass> crmClasses) {
        this.crmClasses = crmClasses;
    }

    public Set<CrmClass> getCrmClasses() {
        return crmClasses;
    }
}