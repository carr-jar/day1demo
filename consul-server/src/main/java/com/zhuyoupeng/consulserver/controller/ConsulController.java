package com.zhuyoupeng.consulserver.controller;

import com.zhuyoupeng.consulserver.config.ConsulConfigInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ConsulController {
    @Value("${config.info}")
    private String configInfo;

    @Autowired
    private ConsulConfigInfo consulConfigInfo;

    @RequestMapping("/config")
    public Object getConfig(){
        return  configInfo;
    }

    @RequestMapping("/getconfig")
    public Object Config(){
        return  consulConfigInfo;
    }
}
