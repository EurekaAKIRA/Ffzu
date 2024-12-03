package org.springframework.security.config.annotation.web.configuration;

import jakarta.servlet.Filter;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.core.ResolvableType;
import org.springframework.security.access.expression.SecurityExpressionHandler;
import org.springframework.security.context.DelegatingApplicationListener;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.WebInvocationPrivilegeEvaluator;

/**
 * Bean definitions for {@link WebSecurityConfiguration}.
 */
public class WebSecurityConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'webSecurityConfiguration'.
   */
  public static BeanDefinition getWebSecurityConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(WebSecurityConfiguration.class);
    InstanceSupplier<WebSecurityConfiguration> instanceSupplier = InstanceSupplier.using(WebSecurityConfiguration::new);
    instanceSupplier = instanceSupplier.andThen(WebSecurityConfiguration__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }

  /**
   * Get the bean definition for 'delegatingApplicationListener'.
   */
  public static BeanDefinition getDelegatingApplicationListenerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(WebSecurityConfiguration.class);
    beanDefinition.setTargetType(DelegatingApplicationListener.class);
    beanDefinition.setInstanceSupplier(BeanInstanceSupplier.<DelegatingApplicationListener>forFactoryMethod(WebSecurityConfiguration.class, "delegatingApplicationListener").withGenerator((registeredBean) -> WebSecurityConfiguration.delegatingApplicationListener()));
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'webSecurityExpressionHandler'.
   */
  private static BeanInstanceSupplier<SecurityExpressionHandler> getWebSecurityExpressionHandlerInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<SecurityExpressionHandler>forFactoryMethod(WebSecurityConfiguration.class, "webSecurityExpressionHandler")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(WebSecurityConfiguration.class).webSecurityExpressionHandler());
  }

  /**
   * Get the bean definition for 'webSecurityExpressionHandler'.
   */
  public static BeanDefinition getWebSecurityExpressionHandlerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition();
    beanDefinition.setTargetType(ResolvableType.forClassWithGenerics(SecurityExpressionHandler.class, FilterInvocation.class));
    beanDefinition.setDependsOn("springSecurityFilterChain");
    beanDefinition.setInstanceSupplier(getWebSecurityExpressionHandlerInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'springSecurityFilterChain'.
   */
  private static BeanInstanceSupplier<Filter> getSpringSecurityFilterChainInstanceSupplier() {
    return BeanInstanceSupplier.<Filter>forFactoryMethod(WebSecurityConfiguration.class, "springSecurityFilterChain")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(WebSecurityConfiguration.class).springSecurityFilterChain());
  }

  /**
   * Get the bean definition for 'springSecurityFilterChain'.
   */
  public static BeanDefinition getSpringSecurityFilterChainBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition();
    beanDefinition.setTargetType(Filter.class);
    beanDefinition.setInstanceSupplier(getSpringSecurityFilterChainInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'privilegeEvaluator'.
   */
  private static BeanInstanceSupplier<WebInvocationPrivilegeEvaluator> getPrivilegeEvaluatorInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<WebInvocationPrivilegeEvaluator>forFactoryMethod(WebSecurityConfiguration.class, "privilegeEvaluator")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(WebSecurityConfiguration.class).privilegeEvaluator());
  }

  /**
   * Get the bean definition for 'privilegeEvaluator'.
   */
  public static BeanDefinition getPrivilegeEvaluatorBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition();
    beanDefinition.setTargetType(WebInvocationPrivilegeEvaluator.class);
    beanDefinition.setDependsOn("springSecurityFilterChain");
    beanDefinition.setInstanceSupplier(getPrivilegeEvaluatorInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean definition for 'conversionServicePostProcessor'.
   */
  public static BeanDefinition getConversionServicePostProcessorBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(WebSecurityConfiguration.class);
    beanDefinition.setTargetType(BeanFactoryPostProcessor.class);
    beanDefinition.setInstanceSupplier(BeanInstanceSupplier.<BeanFactoryPostProcessor>forFactoryMethod(WebSecurityConfiguration.class, "conversionServicePostProcessor").withGenerator((registeredBean) -> WebSecurityConfiguration.conversionServicePostProcessor()));
    return beanDefinition;
  }
}
