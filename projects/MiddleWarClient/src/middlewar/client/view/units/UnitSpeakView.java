/*
 * Middle War - Client
 * version 1.0
 */

package middlewar.client.view.units;

import middlewar.client.view.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import middlewar.client.business.Game;
import middlewar.common.*;
import middlewar.client.business.units.*;

import middlewar.client.exception.ClientException;
import middlewar.client.exception.DataException;

/**
 * Unit designer
 * @author higurashi
 */
public class UnitSpeakView extends View{

    private UnitSpeak unitSpeak;

    public UnitSpeakView(UnitSpeak unitSpeak) {
        this.unitSpeak = unitSpeak;
    }

    @Override
    public void paint(Graphics g, ImageObserver io, Position position) throws ClientException {

        //Unit unit = unitSpeak.getUnit();
        int lines = 1;
        int length = 2;
        String[] linesContent = null;
        

        if(unitSpeak.getIcon() != null){

            length = 2;

        }else

        if(unitSpeak.getText() != null){

        linesContent = unitSpeak.getText().split("\n");
        int k = 0;
        for(String line : linesContent){
           
            lines++;
            if(length<line.length()) length = line.length();

        }
        
        }

        g.setColor(Color.DARK_GRAY);
        g.fillRoundRect(position.getPxX()+2,
                        position.getPxY()-lines*10-30+2,
                        length*10+10,
                        lines*10+14,
                        20,
                        20);
        Polygon p = new Polygon();
        p.addPoint(position.getPxX()+1, position.getPxY()+1);
        p.addPoint(position.getPxX()+5+3, position.getPxY()-30+3);
        p.addPoint(position.getPxX()+25+2, position.getPxY()-30+2);
        g.fillPolygon(p);

        g.setColor(unitSpeak.getBackgroundColor());
        g.fillRoundRect(position.getPxX(),
                        position.getPxY()-lines*10-30,
                        length*10+10,
                        lines*10+14,
                        20,
                        20);
        p = new Polygon();
        p.addPoint(position.getPxX(), position.getPxY());
        p.addPoint(position.getPxX()+5, position.getPxY()-30);
        p.addPoint(position.getPxX()+25, position.getPxY()-30);
        g.fillPolygon(p);


        if(unitSpeak.getIcon() != null){

            g.drawImage(unitSpeak.getEmoticon(),
                     position.getPxX()+7,
                     position.getPxY()-35,io);

        }else
        if(unitSpeak.getText() != null){

        g.setColor(unitSpeak.getFontColor());
        g.setFont(new Font(Font.SANS_SERIF, Font.TRUETYPE_FONT, 14));

        int k = 0;
        for(int i=linesContent.length-1;i>=0;i--){
        g.drawString(linesContent[i],
                     position.getPxX()+7,
                     position.getPxY()-k*12-23);
        k ++;
        }

        }
        

    }

}

