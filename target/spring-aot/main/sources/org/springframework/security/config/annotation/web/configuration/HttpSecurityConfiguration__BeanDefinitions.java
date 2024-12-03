package org.springframework.security.config.annotation.web.configuration;

import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

/**
 * Bean definitions for {@link HttpSecurityConfiguration}.
 */
public class HttpSecurityConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'httpSecurityConfiguration'.
   */
  public static BeanDefinition getHttpSecurityConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(HttpSecurityConfiguration.class);
    InstanceSupplier<HttpSecurityConfiguration> instanceSupplier = InstanceSupplier.using(HttpSecurityConfiguration::new);
    instanceSupplier = instanceSupplier.andThen(HttpSecurityConfiguration__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'org.springframework.security.config.annotation.web.configuration.HttpSecurityConfiguration.httpSecurity'.
   */
  private static BeanInstanceSupplier<HttpSecurity> getHttpSecurityInstanceSupplier() {
    return BeanInstanceSupplier.<HttpSecurity>forFactoryMethod(HttpSecurityConfiguration.class, "httpSecurity")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(HttpSecurityConfiguration.class).httpSecurity());
  }

  /**
   * Get the bean definition for 'httpSecurity'.
   */
  public static BeanDefinition getHttpSecurityBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition();
    beanDefinition.setTargetType(HttpSecurity.class);
    beanDefinition.setScope("prototype");
    beanDefinition.setInstanceSupplier(getHttpSecurityInstanceSupplier());
    return beanDefinition;
  }
}
