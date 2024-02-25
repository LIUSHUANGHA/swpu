package com.swpu.job;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.swpu.common.security.annotation.EnableCustomConfig;
import com.swpu.common.security.annotation.EnableRyFeignClients;
import com.swpu.common.swagger.annotation.EnableCustomSwagger2;

/**
 * 定时任务
 * 
 * @author ruoyi
 */
@EnableCustomConfig
@EnableCustomSwagger2
@EnableRyFeignClients   
@SpringBootApplication
public class SwpuJobApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(SwpuJobApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  定时任务模块启动成功   ლ(´ڡ`ლ)ﾞ  \n" +
                "                     _ __               \n" +
                "     ___   __ __ __ | '_ \\  _  _       \n" +
                "    (_-<   \\ V  V / | .__/ | +| |     \n" +
                "    /__/_   \\_/\\_/  |_|__   \\_,_|    \n" );
    }
}
