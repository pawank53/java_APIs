package com.export.controller;

import com.export.Services.ReportService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/report")
public class ReportController {

    @Autowired
    ReportService reportService;

    @GetMapping("/excel")
    public  void generateExcelReport(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        String headerKey="Content-Disposition";
        String headerValue="attachment;filename=courses.xls";
        response.setHeader(headerKey, headerValue);
        reportService.generateExcel(response);
    }

}
