/**
 * author     : geekplus
 * email      : geekcjj@gmail.com
 * date       : 2/18/23 21:13
 * description: 做什么的？
 */
package com.maike.webapp.function.controller;

import com.maike.common.core.controller.BaseController;
import com.maike.common.result.Result;
import com.maike.webapp.function.domain.ChatPrompt;
import com.maike.webapp.function.service.ChatGPTService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/openai")
public class ChatGPTController extends BaseController {

    @Resource
    private ChatGPTService chatGPTService;

//    @Resource
//    public RedisTemplate redisTemplate;
//    private final StringRedisTemplate stringRedisTemplate;
//
//    public ChatGPTController(StringRedisTemplate stringRedisTemplate) {
//        this.stringRedisTemplate = stringRedisTemplate;
//    }

    @PostMapping("/chatgpttest")
    public Result getChat(@RequestBody ChatPrompt chatPrompt) {
        String text = chatGPTService.getChatContent("",chatPrompt.getData(),chatPrompt.getUsername(),chatPrompt.getOpenAiKey());
        System.out.println(chatPrompt);
        return Result.success(text);
    }

    @PostMapping("/getchatgpt")
    public Result getChatGPTV1(@RequestBody ChatPrompt chatPrompt) throws SocketException, UnknownHostException {
        Map text = chatGPTService.reply(chatPrompt.getData(),chatPrompt.getUsername(),chatPrompt.getOpenAiKey());
        System.out.println(text);
        return Result.success(text);
    }

    //@RequestParam("text")也可以用post传输，但是前端要是用params携带 @RequestBody可以实现封装json也可以以text文本形式
    @PostMapping("/getTextToVoice")
    public Result getTextToVoice(@RequestBody String text){
        try{
            String result= chatGPTService.getTextToVoice(text);
            return Result.success(result);
        }catch (Exception e){
            e.printStackTrace();
            return Result.error(e.getMessage());
        }
    }

    @PostMapping("/uploadVoiceBlob")
    public Result uploadVoiceBlob(@RequestPart("file") MultipartFile file){
        try
        {
            // 上传文件路径
            //String filePath = MaikeConfig.getUploadPath();
            // 上传并获取文件名称
            String fileName = file.getOriginalFilename();
            //String url = serverConfig.getUrl() + fileName;
            byte[] voiceByte= file.getBytes();
            Object text=chatGPTService.getVoiceToText(voiceByte);
            Result ajax = Result.success(text);
            //ajax.put("fileName", fileName);
            //ajax.put("url", url);
            return ajax;
        }
        catch (Exception e)
        {
            return Result.error(e.getMessage());
        }
    }

    @RequestMapping(value = "/getHistoryMessage",method = {RequestMethod.POST, RequestMethod.GET})
    public Result getHistoryMsgList(@RequestParam("username") String username){
        List<String> msgList= chatGPTService.getHistoryMsgList(username);
        //JSONObject jsonObject=JSONObject.parseObject();
        return Result.success(msgList);
    }
}
