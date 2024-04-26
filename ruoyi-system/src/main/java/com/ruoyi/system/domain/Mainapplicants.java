package com.ruoyi.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 应聘成员对象 mainapplicants
 * 
 * @author ruoyi
 * @date 2024-04-24
 */
public class Mainapplicants extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 姓名 */
    @Excel(name = "姓名")
    private String name;

    /** 性别 */
    @Excel(name = "性别")
    private String gender;

    /** 年龄 */
    @Excel(name = "年龄")
    private Long age;

    /** 电话 */
    @Excel(name = "电话")
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

    /** 匹配度 */
    @Excel(name = "匹配度")
    private BigDecimal matchPercentage;

    /** 风险评估 */
    @Excel(name = "风险评估")
    private String riskAssessment;

    /** 风险概要 */
    @Excel(name = "风险概要")
    private String riskSummaryUrl;

    /** 简历 */
    @Excel(name = "简历")
    private String resumeUrl;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
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
    public void setMatchPercentage(BigDecimal matchPercentage) 
    {
        this.matchPercentage = matchPercentage;
    }

    public BigDecimal getMatchPercentage() 
    {
        return matchPercentage;
    }
    public void setRiskAssessment(String riskAssessment) 
    {
        this.riskAssessment = riskAssessment;
    }

    public String getRiskAssessment() 
    {
        return riskAssessment;
    }
    public void setRiskSummaryUrl(String riskSummaryUrl) 
    {
        this.riskSummaryUrl = riskSummaryUrl;
    }

    public String getRiskSummaryUrl() 
    {
        return riskSummaryUrl;
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
            .append("id", getId())
            .append("name", getName())
            .append("gender", getGender())
            .append("age", getAge())
            .append("phone", getPhone())
            .append("education", getEducation())
            .append("expectedSalary", getExpectedSalary())
            .append("positionApplied", getPositionApplied())
            .append("jobStatus", getJobStatus())
            .append("workExperience", getWorkExperience())
            .append("matchPercentage", getMatchPercentage())
            .append("riskAssessment", getRiskAssessment())
            .append("riskSummaryUrl", getRiskSummaryUrl())
            .append("resumeUrl", getResumeUrl())
            .toString();
    }
}
