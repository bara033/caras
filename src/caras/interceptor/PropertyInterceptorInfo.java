/*
 * PropertyOperationInfo
 * Create Date: 2020. 03. 10.
 * Copyright: SONY MUSIC ENTERTAINMENT
 * Initial-Author: barazakos
 */
package caras.interceptor;

import caras.metadata.PropertyMetadata;
import caras.operation.PropertyOperation;

/**
 * @version $Revision$ $LastChangedDate$ 
 * @author $Author$
 */
public class PropertyInterceptorInfo<_B, _P> {

    final PropertyInterceptor<_B, _P> interceptor;
    final PropertyMetadata<_B, _P> propertyMetadata;

    PropertyInterceptorInfo(PropertyInterceptor<_B, _P> interceptor) {
        this.interceptor = interceptor;
        this.propertyMetadata = null; // here comes the reflective inspection of the given operation instance
    }

    public boolean supports(PropertyMetadata<?, ?> propertyMetadata) {
        return true;
    }

    public boolean supports(_B bean) {
        return true;
    }

    PropertyInterceptor<_B, _P> getInstance() {
        return interceptor;
    }
}
