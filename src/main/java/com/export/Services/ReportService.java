package com.export.Services;


import com.export.Repository.CourseRepository;
import com.export.model.Course;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class ReportService {
    @Autowired(required = true)
    CourseRepository courseRepository;
    public void generateExcel(HttpServletResponse response) throws IOException {
       List<Course> courses= courseRepository.findAllCuurse();
        HSSFWorkbook workbook =new HSSFWorkbook();
        HSSFSheet sheet =workbook.createSheet("Course-Info");
        HSSFRow row =sheet.createRow(0);
        row.createCell(0).setCellValue("ID");
        row.createCell(1).setCellValue("Name");
        row.createCell(2).setCellValue("Price");

        int dataRowIndex=1;
        for(Course course:courses){
            HSSFRow dataRow= sheet.createRow(dataRowIndex);
            dataRow.createCell(0).setCellValue(course.getCid());
            dataRow.createCell(1).setCellValue(course.getName());
            dataRow.createCell(2).setCellValue(course.getPrice());
            dataRowIndex ++;
        }
        ServletOutputStream ops= response.getOutputStream();
        workbook.write(ops);
        workbook.close();
        ops.close();

    }
}
