package com.ffzu;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ConfigurationClassUtils;

/**
 * Bean definitions for {@link FfzuApplication}.
 */
public class FfzuApplication__BeanDefinitions {
  /**
   * Get the bean definition for 'ffzuApplication'.
   */
  public static BeanDefinition getFfzuApplicationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(FfzuApplication.class);
    beanDefinition.setTargetType(FfzuApplication.class);
    ConfigurationClassUtils.initializeConfigurationClass(FfzuApplication.class);
    beanDefinition.setInstanceSupplier(FfzuApplication$$SpringCGLIB$$0::new);
    return beanDefinition;
  }
}
