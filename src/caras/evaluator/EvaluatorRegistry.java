/*
 * EvaluatorRegistry
 * Create Date: 2020. 03. 10.
 * Copyright: SONY MUSIC ENTERTAINMENT
 * Initial-Author: barazakos
 */
package caras.evaluator;

import java.util.List;

/**
 * @version $Revision$ $LastChangedDate$ 
 * @author $Author$
 */
public interface EvaluatorRegistry {

    <_B, _P> List<EvaluatorInfo<_B, _P>> getEvaluators();

    static EvaluatorRegistry instance() {
        return null; // returns the configured implementer
    }
}
