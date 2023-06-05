/**
 * author     : geekplus
 * email      : geekcjj@gmail.com
 * date       : 5/10/23 20:17
 * description: 做什么的？
 */
package com.maike.common.utils.poi;

import com.maike.common.annotation.Excel;
import com.maike.common.utils.ServletUtils;
import com.maike.common.utils.StringUtils;
import com.maike.common.utils.file.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelUtils<T> {

    /**
     * Excel sheet最大行数，默认65536
     */
    public static final int sheetSize = 65536;

    /**
     * 实体对象
     */
    public Class<T> clazz;

    /**
     * 导入导出数据列表
     */
    private List<T> list;

    /**
     * 注解列表
     */
    private List<Object[]> fields;

    private static final String EXCEL_XLS = "xls";
    private static final String EXCEL_XLSX = "xlsx";

    public static void writeExcel(List<Map<String,String>> dataList, int cloumnCount,String finalXlsxPath){
        OutputStream out = null;
        try {
            // 获取总列数
            int columnNumCount = cloumnCount;
            // 读取Excel文档
            File finalXlsxFile = new File(finalXlsxPath);
            Workbook workBook = getWorkbok(finalXlsxFile);
            // sheet 对应一个工作页
            Sheet sheet = workBook.getSheetAt(0);
            /**
             * 删除原有数据，除了属性列
             */
            int rowNumber = sheet.getLastRowNum();    // 第一行从0开始算
            System.out.println("原始数据总行数，除属性列：" + rowNumber);
            for (int i = 1; i <= rowNumber; i++) {
                Row row = sheet.getRow(i);
                sheet.removeRow(row);
            }
            // 创建文件输出流，输出电子表格：这个必须有，否则你在sheet上做的任何操作都不会有效
            out =  new FileOutputStream(finalXlsxPath);
            workBook.write(out);
            /**
             * 往Excel中写新数据
             */
            for (int j = 0; j < dataList.size(); j++) {
                // 创建一行：从第二行开始，跳过属性列
                Row row = sheet.createRow(j + 1);
                // 得到要插入的每一条记录
                Map<String,String> dataMap = dataList.get(j);
                String name = dataMap.get("BankName").toString();
                String address = dataMap.get("Addr").toString();
                String phone = dataMap.get("Phone").toString();
                for (int k = 0; k <= columnNumCount; k++) {
                    // 在一行内循环
                    Cell first = row.createCell(0);
                    first.setCellValue(name);

                    Cell second = row.createCell(1);
                    second.setCellValue(address);

                    Cell third = row.createCell(2);
                    third.setCellValue(phone);
                }
            }
            // 创建文件输出流，准备输出电子表格：这个必须有，否则你在sheet上做的任何操作都不会有效
            out =  new FileOutputStream(finalXlsxPath);
            workBook.write(out);
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            try {
                if(out != null){
                    out.flush();
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("数据导出成功");
    }

    /**
     * 判断Excel的版本,获取Workbook
     * @param file
     * @return
     * @throws IOException
     */
    public static Workbook getWorkbok(File file) throws IOException{
        Workbook wb = null;
        FileInputStream in = new FileInputStream(file);
        if(file.getName().endsWith(EXCEL_XLS)){     //Excel&nbsp;2003
            wb = new HSSFWorkbook(in);
        }else if(file.getName().endsWith(EXCEL_XLSX)){    // Excel 2007/2010
            wb = new XSSFWorkbook(in);
        }
        return wb;
    }

    public void exportExcel(List<T> list) throws IOException {

        //1.在内存中创建一个excel文件
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
        //2.创建工作簿
        HSSFSheet sheet = hssfWorkbook.createSheet();

        // 有数据时才处理 得到类的所有field.
        Field[] allFields = clazz.getDeclaredFields();

        Row titlerRow = sheet.createRow(0);

        for(int i=0; i<allFields.length; i++){
            //3.创建标题行
            titlerRow.createCell(i).setCellValue(allFields[i].getName());
        }

        for (int i = 0; i < list.size(); i++){
//            int startNo = index * sheetSize;
//            int endNo = Math.min(startNo + sheetSize, list.size());
            Row row = sheet.createRow(i + 1);
            // 得到导出对象.
            T vo = (T) list.get(i-1);
            int column = 0;
            for(int c=0; c<allFields.length; c++){
                //3.创建标题行
                row.createCell(i).setCellValue(allFields[i].getName());
            }
//            for (Object[] os : fields)
//            {
//                Field field = (Field) os[0];
//                Excel excel = (Excel) os[1];
//                // 设置实体类私有属性可访问
//                field.setAccessible(true);
//                row.createCell(i).setCellValue(allFields[i].getName());
//                this.addCell(excel, row, vo, field, column++);
//            }
        }
        //4.遍历数据,创建数据行
//        for (T entity : list) {
//            //获取最后一行的行号
//            int lastRowNum = sheet.getLastRowNum();
//            HSSFRow dataRow = sheet.createRow(lastRowNum + 1);
//            dataRow.createCell(0).setCellValue(entity.);
//            dataRow.createCell(1).setCellValue(area.getCity());
//            dataRow.createCell(2).setCellValue(area.getDistrict());
//            dataRow.createCell(3).setCellValue(area.getPostcode());
//            dataRow.createCell(4).setCellValue(area.getShortcode());
//            dataRow.createCell(5).setCellValue(area.getCitycode());
//        }
        //5.创建文件名
        String fileName = "区域数据统计.xls";
        //6.获取输出流对象
        HttpServletResponse response = ServletUtils.getResponse();
        ServletOutputStream outputStream = response.getOutputStream();

        //7.获取mimeType
        ServletContext servletContext = ServletUtils.getServletContext();
        String mimeType = servletContext.getMimeType(fileName);
        //8.获取浏览器信息,对文件名进行重新编码
        HttpServletRequest request = ServletUtils.getRequest();
        fileName = FileUtils.filenameEncoding(fileName, request);

        //9.设置信息头
        response.setContentType(mimeType);
        response.setHeader("Content-Disposition","attachment;filename="+fileName);
        //10.写出文件,关闭流
        hssfWorkbook.write(outputStream);
        hssfWorkbook.close();
    }

    public List<?> importExcel(InputStream inputStream){

//        DecimalFormat df = new DecimalFormat("#");
//        double str = Double.parseDouble(row.getCell(5).toString());
//        String format = df.format(str);

        ArrayList<T> list = new ArrayList<>();
        try {
        //1、获取文件输入流
        //InputStream inputStream = new FileInputStream(path);
        //2、获取Excel工作簿对象
            HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
            //3、得到Excel工作表对象
            HSSFSheet sheetAt = workbook.getSheetAt(0);
//            int columnCount=sheetAt.get
            //4、循环读取表格数据
            for (Row row : sheetAt) {
                //continue;
                //首行（即表头）不读取
                if (row.getRowNum() == 0) {
                    // 定义一个map用于存放excel列的序号和field.
                    Map<String, Integer> cellMap = new HashMap<String, Integer>();
                    // 获取表头
//                    Row heard = sheet.getRow(0);
                    for (int i = 0; i < row.getPhysicalNumberOfCells(); i++)
                    {
                        Cell cell = row.getCell(i);
                        if (StringUtils.isNotNull(cell))
                        {
                            String value = row.getCell(i).toString();
                            cellMap.put(value, i);
                        }
                        else
                        {
                            cellMap.put(null, i);
                        }
                    }
                }
                // 有数据时才处理 得到类的所有field.
                Field[] allFields = clazz.getDeclaredFields();
                T entity=null;
                for (int k = 0; k <= allFields.length; k++) {
                    // 如果不存在实例则新建.
                    entity = (entity == null ? clazz.newInstance() : entity);
                    // 在每一行内循环
                    //读取当前行中单元格数据，索引从0开始
                    String value = row.getCell(k).getStringCellValue();
                }

                list.add(entity);
            }
            //5、关闭流
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return list;
    }
}
