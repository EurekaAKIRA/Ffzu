package com.ffzu.service;

import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link UserService}.
 */
public class UserService__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static UserService apply(RegisteredBean registeredBean, UserService instance) {
    AutowiredFieldValueResolver.forRequiredField("userMapper").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("billMapper").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
