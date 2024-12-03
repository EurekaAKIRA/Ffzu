package org.springframework.security.config.annotation.web.configuration;

import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.web.servlet.support.RequestDataValueProcessor;

/**
 * Bean definitions for {@link WebMvcSecurityConfiguration}.
 */
public class WebMvcSecurityConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'webMvcSecurityConfiguration'.
   */
  public static BeanDefinition getWebMvcSecurityConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(WebMvcSecurityConfiguration.class);
    beanDefinition.setInstanceSupplier(WebMvcSecurityConfiguration::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'requestDataValueProcessor'.
   */
  private static BeanInstanceSupplier<RequestDataValueProcessor> getRequestDataValueProcessorInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<RequestDataValueProcessor>forFactoryMethod(WebMvcSecurityConfiguration.class, "requestDataValueProcessor")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(WebMvcSecurityConfiguration.class).requestDataValueProcessor());
  }

  /**
   * Get the bean definition for 'requestDataValueProcessor'.
   */
  public static BeanDefinition getRequestDataValueProcessorBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition();
    beanDefinition.setTargetType(RequestDataValueProcessor.class);
    beanDefinition.setInstanceSupplier(getRequestDataValueProcessorInstanceSupplier());
    return beanDefinition;
  }
}
