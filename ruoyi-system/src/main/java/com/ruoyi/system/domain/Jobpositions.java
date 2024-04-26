package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 职位管理对象 jobpositions
 * 
 * @author ruoyi
 * @date 2024-04-25
 */
public class Jobpositions extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 岗位 */
    @Excel(name = "岗位")
    private String positionName;

    /** 招聘状态 */
    @Excel(name = "招聘状态")
    private String recruitmentStatus;

    /** 所属部门 */
    @Excel(name = "所属部门")
    private String department;

    /** 岗位描述 */
    @Excel(name = "岗位描述")
    private String positionDescription;

    /** 岗位职责 */
    @Excel(name = "岗位职责")
    private String positionResponsibilities;

    /** 附件 */
    @Excel(name = "附件")
    private String attachmentUrl;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setPositionName(String positionName) 
    {
        this.positionName = positionName;
    }

    public String getPositionName() 
    {
        return positionName;
    }
    public void setRecruitmentStatus(String recruitmentStatus) 
    {
        this.recruitmentStatus = recruitmentStatus;
    }

    public String getRecruitmentStatus() 
    {
        return recruitmentStatus;
    }
    public void setDepartment(String department) 
    {
        this.department = department;
    }

    public String getDepartment() 
    {
        return department;
    }
    public void setPositionDescription(String positionDescription) 
    {
        this.positionDescription = positionDescription;
    }

    public String getPositionDescription() 
    {
        return positionDescription;
    }
    public void setPositionResponsibilities(String positionResponsibilities) 
    {
        this.positionResponsibilities = positionResponsibilities;
    }

    public String getPositionResponsibilities() 
    {
        return positionResponsibilities;
    }
    public void setAttachmentUrl(String attachmentUrl) 
    {
        this.attachmentUrl = attachmentUrl;
    }

    public String getAttachmentUrl() 
    {
        return attachmentUrl;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("positionName", getPositionName())
            .append("recruitmentStatus", getRecruitmentStatus())
            .append("department", getDepartment())
            .append("positionDescription", getPositionDescription())
            .append("positionResponsibilities", getPositionResponsibilities())
            .append("attachmentUrl", getAttachmentUrl())
            .toString();
    }
}
