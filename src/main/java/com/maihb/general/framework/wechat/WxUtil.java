package com.maihb.general.framework.wechat;

import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;

import java.util.Map;

@Slf4j
public class WxUtil {

    //此处的appid与wx.config 参数appId一致   微信公众账号提供给开发者的信息，以下同理
    public static String APPID = "1";

    //同上
    public static String SECRET = "2";

    private static TokenJson getAccessToken(){

        String url = String.format("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%s", APPID, SECRET);
        try {
            String result = HttpGetRequest.doGet(url);
            log.info("微信服务器获取token:"+result);
            JSONObject rqJsonObject = JSONObject.fromObject(result);
            TokenJson tokenJson = (TokenJson) JSONObject.toBean(rqJsonObject,TokenJson.class);
            return tokenJson;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    private static TicketJson getTicket(String token){
        String url = String.format("https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=%s&type=jsapi", token);
        try {
            String result = HttpGetRequest.doGet(url);
            log.info("微信服务器获取Ticket:" + result);
            JSONObject rqJsonObject = JSONObject.fromObject(result);
            TicketJson ticket = (TicketJson) JSONObject.toBean(rqJsonObject,TicketJson.class);
            return ticket;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取js sdk 认证信息
     * @author
     * @date 创建时间 2016年7月28日 上午11:25:01
     * @param url
     * @return
     */
    public static Map<String, String> getSign(String url){

        //处理token失效的问题
        try {
            long tokenTimeLong = Long.parseLong(WxParams.tokenTime);
            long tokenExpiresLong = Long.parseLong(WxParams.tokenExpires);

            //时间差
            long differ = (System.currentTimeMillis() - tokenTimeLong) /1000;
            if (WxParams.token == null ||  differ > (tokenExpiresLong - 1800)) {
                System.out.println("token为null，或者超时，重新获取");
                TokenJson tokenJson = getAccessToken();
                if (tokenJson != null) {
                    WxParams.token = tokenJson.getAccessToken();
                    WxParams.tokenTime = System.currentTimeMillis() + "";
                    WxParams.tokenExpires = tokenJson.getExpiresIn() + "";
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            TokenJson tokenJson = getAccessToken();
            if (tokenJson != null) {
                WxParams.token = tokenJson.getAccessToken();
                WxParams.tokenTime = System.currentTimeMillis() + "";
                WxParams.tokenExpires = tokenJson.getExpiresIn() + "";
            }
        }

        //处理ticket失效的问题
        try {
            long ticketTimeLong = Long.parseLong(WxParams.ticketTime);
            long ticketExpiresLong = Long.parseLong(WxParams.ticketExpires);

            //时间差
            long differ = (System.currentTimeMillis() - ticketTimeLong) /1000;
            if (WxParams.ticket == null ||  differ > (ticketExpiresLong - 1800)) {
                System.out.println("ticket为null，或者超时，重新获取");
                TicketJson ticketJson = getTicket(WxParams.token);
                if (ticketJson != null) {
                    WxParams.ticket = ticketJson.getTicket();
                    WxParams.ticketTime = System.currentTimeMillis() + "";
                    WxParams.ticketExpires = ticketJson.getExpiresIn() + "";
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            TicketJson ticketJson = getTicket(WxParams.token);
            if (ticketJson != null) {
                WxParams.ticket = ticketJson.getTicket();
                WxParams.ticketTime = System.currentTimeMillis() + "";
                WxParams.ticketExpires = ticketJson.getExpiresIn() + "";
            }
        }

        Map<String, String> ret = Sign.sign(WxParams.ticket, url);
        log.info("计算出的签名-----------------------");
        for (Map.Entry entry : ret.entrySet()) {
            System.out.println(entry.getKey() + ", " + entry.getValue());
        }
        log.info("-----------------------");
        return ret;
    }

    public static void main(String[] args) {
        getAccessToken();
    }

}
