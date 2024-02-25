package com.swpu.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 网关启动程序
 * 
 * @author ruoyi
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class SwpuGatewayApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(SwpuGatewayApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  网关启动成功   ლ(´ڡ`ლ)ﾞ  \n" +
         "                     _ __               \n" +
         "     ___   __ __ __ | '_ \\  _  _       \n" +
         "    (_-<   \\ V  V / | .__/ | +| |     \n" +
         "    /__/_   \\_/\\_/  |_|__   \\_,_|    \n" );


    }
}
