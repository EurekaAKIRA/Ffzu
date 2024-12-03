package com.ffzu.pojo;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class Bill {
    private String id; // 宿舍号 (与 User 的外键关联)
    private BigDecimal waterBill; // 水费
    private BigDecimal electricityBill; // 电费
    private BigDecimal amount;//总费用
    private String billNumber; // 账单号（格式：宿舍号 + 年月）
    private int year;                    // 年份
    private int month;// 月份

    // 构造函数、getter、setter 会通过 Lombok 的 @Data 注解自动生成
}
