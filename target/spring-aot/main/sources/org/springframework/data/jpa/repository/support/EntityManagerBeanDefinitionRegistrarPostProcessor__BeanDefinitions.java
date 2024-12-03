package org.springframework.data.jpa.repository.support;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link EntityManagerBeanDefinitionRegistrarPostProcessor}.
 */
public class EntityManagerBeanDefinitionRegistrarPostProcessor__BeanDefinitions {
  /**
   * Get the bean definition for 'emBeanDefinitionRegistrarPostProcessor'.
   */
  public static BeanDefinition getEmBeanDefinitionRegistrarPostProcessorBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(EntityManagerBeanDefinitionRegistrarPostProcessor.class);
    beanDefinition.setLazyInit(true);
    beanDefinition.setInstanceSupplier(EntityManagerBeanDefinitionRegistrarPostProcessor::new);
    return beanDefinition;
  }
}
