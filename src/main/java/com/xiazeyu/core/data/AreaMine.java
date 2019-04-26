package com.xiazeyu.core.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 地雷区域
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AreaMine {
    /**
     * 横坐标
     */
    private int x;

    /**
     * 纵坐标
     */
    private int y;
}
