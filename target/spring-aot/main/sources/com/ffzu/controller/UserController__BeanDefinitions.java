package com.ffzu.controller;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link UserController}.
 */
public class UserController__BeanDefinitions {
  /**
   * Get the bean definition for 'userController'.
   */
  public static BeanDefinition getUserControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(UserController.class);
    InstanceSupplier<UserController> instanceSupplier = InstanceSupplier.using(UserController::new);
    instanceSupplier = instanceSupplier.andThen(UserController__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
