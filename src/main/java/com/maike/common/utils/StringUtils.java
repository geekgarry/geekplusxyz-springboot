package com.maike.common.utils;

import com.maike.common.constant.Constants;
import com.maike.common.core.text.StrFormatter;

import javax.servlet.http.HttpServletRequest;
import java.security.MessageDigest;
import java.util.*;


/**
 * @ClassName StringUtil
 * @Description 字符串工具类
 * @Author Zheng
 * @Date 2017年12月31日 11:56:18
 */
public class StringUtils extends org.apache.commons.lang3.StringUtils{

    private static final String RND_STRING = "1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHJKLMNOPQRSTUVWXYZ";
	private static final String RND_NUMBER = "0123456789";
	private static final Random rnd = new Random();
	private static StringBuilder buf = new StringBuilder();

    /** 空字符串 */
    private static final String NULLSTR = "";

    /** 下划线 */
    private static final char SEPARATOR = '_';

    /**
     * 获取参数不为空值
     *
     * @param value defaultValue 要判断的value
     * @return value 返回值
     */
    public static <T> T nvl(T value, T defaultValue)
    {
        return value != null ? value : defaultValue;
    }

    /**
     * * 判断一个Collection是否为空， 包含List，Set，Queue
     *
     * @param coll 要判断的Collection
     * @return true：为空 false：非空
     */
    public static boolean isEmpty(Collection<?> coll)
    {
        return isNull(coll) || coll.isEmpty();
    }

    /**
     * * 判断一个Collection是否非空，包含List，Set，Queue
     *
     * @param coll 要判断的Collection
     * @return true：非空 false：空
     */
    public static boolean isNotEmpty(Collection<?> coll)
    {
        return !isEmpty(coll);
    }

    /**
     * * 判断一个对象数组是否为空
     *
     * @param objects 要判断的对象数组
     ** @return true：为空 false：非空
     */
    public static boolean isEmpty(Object[] objects)
    {
        return isNull(objects) || (objects.length == 0);
    }

    /**
     * * 判断一个对象数组是否非空
     *
     * @param objects 要判断的对象数组
     * @return true：非空 false：空
     */
    public static boolean isNotEmpty(Object[] objects)
    {
        return !isEmpty(objects);
    }

    /**
     * * 判断一个Map是否为空
     *
     * @param map 要判断的Map
     * @return true：为空 false：非空
     */
    public static boolean isEmpty(Map<?, ?> map)
    {
        return isNull(map) || map.isEmpty();
    }

    /**
     * * 判断一个Map是否为空
     *
     * @param map 要判断的Map
     * @return true：非空 false：空
     */
    public static boolean isNotEmpty(Map<?, ?> map)
    {
        return !isEmpty(map);
    }

    /**
     * * 判断一个字符串是否为空串
     *
     * @param str String
     * @return true：为空 false：非空
     */
    public static boolean isEmpty(String str)
    {
        return isNull(str) || NULLSTR.equals(str.trim());
    }

    /**
     * * 判断一个字符串是否为非空串
     *
     * @param str String
     * @return true：非空串 false：空串
     */
    public static boolean isNotEmpty(String str)
    {
        return !isEmpty(str);
    }

    /**
     * * 判断一个对象是否为空
     *
     * @param object Object
     * @return true：为空 false：非空
     */
    public static boolean isNull(Object object)
    {
        return object == null;
    }

    /**
     * * 判断一个对象是否非空
     *
     * @param object Object
     * @return true：非空 false：空
     */
    public static boolean isNotNull(Object object)
    {
        return !isNull(object);
    }

    /**
     * * 判断一个对象是否是数组类型（Java基本型别的数组）
     *
     * @param object 对象
     * @return true：是数组 false：不是数组
     */
    public static boolean isArray(Object object)
    {
        return isNotNull(object) && object.getClass().isArray();
    }

