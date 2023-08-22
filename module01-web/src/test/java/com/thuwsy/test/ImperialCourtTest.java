package com.thuwsy.test;

import com.thuwsy.imperialcourt.mapper.EmpMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * ClassName: ImperialCourtTest
 * Package: com.thuwsy.test
 * Description:
 *
 * @Author THU_wsy
 * @Create 2023/8/21 18:55
 * @Version 1.0
 */
// Spring 和 junit5整合
@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:spring-persist.xml")
public class ImperialCourtTest {
    @Autowired
    private DataSource dataSource;
    @Autowired
    private EmpMapper empMapper;

    @Test
    public void testDataSource() throws SQLException {
        Connection conn = dataSource.getConnection();
        System.out.println("conn = " + conn);
    }
    @Test
    public void testEmpMapper() {

    }
}
