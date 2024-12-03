package com.ffzu.service;

import com.ffzu.mapper.BillMapper;
import com.ffzu.pojo.Bill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class BillService {

    @Autowired
    private BillMapper billMapper; // 注入 BillMapper

    // 1. 增加账单
    public void addBill(Bill bill) {
        billMapper.insertBill(bill);
    }

    // 2. 修改账单
    public void updateBill(Bill updatedBill) {
        // 通过账单号查找现有账单
        Bill existingBill = billMapper.getBillByBillNumber(updatedBill.getBillNumber());

        // 如果找不到账单，抛出异常
        if (existingBill == null) {
            throw new IllegalArgumentException("账单未找到");
        }

        // 更新账单信息
        existingBill.setAmount(updatedBill.getAmount());
        existingBill.setYear(updatedBill.getYear());
        existingBill.setMonth(updatedBill.getMonth());

        // 更新数据库中的账单
        billMapper.updateBill(existingBill);
    }

    // 3. 删除账单
    public void deleteBill(String billId) {
        Bill bill = billMapper.getBillByBillNumber(billId);
        if (bill == null) {
            throw new IllegalArgumentException("账单未找到");
        }
        billMapper.deleteBill(billId);
    }

    // 4. 获取账单信息：计算指定时间范围内水电费总和
    public BigDecimal getBillSumByDateRange(String id, int startYear, int startMonth, int endYear, int endMonth) {
        // 使用实例方法获取账单数据
        List<Bill> bills = billMapper.findBillsByDateRange(id, startYear, startMonth, endYear, endMonth);

        // 累加账单的总水电费用
        return bills.stream()
                .map(Bill::getAmount) // 获取每个账单的总金额
                .reduce(BigDecimal.ZERO, BigDecimal::add); // 累加总金额
    }

    // 5. 获取指定用户范围内指定时间范围的账单并统计水电费总和
    public Map<String, Object> getBillsByUserRangeAndDateRange(List<String> userIds, int startYear, int startMonth, int endYear, int endMonth) {
        // 获取所有用户的账单
        List<Bill> allBills = userIds.stream()
                .flatMap(userId -> billMapper.findBillsByDateRange(userId, startYear, startMonth, endYear, endMonth).stream())
                .collect(Collectors.toList());

        // 计算总金额
        BigDecimal totalAmount = allBills.stream()
                .map(Bill::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        // 封装结果到 Map
        Map<String, Object> result = new HashMap<>();
        result.put("bills", allBills);       // 账单列表
        result.put("totalAmount", totalAmount); // 总金额
        return result;
    }


    // 获取指定时间范围内的所有账单
    public List<Bill> findBillsByDateRange(String id, int startYear, int startMonth, int endYear, int endMonth) {
        return billMapper.findBillsByDateRange(id, startYear, startMonth, endYear, endMonth);
    }

    // 根据账单号获取单个账单
    public Bill getBillByBillNumber(String billNumber) {
        return billMapper.getBillByBillNumber(billNumber);
    }
}
