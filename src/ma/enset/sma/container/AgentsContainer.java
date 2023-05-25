package ma.enset.sma.container;

import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import jade.wrapper.StaleProxyException;


public class AgentsContainer {
    public static void main(String[] args) throws StaleProxyException {
        Runtime instance = Runtime.instance();
        ProfileImpl profile=new ProfileImpl();
        profile.setParameter(ProfileImpl.MAIN_HOST,"localhost");
        AgentContainer agentContainer=instance.createAgentContainer(profile);
        AgentController agentSeller=agentContainer.createNewAgent("seller","ma.enset.sma.javaAgent.SellerAgent",new Object[]{});
        AgentController agentBuyer=agentContainer.createNewAgent("buyer","ma.enset.sma.javaAgent.BuyerAgent",new Object[]{});
        agentSeller.start();
        agentBuyer.start();

    }
}
