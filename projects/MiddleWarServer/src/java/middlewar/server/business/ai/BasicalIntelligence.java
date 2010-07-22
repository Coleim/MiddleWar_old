/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package middlewar.server.business.ai;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import middlewar.server.Server;
import middlewar.server.business.player.Player;
import middlewar.server.business.unit.Unit;
import middlewar.server.engine.GameEngine;
import middlewar.server.exception.ServerException;
import middlewar.xmwp.XMWPException;
import middlewar.xmwp.elements.inform.ImInformElement;

/**
 *
 * @author coleim
 */
public class BasicalIntelligence extends ArtificialIntelligence {

    private static int TIME_PAUSE = 5;
    private int timeStamp = TIME_PAUSE;
    private int index = 0;

    private List<String> talkList = new ArrayList<String>();

    public BasicalIntelligence(Unit parentUnit) {
        super(parentUnit);

        talkList.add("Bonjour !");
        talkList.add("Je suis une Intelligence Artificielle !");
        talkList.add("Mais une de base.");
        talkList.add("En gros, je parle.");
        talkList.add("Et c'est tout.");
        talkList.add("Et en plus, c'est même pas des réponses à ce que tu me demandes.");
        talkList.add("Je parles tout seul quoi.");
        talkList.add("Sinon, je suis un lapin !");
        talkList.add("Et je t'emmerde.");
        talkList.add("Tu veux une pipe au miel?");
        talkList.add("Avec du gros sel de bretagne.");
        talkList.add("Celui qui lit ça est un idiot.");
        talkList.add("POWNED !!!!");
        talkList.add("Oui, je sais, c'est petit.");
        talkList.add("CTB !!!");
        talkList.add("Vive Goblink !");
        talkList.add("Allé, je boucle.");

    }

    @Override
    public void live() {

        if( timeStamp > 0 ) {
            --timeStamp;
        } else {
            timeStamp = TIME_PAUSE;
            talk();
        }
    }

    private void talk() {
       
        try {
                Player p = Server.playerManager.getPlayerById("test1");
                p.addXMWPUpdate(new ImInformElement(this.parentUnit.getId(), null, getNextDialog() ));
                //p.addXMWPUpdate(new ImInformElement(this.parentUnit.getId(), null, "Hello !" ));
        } catch (XMWPException ex) {
            Logger.getLogger(BasicalIntelligence.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ServerException ex) {
            Logger.getLogger(BasicalIntelligence.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private String getNextDialog() {

        String dialog = talkList.get(index);

        ++index;
        if( index >= talkList.size() ) {
            index = 0;
        }

        return dialog;
    }



}
