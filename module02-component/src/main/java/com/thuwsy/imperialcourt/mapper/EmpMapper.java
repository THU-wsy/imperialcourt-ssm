package com.thuwsy.imperialcourt.mapper;

import com.thuwsy.imperialcourt.entity.Emp;
import org.apache.ibatis.annotations.Param;

/**
 * ClassName: EmpMapper
 * Package: com.thuwsy.imperialcourt.mapper
 * Description:
 *
 * @Author THU_wsy
 * @Create 2023/8/21 18:32
 * @Version 1.0
 */
public interface EmpMapper {
    Emp selectEmpByLoginAccount(@Param("loginAccount") String loginAccount, @Param("encodedLoginPassword") String encodedLoginPassword);
}
