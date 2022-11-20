package seller;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

import java.util.Hashtable;

public class BookSellerAgent extends Agent {
    // Catalogue of books.
    private Hashtable<String, Integer> catalogue;

    // GUI for adding books to the catalogue.
    private IBookSellerGui myGui;

    @Override
    protected void setup() {
        catalogue = new Hashtable();

        myGui = new BookSellerGui(this);
        myGui.show();

        // Add the behaviour serving requests for offer from buyer agents
        addBehaviour(new OfferRequestServer());

        // Add the behaviour serving purchase orders from buyer agents
        addBehaviour(new PurchaseOrdersServer());
    }

    @Override
    protected void takeDown() {
        myGui.dispose();

        System.out.println("Seller-agent "+getAID().getName()+" terminating.");
    }

    public void updateCatalogue(final String title, final int price) {
        addBehaviour(new OneShotBehaviour() {
            @Override
            public void action() {
                catalogue.put(title, price);
            }
        });
    }

    private class OfferRequestServer extends CyclicBehaviour {
        @Override
        public void action() {
            MessageTemplate mt = MessageTemplate.MatchPerformative(ACLMessage.CFP);
            ACLMessage msg = myAgent.receive(mt);

            if (msg != null) {
                String title = msg.getContent();
                ACLMessage reply = msg.createReply();

                Integer price = catalogue.get(title);

                if (price != null) {
                    reply.setPerformative(ACLMessage.PROPOSE);
                    reply.setContent(String.valueOf(price.intValue()));
                } else {
                    block();
                }

                myAgent.send(reply);
            }
        }
    }
}
