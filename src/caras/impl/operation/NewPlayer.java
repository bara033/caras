/*
 * NewPlayer
 * Create Date: 2020. 03. 10.
 * Copyright: SONY MUSIC ENTERTAINMENT
 * Initial-Author: barazakos
 */
package caras.impl.operation;

import caras.impl.bean.Person;
import caras.impl.bean.Team;
import caras.operation.BeanOperation;

/**
 * @version $Revision$ $LastChangedDate$ 
 * @author $Author$
 */
public class NewPlayer implements BeanOperation<Team> {

    @Override
    public Object process(Team team) {
        Person person = new Person();
        person.firstName = "Aaron"; // this can come from some context that contains the client request, but it is not in this mockup
        person.lastName = "Rodgers";
        person.isPlayer = true;
        person.team = team;

        return person;
    }
}
