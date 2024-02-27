package edu.hnu.csappdemo.dao;

import edu.hnu.csappdemo.entity.Userdemo;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (Userdemo)表数据库访问层
 *
 * @author makejava
 * @since 2023-06-20 13:26:15
 */
public interface UserdemoDao {

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
     * 查询指定行数据
     *
     * @param userdemo 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<Userdemo> queryAllByLimit(Userdemo userdemo, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param userdemo 查询条件
     * @return 总行数
     */
    long count(Userdemo userdemo);

    /**
     * 新增数据
     *
     * @param userdemo 实例对象
     * @return 影响行数
     */
    int insert(Userdemo userdemo);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Userdemo> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Userdemo> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Userdemo> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Userdemo> entities);

    /**
     * 修改数据
     *
     * @param userdemo 实例对象
     * @return 影响行数
     */
    int update(Userdemo userdemo);

    /**
     * 通过主键删除数据
     *
     * @param uid 主键
     * @return 影响行数
     */
    int deleteById(Integer uid);

}