    /**
     * 去空格
     */
    public static String trim(String str)
    {
        return (str == null ? "" : str.trim());
    }
    /**
     * 去空格
     */
    public static String trimStrByNum(Object obj,String num){
        if(obj==null||obj==""){
            return num;
        }
        String result=String.valueOf(obj).trim();
        return result;
    }
    public static String trimString(Object obj){
        if (obj==null){
            return "";
        }
        String result =String.valueOf(obj).trim();
        return result ;
    }
    /**
     * 截取字符串
     *
     * @param str 字符串
     * @param start 开始
     * @return 结果
     */
    public static String substring(final String str, int start)
    {
        if (str == null)
        {
            return NULLSTR;
        }

        if (start < 0)
        {
            start = str.length() + start;
        }

        if (start < 0)
        {
            start = 0;
        }
        if (start > str.length())
        {
            return NULLSTR;
        }

        return str.substring(start);
    }

    /**
     * 截取字符串
     *
     * @param str 字符串
     * @param start 开始
     * @param end 结束
     * @return 结果
     */
    public static String substring(final String str, int start, int end)
    {
        if (str == null)
        {
            return NULLSTR;
        }

        if (end < 0)
        {
            end = str.length() + end;
        }
        if (start < 0)
        {
            start = str.length() + start;
        }

        if (end > str.length())
        {
            end = str.length();
        }

        if (start > end)
        {
            return NULLSTR;
        }

        if (start < 0)
        {
            start = 0;
        }
        if (end < 0)
        {
            end = 0;
        }

        return str.substring(start, end);
    }

    /**
     * 格式化文本, {} 表示占位符<br>
     * 此方法只是简单将占位符 {} 按照顺序替换为参数<br>
     * 如果想输出 {} 使用 \\转义 { 即可，如果想输出 {} 之前的 \ 使用双转义符 \\\\ 即可<br>
     * 例：<br>
     * 通常使用：format("this is {} for {}", "a", "b") -> this is a for b<br>
     * 转义{}： format("this is \\{} for {}", "a", "b") -> this is \{} for a<br>
     * 转义\： format("this is \\\\{} for {}", "a", "b") -> this is \a for b<br>
     *
     * @param template 文本模板，被替换的部分用 {} 表示
     * @param params 参数值
     * @return 格式化后的文本
     */
    public static String format(String template, Object... params)
    {
        if (isEmpty(params) || isEmpty(template))
        {
            return template;
        }
        return StrFormatter.format(template, params);
    }

    /**
     * 是否包含字符串
     *
     * @param str 验证字符串
     * @param strs 字符串组
     * @return 包含返回true
     */
    public static boolean inStringIgnoreCase(String str, String... strs)
    {
        if (str != null && strs != null)
        {
            for (String s : strs)
            {
                if (str.equalsIgnoreCase(trim(s)))
                {
                    return true;
                }
            }
        }
        return false;
    }

