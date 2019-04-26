package com.xiazeyu.core.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 决策树
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Decision {

    /**
     * 决策种类
     */
    private String type;

    /**
     * 操作指令
     */
    private String cmd;

    /**
     * 指令参数
     */
    private Object[] params;

}
