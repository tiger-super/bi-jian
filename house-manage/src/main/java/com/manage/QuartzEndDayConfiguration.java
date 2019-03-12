package com.manage;

import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import com.manage.service.impl.EndEveryDayUpdateData;
@Configuration
public class QuartzEndDayConfiguration {
	 /**
     *  配置任务
     * @param quartzTask QuartzTask为需要执行的任务
     * @return
     */
    @Bean(name = "endJob")
    public MethodInvokingJobDetailFactoryBean detailFactoryBean(EndEveryDayUpdateData endEveryDayUpdateData) {

        MethodInvokingJobDetailFactoryBean jobDetail = new MethodInvokingJobDetailFactoryBean();

        // 是否并发执行
        jobDetail.setConcurrent(false);

        // 设置任务的名字
        jobDetail.setName("endJob");

        // 设置任务的分组，在多任务的时候使用
        jobDetail.setGroup("endJobGroup");

        // 需要执行的对象
        jobDetail.setTargetObject(endEveryDayUpdateData);

        /*
         * TODO  非常重要
         * 执行QuartzTask类中的需要执行方法
         */
        jobDetail.setTargetMethod("end");
        return jobDetail;
    }

    /**
     * 定时触发器
     * @param endJob 任务
     * @return
     */
    @Bean(name = "endJobTrigger")
    public CronTriggerFactoryBean cronendJobTrigger(JobDetail endJob){

        CronTriggerFactoryBean tigger = new CronTriggerFactoryBean();

        tigger.setJobDetail(endJob);

        tigger.setCronExpression("0 59 23 * * ?");
        tigger.setName("reptilianTrigger");
        return tigger;
    }

    /**
     * 调度工厂
     * @param endJobTrigger 触发器
     * @return
     */
    @Bean(name = "endScheduler")
    public SchedulerFactoryBean schedulerFactory(Trigger endJobTrigger) {

        SchedulerFactoryBean factoryBean = new SchedulerFactoryBean();

        // 用于quartz集群,QuartzScheduler 启动时更新己存在的Job
        factoryBean.setOverwriteExistingJobs(true);

        // 延时启动，应用启动1秒后
        factoryBean.setStartupDelay(1);

        // 注册触发器
        factoryBean.setTriggers(endJobTrigger);
        return factoryBean;
    }
}
