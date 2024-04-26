package com.ruoyi.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 招聘管理对象 applicant
 * 
 * @author ruoyi
 * @date 2024-04-24
 */
public class Applicant extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 用户ID */
    private Long userId;

    /** 用户姓名 */
    @Excel(name = "用户姓名")
    private String name;

    /** 头像 */
    @Excel(name = "头像")
    private String avatarUrl;

    /** 用户性别 */
    @Excel(name = "用户性别")
    private String gender;

    /** 用户年龄 */
    @Excel(name = "用户年龄")
    private Long age;

    /** 电话号码 */
    @Excel(name = "电话号码")
    private String phone;

    /** 学历 */
    @Excel(name = "学历")
    private String education;

    /** 期望工资 */
    @Excel(name = "期望工资")
    private BigDecimal expectedSalary;

    /** 应聘职位 */
    @Excel(name = "应聘职位")
    private String positionApplied;

    /** 求职状态 */
    @Excel(name = "求职状态")
    private String jobStatus;

    /** 工作经验 */
    @Excel(name = "工作经验")
    private Long workExperience;

    /** 简历概要的URL */
    @Excel(name = "简历概要的URL")
    private String resumeKeyUrl;

    /** 简历的URL */
    @Excel(name = "简历的URL")
    private String resumeUrl;

    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setAvatarUrl(String avatarUrl) 
    {
        this.avatarUrl = avatarUrl;
    }

    public String getAvatarUrl() 
    {
        return avatarUrl;
    }
    public void setGender(String gender) 
    {
        this.gender = gender;
    }

    public String getGender() 
    {
        return gender;
    }
    public void setAge(Long age) 
    {
        this.age = age;
    }

    public Long getAge() 
    {
        return age;
    }
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }
    public void setEducation(String education) 
    {
        this.education = education;
    }

    public String getEducation() 
    {
        return education;
    }
    public void setExpectedSalary(BigDecimal expectedSalary) 
    {
        this.expectedSalary = expectedSalary;
    }

    public BigDecimal getExpectedSalary() 
    {
        return expectedSalary;
    }
    public void setPositionApplied(String positionApplied) 
    {
        this.positionApplied = positionApplied;
    }

    public String getPositionApplied() 
    {
        return positionApplied;
    }
    public void setJobStatus(String jobStatus) 
    {
        this.jobStatus = jobStatus;
    }

    public String getJobStatus() 
    {
        return jobStatus;
    }
    public void setWorkExperience(Long workExperience) 
    {
        this.workExperience = workExperience;
    }

    public Long getWorkExperience() 
    {
        return workExperience;
    }
    public void setResumeKeyUrl(String resumeKeyUrl) 
    {
        this.resumeKeyUrl = resumeKeyUrl;
    }

    public String getResumeKeyUrl() 
    {
        return resumeKeyUrl;
    }
    public void setResumeUrl(String resumeUrl) 
    {
        this.resumeUrl = resumeUrl;
    }

    public String getResumeUrl() 
    {
        return resumeUrl;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("userId", getUserId())
            .append("name", getName())
            .append("avatarUrl", getAvatarUrl())
            .append("gender", getGender())
            .append("age", getAge())
            .append("phone", getPhone())
            .append("education", getEducation())
            .append("expectedSalary", getExpectedSalary())
            .append("positionApplied", getPositionApplied())
            .append("jobStatus", getJobStatus())
            .append("workExperience", getWorkExperience())
            .append("resumeKeyUrl", getResumeKeyUrl())
            .append("resumeUrl", getResumeUrl())
            .toString();
    }
}
