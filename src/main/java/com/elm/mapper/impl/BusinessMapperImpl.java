package com.elm.mapper.impl;

import com.elm.mapper.BusinessMapper;
import com.elm.pojo.Business;
import com.elm.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import java.sql.SQLException;
import java.util.List;

public class BusinessMapperImpl implements BusinessMapper {
    //获取sqlSessionFactory对象
    static SqlSessionFactory factory = MybatisUtil.getSqlSessionFactory();

    //根据id查询商家信息
    @Override
    public Business getBusinessById(Integer businessId) {
        //1. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //2.获取Mapper对象
        BusinessMapper businessMapper = sqlSession.getMapper(BusinessMapper.class);
        //3.执行增删改查
        Business business = businessMapper.getBusinessById(businessId);
        //4.释放资源
        sqlSession.close();
        return business;
    }

    //查询所有商家信息
    @Override
    public List<Business> getBusinessList() {
        SqlSession sqlSession = factory.openSession();
        BusinessMapper businessMapper = sqlSession.getMapper(BusinessMapper.class);
        List<Business> businessList = businessMapper.getBusinessList();
        sqlSession.close();
        return businessList;
    }

    //根据姓名和地址查询符合的所有商家信息
    @Override
    public List<Business> getBusinessList(String businessName, String businessAddress) {
        SqlSession sqlSession = factory.openSession();
        BusinessMapper businessMapper = sqlSession.getMapper(BusinessMapper.class);
        List<Business> businessList = businessMapper.getBusinessList(businessName, businessAddress);
        sqlSession.close();
        return businessList;
    }

    //新增商家
    @Override
    public int saveBusiness(Business business) {
        SqlSession sqlSession = factory.openSession();
        int businessId = 0;
        try {
            sqlSession.getConnection().setAutoCommit(false);
            BusinessMapper businessMapper = sqlSession.getMapper(BusinessMapper.class);
            businessMapper.saveBusiness(business);
            businessId = business.getBusinessId();
            sqlSession.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return businessId;
    }

    //根据id删除商家
    @Override
    public boolean removeBusiness(int businessId) {
        SqlSession sqlSession = factory.openSession();
        boolean isDelSuccess = false;
        try {
            sqlSession.getConnection().setAutoCommit(false);
            BusinessMapper businessMapper = sqlSession.getMapper(BusinessMapper.class);
            isDelSuccess = businessMapper.removeBusiness(businessId);
            sqlSession.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return isDelSuccess;
    }

    //更新商家信息
    @Override
    public boolean updateBusiness(Business business) {
        SqlSession sqlSession = factory.openSession();
        boolean isUpdateSuccess = false;
        try {
            sqlSession.getConnection().setAutoCommit(false);
            BusinessMapper businessMapper = sqlSession.getMapper(BusinessMapper.class);
            isUpdateSuccess = businessMapper.updateBusiness(business);
            sqlSession.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return isUpdateSuccess;
    }

    //根据商家id修改商家密码
    @Override
    public boolean updateBusinessPasswordById(Integer businessId, String password) {
        SqlSession sqlSession = factory.openSession();
        boolean isUpdateSuccess = false;
        try {
            sqlSession.getConnection().setAutoCommit(false);
            BusinessMapper businessMapper = sqlSession.getMapper(BusinessMapper.class);
            isUpdateSuccess = businessMapper.updateBusinessPasswordById(businessId, password);
            sqlSession.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return isUpdateSuccess;
    }

    //根据id和密码查找商家
    @Override
    public Business getBusinessByIdAndByPassword(int businessId, String password) {
        SqlSession sqlSession = factory.openSession();
        BusinessMapper businessMapper = sqlSession.getMapper(BusinessMapper.class);
        return businessMapper.getBusinessByIdAndByPassword(businessId, password);
    }
}
