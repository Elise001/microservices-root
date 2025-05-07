package com.example.demo.xxljob;

import com.xxl.job.core.context.XxlJobHelper;
import com.xxl.job.core.handler.annotation.XxlJob;
import org.springframework.stereotype.Component;

@Component
public class DemoExecutor {

    @XxlJob("demoJobHandler")
    public void demoJobHandler() throws Exception {
        // 获取任务参数
        String param = XxlJobHelper.getJobParam();
        System.out.println("Demo Job Handler is running... param: " + param);
    }
}
