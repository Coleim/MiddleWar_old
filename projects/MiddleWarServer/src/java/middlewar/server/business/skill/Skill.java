/*
 * Middle War - Server
 *
 */

package middlewar.server.business.skill;

import middlewar.xmwp.XMWPable;

/**
 * A game skill
 * @author Higurashi
 */
public abstract class Skill implements XMWPable{

    protected SkillType type; // the type of the skill

    public Skill(SkillType type){
        this.type = type;
    }

    public SkillType getType() { return type; }

    public void setType(SkillType type) { this.type = type; }

}
