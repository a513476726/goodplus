package com.zzg.domain;

public class Admin {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin.adminId
     *
     * @mbggenerated Wed Jun 21 10:44:08 CST 2017
     */
    private String adminid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin.adminname
     *
     * @mbggenerated Wed Jun 21 10:44:08 CST 2017
     */
    private String adminname;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin.adminpwd
     *
     * @mbggenerated Wed Jun 21 10:44:08 CST 2017
     */
    private String adminpwd;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column admin.adminId
     *
     * @return the value of admin.adminId
     *
     * @mbggenerated Wed Jun 21 10:44:08 CST 2017
     */
    public String getAdminid() {
        return adminid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column admin.adminId
     *
     * @param adminid the value for admin.adminId
     *
     * @mbggenerated Wed Jun 21 10:44:08 CST 2017
     */
    public void setAdminid(String adminid) {
        this.adminid = adminid == null ? null : adminid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column admin.adminname
     *
     * @return the value of admin.adminname
     *
     * @mbggenerated Wed Jun 21 10:44:08 CST 2017
     */
    public String getAdminname() {
        return adminname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column admin.adminname
     *
     * @param adminname the value for admin.adminname
     *
     * @mbggenerated Wed Jun 21 10:44:08 CST 2017
     */
    public void setAdminname(String adminname) {
        this.adminname = adminname == null ? null : adminname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column admin.adminpwd
     *
     * @return the value of admin.adminpwd
     *
     * @mbggenerated Wed Jun 21 10:44:08 CST 2017
     */
    public String getAdminpwd() {
        return adminpwd;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column admin.adminpwd
     *
     * @param adminpwd the value for admin.adminpwd
     *
     * @mbggenerated Wed Jun 21 10:44:08 CST 2017
     */
    public void setAdminpwd(String adminpwd) {
        this.adminpwd = adminpwd == null ? null : adminpwd.trim();
    }
}