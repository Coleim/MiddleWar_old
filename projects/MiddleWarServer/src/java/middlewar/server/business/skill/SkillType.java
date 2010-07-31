/*
 * Middle War - Server
 *
 */

package middlewar.server.business.skill;

import middlewar.common.MiddlewarConfiguration;

/**
 * All game skills
 * @author Higurashi
 */
public enum SkillType {

    // usable
    usable_talk("magic 1 res","skill_1(talk)",EffectType.usable),
    usable_weapon_1("weapon_1","weapon_1(sword)",EffectType.usable),
    usable_armor_1("armor_1","armor_1(small)",EffectType.usable),
    // resistances
    resistance_magic_1("magic 1 res","magic_1(death)",EffectType.resistance),
    resistance_magic_2("magic 2 res","magic_2(electricity)",EffectType.resistance),
    resistance_magic_3("magic 3 res","magic_3(water)",EffectType.resistance),
    resistance_magic_4("magic 4 res","magic_4(ground)",EffectType.resistance),
    resistance_magic_5("magic 5 res","magic_5(wind)",EffectType.resistance),
    resistance_magic_6("magic 6 res","magic_6(ice)",EffectType.resistance),
    resistance_magic_7("magic 7 res","magic_7(fire)",EffectType.resistance),
    resistance_magic_8("magic 8 res","magic_8(good)",EffectType.resistance),
    resistance_magic_9("magic 9 res","magic_9(bad)",EffectType.resistance),
    // status
    status_wound("bléssé","status_1(wound)",EffectType.status),
    status_dead("mort","status_2(dead)",EffectType.status);

    public enum EffectType{
        status,
        usable,
        unusable,
        resistance,
        weakness,
    }

    // Location of the images
    public static final String IMAGE_PATH=MiddlewarConfiguration.getImageDistPath()+"interface/icons/";

    private String name;
    private String icon;
    private EffectType  type;

    /**
     * The skill
     * @param name the name of the skill
     * @param icon the icon of the skill
     * @param type the type of the skill
     */
    private SkillType(String name,String icon,EffectType type){
        this.icon = icon;
        this.name = name;
        this.type = type;
    }

    public EffectType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getFullPathImage() {
        return IMAGE_PATH+this.icon+".png";
    }

    public String getShortPathImage() {
        return this.icon+".png";
    }

}
