package org.springframework.boot.autoconfigure.jdbc;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link DataSourceProperties}.
 */
public class DataSourceProperties__BeanDefinitions {
  /**
   * Get the bean definition for 'dataSourceProperties'.
   */
  public static BeanDefinition getDataSourcePropertiesBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(DataSourceProperties.class);
    beanDefinition.setInstanceSupplier(DataSourceProperties::new);
    return beanDefinition;
  }
}
