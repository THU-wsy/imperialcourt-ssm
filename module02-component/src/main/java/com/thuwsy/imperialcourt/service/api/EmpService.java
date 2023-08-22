package com.thuwsy.imperialcourt.service.api;

import com.thuwsy.imperialcourt.entity.Emp;

/**
 * ClassName: EmpService
 * Package: com.thuwsy.imperialcourt.service.api
 * Description:
 *
 * @Author THU_wsy
 * @Create 2023/8/21 19:51
 * @Version 1.0
 */
public interface EmpService {

    Emp getEmpByLoginAccount(String loginAccount, String loginPassword);
}
