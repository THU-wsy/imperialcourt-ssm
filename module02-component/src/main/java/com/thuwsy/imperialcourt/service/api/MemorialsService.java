package com.thuwsy.imperialcourt.service.api;

import com.thuwsy.imperialcourt.entity.Memorials;

import java.util.List;

/**
 * ClassName: MemorialsService
 * Package: com.thuwsy.imperialcourt.service.api
 * Description:
 *
 * @Author THU_wsy
 * @Create 2023/8/21 20:41
 * @Version 1.0
 */
public interface MemorialsService {
    List<Memorials> getAllMemorialsDigest();

    Memorials getMemorialDetailById(String memorialsId);

    void updateMemorialsStatusToRead(String memorialsId);

    void updateMemorialsFeedBack(String memorialsId, String feedbackContent);
}
