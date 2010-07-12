/*
 * Middle War - Server
 *
 */

package middlewar.server.xmwp;

import middlewar.server.Server;
import middlewar.server.business.player.Player;
import middlewar.server.business.unit.Unit;
import middlewar.server.exception.ServerException;
import middlewar.server.worldmaker.business.*;
import middlewar.xmwp.*;
import middlewar.xmwp.logic.*;
import middlewar.xmwp.elements.inform.*;
import middlewar.xmwp.elements.request.*;

/**
 * XMWP logic
 * @author higurashi
 */
public class XMWPServerLogic extends XMWPBaseLogic{

    private String playerId; // the player who send the message

    public XMWPServerLogic(String playerId) {
        this.playerId = playerId;
    }

    @Override
    public void onReceivedInformHello(HelloInformElement element, Message message) throws XMWPException {
        // nop
    }

    @Override
    public void onReceivedInformIm(ImInformElement element, Message message) throws XMWPException {
        message.addInform(element);
    }

    @Override
    public void onReceivedRequestBlock(BlockRequestElement element, Message message) throws XMWPException {

        try{

            World w = World.loadWord(WorldName.basic);

            for(String mn : w.getMapsNames()){

                Map map = World.loadMap(mn);
                if(map.getBlocks()!=null)
                    for(Block b : map.getBlocks().values()){
                
                        if(b != null){
                            Element e = b.getXMWPElement();
                            if(e != null) message.addInform(e);
                        }
                        
                
                    }
            }

         }catch(ServerException e){
            message.addInform(new ErrorInformElement(e.getMessage()));
         }catch(Exception e){
            e.printStackTrace();
            message.addInform(new ErrorInformElement("[BUG SERVEUR] "+e.getClass().getName()+" : "+e.getMessage()));
         }
        
    }

    @Override
    public void onReceivedRequestPlayer(PlayerRequestElement element, Message message) throws XMWPException {
        
        try {

            String id = element.getId();

            if(id == null){
                id = this.playerId;
            }

            Player p = Server.playerManager.getPlayer(id);

            String[] units = Server.playerManager.getPlayerUnitsIds(p);

            //message.SendAck();
            message.addInform(new PlayerInformElement(units,p.getId()));


        } catch (ServerException e) {
            message.addInform(new ErrorInformElement(e.getMessage()));
        }
        
    }

    @Override
    public void onReceivedRequestUnit(UnitRequestElement element, Message message) throws XMWPException {
        
        try {

            Unit u = Server.unitManager.getUnit(element.getId());
            message.addInform(new UnitInformElement(u.getId(), u.getPlayerId(), u.getWorld().name()));

        } catch (ServerException e) {
            message.addInform(new ErrorInformElement(e.getMessage()));
        }
          
         
    }




}
