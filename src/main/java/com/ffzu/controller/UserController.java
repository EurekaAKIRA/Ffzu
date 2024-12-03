package com.ffzu.controller;

import com.ffzu.pojo.Bill;
import com.ffzu.pojo.Result;
import com.ffzu.pojo.User;
import com.ffzu.service.BillService;
import com.ffzu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private BillService billService;

    /**
     * 用户登录接口
     *
     * @param user
     * @return 登录结果
     */
    @PostMapping("/login")
    public Result<String> login(@RequestBody User user) {
        User loggedUser = userService.login(user.getId(), user.getPassword());
        return Result.success("登录成功，欢迎 " + loggedUser.getId());
    }

    /**
     * 获取用户账单信息
     *
     * @param requestData 包含 id, startYear, startMonth, endYear, endMonth 的 Map
     * @return 账单信息和总金额
     */
    @PostMapping("/billInfo")
    public Result<Map<String, Object>> getBillInfo(@RequestBody Map<String, Object> requestData) {
        String id = (String) requestData.get("id");
        int startYear = (int) requestData.get("startYear");
        int startMonth = (int) requestData.get("startMonth");
        int endYear = (int) requestData.get("endYear");
        int endMonth = (int) requestData.get("endMonth");

        List<Bill> bills = userService.getBillsByDateRange(id, startYear, startMonth, endYear, endMonth);
        BigDecimal totalAmount = bills.stream()
                .map(Bill::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return Result.success(Map.of(
                "bills", bills,
                "totalAmount", totalAmount
        ));
    }

    /**
     * 根据账单编号获取账单
     *
     * @param requestData 包含 billNumber 的 Map
     * @return 返回账单详情
     */
    @PostMapping("/bill")
    public Result<Bill> getBillByBillNumber(@RequestBody Map<String, Object> requestData) {
        String billNumber = (String) requestData.get("billNumber");
        Bill bill = billService.getBillByBillNumber(billNumber);
        return Result.success(bill);
    }
}
