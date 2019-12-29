package com.learn.mybatis.dao;

import com.learn.mybatis.pojo.User;
import com.learn.mybatis.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserDaoTest {

    @Test
    public void test(){
        //第一步：获得SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //方式一
        //执行SQL
        UserMapper userDao = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userDao.getUserList();
        System.out.println(userList);

        //方式二
//        List<Object> objects = sqlSession.selectList("com.learn.mybatis.dao.UserDao.getUserList");



        //关闭SqlSession
        sqlSession.close();
    }

    @Test
    public void test1(){
        //第一步：获得SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //方式一
        //执行SQL
        UserMapper userDao = sqlSession.getMapper(UserMapper.class);
        User user = userDao.getUserById(1);
        System.out.println(user);
        //关闭SqlSession
        sqlSession.close();
    }


    //增删改需要提交事物
    @Test
    public void testAddUser(){
        //第一步：获得SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //方式一
        //执行SQL
        UserMapper userDao = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setName("啦啦啦");
        user.setPwd("1");
        int i = userDao.addUser(user);
        System.out.println("成功插入"+i+"条数据");
        sqlSession.commit();

        //关闭SqlSession
        sqlSession.close();
    }


    @Test
    public void testUpdateUser(){
        //第一步：获得SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //方式一
        //执行SQL
        UserMapper userDao = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setId(5);
        user.setName("啦啦啦");
        user.setPwd("1111");
        int i = userDao.updateUser(user);
        System.out.println("成功修改"+i+"条数据");
        sqlSession.commit();

        //关闭SqlSession
        sqlSession.close();
    }

    @Test
    public void testDeleteUser(){
        //第一步：获得SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //方式一
        //执行SQL
        UserMapper userDao = sqlSession.getMapper(UserMapper.class);

        int i = userDao.deleteUser(5);
        System.out.println("成功删除"+i+"条数据");
        sqlSession.commit();

        //关闭SqlSession
        sqlSession.close();
    }
}
