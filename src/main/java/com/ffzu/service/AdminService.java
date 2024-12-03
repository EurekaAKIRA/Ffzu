package com.ffzu.service;

import com.ffzu.mapper.AdminMapper;
import com.ffzu.pojo.Admin;
import com.ffzu.pojo.Bill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private BillService billService; // 调用 BillService 提供的方法

    // 管理员登录
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

    // 获取所有账单
    public List<Bill> getAllBills() {
        return billService.getAllBills();
    }

    // 删除账单
    public void deleteBill(String billNumber) {
        billService.deleteBill(billNumber);
    }

    // 添加账单
    public void addBill(Bill bill) {
        billService.addBill(bill);
    }

    // 修改账单
    public void updateBill(Bill updatedBill) {
        billService.updateBill(updatedBill);
    }

    // 获取指定用户范围和时间范围的账单及总金额
    public Map<String, Object> getBillsByUserRangeAndDateRange(List<String> userIds, int startYear, int startMonth, int endYear, int endMonth) {
        return billService.getBillsByUserRangeAndDateRange(userIds, startYear, startMonth, endYear, endMonth);
    }
}
