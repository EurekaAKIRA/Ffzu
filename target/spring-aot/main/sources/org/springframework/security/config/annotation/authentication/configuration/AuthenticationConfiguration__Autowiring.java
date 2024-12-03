package org.springframework.security.config.annotation.authentication.configuration;

import java.util.List;
import org.springframework.beans.factory.aot.AutowiredMethodArgumentsResolver;
import org.springframework.beans.factory.support.RegisteredBean;
import org.springframework.context.ApplicationContext;
import org.springframework.security.config.annotation.ObjectPostProcessor;

/**
 * Autowiring for {@link AuthenticationConfiguration}.
 */
public class AuthenticationConfiguration__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static AuthenticationConfiguration apply(RegisteredBean registeredBean,
      AuthenticationConfiguration instance) {
    AutowiredMethodArgumentsResolver.forRequiredMethod("setApplicationContext", ApplicationContext.class).resolve(registeredBean, args -> instance.setApplicationContext(args.get(0)));
    AutowiredMethodArgumentsResolver.forMethod("setGlobalAuthenticationConfigurers", List.class).resolve(registeredBean, args -> instance.setGlobalAuthenticationConfigurers(args.get(0)));
    AutowiredMethodArgumentsResolver.forRequiredMethod("setObjectPostProcessor", ObjectPostProcessor.class).resolve(registeredBean, args -> instance.setObjectPostProcessor(args.get(0)));
    return instance;
  }
}
