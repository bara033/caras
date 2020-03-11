/*
 * PropertyInterceptor
 * Create Date: 2020. 03. 10.
 * Copyright: SONY MUSIC ENTERTAINMENT
 * Initial-Author: barazakos
 */
package caras.interceptor;

/**
 * @version $Revision$ $LastChangedDate$ 
 * @author $Author$
 */
public interface PropertyInterceptor<_B, _P> {

    void intercept(PropertyInvocation<_B, _P> invocation) throws Exception;
}
