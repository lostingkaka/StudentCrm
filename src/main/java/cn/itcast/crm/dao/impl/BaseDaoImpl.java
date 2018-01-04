package cn.itcast.crm.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cn.itcast.crm.dao.BaseDao;
import cn.itcast.crm.page.PageHibernateCallback;

/**
 * dao接口的实现类，用于继承
 */
public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {
    //通过泛型信息获取类信息
    private Class<T> beanClass;

    public BaseDaoImpl() {
        // this ,在运行时表示的【当前运行类】。在编译时表示就是【当前类】
        // 1 获得当前运行类的父类，父类具有泛型信息，
        ParameterizedType parameterizedType =
                (ParameterizedType) this.getClass().getGenericSuperclass();
        // 2 获得实际参数
        beanClass = (Class<T>) parameterizedType.getActualTypeArguments()[0];
    }

    //保存
    public void save(T t) {
        this.getHibernateTemplate().save(t);
    }

    //更新
    public void update(T t) {
        this.getHibernateTemplate().update(t);
    }

    //保存或更新
    public void saveOrUpdate(T t) {
        this.getHibernateTemplate().saveOrUpdate(t);
    }

    ;

    //删除
    public void delete(T t) {
        this.getHibernateTemplate().delete(t);
    }

    //通过id查询
    public T findById(Serializable id) {
        return this.getHibernateTemplate().get(beanClass, id);
    }

    //查询所有
    public List<T> findAll() {

        // class.getName() 获得类的全限定类名，例如：java.lang.String
        // hibernate hql 完成写法 “from cn.itcast.crm...CrmUser”
        return (List<T>) this.getHibernateTemplate().find("from " + beanClass.getName());
    }

    //通过参数查询所有
    public List<T> findAll(String condition, Object... params) {
        String hql = "from " + beanClass.getName() + " where 1=1 " + condition;
        return (List<T>) this.getHibernateTemplate().find(hql, params);
    }

    //分页查询
    public List<T> findAllWithPage(String conditionHQL, Object[] params,
                                   int startIndex, int pageSize) {
        String hql = "from " + beanClass.getName() + " as c where 1=1" + conditionHQL;
        return this.getHibernateTemplate().execute(new PageHibernateCallback<T>(hql, params, startIndex, pageSize));
    }

    //获取总记录数
    public int getTotalRecord() {

        List<Long> allData =
                (List<Long>) this.getHibernateTemplate().find("select count(u) from " + beanClass.getName() + " u");
        return allData.get(0).intValue();

    }
}
