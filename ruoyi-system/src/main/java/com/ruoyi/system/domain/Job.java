package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 岗位管理对象 job
 * 
 * @author ruoyi
 * @date 2024-04-25
 */
public class Job extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long ID;

    /** 岗位名称 */
    @Excel(name = "岗位名称")
    private String JobTitle;

    /** 招聘状态 */
    @Excel(name = "招聘状态")
    private String RecruitmentStatus;

    /** 部门 */
    @Excel(name = "部门")
    private String Department;

    /** 岗位描述 */
    @Excel(name = "岗位描述")
    private String JobDescription;

    /** 岗位职责 */
    @Excel(name = "岗位职责")
    private String JobResponsibilities;

    /** 附件 */
    @Excel(name = "附件")
    private String Attachment;

    public void setID(Long ID) 
    {
        this.ID = ID;
    }

    public Long getID() 
    {
        return ID;
    }
    public void setJobTitle(String JobTitle) 
    {
        this.JobTitle = JobTitle;
    }

    public String getJobTitle() 
    {
        return JobTitle;
    }
    public void setRecruitmentStatus(String RecruitmentStatus) 
    {
        this.RecruitmentStatus = RecruitmentStatus;
    }

    public String getRecruitmentStatus() 
    {
        return RecruitmentStatus;
    }
    public void setDepartment(String Department) 
    {
        this.Department = Department;
    }

    public String getDepartment() 
    {
        return Department;
    }
    public void setJobDescription(String JobDescription) 
    {
        this.JobDescription = JobDescription;
    }

    public String getJobDescription() 
    {
        return JobDescription;
    }
    public void setJobResponsibilities(String JobResponsibilities) 
    {
        this.JobResponsibilities = JobResponsibilities;
    }

    public String getJobResponsibilities() 
    {
        return JobResponsibilities;
    }
    public void setAttachment(String Attachment) 
    {
        this.Attachment = Attachment;
    }

    public String getAttachment() 
    {
        return Attachment;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("ID", getID())
            .append("JobTitle", getJobTitle())
            .append("RecruitmentStatus", getRecruitmentStatus())
            .append("Department", getDepartment())
            .append("JobDescription", getJobDescription())
            .append("JobResponsibilities", getJobResponsibilities())
            .append("Attachment", getAttachment())
            .toString();
    }
}
