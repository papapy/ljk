package club.ljk.comm.model;

import club.ljk.comm.model.base.BaseModel;

public class AuthorityDperation extends BaseModel {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column xkey_authority_dperation.authority
     *
     * @mbggenerated
     */
    private String authority;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column xkey_authority_dperation.dperation
     *
     * @mbggenerated
     */
    private String dperation;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column xkey_authority_dperation.authority
     *
     * @return the value of xkey_authority_dperation.authority
     *
     * @mbggenerated
     */
    public String getAuthority() {
        return authority;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column xkey_authority_dperation.authority
     *
     * @param authority the value for xkey_authority_dperation.authority
     *
     * @mbggenerated
     */
    public void setAuthority(String authority) {
        this.authority = authority == null ? null : authority.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column xkey_authority_dperation.dperation
     *
     * @return the value of xkey_authority_dperation.dperation
     *
     * @mbggenerated
     */
    public String getDperation() {
        return dperation;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column xkey_authority_dperation.dperation
     *
     * @param dperation the value for xkey_authority_dperation.dperation
     *
     * @mbggenerated
     */
    public void setDperation(String dperation) {
        this.dperation = dperation == null ? null : dperation.trim();
    }
}