package com.online;

import com.online.edu.eduservice.EduApp;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileOutputStream;
import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= EduApp.class)
public class ExcelTest {
    @Test
    public void excelWrite() throws IOException {
        // 创建新的Excel 工作簿
        Workbook workbook = new HSSFWorkbook();

        // 在Excel工作簿中建一工作表，其名为缺省值 Sheet0
        //Sheet sheet = workbook.createSheet();

        // 如要新建一名为"会员登录统计"的工作表，其语句为：
        Sheet sheet = workbook.createSheet("会员登录统计");

        // 创建行（row 1）
        Row row1 = sheet.createRow(0);

        // 创建单元格（col 1-1）
        Cell cell11 = row1.createCell(0);
        cell11.setCellValue("今日人数");

        // 创建单元格（col 1-2）
        Cell cell12 = row1.createCell(1);
        cell12.setCellValue(666);

        // 创建行（row 2）
        Row row2 = sheet.createRow(1);

        // 创建单元格（col 2-1）
        Cell cell21 = row2.createCell(0);
        cell21.setCellValue("统计时间");

        //创建单元格（第三列）
        Cell cell22 = row2.createCell(1);
        String dateTime =  new DateTime().toString("yyyy-MM-dd HH:mm:ss");
        cell22.setCellValue(dateTime);

        // 新建一输出文件流（注意：要先创建文件夹）
        FileOutputStream out = new FileOutputStream("D:/BaiduNetdiskDownload/web/test-write03.xls");
        // 把相应的Excel 工作簿存盘
        workbook.write(out);
        // 操作结束，关闭文件
        out.close();

        System.out.println("文件生成成功");
    }

}

