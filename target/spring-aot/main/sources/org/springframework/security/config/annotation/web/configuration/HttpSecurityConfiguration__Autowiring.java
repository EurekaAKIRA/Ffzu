package org.springframework.security.config.annotation.web.configuration;

import org.springframework.beans.factory.aot.AutowiredMethodArgumentsResolver;
import org.springframework.beans.factory.support.RegisteredBean;
import org.springframework.context.ApplicationContext;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.context.SecurityContextHolderStrategy;
import org.springframework.web.accept.ContentNegotiationStrategy;

/**
 * Autowiring for {@link HttpSecurityConfiguration}.
 */
public class HttpSecurityConfiguration__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static HttpSecurityConfiguration apply(RegisteredBean registeredBean,
      HttpSecurityConfiguration instance) {
    AutowiredMethodArgumentsResolver.forRequiredMethod("setApplicationContext", ApplicationContext.class).resolve(registeredBean, args -> instance.setApplicationContext(args.get(0)));
    AutowiredMethodArgumentsResolver.forMethod("setContentNegotiationStrategy", ContentNegotiationStrategy.class).resolve(registeredBean, args -> instance.setContentNegotiationStrategy(args.get(0)));
    AutowiredMethodArgumentsResolver.forRequiredMethod("setAuthenticationConfiguration", AuthenticationConfiguration.class).resolve(registeredBean, args -> instance.setAuthenticationConfiguration(args.get(0)));
    AutowiredMethodArgumentsResolver.forMethod("setSecurityContextHolderStrategy", SecurityContextHolderStrategy.class).resolve(registeredBean, args -> instance.setSecurityContextHolderStrategy(args.get(0)));
    AutowiredMethodArgumentsResolver.forRequiredMethod("setObjectPostProcessor", ObjectPostProcessor.class).resolve(registeredBean, args -> instance.setObjectPostProcessor(args.get(0)));
    return instance;
  }
}
