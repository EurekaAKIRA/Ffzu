package org.springframework.data.web.config;

import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.data.geo.GeoModule;

/**
 * Bean definitions for {@link SpringDataJacksonConfiguration}.
 */
public class SpringDataJacksonConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'springDataJacksonConfiguration'.
   */
  public static BeanDefinition getSpringDataJacksonConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(SpringDataJacksonConfiguration.class);
    beanDefinition.setInstanceSupplier(SpringDataJacksonConfiguration::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'jacksonGeoModule'.
   */
  private static BeanInstanceSupplier<GeoModule> getJacksonGeoModuleInstanceSupplier() {
    return BeanInstanceSupplier.<GeoModule>forFactoryMethod(SpringDataJacksonConfiguration.class, "jacksonGeoModule")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(SpringDataJacksonConfiguration.class).jacksonGeoModule());
  }

  /**
   * Get the bean definition for 'jacksonGeoModule'.
   */
  public static BeanDefinition getJacksonGeoModuleBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition();
    beanDefinition.setTargetType(GeoModule.class);
    beanDefinition.setInstanceSupplier(getJacksonGeoModuleInstanceSupplier());
    return beanDefinition;
  }
}
