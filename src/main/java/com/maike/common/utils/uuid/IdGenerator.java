package com.maike.common.utils.uuid;

import com.maike.common.utils.StringUtils;
import com.maike.common.utils.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: spring-boot-mybatis-codegenerator-utils
 * @description: 主键id生产工具类
 * @author: GarryChan
 * @create: 2020-12-24 11:42
 **/
public class IdGenerator {

    private static final Logger logger = LoggerFactory.getLogger(IdGenerator.class);
    /**
     * str必填，形如SUA0000046
     * beginIndex必填，从英文字符开始的位数，例如SUA0000046，就是从3开始
     * @param str
     * @param beginIndex
     * @return
     */
    public static String generatorId(String str,int beginIndex) {
        String leftStr=str.substring(0,beginIndex);//前半部分英文字符
        String rigthtStr=str.substring(beginIndex);//后半部分数字字符
        int len=rigthtStr.length();//数字总位数
        int rightInt=Integer.parseInt(rigthtStr)+1;
        String s=rightInt+"";
        int len1=s.length();


        if(len>len1){
            int i=len-len1;
            for (int j = 0; j < i; j++) {
                leftStr+="0";
            }
            leftStr+=rightInt;
        }else{
            leftStr+=rightInt;
        }
        return leftStr;

    }

    public static void main(String[] args) {
        String s= IdGenerator.generatorId("RW_0009", 3);
        System.out.println(s);
    }
    private static final String prefix0 = "00";

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public String generatorStandardCode (String standardType) {
        String codeDate = DateUtils.dateTime(new Date());
        int suffixLength = 3;
        String result = null;
        String number = generatorSerialNumber(codeDate, standardType);
        if (StringUtils.isNotBlank(number)) {
            result = StringUtils.right(prefix0+number, suffixLength);
            if(number.length()>suffixLength){
                result = number;
            }
            result = standardType + codeDate + result;
        }

        return result;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public String generatorTaskCode (String standardCode, String warehouseCode) {
        String codeDate = DateUtils.dateTime(new Date());
        int suffixLength = 2;
        String result = null;
        String codeType = standardCode + "-" +  warehouseCode;
        String number = generatorSerialNumber(codeDate, codeType);
        if (StringUtils.isNotBlank(number)) {
            result = StringUtils.right(prefix0+number, suffixLength);
            if(number.length()>suffixLength){
                result = number;
            }
            result = codeType + "-" + codeDate + "-" + result;
        }

        return result;
    }

    private String generatorSerialNumber(String codeDate, String codeType) {
        String number=null;
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("codeDate", codeDate);
        map.put("codeType", codeType);
        //codeDateMybatisDao.insertOnDuplicate(map);
        //Integer number = codeDateMybatisDao.getCodeDateNumber(map);
        logger.info(DateUtils.dateTime(new Date()) + ",codeDate:" + codeDate + ",codeType:" + codeType  + ",number" + number + ",threadId" + Thread.currentThread().getId());
        return number != null ? number.toString() : null;
    }
}
