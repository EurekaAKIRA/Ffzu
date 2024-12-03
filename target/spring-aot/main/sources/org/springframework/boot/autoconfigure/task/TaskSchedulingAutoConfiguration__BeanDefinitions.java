package org.springframework.boot.autoconfigure.task;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.boot.task.TaskSchedulerBuilder;

/**
 * Bean definitions for {@link TaskSchedulingAutoConfiguration}.
 */
public class TaskSchedulingAutoConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'taskSchedulingAutoConfiguration'.
   */
  public static BeanDefinition getTaskSchedulingAutoConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(TaskSchedulingAutoConfiguration.class);
    beanDefinition.setInstanceSupplier(TaskSchedulingAutoConfiguration::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'taskSchedulerBuilder'.
   */
  private static BeanInstanceSupplier<TaskSchedulerBuilder> getTaskSchedulerBuilderInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<TaskSchedulerBuilder>forFactoryMethod(TaskSchedulingAutoConfiguration.class, "taskSchedulerBuilder", TaskSchedulingProperties.class, ObjectProvider.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(TaskSchedulingAutoConfiguration.class).taskSchedulerBuilder(args.get(0), args.get(1)));
  }

  /**
   * Get the bean definition for 'taskSchedulerBuilder'.
   */
  public static BeanDefinition getTaskSchedulerBuilderBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition();
    beanDefinition.setTargetType(TaskSchedulerBuilder.class);
    beanDefinition.setInstanceSupplier(getTaskSchedulerBuilderInstanceSupplier());
    return beanDefinition;
  }
}
