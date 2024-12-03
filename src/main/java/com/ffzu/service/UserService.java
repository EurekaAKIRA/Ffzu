package com.ffzu.service;

import com.ffzu.mapper.BillMapper;
import com.ffzu.mapper.UserMapper;
import com.ffzu.pojo.User;
import com.ffzu.pojo.Bill;
import com.ffzu.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;


    @Autowired
    private BillService billService;


    // 1. 登录接口
    public User login(String id, String password) {
        User user = userMapper.getUserById(id);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        throw new IllegalArgumentException("账号或密码错误");
    }


//    // 查询本宿舍指定年月范围内的所有账单并返回账单信息
//    public List<Bill> getBillsByDateRange(String id, int startYear, int startMonth, int endYear, int endMonth) {
//        // 通过实例化的 BillMapper 查询数据
//        return billMapper.findBillsByDateRange(id, startYear, startMonth, endYear, endMonth);
//    }

    public Map<String, Object> getBillsByUserRangeAndDateRange(List<String> userIds, int startYear, int startMonth, int endYear, int endMonth) {
        return billService.getBillsByUserRangeAndDateRange(userIds, startYear, startMonth, endYear, endMonth);
    }
}
