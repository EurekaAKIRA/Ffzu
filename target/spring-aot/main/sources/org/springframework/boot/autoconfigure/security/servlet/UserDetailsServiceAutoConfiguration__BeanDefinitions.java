package org.springframework.boot.autoconfigure.security.servlet;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * Bean definitions for {@link UserDetailsServiceAutoConfiguration}.
 */
public class UserDetailsServiceAutoConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'userDetailsServiceAutoConfiguration'.
   */
  public static BeanDefinition getUserDetailsServiceAutoConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(UserDetailsServiceAutoConfiguration.class);
    beanDefinition.setInstanceSupplier(UserDetailsServiceAutoConfiguration::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'inMemoryUserDetailsManager'.
   */
  private static BeanInstanceSupplier<InMemoryUserDetailsManager> getInMemoryUserDetailsManagerInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<InMemoryUserDetailsManager>forFactoryMethod(UserDetailsServiceAutoConfiguration.class, "inMemoryUserDetailsManager", SecurityProperties.class, ObjectProvider.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(UserDetailsServiceAutoConfiguration.class).inMemoryUserDetailsManager(args.get(0), args.get(1)));
  }

  /**
   * Get the bean definition for 'inMemoryUserDetailsManager'.
   */
  public static BeanDefinition getInMemoryUserDetailsManagerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition();
    beanDefinition.setTargetType(InMemoryUserDetailsManager.class);
    beanDefinition.setInstanceSupplier(getInMemoryUserDetailsManagerInstanceSupplier());
    return beanDefinition;
  }
}
