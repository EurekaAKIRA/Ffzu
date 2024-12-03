package org.mybatis.spring.boot.autoconfigure;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link MybatisProperties}.
 */
public class MybatisProperties__BeanDefinitions {
  /**
   * Get the bean definition for 'mybatisProperties'.
   */
  public static BeanDefinition getMybatisPropertiesBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(MybatisProperties.class);
    beanDefinition.setInstanceSupplier(MybatisProperties::new);
    return beanDefinition;
  }
}
