/*
 * Middle War - Server
 *
 */

package middlewar.server.business.unit;

import middlewar.common.Orientation;

/**
 * A visual part of an unit
 * 
 * @author higurashi
 */
public enum UnitVisual {

    clothing_1(new PartImagesSet(PartImage.clothing_1_U_0,
                                 PartImage.clothing_1_D_0,
                                 PartImage.clothing_1_R_0,
                                 PartImage.clothing_1_L_0)),

    clothing_2(new PartImagesSet(PartImage.clothing_2_U_0,
                                 PartImage.clothing_2_D_0,
                                 PartImage.clothing_2_R_0,
                                 PartImage.clothing_2_L_0)),

    head_1(new PartImagesSet(PartImage.head_1_U_0,
                             PartImage.head_1_D_0,
                             PartImage.head_1_R_0,
                             PartImage.head_1_L_0)),

    monster_1(new PartImagesSet(PartImage.monster_1_U_0,
                                 PartImage.monster_1_D_0,
                                 PartImage.monster_1_R_0,
                                 PartImage.monster_1_L_0)),

    object_1(new PartImagesSet(PartImage.object_1_U_0,
                             PartImage.object_1_D_0,
                             PartImage.object_1_R_0,
                             PartImage.object_1_L_0));

    public final PartImagesSet SET;


    private UnitVisual(PartImagesSet set){
        this.SET = set;
    }

    public PartImage get(Orientation orientation) {
        switch(orientation){
            case UP : return this.getUp();
            case DOWN : return this.getDown(); 
            case RIGHT : return this.getRight();
            case LEFT : return this.getLeft();
            default: return this.getDown();
        }
    }

    public PartImagesSet getSET() {
        return SET;
    }

    public PartImage getDown() {
        return SET.down;
    }

    public PartImage getLeft() {
        return SET.left;
    }

    public PartImage getRight() {
        return SET.right;
    }

    public PartImage getUp() {
        return SET.up;
    }

}
