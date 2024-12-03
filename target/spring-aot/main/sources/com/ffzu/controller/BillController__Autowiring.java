package com.ffzu.controller;

import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link BillController}.
 */
public class BillController__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static BillController apply(RegisteredBean registeredBean, BillController instance) {
    AutowiredFieldValueResolver.forRequiredField("billService").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
