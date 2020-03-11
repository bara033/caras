/*
 * BeanInvocation
 * Create Date: 2020. 03. 10.
 * Copyright: SONY MUSIC ENTERTAINMENT
 * Initial-Author: barazakos
 */
package caras.interceptor;

import caras.metadata.BeanMetadata;

import java.util.List;

/**
 * @version $Revision$ $LastChangedDate$ 
 * @author $Author$
 */
public class BeanInvocation<_B> {

    private final _B bean;
    private final BeanMetadata<_B> beanMetadata;
    private final BeanOperation operation;
    private final List<BeanInterceptorInfo<_B>> interceptors;
    private int idx = 0;

    public BeanInvocation(_B bean, BeanMetadata<_B> beanMetadata, BeanOperation operation, List<BeanInterceptorInfo<_B>> interceptors) {
        this.bean = bean;
        this.beanMetadata = beanMetadata;
        this.operation = operation;
        this.interceptors = interceptors;
    }

    public final _B getBean() {
        return bean;
    }

    public final BeanMetadata<_B> getBeanMetadata() {
        return beanMetadata;
    }

    public final BeanOperation getOperation() {
        return operation;
    }

    public void proceed() throws Exception {
        BeanInterceptorInfo<_B> nextInterceptor;
        for (;;) {
            if (idx >= interceptors.size())
                return;
            idx++;

            nextInterceptor = interceptors.get(idx);
            if (nextInterceptor.supports(bean, operation))
                break;
        }

        nextInterceptor.getInstance().intercept(this);
    }
}
