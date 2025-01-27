
package com.epam.training.sportsbetting.builder;

import java.util.ArrayList;
import java.util.List;

import com.epam.training.sportsbetting.domain.OutcomeOdd;


public class OutcomeOddListBuilder {

    private ArrayList<OutcomeOdd> listOfOutcomeOdds;

    public OutcomeOddListBuilder addList() {
        this.listOfOutcomeOdds = new ArrayList<>();
        return this;
    }

    public OutcomeOddListBuilder addOutcomeOdd(OutcomeOdd outcomeOdd) {
        listOfOutcomeOdds.add(outcomeOdd);
        return this;
    }

    public OutcomeOddBuilder addOutcomeOdd() {
        return new OutcomeOddBuilder(this);
    }

    public List<OutcomeOdd> buildList() {
        return listOfOutcomeOdds;
    }

}
