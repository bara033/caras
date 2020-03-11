/*
 * PersonSEvaluator
 * Create Date: 2020. 03. 10.
 * Copyright: SONY MUSIC ENTERTAINMENT
 * Initial-Author: barazakos
 */
package caras.impl.evaluator;

import caras.ctx.User;
import caras.evaluator.EvaluatedState;
import caras.evaluator.EvaluationContext;
import caras.evaluator.Evaluator;
import caras.evaluator.EvaluatorDef;
import caras.impl.bean.Person;
import caras.metadata.PropertyDef;

/**
 * @version $Revision$ $LastChangedDate$ 
 * @author $Author$
 */
public class PersonSEvaluator implements Evaluator<Person, Object> {

    @Override
    @EvaluatorDef(states = {EvaluatedState.VISIBLE, EvaluatedState.EDITABLE})
    @PropertyDef(name = "weight")
    public boolean evaluateState(EvaluationContext<Person, Object> ctx) {
        switch (ctx.getState()) {
            case VISIBLE:
                return evaluateVisible(ctx);
            case EDITABLE:
                return evaluateEditable(ctx);
            default:
                return ctx.getState().isDflt();
        }
    }

    private boolean evaluateVisible(EvaluationContext<Person, Object> ctx) {
        User currentUser = ctx.getApplicationContext().getCurrentUser();
        return ctx.getBean().team.name.equals(currentUser.team);
    }

    private boolean evaluateEditable(EvaluationContext<Person, Object> ctx) {
        User currentUser = ctx.getApplicationContext().getCurrentUser();
        return ctx.getBean().team.name.equals(currentUser.team) && currentUser.teamManager;
    }
}
