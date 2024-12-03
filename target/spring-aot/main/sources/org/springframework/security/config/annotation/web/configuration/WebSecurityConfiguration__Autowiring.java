package org.springframework.security.config.annotation.web.configuration;

import java.util.List;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.aot.AutowiredMethodArgumentsResolver;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.RegisteredBean;
import org.springframework.security.config.annotation.ObjectPostProcessor;

/**
 * Autowiring for {@link WebSecurityConfiguration}.
 */
public class WebSecurityConfiguration__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static WebSecurityConfiguration apply(RegisteredBean registeredBean,
      WebSecurityConfiguration instance) {
    AutowiredFieldValueResolver.forField("objectObjectPostProcessor").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forField("httpSecurity").resolveAndSet(registeredBean, instance);
    AutowiredMethodArgumentsResolver.forMethod("setFilterChainProxySecurityConfigurer", ObjectPostProcessor.class, ConfigurableListableBeanFactory.class).resolve(registeredBean, args -> instance.setFilterChainProxySecurityConfigurer(args.get(0), args.get(1)));
    AutowiredMethodArgumentsResolver.forMethod("setWebSecurityCustomizers", List.class).resolve(registeredBean, args -> instance.setWebSecurityCustomizers(args.get(0)));
    AutowiredMethodArgumentsResolver.forMethod("setFilterChains", List.class).resolve(registeredBean, args -> instance.setFilterChains(args.get(0)));
    return instance;
  }
}
