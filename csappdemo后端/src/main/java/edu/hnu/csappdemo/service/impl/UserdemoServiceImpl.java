package edu.hnu.csappdemo.service.impl;

import edu.hnu.csappdemo.entity.Userdemo;
import edu.hnu.csappdemo.dao.UserdemoDao;
import edu.hnu.csappdemo.service.UserdemoService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (Userdemo)表服务实现类
 *
 * @author makejava
 * @since 2023-06-20 13:26:15
 */
@Service("userdemoService")
    public class UserdemoServiceImpl implements UserdemoService {
        @Resource
        private UserdemoDao userdemoDao;

        /**
         * 通过ID查询单条数据
         *
         * @param uid 主键
         * @return 实例对象
         */
        @Override
        public Userdemo queryById(Integer uid) {
            return this.userdemoDao.queryById(uid);
        }
        @Override
        public Userdemo queryByNameAndPWD(String username,String PWD)
        {
            return this.userdemoDao.queryByNameAndPWD(username,PWD);
        }
        @Override
        public Userdemo queryByName(String username)
        {
            return this.userdemoDao.queryByName(username);
        }
        /**
         * 分页查询
         *
         * @param userdemo 筛选条件
         * @param pageRequest      分页对象
         * @return 查询结果
         */
        @Override
        public Page<Userdemo> queryByPage(Userdemo userdemo, PageRequest pageRequest) {
            long total = this.userdemoDao.count(userdemo);
            return new PageImpl<>(this.userdemoDao.queryAllByLimit(userdemo, pageRequest), pageRequest, total);
        }

        /**
         * 新增数据
         *
         * @param userdemo 实例对象
         * @return 实例对象
         */
        @Override
        public Userdemo insert(Userdemo userdemo) {
            this.userdemoDao.insert(userdemo);
            return userdemo;
        }

        /**
         * 修改数据
         *
         * @param userdemo 实例对象
         * @return 实例对象
         */
        @Override
        public Userdemo update(Userdemo userdemo) {
            this.userdemoDao.update(userdemo);
            return this.queryById(userdemo.getUid());
        }

        /**
         * 通过主键删除数据
         *
         * @param uid 主键
         * @return 是否成功
         */
        @Override
        public boolean deleteById(Integer uid) {
            return this.userdemoDao.deleteById(uid) > 0;
        }
    }
