package com.swpu.modules.monitor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import de.codecentric.boot.admin.server.config.EnableAdminServer;

/**
 * 监控中心
 * 
 * @author ruoyi
 */
@EnableAdminServer
@SpringBootApplication
public class SwpuMonitorApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(SwpuMonitorApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  监控中心启动成功   ლ(´ڡ`ლ)ﾞ  \n" +
                "                     _ __               \n" +
                "     ___   __ __ __ | '_ \\  _  _       \n" +
                "    (_-<   \\ V  V / | .__/ | +| |     \n" +
                "    /__/_   \\_/\\_/  |_|__   \\_,_|    \n" );
    }
}