	/**
	 *使用UUID生成随机字符
	 * @return
	 */
    public static String getRndString(){
    	String uuid = UUID.randomUUID().toString();
    	return uuid;
    }
    /**
     * 随机字符串 UUID + Timestamp
     * @return
     */
    public static String getRndString2(){
    	String uuid = UUID.randomUUID().toString()+new Date().getTime();
    	return uuid;
    }
    /**
     * 获得主键ֵ key+uuid+timestamp
     * @param key  null 默认 zheng
     * @return 128 位加密
     */
    public static String getMainID(String key){
    	if(null == key){
    		key = Constants.APP_MAIN_ID_KEY;
    	}
    	StringBuffer sb = new StringBuffer();
    	sb.append(key);
    	sb.append(getRndString());
    	sb.append(new Date().getTime());
    	return SHAUtil.getMD5(sb.toString());
    }
    /**
     * 验证传入参数是否不为空后者正整数
     * @param object
     * @return true is null false not null
     */
    public static boolean validNotNull(Object object){
    	boolean flag = false;
    	/**
    	 * 判断是否为null
    	 */
    	if(null == object){
    		flag = true;
    	}else{
    		/**
        	 * 判断类型
        	 * TODO 后续可以进行添加其它类型判断
        	 */
        	if(object instanceof Integer){
        		Integer integer = (Integer)object;
        		if(integer<1){
        			flag = true;
        		}
        	}else if(object instanceof String){
        		String string = (String)object;
        		flag = string.isEmpty();
        	}
    	}
    	return flag;
    }
    /**
     * 获取随机字符串 较短数量
     * @param length
     * @return
     */
    public static String getRndStr(Integer length){
    	String backMsg = "";
    	for(int i=0;i<length;i++){
    		backMsg += RND_STRING.charAt(rnd.nextInt(RND_STRING.length()));
    	}
    	return backMsg;
    }
    public static Boolean testRndStr(Integer size,Integer strSize,Boolean isDetail){
    	long startTime = System.currentTimeMillis();
    	if(size < 100 || size >100001){
    		size = 5000;
    	}
    	if(strSize < 3 || strSize >100){
    		strSize = 10;
    	}
    	List<String> arrayList = new ArrayList<>();
    	Set<String> hashSet = new HashSet<>();
    	for(int i=0;i<size;i++){
    		String value = getRndStr(strSize);
    		arrayList.add(value);
    		hashSet.add(value);
    	}
    	if(isDetail){
    		System.out.println("预生成随机数个数: " + size + ",尺寸: " + strSize);
        	System.out.println("ArrayList size: " + arrayList.size());
        	System.out.println("HashSet size: " + hashSet.size());
        	System.out.println("总共消耗: "+(System.currentTimeMillis()-startTime)+" 毫秒");
    	}
    	//System.out.println("比率: " + hashSet.size() + "/" + arrayList.size());
    	return (arrayList.size() == hashSet.size());
    }
    public static String getRndNum(Integer length){
    	String backMsg = "";
    	for(int i=0;i<length;i++){
    		backMsg += RND_STRING.charAt(rnd.nextInt(RND_NUMBER.length()));
    	}
    	return backMsg;
    }
    /**
     * md5加密
     * @param key
     * @return
     */
    public static String MD5(String key) {
        char hexDigits[] = {
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'
        };
        try {
            byte[] btInput = key.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            return null;
        }
    }
    /**
     * 获取用户分享码 全局唯一
     * timestamp + rnd 6 number
     * @return
     */
    public static String getShareKeyCode(){
    	return MD5(""+new Date().getTime()+getRndNum(6));
    }
    public static void main(String[] args) {
//    	String appString = "zheng";
//	    System.out.println(StringUtil.getMainID(appString));
//	    System.out.println(StringUtil.getMainID(appString));
//    	for(int i=0;i<10;i++){
//    		System.out.println(getRndStr(6));
//    	}
//    	for(int i=0;i<15;i++){
//    		System.out.println(StringUtil.getMainID(null));
//    	}
    	//System.out.println(getShareKeyCode());
    	//System.out.println(HloveyRC4("ÏnBÈöÒ2þß	y7"));
//    	Integer isTrue = 0;
//    	for (int i = 0; i < 100; i++) {
//    		if(testRndStr(100000, 8,false)){
//    			isTrue ++;
//    		}
//		}
//    	System.out.println("测试总数: "+100+"/"+isTrue);
    	//$2a$10$mYtRg282kepowy1XlRRJueO8YJ56S7IN8aw9BLiYTwBKvcs8g8.ru
    	//String encrptPWd = springSecurityEncrpt("Uwsu3wdW");
    	//String encrptPWd = springSecurityEncrpt("12345678");
    	//System.out.println(encrptPWd);
    	// $2a$10$kDMqweJAIZdOSXu/sp5Ew./JuBTDiq/6Tk1Pc9ff5xTWB8kNpkQ1m
    	//System.out.println("$2a$10$C8kXIo6dp5ZIo9I4YRBVsOuvLbRWrSQ4vu91B9djRT8Dh6RSJRzEW".equals(encrptPWd));
	}
    /**
     *
    * @Title: HloveyRC4
    * @Description:
    * @param aInput 输入的字符
    * @return String 返回加密、解密后的字符 可以自动获取方式
    * @author WeiZheng
    * @date 2018年8月8日上午11:29:35
     */
    public static String HloveyRC4(String aInput)
    {
    	String aKey = "Iloveyou.123";
        int[] iS = new int[256];
        byte[] iK = new byte[256];

        for (int i=0;i<256;i++)
            iS[i]=i;

        int j = 1;

        for (short i= 0;i<256;i++)
        {
            iK[i]=(byte)aKey.charAt((i % aKey.length()));
        }
        j=0;
        for (int i=0;i<255;i++)
        {
            j=(j+iS[i]+iK[i]) % 256;
            int temp = iS[i];
            iS[i]=iS[j];
            iS[j]=temp;
        }
        int i=0;
        j=0;
        char[] iInputChar = aInput.toCharArray();
        char[] iOutputChar = new char[iInputChar.length];
        for(short x = 0;x<iInputChar.length;x++)
        {
            i = (i+1) % 256;
            j = (j+iS[i]) % 256;
            int temp = iS[i];
            iS[i]=iS[j];
            iS[j]=temp;
            int t = (iS[i]+(iS[j] % 256)) % 256;
            int iY = iS[t];
            char iCY = (char)iY;
            iOutputChar[x] =(char)( iInputChar[x] ^ iCY) ;
        }
        return new String(iOutputChar);
    }
    /**
     * 拼接字符串
    * @Title: appendStr
    * @Description:
    * @param original
    * @param next
    * @param separator
    * @return String
    * @author WeiZheng
    * @date 2018年8月24日上午10:01:27
     */
    public static String appendStr(String original,String next,String separator){
    	buf.setLength(0);
    	buf.append(original);
    	buf.append(separator);
    	buf.append(next);
    	return buf.toString();
    }
    /**
     * 生成订单标题内容
    * @Title: genOrderSubject
    * @Description:
    * @param name 第一件商品名称
    * @param count 总订单商品数量
    * @return String **..等共**件商品
    * @author WeiZheng
    * @date 2018年8月24日上午10:03:22
     */
    public static String genOrderSubject(String name,Integer count){
    	buf.setLength(0);
    	buf.append(name);
    	buf.append("..等共");
    	buf.append(count);
    	buf.append("件商品");
    	return buf.toString();
    }
    public static String getIpAddress(HttpServletRequest request) {
    	String strUnknow = "unknown";
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || strUnknow.equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || strUnknow.equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || strUnknow.equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || strUnknow.equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || strUnknow.equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        // 如果是多级代理，那么取第一个ip为客户端ip
        if (ip != null && ip.indexOf(',') != -1) {
            ip = ip.substring(0, ip.indexOf(',')).trim();
        }

        return ip;
    }

