package com.yuand.smarteye.material.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 物料申请单
 *
 * @author ${author}
 * @email ${email}
 * @date 2022-09-01 19:48:53
 */
@Data
@TableName("mms_mbill")
public class MbillEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 申请单id
     */
    @TableId
    private Long mbillId;
    /**
     * 申请单名称
     */
    private String mbillName;
    /**
     * 描述
     */
    private String mbillDescription;
    /**
     * 所属分区id
     */
    private Long wlId;
    /**
     * 状态[0 - 新建，1 - 处理中，2-已完成]
     */
    private Integer status;
    /**
     *
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    /**
     *
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

}
