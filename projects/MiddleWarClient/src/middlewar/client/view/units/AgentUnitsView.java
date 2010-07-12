/*
 * Middle War - Client
 * version 1.0
 */

package middlewar.client.view.units;

import middlewar.client.view.*;
import middlewar.client.view.units.UnitView;
import java.awt.*;
import java.awt.image.ImageObserver;
import middlewar.common.*;
import middlewar.client.business.units.*;

import middlewar.client.exception.ClientException;

/**
 * Unit designer
 * @author higurashi
 */
public class AgentUnitsView extends View{

    private UnitBoard units;

    public AgentUnitsView(UnitBoard units) {
        this.units = units;
    }

    @Override
    public void paint(Graphics g, ImageObserver io, Position position) throws ClientException {
        for(String id : units.getUnits().keySet()){
            Unit unit = units.getUnits().get(id);
            UnitView uv = new UnitView(unit);
            uv.paint(g, io, unit.getPosition().add(position));
        }
        for(UnitSpeak speak : units.getSpeaks()){
            
            if(!speak.isExpired()){
                UnitSpeakView usv = new UnitSpeakView(speak);
                usv.paint(g, io, speak.getUnit().getPosition().add(position).add(new PxPosition(Constains.blockPxSize/2, 0)));
            }
            
        }
    }

}

