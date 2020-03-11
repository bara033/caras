/*
 * Beanoperation
 * Create Date: 2020. 03. 10.
 * Copyright: SONY MUSIC ENTERTAINMENT
 * Initial-Author: barazakos
 */
package caras.operation;

/**
 * @version $Revision$ $LastChangedDate$ 
 * @author $Author$
 */
public interface BeanOperation<_B> {

    Object process(_B bean);
}
