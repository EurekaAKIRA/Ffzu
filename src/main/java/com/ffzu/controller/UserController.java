package com.ffzu.controller;

import com.ffzu.pojo.Result;
import com.ffzu.pojo.User;
import com.ffzu.request.UserRangeAndDateRange;
import com.ffzu.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private HttpSession session; // 注入 HttpSession

    /**
     * 用户登录接口
     *
     * @param user 包含用户 ID 和密码的对象
     * @return 登录结果
     */
    @PostMapping("/login")
    public Result<String> login(@RequestBody User user) {
        // 验证用户登录
        User loggedUser = userService.login(user.getId(), user.getPassword());

        // 将用户信息存入会话
        session.setAttribute("currentUser", loggedUser);

        return Result.success("登录成功，欢迎 " + loggedUser.getId());
    }


    /**
     * 根据用户范围和日期范围查询账单并返回符合条件的账单和总水电费接口
     *
     * @param request 包含用户ID列表和时间范围的请求对象
     *                - userIds: 用户ID由系统自动填充
     *                - startYear: 起始年份
     *                - startMonth: 起始月份
     *                - endYear: 结束年份
     *                - endMonth: 结束月份
     * @return Result<Map < String, Object>> 返回符合条件的账单和总金额：
     * - bills: 符合条件的账单列表
     * - totalAmount: 符合条件的账单总金额
     */

    @GetMapping("/billInfo")
    public Result getBillInfo(@ModelAttribute UserRangeAndDateRange request) {
        // 从会话中获取当前用户
        User currentUser = (User) session.getAttribute("currentUser");
        if (currentUser == null) {
            return Result.error("用户未登录");
        }

        request.setUserIds(List.of(currentUser.getId())); // 设置用户 ID 列表
        List<String> userId = request.getUserIds();
        int startYear = request.getStartYear();
        int startMonth = request.getStartMonth();
        int endYear = request.getEndYear();
        int endMonth = request.getEndMonth();

        // 调用服务获取账单列表和总金额
        Map<String, Object> result = userService.getBillsByUserRangeAndDateRange(userId, startYear, startMonth, endYear, endMonth);
        return Result.success(result);
    }

//    /**
//     * 根据账单编号获取账单
//     *
//     * @param requestData 包含 billNumber 的 Map
//     * @return 返回账单详情
//     */
//    @PostMapping("/bill")
//    public Result<Bill> getBillByBillNumber(@RequestBody Map<String, Object> requestData) {
//        String billNumber = (String) requestData.get("billNumber");
//        Bill bill = billService.getBillByBillNumber(billNumber);
//        return Result.success(bill);
//    }

}