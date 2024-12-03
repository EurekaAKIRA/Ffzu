package org.springframework.boot.autoconfigure.data.web;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link SpringDataWebProperties}.
 */
public class SpringDataWebProperties__BeanDefinitions {
  /**
   * Get the bean definition for 'springDataWebProperties'.
   */
  public static BeanDefinition getSpringDataWebPropertiesBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(SpringDataWebProperties.class);
    beanDefinition.setInstanceSupplier(SpringDataWebProperties::new);
    return beanDefinition;
  }
}
