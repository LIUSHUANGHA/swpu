package com.swpu.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.swpu.common.security.annotation.EnableCustomConfig;
import com.swpu.common.security.annotation.EnableRyFeignClients;
import com.swpu.common.swagger.annotation.EnableCustomSwagger2;

/**
 * 系统模块
 * 
 * @author ruoyi
 */
@EnableCustomConfig
@EnableCustomSwagger2
@EnableRyFeignClients
@SpringBootApplication
public class SwpuSystemApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(SwpuSystemApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  系统模块启动成功   ლ(´ڡ`ლ)ﾞ  \n" +
                "                     _ __               \n" +
                "     ___   __ __ __ | '_ \\  _  _       \n" +
                "    (_-<   \\ V  V / | .__/ | +| |     \n" +
                "    /__/_   \\_/\\_/  |_|__   \\_,_|    \n" );
    }
}
