/*
 * Middle War - Client
 *
 */

package middlewar.client.view.units;

import java.awt.*;
import java.awt.image.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Vector;
import middlewar.client.business.Game;

import middlewar.client.view.*;
import middlewar.common.*;
import middlewar.client.business.units.*;
import middlewar.client.exception.ClientException;

/**
 * Unit speak designer
 * @author higurashi
 */
public class UnitSpeakView extends View{

    private UnitSpeak unitSpeak;

    public UnitSpeakView(UnitSpeak unitSpeak) {
        this.unitSpeak = unitSpeak;
    }

    @Override
    public void paint(Graphics g, ImageObserver io, Position position) throws ClientException {

        int length = 2;
        int wordsInLine = 3;

        try{

        String text = unitSpeak.getText();
        StringTokenizer st = new StringTokenizer(text, " ");
        ArrayList<String> lines = new ArrayList<String>();

        if(unitSpeak.getIcon() != null){
            length = 2;
            lines.add("");
        }
        else if(text != null){

            while(st.hasMoreTokens()){
                String line = new String();
                for(int i=0;i<wordsInLine;i++){
                    if(!st.hasMoreTokens()) break;
                    line += st.nextToken() + " ";
                }
                if(line.length()>length) length = line.length();
                lines.add(line);
            }
            
        }

        g.setColor(Color.DARK_GRAY);
        g.fillRoundRect(position.getPxX()+2,
                        position.getPxY()-lines.size()*10-30+2,
                        length*9+10,
                        lines.size()*10+14,
                        20,
                        20);
        Polygon p = new Polygon();
        p.addPoint(position.getPxX()+1, position.getPxY()+1);
        p.addPoint(position.getPxX()+5+3, position.getPxY()-30+3);
        p.addPoint(position.getPxX()+25+2, position.getPxY()-30+2);
        g.fillPolygon(p);

        g.setColor(unitSpeak.getBackgroundColor());
        g.fillRoundRect(position.getPxX(),
                        position.getPxY()-lines.size()*10-30,
                        length*9+10,
                        lines.size()*10+14,
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

        }else if(text != null){
            g.setColor(unitSpeak.getFontColor());
            g.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 14));
            int k = 0;
            for(int i=lines.size()-1;i>=0;i--){
                g.drawString(lines.get(i),
                             position.getPxX()+7,
                             position.getPxY()-k*12-23);
                k ++;
            }
        }

    

    }catch(Exception e){
        Game.getInstance().addInfo(">>"+e.getMessage());

    }
    }


}

