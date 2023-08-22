package com.thuwsy.imperialcourt.mapper;

import com.thuwsy.imperialcourt.entity.Memorials;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * ClassName: MemorialsMapper
 * Package: com.thuwsy.imperialcourt.mapper
 * Description:
 *
 * @Author THU_wsy
 * @Create 2023/8/21 18:32
 * @Version 1.0
 */
public interface MemorialsMapper {
    List<Memorials> selectAllMemorialsDigest();

    Memorials selectMemorialsById(@Param("memorialsId") String memorialsId);

    void updateMemorialsStatusToRead(@Param("memorialsId") String memorialsId);

    void updateMemorialsFeedBack(@Param("memorialsId") String memorialsId, @Param("feedbackContent") String feedbackContent);
}
