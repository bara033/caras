/*
 * TypeOperationInfo
 * Create Date: 2020. 03. 10.
 * Copyright: SONY MUSIC ENTERTAINMENT
 * Initial-Author: barazakos
 */
package caras.operation;

import caras.metadata.BeanMetadata;

/**
 * @version $Revision$ $LastChangedDate$ 
 * @author $Author$
 */
public class TypeOperationInfo<_B> {

    final Class<TypeOperation<_B>> operation;
    final BeanMetadata<_B> type;

    TypeOperationInfo(Class<TypeOperation<_B>> operation) {
        this.operation = operation;
        this.type = null; // here comes the reflective inspection of the given operation instance
    }

    public boolean supports(BeanMetadata<?> metadata) {
        return metadata.assignableFrom(type);
    }

    TypeOperation<_B> createInstance() {
        return null; // reflective createNew
    }
}
