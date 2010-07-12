/*
 * Middle War - Client
 * version 1.0
 */

package middlewar.client.business.units;

import java.awt.Color;
import java.awt.Image;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Calendar;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import middlewar.client.business.Game;
import middlewar.common.Orientation;
import middlewar.client.exception.ClientException;
import middlewar.client.exception.DataException;

/**
 * Unit speak (dialog)
 * @author higurashi
 */
public class UnitSpeak {

    private String text = null;
    private Unit unit;
    private Calendar expire;
    private emoticon icon = null;
    private Color fontColor = Color.BLACK;
    private Color backgroundColor = Color.WHITE;


    public UnitSpeak(){
        expire = Calendar.getInstance();
        expire.add(Calendar.SECOND, 5);
    }

    public UnitSpeak(String text,Unit unit) {
        this();
        this.text = text;
        this.unit = unit;
        
    }

    public UnitSpeak(emoticon icon,Unit unit) {
        this();
        this.unit = unit;
        this.icon = icon;
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public Color getFontColor() {
        return fontColor;
    }

    public void setFontColor(Color fontColor) {
        this.fontColor = fontColor;
    }


    public emoticon getIcon() {
        return icon;
    }

    public void setIcon(emoticon icon) {
        this.icon = icon;
    }

    public boolean isExpired(){
        if(Calendar.getInstance().after(expire)) return true; else return false;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public Image getEmoticon() throws ClientException{
        if(this.icon != null){
            try {
                return Game.getImage(new URL(Game.DATA_URL_SCREEN + "emoticon_" + this.icon.name() + ".png"));
            } catch (MalformedURLException e) {
                throw new DataException(e);
            }
        }else return null;
    }

    public enum emoticon{
        evilgrin,
        grin,
        happy,
        smile,
        surprised,
        tongue,
        unhappy,
        wink
    }

}
