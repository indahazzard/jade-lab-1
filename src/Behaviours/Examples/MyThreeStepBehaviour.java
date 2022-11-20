package Behaviours.Examples;

import jade.core.behaviours.Behaviour;

public class MyThreeStepBehaviour extends Behaviour {
    private int step = 0;
    @Override
    public void action() {
        switch (step) {
            case 0 ->
                //
                    step++;
            case 1 ->
                //
                    step++;
            case 2 ->
                //
                    step++;
        }
    }

    @Override
    public boolean done() {
        return step == 3;
    }
}
