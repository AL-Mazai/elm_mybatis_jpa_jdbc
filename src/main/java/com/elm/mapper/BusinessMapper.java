package com.elm.mapper;

import com.elm.pojo.Business;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BusinessMapper {
    /**
     * 根据id查询商家信息
     * @param businessId
     * @return
     */
    public Business getBusinessById(Integer businessId);

    /**
     * 查询所有商家信息
     * @return
     */
    public List<Business> getBusinessList();

    /**
     * 根据姓名和地址查询符合的所有商家信息
     * @param businessName
     * @param businessAddress
     * @return
     */
    //对于mapper接口中，传入的参数有多个时必须使用@param进行标识
    public List<Business> getBusinessList(@Param("businessName") String businessName,
                                          @Param("businessAddress") String businessAddress);

    /**
     * 新增商家
     * @param business
     * @return
     */
    public int saveBusiness(Business business);

    /**
     * 根据id删除商家
     * @param businessId
     * @return
     */
    public boolean removeBusiness(int businessId);

    /**
     * 更新商家信息
     * @param business
     * @return
     */
    public boolean updateBusiness(Business business);

    /**
     * 根据商家id修改商家密码
     * @param businessId
     * @return
     */
    public boolean updateBusinessPasswordById(@Param("businessId") Integer businessId,
                                              @Param("password") String password);

    /**
     * 根据id和密码查找商家
     * @param businessId
     * @param password
     * @return
     */
    Business getBusinessByIdAndByPassword(@Param("businessId") int businessId,
                                          @Param("password") String password);
}
