//package com.maike.webapp.common;
//
//import com.maike.common.constant.Constants;
//import com.maike.common.result.AjaxResult;
//import com.maike.common.core.redis.RedisCache;
//import com.maike.common.utils.VerifyCodeUtils;
//import com.maike.common.utils.sign.Base64;
//import com.maike.common.utils.uuid.IdUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.util.FastByteArrayOutputStream;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.concurrent.TimeUnit;
//
///**
// * 验证码操作处理
// *
// * @author
// */
//@RestController
//public class CaptchaController
//{
////    @Resource(name = "captchaProducer")
////    private Producer captchaProducer;
////
////    @Resource(name = "captchaProducerMath")
////    private Producer captchaProducerMath;
//
//    @Autowired
//    private RedisCache redisCache;
//
//    // 验证码类型
//    //@Value("${maike.captchaType}")
//    //private String captchaType;
//
//    /**
//     * 生成验证码
//     */
//    @GetMapping("/captchaImage")
//    public AjaxResult getCode(HttpServletResponse response) throws IOException
//    {
//        //生成随机字符串
//        String verifyCode= VerifyCodeUtils.generateVerifyCode(4);
//        // 保存验证码信息
//        String uuid = IdUtils.simpleUUID();
//        String verifyKey = Constants.CAPTCHA_CODE_KEY + uuid;
//
////        String capStr = null, code = null;
////        BufferedImage image = null;
////
////        // 生成验证码
////        if ("math".equals(captchaType))
////        {
////            String capText = captchaProducerMath.createText();
////            capStr = capText.substring(0, capText.lastIndexOf("@"));
////            code = capText.substring(capText.lastIndexOf("@") + 1);
////            image = captchaProducerMath.createImage(capStr);
////        }
////        else if ("char".equals(captchaType))
////        {
////            capStr = code = captchaProducer.createText();
////            image = captchaProducer.createImage(capStr);
////        }
//
//        redisCache.setCacheObject(verifyKey, verifyCode, Constants.CAPTCHA_EXPIRATION, TimeUnit.MINUTES);
//        // 转换流信息写出
//        FastByteArrayOutputStream os = new FastByteArrayOutputStream();
//        int width=110,height=35;
//        VerifyCodeUtils.outputImage(width,height,os,verifyCode);
//        try
//        {
//            AjaxResult ajax = AjaxResult.success();
//            ajax.put("uuid", uuid);
//            ajax.put("img", Base64.encode(os.toByteArray()));
//            return ajax;
//            //ImageIO.write(image, "jpg", os);
//        }
//        catch (Exception e)
//        {
//            e.printStackTrace();
//            return AjaxResult.error(e.getMessage());
//        }
//        finally {
//            os.close();
//        }
//    }
//}
