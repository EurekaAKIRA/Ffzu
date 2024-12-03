package com.ffzu.service;

import com.ffzu.mapper.BillMapper;
import com.ffzu.pojo.Bill;
import jakarta.transaction.Transactional;
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
    private BillMapper billMapper;

    // 添加账单
    public void addBill(Bill bill) {
        List<Bill> existingBills = billMapper.findBillsByDateRange(bill.getId(), bill.getYear(), bill.getMonth(), bill.getYear(), bill.getMonth());
        if (!existingBills.isEmpty()) {
            throw new IllegalArgumentException("账单已存在，不能重复添加");
        }
        billMapper.insertBill(bill);
    }

    @Transactional
    // 修改账单,不能改账单时间
    public void updateBill(Bill updatedBill) {
        check(updatedBill);
        if(updatedBill.getBillNumber()==null)
        {
            throw new IllegalArgumentException("账单号不能为空");
        }
        Bill existingBill = billMapper.getBillByBillNumber(updatedBill.getBillNumber());
        if (existingBill == null) {
            throw new IllegalArgumentException("账单未找到");
        }
        existingBill.setAmount(updatedBill.getAmount());
//        existingBill.setYear(updatedBill.getYear());
//        existingBill.setMonth(updatedBill.getMonth());
        billMapper.updateBill(existingBill);
    }

    // 删除账单
    public void deleteBill(String billNumber) {

        Bill bill = billMapper.getBillByBillNumber(billNumber);
        if (bill == null) {
            throw new IllegalArgumentException("账单未找到");
        }
        billMapper.deleteBill(billNumber);
    }
    public void check(Bill bill)
    {
        // 检查账单对象和账单编号
        if (bill == null) {
            throw new IllegalArgumentException("请输入账单信息！");
        }
        // 校验其他关键字段
        if (bill.getId() == null || bill.getId().isEmpty()) {
            throw new IllegalArgumentException("用户ID不能为空");
        }
        if (bill.getYear() <= 0) {
            throw new IllegalArgumentException("年份必须为正整数");
        }
        if (bill.getMonth() <= 0 || bill.getMonth() > 12) {
            throw new IllegalArgumentException("月份必须为 1 到 12 的整数");
        }
        if (bill.getWaterBill() == null) {
            throw new IllegalArgumentException("水费不能为空");
        }
        if (bill.getElectricityBill() == null) {
            throw new IllegalArgumentException("电费不能为空");
        }
    }
    // 获取指定时间范围内账单总金额
    public BigDecimal getBillSumByDateRange(String id, int startYear, int startMonth, int endYear, int endMonth) {
        if (id == null || startYear > endYear || (startYear == endYear && startMonth > endMonth)) {
            throw new IllegalArgumentException("时间范围参数非法");
        }
        List<Bill> bills = billMapper.findBillsByDateRange(id, startYear, startMonth, endYear, endMonth);
        return bills.stream()
                .map(Bill::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    // 获取指定用户范围和时间范围内的账单及总金额
    public Map<String, Object> getBillsByUserRangeAndDateRange(List<String> userIds, int startYear, int startMonth, int endYear, int endMonth) {
        if (userIds == null || userIds.isEmpty()) {
            throw new IllegalArgumentException("用户ID列表不能为空");
        }
        if (startYear > endYear || (startYear == endYear && startMonth > endMonth)) {
            throw new IllegalArgumentException("时间范围参数非法");
        }

        List<Bill> allBills = userIds.stream()
                .flatMap(userId -> billMapper.findBillsByDateRange(userId, startYear, startMonth, endYear, endMonth).stream())
                .collect(Collectors.toList());

        BigDecimal totalAmount = allBills.stream()
                .map(Bill::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        Map<String, Object> result = new HashMap<>();
        result.put("bills", allBills);
        result.put("totalAmount", totalAmount);
        return result;
    }

    // 查询指定时间范围内的账单
    public List<Bill> findBillsByDateRange(String id, int startYear, int startMonth, int endYear, int endMonth) {
        return billMapper.findBillsByDateRange(id, startYear, startMonth, endYear, endMonth);
    }

    // 根据账单号获取账单
    public Bill getBillByBillNumber(String billNumber) {
        if (billNumber == null || billNumber.isEmpty()) {
            throw new IllegalArgumentException("账单号不能为空");
        }
        return billMapper.getBillByBillNumber(billNumber);
    }

    // 获取所有账单
    public List<Bill> getAllBills() {
        return billMapper.getAllBills();
    }
}
