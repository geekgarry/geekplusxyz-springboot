package com.maike.common.utils.file;

import com.maike.common.config.MaikeConfig;
import com.maike.common.constant.Constants;
import sun.misc.BASE64Encoder;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * @ClassName: FileUtils
 * @Description:
 * @author: WeiZheng
 * @date: 2018年8月30日 下午4:24:30
 */
public class FileUtils {

    public static String FILENAME_PATTERN = "[a-zA-Z0-9_\\-\\|\\.\\u4e00-\\u9fa5]+";

    /**
     * 输出指定文件的byte数组
     *
     * @param filePath 文件路径
     * @param os 输出流
     * @return
     */
    public static void writeBytes(String filePath, OutputStream os) throws IOException
    {
        FileInputStream fis = null;
        try
        {
            File file = new File(filePath);
            if (!file.exists())
            {
                throw new FileNotFoundException(filePath);
            }
            fis = new FileInputStream(file);
            byte[] b = new byte[1024];
            int length;
            while ((length = fis.read(b)) > 0)
            {
                os.write(b, 0, length);
            }
        }
        catch (IOException e)
        {
            throw e;
        }
        finally
        {
            if (os != null)
            {
                try
                {
                    os.close();
                }
                catch (IOException e1)
                {
                    e1.printStackTrace();
                }
            }
            if (fis != null)
            {
                try
                {
                    fis.close();
                }
                catch (IOException e1)
                {
                    e1.printStackTrace();
                }
            }
        }
    }

    /**
     * 删除文件
     *
     * @param filePath 文件
     * @return
     */
    public static boolean deleteFile(String filePath)
    {
        boolean flag = false;
        File file = new File(filePath);
        // 路径为文件且不为空则进行删除
        if (file.isFile() && file.exists())
        {
            file.delete();
            flag = true;
        }
        return flag;
    }

    public static int deleteFileCategory(String filePath){
        int flag=0;
        File file = new File(filePath);
        // 路径为文件且不为空则进行删除
        if (file.isFile() && file.exists())
        {
            file.delete();
            flag = 1;
        }
        //File[] listFiles = file.listFiles();
//        if(listFiles != null)
//        {
//            for(File f: listFiles)
//            {
//                if(f.isDirectory())
//                {
//                    flag=deleteFileCategory(f.getAbsolutePath());
//                }
//                else
//                {
//                    f.delete();
//                    flag=true;
//                }
//            }
//        }
        return flag;
    }

    /**
     * 文件名称验证
     *
     * @param filename 文件名称
     * @return true 正常 false 非法
     */
    public static boolean isValidFilename(String filename)
    {
        return filename.matches(FILENAME_PATTERN);
    }

    /**
     * 下载文件名重新编码
     *
     * @param request 请求对象
     * @param fileName 文件名
     * @return 编码后的文件名
     */
    public static String setFileDownloadHeader(HttpServletRequest request, String fileName)
            throws UnsupportedEncodingException
    {
        final String agent = request.getHeader("USER-AGENT");
        String filename = fileName;
        if (agent.contains("MSIE"))
        {
            // IE浏览器
            filename = URLEncoder.encode(filename, "utf-8");
            filename = filename.replace("+", " ");
        }
        else if (agent.contains("Firefox"))
        {
            // 火狐浏览器
            filename = new String(fileName.getBytes(), "ISO8859-1");
        }
        else if (agent.contains("Chrome"))
        {
            // google浏览器
            filename = URLEncoder.encode(filename, "utf-8");
        }
        else
        {
            // 其它浏览器
            filename = URLEncoder.encode(filename, "utf-8");
        }
        return filename;
    }

    /**
     * 百分号编码工具方法
     *
     * @param s 需要百分号编码的字符串
     * @return 百分号编码后的字符串
     */
    public static String percentEncode(String s) throws UnsupportedEncodingException
    {
        String encode = URLEncoder.encode(s, StandardCharsets.UTF_8.toString());
        return encode.replaceAll("\\+", "%20");
    }

