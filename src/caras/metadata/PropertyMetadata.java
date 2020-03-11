/*
 * PropertyMetadata
 * Create Date: 2020. 03. 10.
 * Copyright: SONY MUSIC ENTERTAINMENT
 * Initial-Author: barazakos
 */
package caras.metadata;

import caras.evaluator.EvaluatorInfo;
import caras.interceptor.BeanInterceptorInfo;
import caras.interceptor.PropertyInterceptorInfo;
import caras.operation.PropertyOperationInfo;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

/**
 * @version $Revision$ $LastChangedDate$ 
 * @author $Author$
 */
public interface PropertyMetadata<_B, _P> {

    BeanMetadata<_B> getBeanMetadata();

    Class<_P> getValueType();

    /**
     * Gets the underlying java field of this property.
     */
    Field getField();

    /**
     * Gets the underlying getter method of this property.
     */
    Method getGetter();

    /**
     * Gets the underlying setter method of this property.
     */
    Method getSetter();

    List<PropertyInterceptorInfo<_B, _P>> getPropertyInterceptors();

    void setPropertyInterceptors(List<PropertyInterceptorInfo<_B, _P>> propertyInterceptors);

    List<EvaluatorInfo<_B, _P>> getEvaluators();

    void setEvaluators(List<EvaluatorInfo<_B, _P>> evaluators);

    List<PropertyOperationInfo<_B, _P>> getPropertyOperations();

    void setPropertyOperations(List<PropertyOperationInfo<_B, _P>> propertyOperations);
}
