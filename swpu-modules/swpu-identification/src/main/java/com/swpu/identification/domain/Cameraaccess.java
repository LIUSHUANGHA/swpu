package com.swpu.identification.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.swpu.common.core.annotation.Excel;
import com.swpu.common.core.web.domain.BaseEntity;

/**
 * 摄像头接入对象 cameraaccess
 * 
 * @author liushuang
 * @date 2024-02-02
 */
public class Cameraaccess extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 摄像头id */
    private Integer cameraId;

    /** 摄像头名称 */
    @Excel(name = "摄像头名称")
    private String cameraName;

    /** 安装位置 */
    @Excel(name = "安装位置")
    private String installLocation;

    /** ip地址 */
    @Excel(name = "ip地址")
    private String ipLocation;

    /** 端口号 */
    @Excel(name = "端口号")
    private Integer portNumber;

    /** 连接状态（0正常 1停用） */
    @Excel(name = "连接状态", readConverterExp = "0=正常,1=停用")
    private Integer connectionStatus;

    /** 最后更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "最后更新时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date lastUpdated;

    public void setCameraId(Integer cameraId) 
    {
        this.cameraId = cameraId;
    }

    public Integer getCameraId() 
    {
        return cameraId;
    }
    public void setCameraName(String cameraName) 
    {
        this.cameraName = cameraName;
    }

    public String getCameraName() 
    {
        return cameraName;
    }
    public void setInstallLocation(String installLocation) 
    {
        this.installLocation = installLocation;
    }

    public String getInstallLocation() 
    {
        return installLocation;
    }
    public void setIpLocation(String ipLocation) 
    {
        this.ipLocation = ipLocation;
    }

    public String getIpLocation() 
    {
        return ipLocation;
    }
    public void setPortNumber(Integer portNumber) 
    {
        this.portNumber = portNumber;
    }

    public Integer getPortNumber() 
    {
        return portNumber;
    }
    public void setConnectionStatus(Integer connectionStatus) 
    {
        this.connectionStatus = connectionStatus;
    }

    public Integer getConnectionStatus() 
    {
        return connectionStatus;
    }
    public void setLastUpdated(Date lastUpdated) 
    {
        this.lastUpdated = lastUpdated;
    }

    public Date getLastUpdated() 
    {
        return lastUpdated;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("cameraId", getCameraId())
            .append("cameraName", getCameraName())
            .append("installLocation", getInstallLocation())
            .append("ipLocation", getIpLocation())
            .append("portNumber", getPortNumber())
            .append("connectionStatus", getConnectionStatus())
            .append("lastUpdated", getLastUpdated())
            .toString();
    }
}
