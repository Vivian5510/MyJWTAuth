package com.rosy.myjwtauth.domain.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 角色表(Role)表实体类
 *
 * @author rosy
 * @since 2024-12-11 20:56:01
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("sys_role")
public class Role {
    @TableId
    private Long id;
    private String name;
    // 角色权限字符串
    private String roleKey;
    // 角色状态（0正常 1停用）
    private String status;
    // del_flag
    @TableLogic
    private Integer delFlag;
    private Long createBy;
    private Date createTime;
    private Long updateBy;
    private Date updateTime;
    // 备注
    private String remark;
}

