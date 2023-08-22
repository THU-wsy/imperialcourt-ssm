package com.thuwsy.imperialcourt.controller;

import com.thuwsy.imperialcourt.entity.Memorials;
import com.thuwsy.imperialcourt.service.api.MemorialsService;
import com.thuwsy.imperialcourt.util.ImperialCourtConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * ClassName: WorkController
 * Package: com.thuwsy.imperialcourt.controller
 * Description:
 *
 * @Author THU_wsy
 * @Create 2023/8/21 21:30
 * @Version 1.0
 */
@Controller
public class WorkController {
    @Autowired
    private MemorialsService memorialsService;

    @GetMapping("/work/show")
    public String showMemorialsDigestList(Model model, HttpSession httpSession) {
        Object loginEmp = httpSession.getAttribute(ImperialCourtConst.LOGIN_EMP_ATTR_NAME);
        if (loginEmp == null) {
            model.addAttribute("systemMessage", ImperialCourtConst.ACCESS_DENIED_MESSAGE);
            return "index";
        }

        // 1、调用Service方法查询数据
        List<Memorials> memorialsList = memorialsService.getAllMemorialsDigest();

        // 2、将查询得到的数据存入请求域
        model.addAttribute("memorialsList", memorialsList);

        // 3、渲染视图
        return "memorials-list";
    }

    @GetMapping("/work/show/{id}")
    public String showMemorialsDetail(@PathVariable("id") String memorialsId, Model model, HttpSession httpSession) {
        Object loginEmp = httpSession.getAttribute(ImperialCourtConst.LOGIN_EMP_ATTR_NAME);
        if (loginEmp == null) {
            model.addAttribute("systemMessage", ImperialCourtConst.ACCESS_DENIED_MESSAGE);
            return "index";
        }

        // 根据memorialsId从Service中查询Memorials对象
        Memorials memorials = memorialsService.getMemorialDetailById(memorialsId);

        // 补充功能
        // 获取当前奏折对象的状态
        Integer memorialsStatus = memorials.getMemorialsStatus();
        // 判断奏折状态，如果是未读，则更新为已读
        if (memorialsStatus == 0) {
            // 数据库中更新状态为已读
            memorialsService.updateMemorialsStatusToRead(memorialsId);
            // 当前对象更新状态为已读
            memorials.setMemorialsStatus(1);
        }

        // 将Memorials对象存入请求域
        model.addAttribute("memorials", memorials);

        // 解析渲染视图
        return "memorials_detail";
    }

    @PostMapping("/work/feed/{id}")
    public String feedBack(@PathVariable("id") String memorialsId, String feedbackContent, HttpSession httpSession, Model model) {
        Object loginEmp = httpSession.getAttribute(ImperialCourtConst.LOGIN_EMP_ATTR_NAME);
        if (loginEmp == null) {
            model.addAttribute("systemMessage", ImperialCourtConst.ACCESS_DENIED_MESSAGE);
            return "index";
        }

        // 执行更新
        memorialsService.updateMemorialsFeedBack(memorialsId, feedbackContent);

        // 重定向回显示奏折列表页面
        return "redirect:/work/show";
    }
}
