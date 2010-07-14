/*
 * Middle War - Server
 *
 */

package middlewar.server.xmwp;

import java.util.Stack;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import middlewar.common.BlockPosition;
import middlewar.common.MapPosition;
import middlewar.common.Orientation;
import middlewar.server.Server;
import middlewar.server.ServerSecurity;
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

    private String playerId; // the player who send the messages

    public XMWPServerLogic(String playerId) {
        this.playerId = playerId;
    }

    @Override
    public void onReceivedRequestAck(AckRequestElement element, Message message) throws XMWPException {
        try {

            Player p = Server.playerManager.getPlayerById(playerId);

            // send xmwp updates for specified player
            while(!p.getXmwpUpdates().empty()){
                message.addInform(p.getXmwpUpdates().pop());
            }

        } catch (ServerException e) {
            e.printStackTrace();
            message.addInform(new ErrorInformElement(e.getMessage()));
        }
    }

    @Override
    public void onReceivedInformHello(HelloInformElement element, Message message) throws XMWPException {
        // nop
    }

    @Override
    public void onReceivedInformIm(ImInformElement element, Message message) throws XMWPException {
        try {

            // re-send the IM to the sender
            message.addInform(element);

            // send the IM to all players in the zone
            Unit source = Server.unitManager.getUnit(element.getUnitId());

            Stack<Unit> units = Server.unitManager.getUnitsAtSpeakRange(source);
            Vector<String> players = new Vector();

            while(!units.empty()){
                Unit u = units.pop();
                if(!u.getPlayerId().equals(playerId) && !players.contains(u.getPlayerId())){
                    players.add(u.getPlayerId());
                    Player p = Server.playerManager.getPlayerById(u.getPlayerId());
                    p.addXMWPUpdate(new ImInformElement(source.getId(), u.getPlayerId(), element.getMessage()));
                }
            }

        }catch(ServerException e){
            e.printStackTrace();
            message.addInform(new ErrorInformElement(e.getMessage()));
         }
    }

    @Override
    public void onReceivedRequestBlock(BlockRequestElement element, Message message) throws XMWPException {
        try{
            Map map = Server.worldManager.getMapByName(element.getMap());
            
            // retrive the blocks of the specified map
            if(map.getBlocks()!=null){
                for(Block b : map.getBlocks().values()){
                    if(b != null){
                        Element e = b.getXMWPElement();
                        if(e != null) message.addInform(e);
                    }
                }
            }
            
         }catch(ServerException e){
            e.printStackTrace();
            message.addInform(new ErrorInformElement(e.getMessage()));
         }
    }

    @Override
    public void onReceivedRequestPlayer(PlayerRequestElement element, Message message) throws XMWPException {
        try {

            // set id of the player
            String id = element.getId();
            if(id == null) id = this.playerId;
            
            Player p = Server.playerManager.getPlayerById(id);

            String[] units = Server.playerManager.getPlayerUnitsIds(p);

            message.addInform(new PlayerInformElement(units,p.getId()));

        } catch (ServerException e) {
            e.printStackTrace();
            message.addInform(new ErrorInformElement(e.getMessage()));
        }
        
    }

    @Override
    public void onReceivedRequestUnit(UnitRequestElement element, Message message) throws XMWPException {
        try {

            // the unit requested
            Unit u = Server.unitManager.getUnit(element.getId());

            // get the inform element describing the unit
            UnitInformElement e = getUnitInformElement(u,true);
            message.addInform(e);

            // tell others players
            Server.xmwpUpdateManager.addUpdateInMap(getUnitInformElement(u,false), e.getMap(), playerId);

        } catch (ServerException e) {
            e.printStackTrace();
            message.addInform(new ErrorInformElement(e.getMessage()));
        } catch (WorldMakerException e) {
            e.printStackTrace();
            message.addInform(new ErrorInformElement(e.getMessage()));
        }
         
    }

    @Override
    public void onReceivedRequestMove(MoveRequestElement element, Message message) throws XMWPException {
        try {

            // the unit to move
            Unit u = Server.unitManager.getUnit(element.getId());

            // security test
            if(!u.getPlayerId().equals(playerId)) throw new ServerException("wrong player id to move this unit");

            if(Server.worldManager.canMoveUnitTo(u,element.getX(),element.getY())){
            
                // move the unit
                u.setPosition(new BlockPosition(element.getX(),element.getY()));

                // get the inform element describing the unit
                UnitInformElement e = getUnitInformElement(u,true);
                message.addInform(e);

                // tell others players
                Server.xmwpUpdateManager.addUpdateInMap(getUnitInformElement(u,false), e.getMap(), playerId);

            }

        } catch (ServerException e) {
            e.printStackTrace();
            message.addInform(new ErrorInformElement(e.getMessage()));
        }  catch (WorldMakerException e) {
            e.printStackTrace();
            message.addInform(new ErrorInformElement(e.getMessage()));
        }

    }

    @Override
    public void onReceivedRequestUpdate(UpdateRequestElement element, Message message) throws XMWPException {
        try {

            // the player
            Player p = Server.playerManager.getPlayerById(playerId);

            // update the player watch list
            if(element.isSubscribe()){
                if(!p.getXmwpMapWatch().contains(element.getMap())){
                    p.addXmwpMapWatch(element.getMap());
                }
            }else{
                if(element.getMap()!=null){
                    if(p.getXmwpMapWatch().contains(element.getMap())){
                        p.removeXmwpMapWatch(element.getMap());
                    }
                }
            }

            if(element.getMap()!=null){

                Map map = Server.worldManager.getMapByName(element.getMap());

                // Units
                for(Unit u : Server.unitManager.getUnitsInMap(map)){
                     //if(!u.getPlayerId().equals(playerId))
                     message.addInform(getUnitInformElement(u,false));
                }

            }
            else{

                while(!p.getXmwpUpdates().empty()){
                    message.addInform(p.getXmwpUpdates().pop());
                }
                
            }

        } catch (WorldMakerException e) {
            e.printStackTrace();
            message.addInform(new ErrorInformElement(e.getMessage()));
        } catch (ServerException e) {
            e.printStackTrace();
            message.addInform(new ErrorInformElement(e.getMessage()));
        }

    }

    /**
     * Build a inform element describing an unit
     * @param u the unit to describe
     * @return the inform element
     */
    private UnitInformElement getUnitInformElement(Unit u,boolean focus) throws ServerException, WorldMakerException, XMWPException{
        // the world of the unit
        World w = Server.worldManager.getWorldByName(u.getWorld());
        // get maps
        String[] mapsNames = w.getMapForPosition(u.getPosition());
        // main map
        String m = mapsNames[0];
        // build the inform element
        return 
        new UnitInformElement(u.getId(),
                              u.getPlayerId(),
                              m,
                              u.getPosition().getBlockX(),
                              u.getPosition().getBlockY(),
                              mapsNames,
                              focus);
    }

    @Override
    public void onReceivedInformBye(ByeInformElement element, Message message) throws XMWPException {
        try {

            // the player
            Player p = Server.playerManager.getPlayerById(playerId);

            // save into the database
            Server.playerManager.savePlayer(p);

        } catch (ServerException e) {
            e.printStackTrace();
            message.addInform(new ErrorInformElement(e.getMessage()));
        }
    }




}