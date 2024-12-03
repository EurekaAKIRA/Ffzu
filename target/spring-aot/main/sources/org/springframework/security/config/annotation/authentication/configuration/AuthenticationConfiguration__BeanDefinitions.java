package org.springframework.security.config.annotation.authentication.configuration;

import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

/**
 * Bean definitions for {@link AuthenticationConfiguration}.
 */
public class AuthenticationConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'authenticationConfiguration'.
   */
  public static BeanDefinition getAuthenticationConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(AuthenticationConfiguration.class);
    InstanceSupplier<AuthenticationConfiguration> instanceSupplier = InstanceSupplier.using(AuthenticationConfiguration::new);
    instanceSupplier = instanceSupplier.andThen(AuthenticationConfiguration__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'authenticationManagerBuilder'.
   */
  private static BeanInstanceSupplier<AuthenticationManagerBuilder> getAuthenticationManagerBuilderInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<AuthenticationManagerBuilder>forFactoryMethod(AuthenticationConfiguration.class, "authenticationManagerBuilder", ObjectPostProcessor.class, ApplicationContext.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(AuthenticationConfiguration.class).authenticationManagerBuilder(args.get(0), args.get(1)));
  }

  /**
   * Get the bean definition for 'authenticationManagerBuilder'.
   */
  public static BeanDefinition getAuthenticationManagerBuilderBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition();
    beanDefinition.setTargetType(AuthenticationManagerBuilder.class);
    beanDefinition.setInstanceSupplier(getAuthenticationManagerBuilderInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'enableGlobalAuthenticationAutowiredConfigurer'.
   */
  private static BeanInstanceSupplier<GlobalAuthenticationConfigurerAdapter> getEnableGlobalAuthenticationAutowiredConfigurerInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<GlobalAuthenticationConfigurerAdapter>forFactoryMethod(AuthenticationConfiguration.class, "enableGlobalAuthenticationAutowiredConfigurer", ApplicationContext.class)
            .withGenerator((registeredBean, args) -> AuthenticationConfiguration.enableGlobalAuthenticationAutowiredConfigurer(args.get(0)));
  }

  /**
   * Get the bean definition for 'enableGlobalAuthenticationAutowiredConfigurer'.
   */
  public static BeanDefinition getEnableGlobalAuthenticationAutowiredConfigurerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(AuthenticationConfiguration.class);
    beanDefinition.setTargetType(GlobalAuthenticationConfigurerAdapter.class);
    beanDefinition.setInstanceSupplier(getEnableGlobalAuthenticationAutowiredConfigurerInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'initializeUserDetailsBeanManagerConfigurer'.
   */
  private static BeanInstanceSupplier<InitializeUserDetailsBeanManagerConfigurer> getInitializeUserDetailsBeanManagerConfigurerInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<InitializeUserDetailsBeanManagerConfigurer>forFactoryMethod(AuthenticationConfiguration.class, "initializeUserDetailsBeanManagerConfigurer", ApplicationContext.class)
            .withGenerator((registeredBean, args) -> AuthenticationConfiguration.initializeUserDetailsBeanManagerConfigurer(args.get(0)));
  }

  /**
   * Get the bean definition for 'initializeUserDetailsBeanManagerConfigurer'.
   */
  public static BeanDefinition getInitializeUserDetailsBeanManagerConfigurerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(AuthenticationConfiguration.class);
    beanDefinition.setTargetType(InitializeUserDetailsBeanManagerConfigurer.class);
    beanDefinition.setInstanceSupplier(getInitializeUserDetailsBeanManagerConfigurerInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'initializeAuthenticationProviderBeanManagerConfigurer'.
   */
  private static BeanInstanceSupplier<InitializeAuthenticationProviderBeanManagerConfigurer> getInitializeAuthenticationProviderBeanManagerConfigurerInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<InitializeAuthenticationProviderBeanManagerConfigurer>forFactoryMethod(AuthenticationConfiguration.class, "initializeAuthenticationProviderBeanManagerConfigurer", ApplicationContext.class)
            .withGenerator((registeredBean, args) -> AuthenticationConfiguration.initializeAuthenticationProviderBeanManagerConfigurer(args.get(0)));
  }

  /**
   * Get the bean definition for 'initializeAuthenticationProviderBeanManagerConfigurer'.
   */
  public static BeanDefinition getInitializeAuthenticationProviderBeanManagerConfigurerBeanDefinition(
      ) {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(AuthenticationConfiguration.class);
    beanDefinition.setTargetType(InitializeAuthenticationProviderBeanManagerConfigurer.class);
    beanDefinition.setInstanceSupplier(getInitializeAuthenticationProviderBeanManagerConfigurerInstanceSupplier());
    return beanDefinition;
  }
}
