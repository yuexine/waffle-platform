package com.waffle.hbase;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CellUtil;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.filter.CompareFilter;
import org.apache.hadoop.hbase.filter.Filter;
import org.apache.hadoop.hbase.filter.RegexStringComparator;
import org.apache.hadoop.hbase.filter.ValueFilter;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/**
 * @author yuexin
 */
public class HBaseOperaterTest {

    private static final String HBASE_QUORUM = "hbase.zookeeper.quorum";

    private Table table;

    private Connection connection;

    //    @Before
    public void init() throws IOException {
        Configuration configuration = new Configuration();
        connection = ConnectionFactory.createConnection(configuration);
        configuration.set(HBASE_QUORUM, "localhost");
        configuration.set("hbase.zookeeper.property.clientPort", "2181");
        table = connection.getTable(TableName.valueOf("users"));
    }


    //    @After
    public void destroy() throws IOException {
        table.close();
        connection.close();
    }

    //    @Test
    public void testGet() throws IOException {
        Get get = new Get(Bytes.toBytes("ii"));
        Result result = table.get(get);
        List<Cell> cells = result.getColumnCells("info".getBytes(), "name".getBytes());
        for (Cell cell : cells) {
            System.out.println(Bytes.toLong(CellUtil.cloneValue(cell)));
        }
    }

    //    @Test
    public void operate() throws IOException {
        for (int i = 0; i < 100; i++) {
            Put p = new Put(Bytes.toBytes("foo_" + i));
            p.addColumn(Bytes.toBytes("info"), Bytes.toBytes("name"), Bytes.toBytes("roys_" + i));
//        p.addColumn(Bytes.toBytes("info"), Bytes.toBytes("name"), Bytes.toBytes("zhangsan"));
//        p.addColumn(Bytes.toBytes("info"), Bytes.toBytes("age"), Bytes.toBytes("16"));
            table.put(p);
        }

    }

    //    @Test
    public void testDelete() throws IOException {
        Delete d = new Delete("foo".getBytes());
        table.delete(d);
    }

    //    @Test
    public void testScan() throws IOException {
        Scan scan = new Scan("foo_2".getBytes(), "foo_3".getBytes());
        Filter filter = new ValueFilter(CompareFilter.CompareOp.EQUAL, new RegexStringComparator("roys_26"));
        scan.setFilter(filter);
        ResultScanner scanner = table.getScanner(scan);
        Iterator<Result> iterator = scanner.iterator();
        while (iterator.hasNext()) {
            Result r = iterator.next();
            List<Cell> cellList = r.getColumnCells("info".getBytes(), "name".getBytes());
            System.out.println(Bytes.toString(CellUtil.cloneValue(cellList.get(0))));
        }
    }

    //    @Test
    public void testIncrement() throws IOException {
        long c = table.incrementColumnValue("ii".getBytes(), "info".getBytes(), "name".getBytes(), 1L);
        System.out.println(c);
    }
}
