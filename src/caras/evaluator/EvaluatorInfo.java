/*
 * StateEvaluatorInfo
 * Create Date: 2020. 03. 10.
 * Copyright: SONY MUSIC ENTERTAINMENT
 * Initial-Author: barazakos
 */
package caras.evaluator;

import caras.metadata.BeanMetadata;
import caras.metadata.PropertyMetadata;

import java.util.EnumSet;

/**
 * @version $Revision$ $LastChangedDate$ 
 * @author $Author$
 */
public class EvaluatorInfo<_B, _P> {

    final Evaluator<_B, _P> evaluator;
    final BeanMetadata<_B> beanMetadata;
    final PropertyMetadata<_B, _P> propertyMetadata;
    final EnumSet<EvaluatedState> supportedStates;

    EvaluatorInfo(Evaluator<_B, _P> evaluator) {
        this.evaluator = evaluator;

        // here comes the reflective inspection of the given operation instance
        this.beanMetadata = null;
        this.propertyMetadata = null;
        this.supportedStates = EnumSet.noneOf(EvaluatedState.class);
    }

    public boolean supports(BeanMetadata<?> beanMetadata) {
        return propertyMetadata == null && this.beanMetadata == beanMetadata;
    }

    public boolean supports(PropertyMetadata<?, ?> propertyMetadata) {
        return this.propertyMetadata == propertyMetadata;
    }

    public boolean supports(EvaluatedState state, _B bean) {
        if (!supportedStates.contains(state))
            return false;
        return true;
    }

    Evaluator<_B, _P> getInstance() {
        return evaluator;
    }
}
