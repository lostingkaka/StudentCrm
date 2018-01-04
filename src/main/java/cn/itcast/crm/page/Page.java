package cn.itcast.crm.page;

import java.util.List;

/**
 * 分页 数据封装对象
 */
public class Page<T> {
    // 必选项
    private int pageNum;            //当前页 -- 浏览器传递
    private int pageSize;            //每页显示个数 -- 固定值（浏览器传递）
    private int totalRecord;        //总记录数（数据库总条数） -- 查询数据库获得
    // 计算项
    private int startIndex;            //开始索引
    private int totalPage;            //总分页数
    // 分页数据
    private List<T> data;            //分页数据 --查询数据库获得
    // 导航动态显示条
    private int start;                //循环开始
    private int end;                //循环结束

    public Page(int pageNum, int pageSize, int totalRecord) {
        super();
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.totalRecord = totalRecord;
        // 0 优化 -- 排除负页
        if (this.pageNum < 1) {
            this.pageNum = 1;
        }
        //1 计算项
        // 1.1  开始索引
        this.startIndex = (this.pageNum - 1) * this.pageSize;
        // 1.2 总分页数
        this.totalPage = (this.totalRecord + this.pageSize - 1) / this.pageSize;
        //2 动态条 最多显示10分页，前4后5
        // 2.1 默认值
        this.start = 1;
        this.end = 10;
        // 2.2 处理
        // * 假设 totalPage = 4;
        if (this.totalPage <= 10) {
            this.end = this.totalPage;
        } else {
            // 假设 totalPage = 35

            // * 前4后5
            this.start = this.pageNum - 4;
            this.end = this.pageNum + 5;
            // * pageNum = 1
            if (this.start < 1) {
                this.start = 1;
                this.end = 10;
            }
            // * pageNUm = 35
            if (this.end > this.totalPage) {
                this.end = this.totalPage;
                this.start = this.totalPage - 9;
            }
        }
    }
    //此处省略各属性的getter和setter方法
}
