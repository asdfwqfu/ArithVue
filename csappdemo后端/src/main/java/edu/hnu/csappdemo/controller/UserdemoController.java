package edu.hnu.csappdemo.controller;

import edu.hnu.csappdemo.entity.Userdemo;
import edu.hnu.csappdemo.service.UserdemoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Userdemo)表控制层
 *
 * @author makejava
 * @since 2023-06-20 13:26:15
 */
@RestController
@RequestMapping("userdemo")
public class UserdemoController {
    /**
     * 服务对象
     */
    @Resource
    private UserdemoService userdemoService;

    /**
     * 分页查询
     *
     * @param userdemo 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Userdemo>> queryByPage(Userdemo userdemo, PageRequest pageRequest) {
        return ResponseEntity.ok(this.userdemoService.queryByPage(userdemo, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Userdemo> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.userdemoService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param userdemo 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Userdemo> add(Userdemo userdemo) {
        return ResponseEntity.ok(this.userdemoService.insert(userdemo));
    }

    /**
     * 编辑数据
     *
     * @param userdemo 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Userdemo> edit(Userdemo userdemo) {
        return ResponseEntity.ok(this.userdemoService.update(userdemo));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.userdemoService.deleteById(id));
    }

}

