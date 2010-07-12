/*
 * Middle War - Client
 * version 1.0
 */

package middlewar.client.view;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;
import java.net.MalformedURLException;
import java.net.URL;
import middlewar.client.business.Game;
import middlewar.common.Position;
import middlewar.client.exception.*;


/**
 * Integer graphique
 * @author higurashi
 */
public class IntegerView extends View{

    private int value;

    public IntegerView(int value) {
        this.value=value;
    }

    private void paintInteger(int value,Graphics g, ImageObserver io,Position position,Style type,int count) throws DataException{

        String url="0_small_white.png";

        switch(type){
        
            case white : switch(value){
                case 0 : url="0_small_white.png"; break;
                case 1 : url="1_small_white.png"; break;
                case 2 : url="2_small_white.png"; break;
                case 3 : url="3_small_white.png"; break;
                case 4 : url="4_small_white.png"; break;
                case 5 : url="5_small_white.png"; break;
                case 6 : url="6_small_white.png"; break;
                case 7 : url="7_small_white.png"; break;
                case 8 : url="8_small_white.png"; break;
                case 9 : url="9_small_white.png"; break;
            }break;

            case gold : switch(value){
                case 0 : url="0_small.png"; break;
                case 1 : url="1_small.png"; break;
                case 2 : url="2_small.png"; break;
                case 3 : url="3_small.png"; break;
                case 4 : url="4_small.png"; break;
                case 5 : url="5_small.png"; break;
                case 6 : url="6_small.png"; break;
                case 7 : url="7_small.png"; break;
                case 8 : url="8_small.png"; break;
                case 9 : url="9_small.png"; break;
            }break;

            case blue : switch(value){
                case 0 : url="0_small_blue.png"; break;
                case 1 : url="1_small_blue.png"; break;
                case 2 : url="2_small_blue.png"; break;
                case 3 : url="3_small_blue.png"; break;
                case 4 : url="4_small_blue.png"; break;
                case 5 : url="5_small_blue.png"; break;
                case 6 : url="6_small_blue.png"; break;
                case 7 : url="7_small_blue.png"; break;
                case 8 : url="8_small_blue.png"; break;
                case 9 : url="9_small_blue.png"; break;
            }break;

            case warm : switch(value){
                case 0 : url="0_small_warm.png"; break;
                case 1 : url="1_small_warm.png"; break;
                case 2 : url="2_small_warm.png"; break;
                case 3 : url="3_small_warm.png"; break;
                case 4 : url="4_small_warm.png"; break;
                case 5 : url="5_small_warm.png"; break;
                case 6 : url="6_small_warm.png"; break;
                case 7 : url="7_small_warm.png"; break;
                case 8 : url="8_small_warm.png"; break;
                case 9 : url="9_small_warm.png"; break;
            }break;

            case green : switch(value){
                case 0 : url="0_small_green.png"; break;
                case 1 : url="1_small_green.png"; break;
                case 2 : url="2_small_green.png"; break;
                case 3 : url="3_small_green.png"; break;
                case 4 : url="4_small_green.png"; break;
                case 5 : url="5_small_green.png"; break;
                case 6 : url="6_small_green.png"; break;
                case 7 : url="7_small_green.png"; break;
                case 8 : url="8_small_green.png"; break;
                case 9 : url="9_small_green.png"; break;
            }break;

            case red : switch(value){
                case 0 : url="0_small_red.png"; break;
                case 1 : url="1_small_red.png"; break;
                case 2 : url="2_small_red.png"; break;
                case 3 : url="3_small_red.png"; break;
                case 4 : url="4_small_red.png"; break;
                case 5 : url="5_small_red.png"; break;
                case 6 : url="6_small_red.png"; break;
                case 7 : url="7_small_red.png"; break;
                case 8 : url="8_small_red.png"; break;
                case 9 : url="9_small_red.png"; break;
            }break;

        }

        try {
            URL u = new URL(Game.DATA_URL_NUMBERS + url);
            Image image = Toolkit.getDefaultToolkit().getImage(u);
            g.drawImage(image, position.getPxX() + 16*count, position.getPxY(), io);
        } catch (MalformedURLException e) {
            throw new DataException(e.getMessage());
        }


    }

    public enum Style{
        white,
        red,
        gold,
        green,
        warm,
        blue
    }

    public void paint(Graphics g, ImageObserver io,Position position, Style type) throws ClientException {
        String s = Integer.toString(value);
        for(int i=0;i<s.length();i++){
            Character c = s.charAt(i);
            this.paintInteger(Integer.parseInt(c.toString()), g, io, position, type,i);
        }
    }

    @Override
    public void paint(Graphics g, ImageObserver io,Position position) throws ClientException {
        this.paint(g, io, position, Style.white);
    }
 
}
