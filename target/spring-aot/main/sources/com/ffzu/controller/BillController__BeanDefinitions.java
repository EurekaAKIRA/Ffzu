package com.ffzu.controller;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link BillController}.
 */
public class BillController__BeanDefinitions {
  /**
   * Get the bean definition for 'billController'.
   */
  public static BeanDefinition getBillControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(BillController.class);
    InstanceSupplier<BillController> instanceSupplier = InstanceSupplier.using(BillController::new);
    instanceSupplier = instanceSupplier.andThen(BillController__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
