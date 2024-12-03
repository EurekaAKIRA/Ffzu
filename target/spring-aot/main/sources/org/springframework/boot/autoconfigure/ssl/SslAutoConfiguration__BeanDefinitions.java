package org.springframework.boot.autoconfigure.ssl;

import java.util.List;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.boot.ssl.DefaultSslBundleRegistry;

/**
 * Bean definitions for {@link SslAutoConfiguration}.
 */
public class SslAutoConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'sslAutoConfiguration'.
   */
  public static BeanDefinition getSslAutoConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(SslAutoConfiguration.class);
    beanDefinition.setInstanceSupplier(SslAutoConfiguration::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'sslPropertiesSslBundleRegistrar'.
   */
  private static BeanInstanceSupplier<SslPropertiesBundleRegistrar> getSslPropertiesSslBundleRegistrarInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<SslPropertiesBundleRegistrar>forFactoryMethod(SslAutoConfiguration.class, "sslPropertiesSslBundleRegistrar", SslProperties.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(SslAutoConfiguration.class).sslPropertiesSslBundleRegistrar(args.get(0)));
  }

  /**
   * Get the bean definition for 'sslPropertiesSslBundleRegistrar'.
   */
  public static BeanDefinition getSslPropertiesSslBundleRegistrarBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition();
    beanDefinition.setTargetType(SslPropertiesBundleRegistrar.class);
    beanDefinition.setInstanceSupplier(getSslPropertiesSslBundleRegistrarInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'sslBundleRegistry'.
   */
  private static BeanInstanceSupplier<DefaultSslBundleRegistry> getSslBundleRegistryInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<DefaultSslBundleRegistry>forFactoryMethod(SslAutoConfiguration.class, "sslBundleRegistry", List.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(SslAutoConfiguration.class).sslBundleRegistry(args.get(0)));
  }

  /**
   * Get the bean definition for 'sslBundleRegistry'.
   */
  public static BeanDefinition getSslBundleRegistryBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition();
    beanDefinition.setTargetType(DefaultSslBundleRegistry.class);
    beanDefinition.setInstanceSupplier(getSslBundleRegistryInstanceSupplier());
    return beanDefinition;
  }
}
