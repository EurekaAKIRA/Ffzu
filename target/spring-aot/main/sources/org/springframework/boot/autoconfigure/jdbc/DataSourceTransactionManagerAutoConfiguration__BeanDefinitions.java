package org.springframework.boot.autoconfigure.jdbc;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link DataSourceTransactionManagerAutoConfiguration}.
 */
public class DataSourceTransactionManagerAutoConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'dataSourceTransactionManagerAutoConfiguration'.
   */
  public static BeanDefinition getDataSourceTransactionManagerAutoConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(DataSourceTransactionManagerAutoConfiguration.class);
    beanDefinition.setInstanceSupplier(DataSourceTransactionManagerAutoConfiguration::new);
    return beanDefinition;
  }

  /**
   * Bean definitions for {@link DataSourceTransactionManagerAutoConfiguration.JdbcTransactionManagerConfiguration}.
   */
  public static class JdbcTransactionManagerConfiguration {
    /**
     * Get the bean definition for 'jdbcTransactionManagerConfiguration'.
     */
    public static BeanDefinition getJdbcTransactionManagerConfigurationBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(DataSourceTransactionManagerAutoConfiguration.JdbcTransactionManagerConfiguration.class);
      beanDefinition.setInstanceSupplier(DataSourceTransactionManagerAutoConfiguration.JdbcTransactionManagerConfiguration::new);
      return beanDefinition;
    }
  }
}
