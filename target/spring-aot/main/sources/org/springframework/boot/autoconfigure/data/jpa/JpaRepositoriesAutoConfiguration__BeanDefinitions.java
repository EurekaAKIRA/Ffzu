package org.springframework.boot.autoconfigure.data.jpa;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link JpaRepositoriesAutoConfiguration}.
 */
public class JpaRepositoriesAutoConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'jpaRepositoriesAutoConfiguration'.
   */
  public static BeanDefinition getJpaRepositoriesAutoConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(JpaRepositoriesAutoConfiguration.class);
    beanDefinition.setInstanceSupplier(JpaRepositoriesAutoConfiguration::new);
    return beanDefinition;
  }
}
