/*
 * InterceptorManager
 * Create Date: 2020. 03. 10.
 * Copyright: SONY MUSIC ENTERTAINMENT
 * Initial-Author: barazakos
 */
package caras.interceptor;

import caras.metadata.BeanMetadata;
import caras.metadata.PropertyMetadata;

import java.util.ArrayList;
import java.util.List;

/**
 * @version $Revision$ $LastChangedDate$ 
 * @author $Author$
 */
public class InterceptorManager {

    public static InterceptorManager instance() {
        return null; // returns the configured instance
    }

    protected <_B> void processBean(BeanMetadata<_B> beanMetadata, _B bean, BeanOperation operation) throws Exception {
        List<BeanInterceptorInfo<_B>> interceptors = beanMetadata.getBeanInterceptors();
        if (interceptors == null) {
            List<BeanInterceptorInfo<_B>> all = InterceptorRegistry.instance().getBeanInterceptors();
            interceptors = new ArrayList<>(all.size());

            for (int i = all.size(); --i >= 0; ) {
                BeanInterceptorInfo<_B> interceptor = all.get(i);
                if (interceptor.supports(beanMetadata))
                    interceptors.add(interceptor);
            }
            beanMetadata.setBeanInterceptors(interceptors);
        }

        BeanInvocation<_B> invocation = new BeanInvocation<_B>(bean, beanMetadata, operation, interceptors);
        invocation.proceed();
    }

    protected <_B, _P> void processProperty(PropertyMetadata<_B, _P> propertyMetadata, _B bean, _P originalValue, _P newValue) throws Exception {
        List<PropertyInterceptorInfo<_B, _P>> interceptors = propertyMetadata.getPropertyInterceptors();
        if (interceptors == null) {
            List<PropertyInterceptorInfo<_B, _P>> all = InterceptorRegistry.instance().getPropertyInterceptors();
            interceptors = new ArrayList<>(all.size());

            for (int i = all.size(); --i >= 0; ) {
                PropertyInterceptorInfo<_B, _P> interceptor = all.get(i);
                if (interceptor.supports(propertyMetadata))
                    interceptors.add(interceptor);
            }
            propertyMetadata.setPropertyInterceptors(interceptors);
        }

        PropertyInvocation<_B, _P> invocation = new PropertyInvocation<_B, _P>(bean, originalValue, newValue, propertyMetadata, interceptors);
        invocation.proceed();
    }
}
