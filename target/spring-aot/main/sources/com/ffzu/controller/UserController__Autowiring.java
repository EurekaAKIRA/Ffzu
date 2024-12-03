package com.ffzu.controller;

import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link UserController}.
 */
public class UserController__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static UserController apply(RegisteredBean registeredBean, UserController instance) {
    AutowiredFieldValueResolver.forRequiredField("userService").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("billService").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
