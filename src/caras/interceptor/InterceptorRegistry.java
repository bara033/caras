/*
 * InterceptorRegistry
 * Create Date: 2020. 03. 10.
 * Copyright: SONY MUSIC ENTERTAINMENT
 * Initial-Author: barazakos
 */
package caras.interceptor;

import caras.metadata.BeanMetadata;
import caras.metadata.PropertyMetadata;

import java.util.List;

/**
 * @version $Revision$ $LastChangedDate$ 
 * @author $Author$
 */
public interface InterceptorRegistry {

    <_B> List<BeanInterceptorInfo<_B>> getBeanInterceptors();

    <_B, _P> List<PropertyInterceptorInfo<_B, _P>> getPropertyInterceptors();

    static InterceptorRegistry instance() {
        return null; // returns the configured implementer
    }
}
