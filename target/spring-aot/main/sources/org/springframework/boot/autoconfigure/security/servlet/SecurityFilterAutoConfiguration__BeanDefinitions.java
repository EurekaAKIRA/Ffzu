package org.springframework.boot.autoconfigure.security.servlet;

import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.web.servlet.DelegatingFilterProxyRegistrationBean;

/**
 * Bean definitions for {@link SecurityFilterAutoConfiguration}.
 */
public class SecurityFilterAutoConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'securityFilterAutoConfiguration'.
   */
  public static BeanDefinition getSecurityFilterAutoConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(SecurityFilterAutoConfiguration.class);
    beanDefinition.setInstanceSupplier(SecurityFilterAutoConfiguration::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'securityFilterChainRegistration'.
   */
  private static BeanInstanceSupplier<DelegatingFilterProxyRegistrationBean> getSecurityFilterChainRegistrationInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<DelegatingFilterProxyRegistrationBean>forFactoryMethod(SecurityFilterAutoConfiguration.class, "securityFilterChainRegistration", SecurityProperties.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(SecurityFilterAutoConfiguration.class).securityFilterChainRegistration(args.get(0)));
  }

  /**
   * Get the bean definition for 'securityFilterChainRegistration'.
   */
  public static BeanDefinition getSecurityFilterChainRegistrationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition();
    beanDefinition.setTargetType(DelegatingFilterProxyRegistrationBean.class);
    beanDefinition.setInstanceSupplier(getSecurityFilterChainRegistrationInstanceSupplier());
    return beanDefinition;
  }
}
