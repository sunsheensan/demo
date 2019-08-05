package com.example.demo.util;

import com.example.demo.entity.Logtable;
import com.example.demo.service.ILogtableService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.Date;

@Component
@Aspect
public class LogAopAspect {
    @Autowired
    private ILogtableService logtableService;
    /**
     * 环绕通知记录日志通过注解匹配到需要增加日志功能的方法
     *
     * @param pjp
     * @return
     * @throws Throwable
     */
    @Around("@annotation(com.example.demo.util.LogAnno)")
    public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable {
        // 1.方法执行前的处理，相当于前置通知
        // 获取方法签名
        MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
        // 获取方法
        Method method = methodSignature.getMethod();
        // 获取方法上面的注解
        LogAnno logAnno = method.getAnnotation(LogAnno.class);
        // 获取操作描述的属性值
        String operateType = logAnno.operateType();
        // 创建一个日志对象(准备记录日志)
        Logtable logtable = new Logtable();
        logtable.setOperatetype(operateType);

        Object result = null;
        try {
            //让代理方法执行
            result = pjp.proceed();
            // 2.相当于后置通知(方法成功执行之后走这里)
            logtable.setOperateresult("正常");
        } catch (SQLException e) {
            // 3.相当于异常通知部分
            logtable.setOperateresult("失败，在catch SQLException中捕获");
        } catch (Exception e) {
            // 3.相当于异常通知部分
            logtable.setOperateresult("失败，在catch Exception中捕获");
            logtable.setRemark(e.getMessage());
        }finally {
            // 4.相当于最终通知
            if(logtable.getOperateresult() == null){
                // 设置操作结果
                logtable.setOperateresult("失败，在finally中捕获");
            }
            // 设置操作日期
            logtable.setOperatedate(new Date());
            // 添加日志记录
            logtableService.addLog(logtable);
        }
        return result;
    }
}
