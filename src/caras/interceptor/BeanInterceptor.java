/*
 * BeanInterceptor
 * Create Date: 2020. 03. 10.
 * Copyright: SONY MUSIC ENTERTAINMENT
 * Initial-Author: barazakos
 */
package caras.interceptor;

/**
 * @version $Revision$ $LastChangedDate$ 
 * @author $Author$
 */
public interface BeanInterceptor<_B> {

    void intercept(BeanInvocation<_B> invocation) throws Exception;
}
