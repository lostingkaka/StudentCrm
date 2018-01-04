package cn.itcast.crm.page;

import java.util.List;

import org.hibernate.HibernateException;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateCallback;

/**
 * Hibernate分页的方法
 */
public class PageHibernateCallback<T> implements HibernateCallback<List<T>> {
    private String hql;        //hql语句
    private Object[] params;//hql语句的实际查询条件
    private int startIndex;    //分页：开始索引
    private int pageSize;    //分页：每页显示个数

    public PageHibernateCallback(String hql, Object[] params, int startIndex, int pageSize) {
        super();
        this.hql = hql;
        this.params = params;
        this.startIndex = startIndex;
        this.pageSize = pageSize;
    }

    //spring在执行查询时，将执行 doInHibernate方法，并将当前线程绑定session作为参数
    @SuppressWarnings("unchecked")
    public List<T> doInHibernate(Session session)
            throws HibernateException {
        //1 创建Query对象
        Query queryObject = session.createQuery(hql);
        //2参数封装
        if (params != null) {
            for (int i = 0; i < params.length; i++) {
                queryObject.setParameter(i, params[i]);
            }
        }
        //3 分页
        // 3.1 开始索引
        if (startIndex >= 0) {
            queryObject.setFirstResult(startIndex);
        }
        // 3.2 每页显示个数
        if (pageSize > 0) {
            queryObject.setMaxResults(pageSize);
        }
        return queryObject.list();
    }
}
