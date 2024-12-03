package com.ffzu.service;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link AdminService}.
 */
public class AdminService__BeanDefinitions {
  /**
   * Get the bean definition for 'adminService'.
   */
  public static BeanDefinition getAdminServiceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(AdminService.class);
    InstanceSupplier<AdminService> instanceSupplier = InstanceSupplier.using(AdminService::new);
    instanceSupplier = instanceSupplier.andThen(AdminService__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
