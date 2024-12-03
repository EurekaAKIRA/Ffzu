package com.ffzu.service;

import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link AdminService}.
 */
public class AdminService__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static AdminService apply(RegisteredBean registeredBean, AdminService instance) {
    AutowiredFieldValueResolver.forRequiredField("adminMapper").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("billMapper").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
