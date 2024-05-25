package com.ruoyi.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 应聘对象 recruit
 * 
 * @author ruoyi
 * @date 2024-04-27
 */
public class Recruit extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long UserID;

    /** 姓名 */
    @Excel(name = "姓名")
    private String UserName;

    /** 性别 */
    @Excel(name = "性别")
    private String Gender;

    /** 年龄 */
    @Excel(name = "年龄")
    private Long Age;

    /** 电话 */
    @Excel(name = "电话")
    private String Phone;

    /** 学历 */
    @Excel(name = "学历")
    private String Education;

    /** 期望工资 */
    @Excel(name = "期望工资")
    private String ExpectedSalary;

    /** 应聘职位 */
    @Excel(name = "应聘职位")
    private String AppliedPosition;

    /** 求职状态 */
    @Excel(name = "求职状态")
    private String JobStatus;

    /** 工作经验 */
    @Excel(name = "工作经验")
    private String WorkExperience;

    /** 匹配度 */
    @Excel(name = "匹配度")
    private BigDecimal MatchScore;

    /** 风险评估 */
    @Excel(name = "风险评估")
    private String RiskAssessment;

    /** 风险概要 */
    @Excel(name = "风险概要")
    private String AnalysisSummaryURL;

    /** 简历 */
    @Excel(name = "简历")
    private String ResumeURL;

    public void setUserID(Long UserID) 
    {
        this.UserID = UserID;
    }

    public Long getUserID() 
    {
        return UserID;
    }
    public void setUserName(String UserName) 
    {
        this.UserName = UserName;
    }

    public String getUserName() 
    {
        return UserName;
    }
    public void setGender(String Gender) 
    {
        this.Gender = Gender;
    }

    public String getGender() 
    {
        return Gender;
    }
    public void setAge(Long Age) 
    {
        this.Age = Age;
    }

    public Long getAge() 
    {
        return Age;
    }
    public void setPhone(String Phone) 
    {
        this.Phone = Phone;
    }

    public String getPhone() 
    {
        return Phone;
    }
    public void setEducation(String Education) 
    {
        this.Education = Education;
    }

    public String getEducation() 
    {
        return Education;
    }
    public void setExpectedSalary(String ExpectedSalary) 
    {
        this.ExpectedSalary = ExpectedSalary;
    }

    public String getExpectedSalary() 
    {
        return ExpectedSalary;
    }
    public void setAppliedPosition(String AppliedPosition) 
    {
        this.AppliedPosition = AppliedPosition;
    }

    public String getAppliedPosition() 
    {
        return AppliedPosition;
    }
    public void setJobStatus(String JobStatus) 
    {
        this.JobStatus = JobStatus;
    }

    public String getJobStatus() 
    {
        return JobStatus;
    }
    public void setWorkExperience(String WorkExperience) 
    {
        this.WorkExperience = WorkExperience;
    }

    public String getWorkExperience() 
    {
        return WorkExperience;
    }
    public void setMatchScore(BigDecimal MatchScore) 
    {
        this.MatchScore = MatchScore;
    }

    public BigDecimal getMatchScore() 
    {
        return MatchScore;
    }
    public void setRiskAssessment(String RiskAssessment) 
    {
        this.RiskAssessment = RiskAssessment;
    }

    public String getRiskAssessment() 
    {
        return RiskAssessment;
    }
    public void setAnalysisSummaryURL(String AnalysisSummaryURL) 
    {
        this.AnalysisSummaryURL = AnalysisSummaryURL;
    }

    public String getAnalysisSummaryURL() 
    {
        return AnalysisSummaryURL;
    }
    public void setResumeURL(String ResumeURL) 
    {
        this.ResumeURL = ResumeURL;
    }

    public String getResumeURL() 
    {
        return ResumeURL;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("UserID", getUserID())
            .append("UserName", getUserName())
            .append("Gender", getGender())
            .append("Age", getAge())
            .append("Phone", getPhone())
            .append("Education", getEducation())
            .append("ExpectedSalary", getExpectedSalary())
            .append("AppliedPosition", getAppliedPosition())
            .append("JobStatus", getJobStatus())
            .append("WorkExperience", getWorkExperience())
            .append("MatchScore", getMatchScore())
            .append("RiskAssessment", getRiskAssessment())
            .append("AnalysisSummaryURL", getAnalysisSummaryURL())
            .append("ResumeURL", getResumeURL())
            .toString();
    }
}