    /** * 读取某个文件夹下的所有文件夹和文件 */
    public static List<Map> readFileList(String filepath) throws IOException {
        List<Map> listFile=new ArrayList<>();

        File file = new File(filepath);
        if (!file.isDirectory()) {
            Map<String,Object> map=new Hashtable<>();
            //Map<String,Object> map=new Hashtable<>();
            //type=file为文件，type=folder为文件夹
            map.put("type","file");
            map.put("path",file.getPath());
            //map.put("time",file.getFreeSpace());
            map.put("filePath",file.getAbsolutePath().replace(MaikeConfig.getFilePath()+File.separator,""));
            map.put("fileName",file.getName());
            listFile.add(map);
        } else {
            String[] fileList = file.list();
            for (int i = 0; i < fileList.length; i++) { //\\反斜杠是转译字符
                Map<String,Object> mapp=new Hashtable<>();
                File readFile = new File(filepath + File.separator + fileList[i]);
                if(readFile.isDirectory()){
                    //Map<String,Object> map=new Hashtable<>();
                    //type=file为文件，type=folder为文件夹
                    mapp.put("type","folder");
                }else {
                    //Map<String,Object> map=new Hashtable<>();
                    //type=file为文件，type=folder为文件夹
                    mapp.put("type", "file");
                }
                mapp.put("path",file.getPath());
                mapp.put("filePath",readFile.getAbsolutePath().replace(MaikeConfig.getFilePath()+File.separator,""));
                mapp.put("fileName",readFile.getName());
                listFile.add(mapp);
            }
        }
//        sortRes = listFile.stream().sorted(Comparator.comparing(Map::map.get("fileName"))).collect(Collectors.toList());
        //取到文件夹内所有文件，在根据后缀过滤(按.分割)，然后路径加上文件名就是一个图片的地址了。
        //返回值用list或者拼接的字符串去前台解析也可以。
        return listFile;
    }

    /** * 读取某个文件夹下的所有图片文件 */
    public static List<String> readFileImage(String filepath,String folder) throws FileNotFoundException, IOException {
        List<String> listImage=new ArrayList<>();
        try {
            File file = new File(filepath+folder);
            if (!file.isDirectory()) {
//                System.out.println("文件");
//                System.out.println("path=" + file.getPath());
//                System.out.println("absolutePath=" + file.getAbsolutePath());
//                System.out.println("name=" + file.getName());
                if(isImage(file.getPath())) {
                    listImage.add(Constants.RESOURCE_PREFIX + folder + File.separator +file.getName());
                }
            } else if (file.isDirectory()) {
                String[] fileList = file.list();
                for (int i = 0; i < fileList.length; i++) { //\\反斜杠是转译字符
                    File readFile = new File(filepath + folder + File.separator + fileList[i]);
                    if (!readFile.isDirectory()) {
//                        System.out.println("path=" + readFile.getPath());
//                        System.out.println("absolutePath=" + readFile.getAbsolutePath());
//                        System.out.println("name=" + readFile.getName());
                        if(isImage(readFile.getPath())) {
                            listImage.add(Constants.RESOURCE_PREFIX + folder + File.separator +readFile.getName());
                        }
                    } else if (readFile.isDirectory()) {
                        readFileImage(filepath+ folder, File.separator + fileList[i]);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("readFile() Exception:" + e.getMessage());
        }
        //取到文件夹内所有文件，在根据后缀过滤(按.分割)，然后路径加上文件名就是一个图片的地址了。
        //返回值用list或者拼接的字符串去前台解析也可以。
        return listImage;
    }

    //判断是否为图片
    public static boolean isImage(String fileAllPath){
        String imgFormat=fileAllPath.split("\\.",-1)[1];
        String[] extensions= MimeTypeUtils.IMAGE_EXTENSION;
        return Arrays.asList(extensions).contains(imgFormat);
    }

    public static final File getExistFileCategory(String filePath) throws IOException {
        File file = new File(filePath);
        if (!file.getParentFile().exists())
        {
            file.getParentFile().mkdirs();
        }
        if (!file.exists()) {
            file.createNewFile();
        }
//        else{
//            file.delete();
//            file.createNewFile();
//        }
        return file;
    }

	/**
     * 获取网络图片流
     *
     * @param url
     * @return
     */
    public static InputStream getInputStreamByGet(String url) {
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setReadTimeout(5000);
            connection.setConnectTimeout(5000);
            connection.setRequestMethod("GET");
            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                InputStream inputStream = connection.getInputStream();
                return inputStream;
            }
        } catch (IOException e) {
            System.out.println("获取网络图片出现异常，图片路径为：" + url);
            e.printStackTrace();
        }
        return null;
    }

    public static String filenameEncoding(String filename, HttpServletRequest request) throws IOException {
        String agent = request.getHeader("User-Agent"); //获取浏览器
        if (agent.contains("Firefox")) {
            BASE64Encoder base64Encoder = new BASE64Encoder();
            filename = "=?utf-8?B?"
                    + base64Encoder.encode(filename.getBytes("utf-8"))
                    + "?=";
        } else if(agent.contains("MSIE")) {
            filename = URLEncoder.encode(filename, "utf-8");
        } else if(agent.contains ("Safari")) {
            filename = new String (filename.getBytes ("utf-8"),"ISO8859-1");
        } else {
            filename = URLEncoder.encode(filename, "utf-8");
        }
        return filename;
    }
}
