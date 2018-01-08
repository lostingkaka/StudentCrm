package cn.itcast.crm.service;

import java.util.List;

import cn.itcast.crm.domain.CrmPost;

public interface CrmPostService {
    // 通过部门id查询所有的职务
    public List<CrmPost> findAll(String depId);

    // 查询所有的职务
    public List<CrmPost> findAll();

    // 通过id查询职务
    public CrmPost findById(String postId);

    // 添加或编辑职务
    public void saveOrEdit(CrmPost crmPost);
}
