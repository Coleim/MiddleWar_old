/*
 * Middle War - Client
 * version 1.0
 */

package middlewar.client.view.units;

import middlewar.client.view.*;
import middlewar.client.view.units.UnitView;
import java.awt.*;
import java.awt.image.ImageObserver;
import middlewar.client.business.AgentUnits;
import middlewar.client.business.AgentWorld;
import middlewar.client.business.Game;
import middlewar.common.*;
import middlewar.client.business.units.*;

import middlewar.client.exception.ClientException;

/**
 * Unit designer
 * @author higurashi
 */
public class AgentUnitsView extends View{

    private AgentUnits agent;

    public AgentUnitsView(AgentUnits agent) {
        this.agent = agent;
    }

    @Override
    public void paint(Graphics g, ImageObserver io, Position position) throws ClientException {
        for(String id : agent.getUnits().keySet()){
            Unit unit = agent.getUnits().get(id);
            UnitView uv = new UnitView(unit);
            Position p = unit.getPosition().relativeTo(Game.getAgentWorld().getFocusPosition());
            p=p.add(new BlockPosition((int)AgentWorld.X/2,(int)AgentWorld.Y/2)); // center
            p=p.add(position);
            uv.paint(g, io, p);
            if(agent.getSelectedUnit().getId().equals(id)){
                g.setColor(Color.yellow);
                g.drawString(unit.getId(), p.getPxX(), p.getPxY());
            }else{
                g.setColor(Color.white);
                g.drawString(unit.getId(), p.getPxX(), p.getPxY());
                g.setColor(Color.white);
                g.drawString("<"+unit.getPlayerId()+">", p.getPxX(), p.getPxY()+10);
            }
        }
        for(UnitSpeak speak : agent.getSpeaks()){
            
            if(!speak.isExpired()){
                UnitSpeakView usv = new UnitSpeakView(speak);
                Position p = agent.getUnit(speak.getUnitId()).getPosition().relativeTo(Game.getAgentWorld().getFocusPosition());
                p=p.add(new BlockPosition((int)AgentWorld.X/2,(int)AgentWorld.Y/2)); // center
                p=p.add(position);
                p=p.add(new PxPosition(Constains.blockPxSize/2, 0));
                usv.paint(g, io, p);
            }
            
        }
    }

}

