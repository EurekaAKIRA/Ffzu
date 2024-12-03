package org.springframework.security.config.annotation.configuration;

import java.lang.Object;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.core.ResolvableType;
import org.springframework.security.config.annotation.ObjectPostProcessor;

/**
 * Bean definitions for {@link ObjectPostProcessorConfiguration}.
 */
public class ObjectPostProcessorConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'objectPostProcessorConfiguration'.
   */
  public static BeanDefinition getObjectPostProcessorConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ObjectPostProcessorConfiguration.class);
    beanDefinition.setRole(BeanDefinition.ROLE_INFRASTRUCTURE);
    beanDefinition.setInstanceSupplier(ObjectPostProcessorConfiguration::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'objectPostProcessor'.
   */
  private static BeanInstanceSupplier<ObjectPostProcessor> getObjectPostProcessorInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<ObjectPostProcessor>forFactoryMethod(ObjectPostProcessorConfiguration.class, "objectPostProcessor", AutowireCapableBeanFactory.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(ObjectPostProcessorConfiguration.class).objectPostProcessor(args.get(0)));
  }

  /**
   * Get the bean definition for 'objectPostProcessor'.
   */
  public static BeanDefinition getObjectPostProcessorBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition();
    beanDefinition.setTargetType(ResolvableType.forClassWithGenerics(ObjectPostProcessor.class, Object.class));
    beanDefinition.setRole(BeanDefinition.ROLE_INFRASTRUCTURE);
    beanDefinition.setInstanceSupplier(getObjectPostProcessorInstanceSupplier());
    return beanDefinition;
  }
}
