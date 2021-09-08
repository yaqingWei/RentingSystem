package com.controller;

import com.domain.Tbl_Fwxx;
import com.service.Tbl_FwxxService;
import com.sun.net.httpserver.Headers;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.spi.http.HttpContext;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @author Xiaobo
 * @create 2021-09-08 9:48
 * Excel处理
 */
@Controller
public class poiController {
    @Autowired
    private Tbl_FwxxService tbl_fwxxService;
    
    @RequestMapping(value = "/downLoadModel", produces = "application/msexcel")
    public ResponseEntity<byte[]> downLoadModel() throws IOException {
        InputStream inputStream = poiController.class.getClassLoader().getResourceAsStream("房屋报表.xls");
        POIFSFileSystem fileSystem = new POIFSFileSystem(inputStream);
        HSSFWorkbook workbook = new HSSFWorkbook(fileSystem);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        workbook.write(out);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentDispositionFormData("attachement", new String("房屋模板.xls".getBytes(StandardCharsets.UTF_8), "iso-8859-1"));
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(out.toByteArray(), headers, HttpStatus.OK);
        return responseEntity;
    }

    @RequestMapping(value = "/exportModel", produces = "application/msexcel")
    public ResponseEntity<byte[]> exportModel() throws Exception {
        InputStream inputStream = poiController.class.getClassLoader().getResourceAsStream("房屋报表.xls");
        POIFSFileSystem fileSystem = new POIFSFileSystem(inputStream);
        HSSFWorkbook workbook = new HSSFWorkbook(fileSystem);
        List<Tbl_Fwxx> all = tbl_fwxxService.findAll();
        HSSFSheet sheet = workbook.getSheetAt(0);
        for (int i = 0; i <all.size(); i++) {
            HSSFCellStyle cellStyle = workbook.createCellStyle();
            cellStyle.setAlignment(HorizontalAlignment.CENTER);
            cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
            Tbl_Fwxx tbl_fwxx = all.get(i);
            HSSFRow row = sheet.createRow(i + 1);

            HSSFCell cell0 = row.createCell(0);
            cell0.setCellStyle(cellStyle);
            cell0.setCellValue(tbl_fwxx.getFwid());

            HSSFCell cell1 = row.createCell(1);
            cell1.setCellValue(tbl_fwxx.getTbl_user().getUname());
            cell1.setCellStyle(cellStyle);

            HSSFCell cell2 = row.createCell(2);
            cell2.setCellValue(tbl_fwxx.getTbl_jd()==null?"未知":tbl_fwxx.getTbl_jd().getJd());
            cell2.setCellStyle(cellStyle);

            HSSFCell cell3 = row.createCell(3);
            cell3.setCellValue(tbl_fwxx.getTbl_qx().getQx());
            cell3.setCellStyle(cellStyle);

            HSSFCell cell4 = row.createCell(4);
            cell4.setCellValue(tbl_fwxx.getTbl_fwlx().getFwlx());
            cell4.setCellStyle(cellStyle);

            HSSFCell cell5 = row.createCell(5);
            cell5.setCellValue(tbl_fwxx.getShi());
            cell5.setCellStyle(cellStyle);

            HSSFCell cell6= row.createCell(6);
            cell6.setCellValue(tbl_fwxx.getTing());
            cell6.setCellStyle(cellStyle);

            HSSFCell cell7 = row.createCell(7);
            cell7.setCellValue(tbl_fwxx.getFwxx());
            cell7.setCellStyle(cellStyle);

            HSSFCell cell8 = row.createCell(8);
            cell8.setCellValue(tbl_fwxx.getZj());
            cellStyle.setDataFormat(workbook.createDataFormat().getFormat("#,###.00"));
            cell8.setCellStyle(cellStyle);

            HSSFCell cell9 = row.createCell(9);
            cell9.setCellValue(tbl_fwxx.getTitle());
            cell9.setCellStyle(cellStyle);

            HSSFCell cell10 = row.createCell(10);
            cell10.setCellValue(tbl_fwxx.getDate());
            cellStyle.setDataFormat(workbook.createDataFormat().getFormat("yyyy-MM-dd HH:mm:ss"));
            cell10.setCellStyle(cellStyle);

            HSSFCell cell11 = row.createCell(11);
            cell11.setCellValue(tbl_fwxx.getTelephone());
            cell11.setCellStyle(cellStyle);

            HSSFCell cell12 = row.createCell(12);
            cell12.setCellValue(tbl_fwxx.getLxr());
            cell12.setCellStyle(cellStyle);
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        workbook.write(byteArrayOutputStream);
        HttpHeaders headers=new HttpHeaders();
        headers.setContentDispositionFormData("attachment",new String("房屋报表.xls".getBytes(StandardCharsets.UTF_8),"iso-8859-1"));
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<byte[]>(byteArrayOutputStream.toByteArray(),headers,HttpStatus.OK);
        return responseEntity;
    }
    @RequestMapping(value = "/importModel",produces = "application/msexcel")
    public void importModel(MultipartFile model) throws Exception {
        InputStream inputStream = model.getInputStream();
        POIFSFileSystem fileSystem=new POIFSFileSystem(inputStream);
        HSSFWorkbook workbook = new HSSFWorkbook(fileSystem);
        Tbl_Fwxx tbl_fwxx = new Tbl_Fwxx();
        HSSFSheet sheetAt = workbook.getSheetAt(0);
        for (int i = 1; i < sheetAt.getLastRowNum(); i++) {
            HSSFRow row = sheetAt.getRow(i);
            if(row==null){
                continue;
            }
            HSSFCell cell = row.getCell(0);

        }
    }
}
