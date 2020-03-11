/*
 * PlayerNameInterceptor
 * Create Date: 2020. 03. 10.
 * Copyright: SONY MUSIC ENTERTAINMENT
 * Initial-Author: barazakos
 */
package caras.impl.interceptor;

import caras.impl.bean.Person;
import caras.interceptor.PropertyInterceptor;
import caras.interceptor.PropertyInvocation;
import caras.metadata.PropertyDef;

/**
 * @version $Revision$ $LastChangedDate$ 
 * @author $Author$
 */
public class PersonNameInterceptor implements PropertyInterceptor<Person, String> {

    @Override
    @PropertyDef(name = {"firstName", "lastName"})
    public void intercept(PropertyInvocation<Person, String> invocation) throws Exception {
        invocation.proceed(); // call the next interceptor

        Person person = invocation.getBean();
        person.name = person.firstName + " " + person.lastName;
    }
}
