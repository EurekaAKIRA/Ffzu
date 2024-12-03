package com.ffzu.controller;

import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link AdminController}.
 */
public class AdminController__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static AdminController apply(RegisteredBean registeredBean, AdminController instance) {
    AutowiredFieldValueResolver.forRequiredField("adminService").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
