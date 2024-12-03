package org.mybatis.spring.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link MapperScannerConfigurer}.
 */
public class MapperScannerConfigurer__BeanDefinitions {
  /**
   * Get the bean definition for 'mapperScannerConfigurer'.
   */
  public static BeanDefinition getMapperScannerConfigurerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(MapperScannerConfigurer.class);
    beanDefinition.setRole(BeanDefinition.ROLE_INFRASTRUCTURE);
    beanDefinition.getPropertyValues().addPropertyValue("processPropertyPlaceHolders", true);
    beanDefinition.getPropertyValues().addPropertyValue("annotationClass", Mapper.class);
    beanDefinition.getPropertyValues().addPropertyValue("basePackage", "com.ffzu");
    beanDefinition.getPropertyValues().addPropertyValue("lazyInitialization", "${mybatis.lazy-initialization:false}");
    beanDefinition.getPropertyValues().addPropertyValue("defaultScope", "${mybatis.mapper-default-scope:}");
    beanDefinition.getPropertyValues().addPropertyValue("sqlSessionTemplateBeanName", "sqlSessionTemplate");
    beanDefinition.setInstanceSupplier(MapperScannerConfigurer::new);
    return beanDefinition;
  }
}
