/*
 * StateEvaluator
 * Create Date: 2020. 03. 10.
 * Copyright: SONY MUSIC ENTERTAINMENT
 * Initial-Author: barazakos
 */
package caras.evaluator;

/**
 * @version $Revision$ $LastChangedDate$ 
 * @author $Author$
 */
public interface Evaluator<_B, _P> {

    boolean evaluateState(EvaluationContext<_B, _P> ctx);
}
