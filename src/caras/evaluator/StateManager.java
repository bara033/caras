/*
 * StateManager
 * Create Date: 2020. 03. 10.
 * Copyright: SONY MUSIC ENTERTAINMENT
 * Initial-Author: barazakos
 */
package caras.evaluator;

import caras.metadata.BeanMetadata;
import caras.metadata.BeanMetadataFactory;
import caras.metadata.PropertyMetadata;

/**
 * @version $Revision$ $LastChangedDate$ 
 * @author $Author$
 */
public class StateManager {

    public StateManager instance() {
        return null; // gets the configured instance
    }

    public <_B> boolean evaluateState(_B bean, BeanMetadata<_B> beanMetadata, EvaluatedState state) {
        EvaluationContext<_B, ?> context = new EvaluationContext<>(bean, beanMetadata, state);
        return context.evaluate();
    }

    public <_B> boolean isVisible(_B bean) {
        return evaluateState(bean, BeanMetadataFactory.instance().forBean(bean), EvaluatedState.VISIBLE);
    }

    public <_B> boolean isEditable(_B bean) {
        return evaluateState(bean, BeanMetadataFactory.instance().forBean(bean), EvaluatedState.EDITABLE);
    }

    public <_B> boolean hasError(_B bean) {
        return evaluateState(bean, BeanMetadataFactory.instance().forBean(bean), EvaluatedState.ERRORS);
    }

    public <_B> MessageBuilder evaluateMessages(_B bean, BeanMetadata<_B> beanMetadata, EvaluatedState state) {
        EvaluationContext<_B, ?> context = new EvaluationContext<>(bean, beanMetadata, state);
        return context.getMessages();
    }

    public <_B> MessageBuilder getErrors(_B bean) {
        return evaluateMessages(bean, BeanMetadataFactory.instance().forBean(bean), EvaluatedState.ERRORS);
    }

    public <_B> MessageBuilder getWarnings(_B bean) {
        return evaluateMessages(bean, BeanMetadataFactory.instance().forBean(bean), EvaluatedState.WARNINGS);
    }

    /**
     * Property level evaluation, that we can wire out also into the PropertyMetaData for convenience.
     */
    public <_B, _P> boolean evaluateState(_B bean, PropertyMetadata<_B, _P> propertyMetadata, EvaluatedState state) {
        EvaluationContext<_B, _P> context = new EvaluationContext<>(bean, propertyMetadata, state);
        return context.evaluate();
    }

    public <_B, _P> boolean isVisible(_B bean, PropertyMetadata<_B, _P> propertyMetadata) {
        return evaluateState(bean, propertyMetadata, EvaluatedState.VISIBLE);
    }

    public <_B, _P> boolean isEditable(_B bean, PropertyMetadata<_B, _P> propertyMetadata) {
        return evaluateState(bean, propertyMetadata, EvaluatedState.EDITABLE);
    }

    public <_B, _P> boolean isMandatory(_B bean, PropertyMetadata<_B, _P> propertyMetadata) {
        return evaluateState(bean, propertyMetadata, EvaluatedState.MANDATORY);
    }

    public <_B, _P> MessageBuilder evaluateMessages(_B bean, PropertyMetadata<_B, _P> propertyMetadata, EvaluatedState state) {
        EvaluationContext<_B, ?> context = new EvaluationContext<>(bean, propertyMetadata, state);
        return context.getMessages();
    }

    public <_B, _P> MessageBuilder getErrors(_B bean, PropertyMetadata<_B, _P> propertyMetadata) {
        return evaluateMessages(bean, BeanMetadataFactory.instance().forBean(bean), EvaluatedState.ERRORS);
    }

    public <_B, _P> MessageBuilder getWarnings(_B bean, PropertyMetadata<_B, _P> propertyMetadata) {
        return evaluateMessages(bean, BeanMetadataFactory.instance().forBean(bean), EvaluatedState.WARNINGS);
    }
}
