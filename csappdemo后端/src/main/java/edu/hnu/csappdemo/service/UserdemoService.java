package edu.hnu.csappdemo.service;

import edu.hnu.csappdemo.entity.Userdemo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (Userdemo)表服务接口
 *
 * @author makejava
 * @since 2023-06-20 13:26:15
 */
public interface UserdemoService {

    /**
     * 通过ID查询单条数据
     *
     * @param uid 主键
     * @return 实例对象
     */
    Userdemo queryById(Integer uid);
    Userdemo queryByNameAndPWD(String username,String PWD);
    Userdemo queryByName(String username);
    /**
     * 分页查询
     *
     * @param userdemo 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Userdemo> queryByPage(Userdemo userdemo, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param userdemo 实例对象
     * @return 实例对象
     */
    Userdemo insert(Userdemo userdemo);

    /**
     * 修改数据
     *
     * @param userdemo 实例对象
     * @return 实例对象
     */
    Userdemo update(Userdemo userdemo);

    /**
     * 通过主键删除数据
     *
     * @param uid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer uid);

}
