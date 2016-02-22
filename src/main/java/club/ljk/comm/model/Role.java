package club.ljk.comm.model;

import club.ljk.comm.model.base.BaseModel;
import java.util.Date;

public class Role extends BaseModel {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column xkey_role.role_id
     *
     * @mbggenerated
     */
    private String roleId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column xkey_role.role_name
     *
     * @mbggenerated
     */
    private String roleName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column xkey_role.role_depcit
     *
     * @mbggenerated
     */
    private String roleDepcit;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column xkey_role.role_is_del
     *
     * @mbggenerated
     */
    private Integer roleIsDel;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column xkey_role.role_create
     *
     * @mbggenerated
     */
    private String roleCreate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column xkey_role.role_time
     *
     * @mbggenerated
     */
    private Date roleTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column xkey_role.role_id
     *
     * @return the value of xkey_role.role_id
     *
     * @mbggenerated
     */
    public String getRoleId() {
        return roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column xkey_role.role_id
     *
     * @param roleId the value for xkey_role.role_id
     *
     * @mbggenerated
     */
    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column xkey_role.role_name
     *
     * @return the value of xkey_role.role_name
     *
     * @mbggenerated
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column xkey_role.role_name
     *
     * @param roleName the value for xkey_role.role_name
     *
     * @mbggenerated
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column xkey_role.role_depcit
     *
     * @return the value of xkey_role.role_depcit
     *
     * @mbggenerated
     */
    public String getRoleDepcit() {
        return roleDepcit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column xkey_role.role_depcit
     *
     * @param roleDepcit the value for xkey_role.role_depcit
     *
     * @mbggenerated
     */
    public void setRoleDepcit(String roleDepcit) {
        this.roleDepcit = roleDepcit == null ? null : roleDepcit.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column xkey_role.role_is_del
     *
     * @return the value of xkey_role.role_is_del
     *
     * @mbggenerated
     */
    public Integer getRoleIsDel() {
        return roleIsDel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column xkey_role.role_is_del
     *
     * @param roleIsDel the value for xkey_role.role_is_del
     *
     * @mbggenerated
     */
    public void setRoleIsDel(Integer roleIsDel) {
        this.roleIsDel = roleIsDel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column xkey_role.role_create
     *
     * @return the value of xkey_role.role_create
     *
     * @mbggenerated
     */
    public String getRoleCreate() {
        return roleCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column xkey_role.role_create
     *
     * @param roleCreate the value for xkey_role.role_create
     *
     * @mbggenerated
     */
    public void setRoleCreate(String roleCreate) {
        this.roleCreate = roleCreate == null ? null : roleCreate.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column xkey_role.role_time
     *
     * @return the value of xkey_role.role_time
     *
     * @mbggenerated
     */
    public Date getRoleTime() {
        return roleTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column xkey_role.role_time
     *
     * @param roleTime the value for xkey_role.role_time
     *
     * @mbggenerated
     */
    public void setRoleTime(Date roleTime) {
        this.roleTime = roleTime;
    }
}