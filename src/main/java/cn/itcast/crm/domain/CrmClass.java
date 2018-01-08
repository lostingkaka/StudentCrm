package cn.itcast.crm.domain;
import java.util.Date;
/**
 * 班级管理
 */
public class CrmClass implements java.io.Serializable {
    private static final long serialVersionUID = -6412775832959370116L;
    private String classId;
    private String name;  //班级名次
    private CrmLessontype crmLessontype;  //所属课程
    private Date beginTime;  //开班时间
    private Date endTime; // 毕业时间
    private String status;		//状态（未开课/已开课/已结束）
    private int totalCount;		//学生总数
    private int upgradeCount;	//升学数
    private int changeCount;	//转班数
    private int runoffCount;	//退费数
    private String remark;
    //文件上传
    private String uploadPath;		//课表(schedule)路径
    private String uploadFilename;	//上传文件名称
    private Date uploadTime;		//长传时间
    //此处省略各属性的getter和setter方法

    public CrmLessontype getCrmLessontype() {
        return crmLessontype;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public int getChangeCount() {
        return changeCount;
    }

    public Date getUploadTime() {
        return uploadTime;
    }

    public int getRunoffCount() {
        return runoffCount;
    }

    public String getClassId() {
        return classId;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public int getUpgradeCount() {
        return upgradeCount;
    }

    public String getRemark() {
        return remark;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public String getUploadFilename() {
        return uploadFilename;
    }

    public String getUploadPath() {
        return uploadPath;
    }

    public void setChangeCount(int changeCount) {
        this.changeCount = changeCount;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public void setCrmLessontype(CrmLessontype crmLessontype) {
        this.crmLessontype = crmLessontype;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public void setRunoffCount(int runoffCount) {
        this.runoffCount = runoffCount;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public void setUpgradeCount(int upgradeCount) {
        this.upgradeCount = upgradeCount;
    }

    public void setUploadFilename(String uploadFilename) {
        this.uploadFilename = uploadFilename;
    }

    public void setUploadPath(String uploadPath) {
        this.uploadPath = uploadPath;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }
}
