package cn.itcast.crm.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.crm.domain.CrmClass;
import cn.itcast.crm.domain.CrmLessontype;
import cn.itcast.crm.service.CrmClassService;
import cn.itcast.crm.service.CrmLessontypeService;
import cn.itcast.crm.util.StringUtils;

/**
 * 班级Action
 */
public class ClassAction extends ActionSupport
        implements ModelDriven<CrmClass> {
    private static final long serialVersionUID = 7109237028679527218L;

    private static final Logger logger = LoggerFactory.getLogger(ClassAction.class);
    /**
     * 使用模型驱动封装数据
     */
    private CrmClass crmClass = new CrmClass();

    public CrmClass getModel() {
        return crmClass;
    }

    /**
     * 定义crmClassService属性及其setter方法
     */
    private CrmClassService crmClassService;

    public void setCrmClassService(CrmClassService crmClassService) {
        this.crmClassService = crmClassService;
    }

    private CrmLessontypeService crmLessontypeService;

    public CrmLessontypeService getCrmLessontypeService() {
        return crmLessontypeService;
    }

    public void setCrmLessontypeService(CrmLessontypeService
                                                crmLessontypeService) {
        this.crmLessontypeService = crmLessontypeService;
    }

    /**
     * 查询所有
     */
    public String findAll() {
        List<CrmClass> allClass = this.crmClassService.findAll();
        ActionContext.getContext().getValueStack()
                .set("allClass", allClass);
        return "findAll";
    }

    /**
     * 添加或更新前
     */
    public String preAddOrEdit() {
        //1 查询班级
        if (this.getModel().getClassId() != null) {
            CrmClass findClass = this.crmClassService
                    .findById(this.getModel().getClassId());
            ActionContext.getContext().getValueStack().push(findClass);
        }
        //2 查询类别
        List<CrmLessontype> allLessontype = this.crmLessontypeService
                .findAll();
        ActionContext.getContext().getValueStack()
                .set("allLessontype", allLessontype);
        return "preAddOrEdit";
    }

    /**
     * 添加或更新
     */
    public String addOrEdit() {
        Date date = new Date();
        long CurrentTime = date.getTime();
        long beginTime = this.getModel().getBeginTime().getTime();
        long endTime = this.getModel().getEndTime().getTime();
        if (CurrentTime < beginTime) {
            this.getModel().setStatus("未开班");
        } else if (CurrentTime > endTime) {
            this.getModel().setStatus("已结束");
        } else {
            this.getModel().setStatus("已开班");
        }
        this.crmClassService.saveOrEdit(this.getModel());
        return "addOrEdit";
    }

    /**
     * 通过id查询
     */
    public String findById() {
        CrmClass findClass = this.crmClassService
                .findById(this.getModel().getClassId());
        ActionContext.getContext().getValueStack().push(findClass);
        return "findById";
    }

    // 课表上传路径
    public static String CLASS_SCHEDULE_DIR = "/WEB-INF/upload";

    /**
     * 上传前
     */
    public String preUpload() {
        CrmClass findClass = this.crmClassService
                .findById(this.getModel().getClassId());
        ActionContext.getContext().getValueStack().push(findClass);
        return "preUpload";
    }

    // 声明上传属性
    private File schedule;  //上传的课表
    private String scheduleFileName; //上传的课表名称

    public void setSchedule(File schedule) {
        this.schedule = schedule;
    }

    public void setScheduleFileName(String scheduleFileName) {
        this.scheduleFileName = scheduleFileName;
    }

    /**
     * 上传方法
     */
    public String upload() {
        try {
            //将上传内容保存到指定位置
            String parentDir = System.getProperty("user.dir") + CLASS_SCHEDULE_DIR;
            String randomName = StringUtils.getUUID();
            File target = new File(parentDir, randomName);
            FileUtils.copyFile(schedule, target);
            //设置路径
            this.getModel()
                    .setUploadPath(CLASS_SCHEDULE_DIR + "/" + randomName);
            this.getModel().setUploadFilename(scheduleFileName);
            this.crmClassService.updateSchedule(this.getModel());
        } catch (Exception e) {
            e.printStackTrace();
            this.addFieldError("uploadTime", "上传有误" + e.getMessage());
            return "input";
        }
        return "upload";
    }

    /**
     * 声明下载文件属性
     */
    private InputStream target;
    private String downloadFileName;

    public InputStream getTarget() {
        return target;
    }

    //获取文件名称
    public String getDownloadFileName()
            throws UnsupportedEncodingException {
        if (downloadFileName != null) {
            return new String(downloadFileName.getBytes(), "ISO-8859-1");
        }
        return downloadFileName;
    }

    /**
     * 下载方法
     */
    public String download() {
        //获取CrmClass对象
        CrmClass findClass = this.crmClassService
                .findById(this.getModel().getClassId());
        //查找CrmClass对象路径中的文件，并放入输入流中
        InputStream is = null;
        try {
            is = new FileInputStream(new File(findClass.getUploadPath()));
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        //判断文件是否存在
        if (is == null) {
            this.addFieldError("uploadFilename", "课表已不存在，请重新上传");
            return "input";
        }
        this.target = is;
        this.downloadFileName = findClass.getUploadFilename();
        return "download";
    }
}
