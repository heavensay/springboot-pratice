package com.ljy.spt.portal.spring.postprocessor;

import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.stereotype.Component;
import org.springframework.validation.beanvalidation.MethodValidationInterceptor;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

/**
 * 支持aop express来匹配需要validation功能的类；减少注解类，并且可通过表达式对validtion层进行控制，如只需对controller和dao层
 * 支持validation，其他层不需要支持
 *
 * spring默认值支持@Validated修复的方法，这样虽然灵活，但是每个类都需要配置注解；
 * @author lijianyu
 * @date 2018/8/30 11:51
 */
@Component
public class MethodValidationMatchExpressPostProcessor extends MethodValidationPostProcessor {
    @Override
    public void afterPropertiesSet() {
        //声明一个aspectj切点
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        //生产环境中支持可配置即可
        pointcut.setExpression("execution(public * com.ljy.spt.portal.dao..*.*(..))");

        this.advisor = new DefaultPointcutAdvisor(pointcut, new MethodValidationInterceptor());
    }
}
