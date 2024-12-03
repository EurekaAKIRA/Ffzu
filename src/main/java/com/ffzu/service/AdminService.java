package com.ffzu.service;

import com.ffzu.mapper.AdminMapper;
import com.ffzu.mapper.BillMapper;
import com.ffzu.pojo.Admin;
import com.ffzu.pojo.Bill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class AdminService {
    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private BillMapper billMapper;

    // 登录接口
    public Admin login(String id, String password) {
        if (id == null || password == null) {
            throw new IllegalArgumentException("账号或密码不能为空");
        }
        Admin admin = adminMapper.getAdminById(id);
        if (admin != null && password.equals(admin.getPassword())) {
            return admin;
        }
        throw new IllegalArgumentException("账号或密码错误");
    }

    // 1. 获取所有账单
    public List<Bill> getAllBills() {
        return billMapper.getAllBills();
    }

    // 2. 删除账单
    public void deleteBill(String billNumber) {
        if (billNumber == null || billNumber.isEmpty()) {
            throw new IllegalArgumentException("账单号不能为空");
        }
        Bill bill = billMapper.getBillByBillNumber(billNumber);
        if (bill == null) {
            throw new IllegalArgumentException("账单未找到");
        }
        billMapper.deleteBill(billNumber);
    }

    // 3. 增加账单
    public void addBill(Bill bill) {
        if (bill == null || bill.getBillNumber() == null) {
            throw new IllegalArgumentException("账单信息不完整");
        }
        billMapper.insertBill(bill);
    }

    // 4. 修改账单
    public void updateBill(Bill updatedBill) {
        if (updatedBill == null || updatedBill.getBillNumber() == null) {
            throw new IllegalArgumentException("账单信息不完整");
        }
        Bill existingBill = billMapper.getBillByBillNumber(updatedBill.getBillNumber());
        if (existingBill == null) {
            throw new IllegalArgumentException("账单未找到");
        }
        existingBill.setAmount(updatedBill.getAmount());
        existingBill.setYear(updatedBill.getYear());
        existingBill.setMonth(updatedBill.getMonth());
        billMapper.updateBill(existingBill);
    }

    // 5. 获取指定时间范围内的水电费总和
    public BigDecimal getBillSumByDateRange(String id, int startYear, int startMonth, int endYear, int endMonth) {
        if (id == null || startYear > endYear || (startYear == endYear && startMonth > endMonth)) {
            throw new IllegalArgumentException("时间范围参数非法");
        }
        List<Bill> bills = billMapper.findBillsByDateRange(id, startYear, startMonth, endYear, endMonth);
        return bills.stream()
                .map(Bill::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public Map<String, Object> getBillsByUserRangeAndDateRange(List<String> userIds, int startYear, int startMonth, int endYear, int endMonth) {
        // 参数校验
        if (userIds == null || userIds.isEmpty()) {
            throw new IllegalArgumentException("用户ID列表不能为空");
        }
        if (startYear > endYear || (startYear == endYear && startMonth > endMonth)) {
            throw new IllegalArgumentException("时间范围参数非法");
        }

        // 查询所有符合条件的账单
        List<Bill> allBills = userIds.stream()
                .flatMap(userId -> billMapper.findBillsByDateRange(userId, startYear, startMonth, endYear, endMonth).stream())
                .collect(Collectors.toList());

        // 计算总费用
        BigDecimal totalAmount = allBills.stream()
                .map(Bill::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        // 构建返回结果
        Map<String, Object> result = new HashMap<>();
        result.put("bills", allBills);       // 符合条件的账单列表
        result.put("totalAmount", totalAmount); // 总费用
        return result;
    }

    // 7. 获取指定时间范围内的所有账单
    public List<Bill> findBillsByDateRange(String id, int startYear, int startMonth, int endYear, int endMonth) {
        if (id == null || startYear > endYear || (startYear == endYear && startMonth > endMonth)) {
            throw new IllegalArgumentException("时间范围参数非法");
        }
        return billMapper.findBillsByDateRange(id, startYear, startMonth, endYear, endMonth);
    }

    // 8. 根据账单号获取单个账单
    public Bill getBillByBillNumber(String billNumber) {
        if (billNumber == null || billNumber.isEmpty()) {
            throw new IllegalArgumentException("账单号不能为空");
        }
        return Optional.ofNullable(billMapper.getBillByBillNumber(billNumber))
                .orElseThrow(() -> new IllegalArgumentException("账单未找到"));
    }
}
