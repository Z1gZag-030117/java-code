package com.zz.processor;

import com.zz.util.BaseClassScanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;

import java.util.Map;

/**
 * @author 朱喆
 * @version 1.0
 */
public class MyComponentBeanFactoryPostProcessor implements BeanDefinitionRegistryPostProcessor {
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        //通过扫描工具扫描指定包下的所有类，收集使用注解的类
        Map<String, Class> myComponentAnnotation = BaseClassScanUtils.scanMyComponentAnnotation("com.zz");
        //循环遍历，组装BeanDefinition进行注册
        myComponentAnnotation.forEach((beanName,clazz)->{
                    String beanClassName=clazz.getName();
                    //创建BeanDefinition
                    BeanDefinition beanDefinition=new RootBeanDefinition();
                    beanDefinition.setBeanClassName(beanClassName);
                    registry.registerBeanDefinition(beanName,beanDefinition);
                });
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

    }
}
