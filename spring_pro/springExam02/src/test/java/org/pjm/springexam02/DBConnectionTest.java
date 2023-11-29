package org.pjm.springexam02;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;
import java.sql.Connection;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:/root-context.xml")
public class DBConnectionTest {
    @Autowired
    private DataSource dataSource;

    @Test
    public void testConnect() throws Exception {
        Connection connection = dataSource.getConnection();
        log.info(connection);
        connection.close();
    }
}