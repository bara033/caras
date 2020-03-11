/*
 * BeanMetadataFactory
 * Create Date: 2020. 03. 10.
 * Copyright: SONY MUSIC ENTERTAINMENT
 * Initial-Author: barazakos
 */
package caras.metadata;

/**
 * @version $Revision$ $LastChangedDate$ 
 * @author $Author$
 */
public interface BeanMetadataFactory {

    <_B> BeanMetadata<_B> forClass(Class<_B> javaClass);

    default <_B> BeanMetadata<_B> forBean(_B object) {
        return (BeanMetadata<_B>) forClass(object.getClass());
    }

    static BeanMetadataFactory instance() {
        return null; // returns the implementation
    }
}
