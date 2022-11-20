package AgentBehaviours;

import jade.core.Agent;
import jade.core.behaviours.WakerBehaviour;

public class WakerBehaviourAgent extends Agent {
    @Override
    protected void setup() {
        System.out.println("Adding waker behaviour");
        addBehaviour(new WakerBehaviour(this, 10000) {
            @Override
            protected void handleElapsedTimeout() {
                //
            }
        });
    }
}
