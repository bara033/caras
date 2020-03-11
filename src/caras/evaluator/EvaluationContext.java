/*
 * EvaluationContext
 * Create Date: 2020. 03. 10.
 * Copyright: SONY MUSIC ENTERTAINMENT
 * Initial-Author: barazakos
 */
package caras.evaluator;

import caras.ctx.ApplicationContext;
import caras.metadata.BeanMetadata;
import caras.metadata.PropertyMetadata;

import java.util.ArrayList;
import java.util.List;

/**
 * @version $Revision$ $LastChangedDate$ 
 * @author $Author$
 */
public class EvaluationContext<_B, _P> {

    private _B bean;
    private BeanMetadata<_B> beanMetadata;
    private PropertyMetadata<_B, _P> propertyMetadata;
    private EvaluatedState state;
    private MessageBuilder messages;

    public EvaluationContext(_B bean, BeanMetadata<_B> beanMetadata, EvaluatedState state) {
        this.bean = bean;
        this.beanMetadata = beanMetadata;
        this.propertyMetadata = null;
        this.state = state;
    }

    public EvaluationContext(_B bean, PropertyMetadata<_B, _P> propertyMetadata, EvaluatedState state) {
        this.bean = bean;
        this.beanMetadata = null;
        this.propertyMetadata = propertyMetadata;
        this.state = state;
    }

    public _B getBean() {
        return bean;
    }

    public BeanMetadata<_B> getBeanMetadata() {
        return beanMetadata;
    }

    public PropertyMetadata<_B, _P> getPropertyMetadata() {
        return propertyMetadata;
    }

    public EvaluatedState getState() {
        return state;
    }

    public MessageBuilder getMessages() {
        return messages;
    }

    public ApplicationContext getApplicationContext() {
        return null; // comes from the current session?
    }

    List<EvaluatorInfo<_B, _P>> getEvaluators() {
        List<EvaluatorInfo<_B, _P>> evaluators = propertyMetadata != null ? (List) propertyMetadata.getEvaluators() : (List) beanMetadata.getEvaluators();
        if (evaluators == null) {
            List<EvaluatorInfo<_B, _P>> all = EvaluatorRegistry.instance().getEvaluators();
            evaluators =  new ArrayList<>();
            for (int i = all.size(); --i >= 0; ) {
                EvaluatorInfo<_B, _P> evaluator = all.get(i);
                if (propertyMetadata == null && !evaluator.supports(beanMetadata))
                    continue;
                if (propertyMetadata != null && !evaluator.supports(propertyMetadata))
                    continue;

                evaluators.add(evaluator);
            }

            if (propertyMetadata != null)
                propertyMetadata.setEvaluators(evaluators);
            else
                beanMetadata.setEvaluators((List) evaluators);
        }
        return evaluators;
    }

    boolean evaluate() {
        List<EvaluatorInfo<_B, _P>> evaluators = getEvaluators();

        boolean returnOnFirst = !state.isMessageState(); // we need to run all the evaluators to get all the messages
        boolean startState = state.isInitial();
        boolean actState = startState;

        for (int i = evaluators.size(); --i >= 0; ) {
            EvaluatorInfo<_B, _P> evaluator = evaluators.get(i);
            if (!evaluator.supports(state, bean))
                continue;

            boolean evaluatedState = evaluator.getInstance().evaluateState(this);

            if (returnOnFirst && evaluatedState != startState)
                return evaluatedState;
            else
                actState = actState | evaluatedState;
        }

        return actState;
    }
}
