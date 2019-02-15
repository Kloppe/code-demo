package com.ggj.platform.demo.core.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * 实体对象
 *
 * @author <a href="mailto:zhongchao@gegejia.com">珞玉</a>
 * @version 1.0 2018/4/12
 * @since 1.0
 */
@Data
public abstract class BaseEntity implements Serializable {

    private static final long serialVersionUID = -6508220097255084349L;

    /**
     * 主键
     */
    private Long id;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;
}
