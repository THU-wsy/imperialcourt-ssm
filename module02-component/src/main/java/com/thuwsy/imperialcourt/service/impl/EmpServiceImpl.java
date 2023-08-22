package com.thuwsy.imperialcourt.service.impl;

import com.thuwsy.imperialcourt.entity.Emp;
import com.thuwsy.imperialcourt.exception.LoginFailedException;
import com.thuwsy.imperialcourt.mapper.EmpMapper;
import com.thuwsy.imperialcourt.service.api.EmpService;
import com.thuwsy.imperialcourt.util.ImperialCourtConst;
import com.thuwsy.imperialcourt.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * ClassName: EmpServiceImpl
 * Package: com.thuwsy.imperialcourt.service.impl
 * Description:
 *
 * @Author THU_wsy
 * @Create 2023/8/21 19:52
 * @Version 1.0
 */
@Service
@Transactional(readOnly = true)
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;

    @Override
    public Emp getEmpByLoginAccount(String loginAccount, String loginPassword) {
        // 1、对密码执行加密
        String encodedLoginPassword = MD5Util.encode(loginPassword);

        // 2、根据账户和加密密码查询数据库
        Emp emp = empMapper.selectEmpByLoginAccount(loginAccount, encodedLoginPassword);

        return emp;
    }
}
