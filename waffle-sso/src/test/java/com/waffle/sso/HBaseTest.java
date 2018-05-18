package com.waffle.sso;

import com.waffle.component.hbase.beans.HBaseTemplate;
import com.waffle.component.hbase.config.HBaseProperties;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author yuexin
 */
public class HBaseTest extends ApplicationTests {

    @Autowired
    private HBaseProperties hBaseProperties;

    @Autowired
    private HBaseTemplate hBaseTemplate;

    //    @Test
    public void testCreateTable() {
        hBaseTemplate.createTable("foo", "bar");
    }

    //    @Test
    public void testDropTable() {
        hBaseTemplate.dropTable("foo");
    }


}
