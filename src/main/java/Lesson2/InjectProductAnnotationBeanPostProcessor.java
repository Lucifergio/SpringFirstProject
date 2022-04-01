package Lesson2;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;

@Component
public class InjectProductAnnotationBeanPostProcessor implements BeanPostProcessor {

    List<Product> prod = List.of(
            new Product(1, "QQQ", 100),
            new Product(2, "WWW", 200),
            new Product(3, "EEE", 300),
            new Product(4, "RRR", 400),
            new Product(5, "TTT", 500)
    );
    Integer id = 5;

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        for (Field field : bean.getClass().getDeclaredFields()) {
            InjectProduct annotation = field.getAnnotation(InjectProduct.class);
            if (annotation != null) {
                field.setAccessible(true);

                if (field.getClass().equals(Integer.class)) {
                    ReflectionUtils.setField(field, bean, this.id);
                    continue;
                }
                ReflectionUtils.setField(field, bean, prod);

            }
        }

        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }
}
