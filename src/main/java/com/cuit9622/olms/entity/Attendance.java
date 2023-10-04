package com.cuit9622.olms.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 签到表
 * @TableName sys_attendance
 */
@TableName(value ="sys_attendance")
@Data
public class Attendance implements Serializable {
    /**
     * 签到id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 考勤人员
     */
    @TableField(value = "user_id")
    private Long userId;

    /**
     * 预约记录id
     */
    @TableField(value = "appointment_id")
    private Long appointmentId;

    /**
     * 考勤状态，1正常，0缺勤，2迟到，3早退
     */
    @TableField(value = "status")
    private Object status;

    /**
     * 原因
     */
    @TableField(value = "absence_reason")
    private String absenceReason;

    /**
     * 考勤创建时间
     */
    @TableField(value = "create_time")
    private Date createTime;

    /**
     * 考勤修改时间
     */
    @TableField(value = "update_time")
    private Date updateTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}