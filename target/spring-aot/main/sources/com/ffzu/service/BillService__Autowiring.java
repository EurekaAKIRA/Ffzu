package com.ffzu.service;

import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link BillService}.
 */
public class BillService__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static BillService apply(RegisteredBean registeredBean, BillService instance) {
    AutowiredFieldValueResolver.forRequiredField("billMapper").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
