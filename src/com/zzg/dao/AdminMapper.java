package com.zzg.dao;

import com.zzg.domain.Admin;
import com.zzg.domain.AdminExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdminMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin
     *
     * @mbggenerated Wed Jun 21 10:44:08 CST 2017
     */
    int countByExample(AdminExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin
     *
     * @mbggenerated Wed Jun 21 10:44:08 CST 2017
     */
    int deleteByExample(AdminExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin
     *
     * @mbggenerated Wed Jun 21 10:44:08 CST 2017
     */
    int deleteByPrimaryKey(String adminid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin
     *
     * @mbggenerated Wed Jun 21 10:44:08 CST 2017
     */
    int insert(Admin record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin
     *
     * @mbggenerated Wed Jun 21 10:44:08 CST 2017
     */
    int insertSelective(Admin record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin
     *
     * @mbggenerated Wed Jun 21 10:44:08 CST 2017
     */
    List<Admin> selectByExample(AdminExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin
     *
     * @mbggenerated Wed Jun 21 10:44:08 CST 2017
     */
    Admin selectByPrimaryKey(String adminid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin
     *
     * @mbggenerated Wed Jun 21 10:44:08 CST 2017
     */
    int updateByExampleSelective(@Param("record") Admin record, @Param("example") AdminExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin
     *
     * @mbggenerated Wed Jun 21 10:44:08 CST 2017
     */
    int updateByExample(@Param("record") Admin record, @Param("example") AdminExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin
     *
     * @mbggenerated Wed Jun 21 10:44:08 CST 2017
     */
    int updateByPrimaryKeySelective(Admin record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin
     *
     * @mbggenerated Wed Jun 21 10:44:08 CST 2017
     */
    int updateByPrimaryKey(Admin record);
}