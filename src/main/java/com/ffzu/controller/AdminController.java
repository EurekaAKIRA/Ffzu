package com.ffzu.controller;

import com.ffzu.pojo.Admin;
import com.ffzu.pojo.Bill;
import com.ffzu.pojo.Result;
import com.ffzu.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    /**
     * 管理员登录接口
     *
     * @param admin 管理员对象（包含 id 和 password）
     * @return 返回登录结果
     */
    @PostMapping("/adminLogin")
    public Result<String> login(@RequestBody Admin admin) {
        Admin loggedInAdmin = adminService.login(admin.getId(), admin.getPassword());
        return Result.success("管理员登录成功，欢迎 " + loggedInAdmin.getId());
    }

    /**
     * 获取所有账单接口
     *
     * @return 返回所有账单列表
     */
    @GetMapping("/bills")
    public Result<List<Bill>> getAllBills() {
        List<Bill> bills = adminService.getAllBills();
        return Result.success(bills);
    }

    /**
     * 根据用户范围和日期范围查询账单
     *
     * @param requestData 包含 userIds, startYear, startMonth, endYear, endMonth
     * @return 返回符合条件的账单
     */
    @PostMapping("/bills/range")
    public Result<Map<String, Object>> getBillsByUserRangeAndDateRange(@RequestBody Map<String, Object> requestData) {
        @SuppressWarnings("unchecked")
        List<String> userIds = (List<String>) requestData.get("userIds");
        int startYear = (int) requestData.get("startYear");
        int startMonth = (int) requestData.get("startMonth");
        int endYear = (int) requestData.get("endYear");
        int endMonth = (int) requestData.get("endMonth");

        Map<String, Object> result = adminService.getBillsByUserRangeAndDateRange(userIds, startYear, startMonth, endYear, endMonth);
        return Result.success(result);
    }

    /**
     * 删除账单接口
     *
     * @param billNumber 要删除的账单编号
     * @return 返回删除结果
     */
    @DeleteMapping("/bill/{billNumber}")
    public Result<String> deleteBill(@PathVariable String billNumber) {
        adminService.deleteBill(billNumber);
        return Result.success("账单删除成功");
    }

    /**
     * 添加账单接口
     *
     * @param bill 要添加的账单对象
     * @return 返回添加结果
     */
    @PostMapping("/bill")
    public Result<String> addBill(@RequestBody Bill bill) {
        adminService.addBill(bill);
        return Result.success("账单添加成功");
    }

    /**
     * 修改账单接口
     *
     * @param updatedBill 修改后的账单对象
     * @return 返回修改结果
     */
    @PutMapping("/bill")
    public Result<String> updateBill(@RequestBody Bill updatedBill) {
        adminService.updateBill(updatedBill);
        return Result.success("账单修改成功");
    }
}
