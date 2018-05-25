package zool.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class HttpAspect {

    /*使用org.slf4j.Logger,这是Spring实现日志的方法*/
    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    /*定义aop扫描路径*/
    @Pointcut("execution(public * zool.api..*.*(..))")
    public void log(){}

    /*记录HTTP请求开始时的日志*/
    @Before("log()")
    public void doBefore(JoinPoint joinPoint) throws Throwable{

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if(attributes!=null){
            HttpServletRequest request = attributes.getRequest();
            /*URI*/
            logger.info("url={}",request.getRequestURI());
            /*method*/
            logger.info("method={}",request.getMethod());
            /*ip*/
            logger.info("ip={}",request.getRemoteAddr());
            /*类方法*/
            logger.info("class={} and method name={}",joinPoint.getSignature().getDeclaringTypeName(),joinPoint.getSignature().getName());
            /*参数*/
            logger.info("参数={}",joinPoint.getArgs());
        }

    }

    @After("log()")
    public void doAfter(){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attributes!=null){
            HttpServletRequest request = attributes.getRequest();
            logger.info("url = {} end of execution",request.getRequestURL());
        }
    }

    @AfterReturning(returning = "object",pointcut = "log()")
    public void doAfterReturn(Object object){
        logger.info("respones={}",object.toString());
    }

}
