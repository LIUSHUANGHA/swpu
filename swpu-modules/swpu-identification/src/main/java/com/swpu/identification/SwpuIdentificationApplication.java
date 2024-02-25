package com.swpu.identification;

import com.swpu.common.security.annotation.EnableCustomConfig;
import com.swpu.common.security.annotation.EnableRyFeignClients;
import com.swpu.common.swagger.annotation.EnableCustomSwagger2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 工人异常识别模块
 * 
 * @author ruoyi
 */
@EnableCustomConfig
@EnableCustomSwagger2
@EnableRyFeignClients
@SpringBootApplication
public class SwpuIdentificationApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(SwpuIdentificationApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  工人异常行为识别模块启动成功   ლ(´ڡ`ლ)ﾞ  \n" +
                "                     _ __               \n" +
                "     ___   __ __ __ | '_ \\  _  _       \n" +
                "    (_-<   \\ V  V / | .__/ | +| |     \n" +
                "    /__/_   \\_/\\_/  |_|__   \\_,_|    \n" );
    }
}
