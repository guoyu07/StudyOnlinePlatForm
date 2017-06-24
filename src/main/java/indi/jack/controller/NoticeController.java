/**
 * 
 */
package indi.jack.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import indi.jack.model.ChatRoomMsgModel;
import indi.jack.model.MessageModel;

/**
 * <p>Title:NoticeController</p>
 * <p>Description:通知消息实时提醒控制器</p>
 * <p>Company:</p>
 * @author jackhoo
 * @date   2017年4月27日 下午4:52:44
 */
@Controller  
public class NoticeController {
	private SimpMessagingTemplate template;
	//private SimpMessageSendingOperations simpMessageSendingOperations;
    @Autowired
	public NoticeController(SimpMessagingTemplate template) {
    	this.template = template;
	}
    /**
     * 学校通知
     * @param topic
     * @param headers
     * @param principal
     * @return
     */
    @MessageMapping("/schoolnotice")//前端需要发布消息需要加上/minersocket 
    @SendTo("/topic/schoolnews")//前端需要订阅的话题  
    public Map<String, MessageModel> schoolnotice(MessageModel message) {  
        //处理前端给服务器发布的消息
    	Map<String, MessageModel> schoolnotice=new HashMap<>();
    	schoolnotice.put("schoolnotice", message);
    	return schoolnotice;
    }  
    /**
     * 班级通知（订阅对象是学生）
     * 发布的时候需要给定班级号
     * @param topic
     * @param 
     * @return
     */
	@MessageMapping("/classnotice/{classid}") //"/hello"为WebSocketConfig类中registerStompEndpoints()方法配置的  
    /*@SendTo("/topic/classnews/2")*/
    public void classnotice(@DestinationVariable(value="classid") String classid,MessageModel message) {
		Map<String, MessageModel> classnotice=new HashMap<>();
		classnotice.put("classNewsFrom"+classid, message);
		String destination="/topic/classnews/"+classid;
        this.template.convertAndSend(destination, classnotice);
    } 
    /**
     * 讨论区回复通知
     * @param message
     * @param userid
     */
    @MessageMapping("/userreply/{userid}")  
    @SendTo(value="/discuss/replymesg")
    public void replyNotice(MessageModel message,@DestinationVariable(value="userid") String userid) {
    	Map<String, MessageModel> replynotice=new HashMap<>();
        String destination="/discuss/replymesg/"+userid;
        replynotice.put("replyMesFrom"+userid, message);
        this.template.convertAndSend(destination, replynotice);
    }  
    /**
     *直播间消息转播
     */
    @MessageMapping("/chat/{roomid}")
    public void chatroomMessage(@DestinationVariable(value="roomid") String roomid,ChatRoomMsgModel message){
    	Map<String, ChatRoomMsgModel> chatMsg=new HashMap<>();
    	String destination="/chatroom/live/"+roomid;
    	chatMsg.put("message", message);
    	this.template.convertAndSend(destination, chatMsg);
    }
    /** 
     * 测试对指定用户发送消息方法 
     * @return 
     */  
    @RequestMapping(value= "/send", method = RequestMethod.GET)  
    @ResponseBody
    public String send() { 
    	this.template.convertAndSend("/topic/classnews/2","老师发布了一个通知");
    	this.template.convertAndSend("/discuss/replymesg/666666", "有人回复了你");
    	return "服务器发布消息";  
    }  
  
}
