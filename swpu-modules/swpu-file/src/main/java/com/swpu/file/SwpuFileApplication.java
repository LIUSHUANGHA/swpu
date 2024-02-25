package com.swpu.file;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import com.swpu.common.swagger.annotation.EnableCustomSwagger2;

/**
 * 文件服务
 * 
 * @author ruoyi
 */
@EnableCustomSwagger2
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class SwpuFileApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(SwpuFileApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  文件服务模块启动成功   ლ(´ڡ`ლ)ﾞ  \n" +
                "                     _ __               \n" +
                "     ___   __ __ __ | '_ \\  _  _       \n" +
                "    (_-<   \\ V  V / | .__/ | +| |     \n" +
                "    /__/_   \\_/\\_/  |_|__   \\_,_|    \n" );
    }
}
