/*
 * PropertyOperation
 * Create Date: 2020. 03. 10.
 * Copyright: SONY MUSIC ENTERTAINMENT
 * Initial-Author: barazakos
 */
package caras.operation;

import caras.metadata.PropertyMetadata;

/**
 * @version $Revision$ $LastChangedDate$ 
 * @author $Author$
 */
public interface PropertyOperation<_B, _P> {

    Object process(_B bean, PropertyMetadata<_B, _P> propertyMetadata);
}
