package com.example.demo.config;

import com.xxl.job.core.executor.impl.XxlJobSpringExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * XXL-JOB配置
 */
@Configuration
public class XxlJobConfig {
    // 私有的静态且不可修改的日志记录器实例，独立于lombok依赖，可维护性好。但可以通过@SLF4J简化模板代码
    private static final Logger jobLogger = LoggerFactory.getLogger(XxlJobConfig.class);

    @Value("${xxl.job.admin.addresses}")
    private String adminAddresses;

    @Value("${xxl.job.accessToken}")
    private String accessToken;

    @Value("${xxl.job.executor.appname}")
    private String appname;

    @Value("${server.port}")
    private int port;

    @Value("${xxl.job.executor.logpath}")
    private String logPath;

    @Value("${xxl.job.executor.logretentiondays}")
    private int logRetentionDays;

    /**
     * 返回一个执行器的实现类
     * @return XxlJobSpringExecutor
     */
    @Bean
    public XxlJobSpringExecutor xxlJobExecutor() {
        jobLogger.info(">>>>>>>>>>> xxl-job config init.");
        XxlJobSpringExecutor xxlJobSpringExecutor = new XxlJobSpringExecutor();
        xxlJobSpringExecutor.setAdminAddresses(adminAddresses); // xxl-job admin服务地址
        xxlJobSpringExecutor.setAppname(appname);  // 执行器应用名称
        xxlJobSpringExecutor.setPort(port + 10000);  // 执行器应用端口
        xxlJobSpringExecutor.setAccessToken(accessToken); // 执行器通讯token
        xxlJobSpringExecutor.setLogPath(logPath);  // 执行器日志文件存储路径
        xxlJobSpringExecutor.setLogRetentionDays(logRetentionDays);  // 执行器日志文件保存天数

        return xxlJobSpringExecutor;
    }
}
