import jade.core.AID;
import jade.core.Agent;

import java.lang.reflect.Array;
import java.util.Arrays;

public class BookBuyerAgent extends Agent {
    // Book title to buy.
    private String targetBookTitle;

    // Known sellers.
    private AID[] sellerAgents = {
            new AID("seller1", AID.ISLOCALNAME),
            new AID("seller2", AID.ISLOCALNAME)
    };

    // Initialization
    @Override
    protected void setup() {
        System.out.println("Hello! Buyer-agent " + getAID().getName() + " is ready");

        Object[] args = getArguments();
        System.out.println("input: " + Arrays.toString(args));
        if (args != null && args.length > 0) {
            targetBookTitle = (String) args[0];
            System.out.println("Trying to buy: " + targetBookTitle);
        } else {
            System.out.println("No book title specified");
            doDelete();
        }
    }

    @Override
    protected void takeDown() {
        System.out.println("Buyer-agent " + getAID().getName() + " terminating");
    }
}
