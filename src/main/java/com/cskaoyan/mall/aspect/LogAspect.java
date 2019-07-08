package com.cskaoyan.mall.aspect;

import com.cskaoyan.mall.bean.admin.Admin;
import com.cskaoyan.mall.bean.log.Log;
import com.cskaoyan.mall.service.LogService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
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
import java.time.LocalTime;
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

    @Pointcut("@annotation(com.cskaoyan.mall.annotation.Log)")
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
        com.cskaoyan.mall.annotation.Log myLog = method.getAnnotation(com.cskaoyan.mall.annotation.Log.class);
        if (myLog != null) {
            String value = myLog.value();
            log.setAction(value);
        }

        HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
        // 获取主机ip
        String ip = request.getRemoteHost();
        //Subject currentUser = SecurityUtils.getSubject();

        //Admin admin = (Admin) currentUser.getPrincipal();
        //log.setAdmin(admin.getUsername());

        // 操作类别，默认为安全操作
        //log.setType(1);
        log.setAdmin("admin123");
        log.setIp(ip);
        log.setAddTime(new Date());



        // 调用service保存到数据库
        logService.save(log);
    }
}
