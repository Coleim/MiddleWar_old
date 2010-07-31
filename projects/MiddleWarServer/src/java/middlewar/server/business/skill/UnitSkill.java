/*
 * Middle War - Server
 *
 */

package middlewar.server.business.skill;

import middlewar.xmwp.XMWPException;
import middlewar.xmwp.elements.inform.SkillInformElement;

/**
 * An unit skill
 * @author Higurashi
 */
public class UnitSkill extends Skill{

    private int value;
    private String unitId;

    /**
     * Define a unit skill
     * @param type the type of the skill
     * @param value the value (linked to the effect of the skill)
     * @param unitId the unit id linked to the skill
     */
    public UnitSkill(SkillType type,int value,String unitId){
        super(type);
        this.value = value;
        this.unitId = unitId;
    }

    /**
     * Define a unit skill
     * @param type the type of the skill
     * @param unitId the unit id linked to the skill
     */
    public UnitSkill(SkillType type,String unitId){
        super(type);
        this.value = -1;
        this.unitId = unitId;
    }

    /**
     * @see XMWPable
     */
    public SkillInformElement getXMWPElement() throws XMWPException {
        return new SkillInformElement(unitId,type.getName(),type.getFullPathImage(),value);
    }

}
