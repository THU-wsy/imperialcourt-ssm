package com.thuwsy.imperialcourt.controller;

import com.thuwsy.imperialcourt.entity.Emp;
import com.thuwsy.imperialcourt.service.api.EmpService;
import com.thuwsy.imperialcourt.util.ImperialCourtConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * ClassName: AuthController
 * Package: com.thuwsy.imperialcourt.controller
 * Description:
 *
 * @Author THU_wsy
 * @Create 2023/8/21 19:47
 * @Version 1.0
 */
@Controller
public class AuthController {
    @Autowired
    private EmpService empService;

    @PostMapping("/auth/login")
    public String login(
            @RequestParam("loginAccount") String loginAccount,
            @RequestParam("loginPassword") String loginPassword,
            HttpSession httpSession,
            Model model) {
        Emp emp = empService.getEmpByLoginAccount(loginAccount, loginPassword);
        if (emp == null) {
            model.addAttribute("message", ImperialCourtConst.LOGIN_FAILED_MESSAGE);
            return "index";
        } else {
            httpSession.setAttribute(ImperialCourtConst.LOGIN_EMP_ATTR_NAME, emp);
            return "redirect:/work/show";
        }
    }

    @GetMapping("/auth/logout")
    public String logout(HttpSession httpSession) {
        // 1、将HttpSession对象强制失效
        httpSession.invalidate();

        // 2、回到首页
        return "index";
    }
}
