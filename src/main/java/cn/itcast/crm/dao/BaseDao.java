package cn.itcast.crm.dao;

import java.util.List;

/**
 * 抽取出的dao接口方法，专门用于继承
 */
public interface BaseDao<T> {
    // 添加
    void save(T t);

    // 更新
    void update(T t);

    // 保存或更新(代理主键：如果没有OID将执行save，如果有OID将执行update)
    void saveOrUpdate(T t);

    // 删除
    void delete(T t);

    // 通过id查询
    T findById(java.io.Serializable id);

    //查询所有
    List<T> findAll();

    /**
     * 带有条件查询所有
     *
     * @param condition 条件语句 （where之后的语句）
     *                  * 格式： and 属性 关键字 ?
     *                  * 例如：and name like ?
     * @param params    条件
     */
    List<T> findAll(String condition, Object... params);

    //查询分页数据
    List<T> findAllWithPage(String conditionHQL, Object[] params, int startIndex, int pageSize);

    //查询总记录数
    int getTotalRecord();
}
