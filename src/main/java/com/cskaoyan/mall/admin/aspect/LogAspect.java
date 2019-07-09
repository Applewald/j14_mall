package com.cskaoyan.mall.admin.aspect;

import com.cskaoyan.mall.admin.bean.log.Log;
import com.cskaoyan.mall.admin.service.LogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @author zzc
 * @version 1.0
 * @date 2019-07-06 17:35
 * @description 系统管理 - 操作日志 - 切面处理类
 */
@Aspect
@Component
public class LogAspect {

    @Autowired
    private LogService logService;

    @Pointcut("@annotation(com.cskaoyan.mall.admin.annotation.Log)")
    public void logPutCut(){}

    @AfterReturning("logPutCut()")
    public void saveLog(JoinPoint joinPoint) {

        // 新建日志实例
        Log log = new Log();

        // 从切面织入点处通过反射机制获取织入点处的方法
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();

        // 获取切入点所在的方法
        Method method = signature.getMethod();

        // 获取,并保存操作 action
        com.cskaoyan.mall.admin.annotation.Log myLog = method.getAnnotation(com.cskaoyan.mall.admin.annotation.Log.class);
        if (myLog != null) {
            String value = myLog.value();
            log.setAction(value);
        }

        HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();

        // 获取主机ip
        String ip = request.getRemoteHost();
        log.setIp(ip);

        // 记录当前时间
        log.setAddTime(new Date());

        // 操作类别，默认为安全操作
        log.setType(1);



        // 获取请求的类名
        String className = joinPoint.getTarget().getClass().getName();


        // 调用service保存到数据库
        //logService.save(log);
    }
}
