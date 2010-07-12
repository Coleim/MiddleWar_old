/*
 * Middle War - Client
 * version 1.0
 */

package middlewar.client.business.skills;

import java.awt.*;
import middlewar.client.business.Game;

/**
 * Basic unit skill
 * @author higurashi
 */
public class Skill {

    public Image icon;
    
    public Skill() {
        this.icon = Toolkit.getDefaultToolkit().getImage(Game.DATA_URL_ICONS+"void_g.png");
    }

    public Skill(String image) {
        this.icon = Toolkit.getDefaultToolkit().getImage(Game.DATA_URL_ICONS+image);
    }

    public Image getIcon() {
        return icon;
    }

    public void setIcon(Image icon) {
        this.icon = icon;
    }

}
