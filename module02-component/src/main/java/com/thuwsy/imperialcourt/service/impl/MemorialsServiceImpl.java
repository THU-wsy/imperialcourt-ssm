package com.thuwsy.imperialcourt.service.impl;

import com.thuwsy.imperialcourt.entity.Memorials;
import com.thuwsy.imperialcourt.mapper.MemorialsMapper;
import com.thuwsy.imperialcourt.service.api.MemorialsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * ClassName: MemorialsServiceImpl
 * Package: com.thuwsy.imperialcourt.service.impl
 * Description:
 *
 * @Author THU_wsy
 * @Create 2023/8/21 20:41
 * @Version 1.0
 */
@Service
@Transactional
public class MemorialsServiceImpl implements MemorialsService {
    @Autowired
    private MemorialsMapper memorialsMapper;
    @Override
    public List<Memorials> getAllMemorialsDigest() {
        return memorialsMapper.selectAllMemorialsDigest();
    }

    @Override
    public Memorials getMemorialDetailById(String memorialsId) {
        return memorialsMapper.selectMemorialsById(memorialsId);
    }

    @Override
    public void updateMemorialsStatusToRead(String memorialsId) {
        memorialsMapper.updateMemorialsStatusToRead(memorialsId);
    }

    @Override
    public void updateMemorialsFeedBack(String memorialsId, String feedbackContent) {
        memorialsMapper.updateMemorialsFeedBack(memorialsId, feedbackContent);
    }
}
