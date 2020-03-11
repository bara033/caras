/*
 * BeanType
 * Create Date: 2020. 03. 10.
 * Copyright: SONY MUSIC ENTERTAINMENT
 * Initial-Author: barazakos
 */
package caras.metadata;

import caras.evaluator.EvaluatorInfo;
import caras.interceptor.BeanInterceptorInfo;
import caras.operation.BeanOperationInfo;
import caras.operation.TypeOperation;
import caras.operation.TypeOperationInfo;

import java.util.List;

/**
 * This is a question!
 * Hibernate has its own org.hibernate.metadata.ClassMetadata, but it has no property metadata
 *
 * @version $Revision$ $LastChangedDate$
 * @author $Author$
 */
public interface BeanMetadata<_B> {

    /**
     * Gets the java class that represented by this metadata.
     */
    Class<_B> getJavaClass();

    /**
     * Gets all properties of this type.
     */
    List<PropertyMetadata<_B, ?>> getProperties();

    /**
     * Gets a property of this type that has the given name;
     */
    PropertyMetadata<_B, ?> getProperty(String name);

    /**
     * Gets a property by index. Optional.
     */
    PropertyMetadata<_B, ?> getProperty(int index);

    List<BeanInterceptorInfo<_B>> getBeanInterceptors();

    void setBeanInterceptors(List<BeanInterceptorInfo<_B>> beanInterceptors);

    List<EvaluatorInfo<_B, ?>> getEvaluators();

    void setEvaluators(List<EvaluatorInfo<_B, ?>> evaluators);

    List<TypeOperationInfo<_B>> getTypeOperations();

    void setTypeOperations(List<TypeOperationInfo<_B>> typeOperations);

    List<BeanOperationInfo<_B>> getBeanOperations();

    void setBeanOperations(List<BeanOperationInfo<_B>> beanOperations);

    default boolean assignableFrom(BeanMetadata<?> other) {
        return getJavaClass().isAssignableFrom(other.getJavaClass());
    }
}