    /**
     * 下划线转驼峰命名
     */
    public static String toUnderScoreCase(String str) {
        if (str ==null)
        {
            return null;
        }
        StringBuilder sb =new StringBuilder();
        // 前置字符是否大写
        boolean preCharIsUpperCase =true;
        // 当前字符是否大写
        boolean curreCharIsUpperCase =true;
        // 下一字符是否大写
        boolean nexteCharIsUpperCase =true;
        for (int i =0; i < str.length(); i++)
        {
            char c = str.charAt(i);
        if (i >0)
        {
            preCharIsUpperCase = Character.isUpperCase(str.charAt(i -1));
        }
        else{
            preCharIsUpperCase =false;
        }
        curreCharIsUpperCase = Character.isUpperCase(c);
        if (i < (str.length() -1))
            {
            nexteCharIsUpperCase = Character.isUpperCase(str.charAt(i +1));
            }
            if (preCharIsUpperCase && curreCharIsUpperCase && !nexteCharIsUpperCase)
            {
                sb.append(SEPARATOR);
            }
            else if ((i !=0 && !preCharIsUpperCase) && curreCharIsUpperCase)
            {
                sb.append(SEPARATOR);
            }
            sb.append(Character.toLowerCase(c));
        }
        return sb.toString();
    }

}
