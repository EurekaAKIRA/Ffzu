package com.ffzu.service;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link BillService}.
 */
public class BillService__BeanDefinitions {
  /**
   * Get the bean definition for 'billService'.
   */
  public static BeanDefinition getBillServiceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(BillService.class);
    InstanceSupplier<BillService> instanceSupplier = InstanceSupplier.using(BillService::new);
    instanceSupplier = instanceSupplier.andThen(BillService__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
