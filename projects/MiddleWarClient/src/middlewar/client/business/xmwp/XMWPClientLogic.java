/*
 * Middle War Client
 *
 */

package middlewar.client.business.xmwp;

import java.util.logging.Level;
import java.util.logging.Logger;
import middlewar.client.business.Game;
import middlewar.xmwp.elements.inform.*;
import middlewar.xmwp.elements.request.*;
import middlewar.client.business.units.*;
import middlewar.client.business.world.Map;
import middlewar.client.exception.ClientException;
import middlewar.xmwp.*;
import middlewar.xmwp.logic.*;

/**
 * XMWP logic
 * @author higurashi
 */
public class XMWPClientLogic extends XMWPBaseLogic{

    private XMWPClientThread link;
    private Game game;


    public XMWPClientLogic(XMWPClientThread link) {
        this.link = link;
        this.game = link.getGame();
    }

    @Override
    public void onReceivedInformPlayer(PlayerInformElement element, Message message) throws XMWPException {
        String ids[] = element.getUnits();
        for(String id : ids){
            message.addRequest(new UnitRequestElement(id));
        }
        if(game.getPlayerId()==null){
            try {
                game.setPlayerId(element.getId());
                game.addInfo("ID : "+game.getPlayerId());
            } catch (ClientException e) {
                game.addError(e.getMessage());
            }
        }
    }

    @Override
    public void onReceivedInformUnit(UnitInformElement element, Message message) throws XMWPException {

        Unit u = new Unit(element.getId());
        u.setPlayerId(element.getPlayerId());
        u.setX(element.getX());
        u.setY(element.getY());
        u.addGraphicalPart("m_1", 0, 0, 0, 0);

        try {

            if(Game.getAgentUnits().unitExist(u.getId())){
                game.modifyUnit(u);
            }
            else{
                game.addUnit(u);
            }

            if(element.isFocus()){
                Game.getAgentUnits().setFocus(u);
                Game.getAgentWorld().setFocusPosition(u.getPosition());
            }
            
            for(String map : element.getMaps()){
                if(!Game.getAgentWorld().maps.containsKey(map)){
                    Game.getAgentWorld().maps.put(map, new Map(map));
                    message.addRequest(new BlockRequestElement(map));
                    message.addRequest(new UpdateRequestElement(map,true));
                }
            }

        } catch (ClientException e) {
            game.addError("error unit "+u.toString()+" "+e.getMessage());
        }
        

    }

    @Override
    public void onReceivedInformIm(ImInformElement element, Message message)  {
        try {
            Unit u = Game.getAgentUnits().getUnit(element.getUnitId());
            UnitSpeak us = new UnitSpeak(element.getMessage(), u.getId());
            Game.getAgentUnits().addUnitSpeak(us);
            game.addUnitSpeakToChat(us);
        } catch (ClientException e) {
            game.addError(e.getMessage());
        }
        
    }

    @Override
    public void onReceivedInformError(ErrorInformElement element, Message message) {
        game.addError(element.getMessage());
    }

    @Override
    public void onReceivedInformBlock(BlockInformElement element, Message message) {
        
        try {

            if(Game.getAgentWorld().maps.containsKey(element.getMap())){
                Game.getAgentWorld().setBlock(
                        element.getX(),
                        element.getY(),
                        element.getMap(),
                        element.getLayer(),
                        element.getOrder(),
                        element.getImage()
                );

            }else throw new ClientException(element.getMap()+" unknown");

        } catch (ClientException e) {
            game.addError(e.getMessage());
        } 

    }

    @Override
    public void onReceivedInformMove(MoveInformElement element, Message message) throws XMWPException {
        try {

            String map = element.getMap();

            if(Game.getAgentUnits().unitExist(element.getId())){
                Unit u = Game.getAgentUnits().getUnit(element.getId());
                u.setX(element.getX());
                u.setY(element.getY());
                u.setMap(map);
                game.modifyUnit(u);
            }

            if(!Game.getAgentWorld().maps.containsKey(map)){
                Game.getAgentWorld().maps.put(map, new Map(map));
                message.addRequest(new BlockRequestElement(map));
                message.addRequest(new UpdateRequestElement(map,true));
            }

        } catch (ClientException e) {
            game.addError(e.getMessage());
        }

    }



}
