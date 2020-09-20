package net.xdclass.demo_project.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.io.Serializable;

/**
 * @ClassName : WXConfig  //类名
 * @Description :   //描述
 * @Author : shenhengxin  //作者
 * @Date: 2020-09-20 13:49  //时间
 */
@Configuration//声明是配置类
@PropertySource(value="classpath:pay.properties")
public class WXConfig{
    @Value("${wxpay.appid}")
    private String payAppid;
    @Value("${wxpay.secret}")
    private String paySecret;
    @Value("${wxpay.mechid}")
    private String payMechId;

    public String getPayAppid() {
        return payAppid;
    }

    public void setPayAppid(String payAppid) {
        this.payAppid = payAppid;
    }

    public String getPaySecret() {
        return paySecret;
    }

    public void setPaySecret(String paySecret) {
        this.paySecret = paySecret;
    }

    public String getPayMechId() {
        return payMechId;
    }

    public void setPayMechId(String payMechId) {
        this.payMechId = payMechId;
    }
}
