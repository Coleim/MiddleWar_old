/*
 * Middle War - Server
 * 
 */

package middlewar.server.business.unit;

import middlewar.common.MiddlewarConfiguration;

/**
 * A part of a unit (visual)
 * @author higurashi
 */
public enum PartImage{

    object_1_R_0("object_1/R_0",32,48),
    object_1_R_1("object_1/R_1",32,48),
    object_1_R_2("object_1/R_2",32,48),
    object_1_R_3("object_1/R_3",32,48),
    object_1_L_0("object_1/L_0",32,48),
    object_1_L_1("object_1/L_1",32,48),
    object_1_L_2("object_1/L_2",32,48),
    object_1_L_3("object_1/L_3",32,48),
    object_1_D_0("object_1/D_0",32,48),
    object_1_D_1("object_1/D_1",32,48),
    object_1_D_2("object_1/D_2",32,48),
    object_1_D_3("object_1/D_3",32,48),

    clothing_1_U_0("clothing_1/U_0",32,48),
    clothing_1_U_1("clothing_1/U_1",32,48),
    clothing_1_U_2("clothing_1/U_2",32,48),
    clothing_1_U_3("clothing_1/U_3",32,48),
    clothing_1_R_0("clothing_1/R_0",32,48),
    clothing_1_R_1("clothing_1/R_1",32,48),
    clothing_1_R_2("clothing_1/R_2",32,48),
    clothing_1_R_3("clothing_1/R_3",32,48),
    clothing_1_L_0("clothing_1/L_0",32,48),
    clothing_1_L_1("clothing_1/L_1",32,48),
    clothing_1_L_2("clothing_1/L_2",32,48),
    clothing_1_L_3("clothing_1/L_3",32,48),
    clothing_1_D_0("clothing_1/D_0",32,48),
    clothing_1_D_1("clothing_1/D_1",32,48),
    clothing_1_D_2("clothing_1/D_2",32,48),
    clothing_1_D_3("clothing_1/D_3",32,48),

    clothing_2_U_0("clothing_2/U_0",32,48),
    clothing_2_U_1("clothing_2/U_1",32,48),
    clothing_2_U_2("clothing_2/U_2",32,48),
    clothing_2_U_3("clothing_2/U_3",32,48),
    clothing_2_R_0("clothing_2/R_0",32,48),
    clothing_2_R_1("clothing_2/R_1",32,48),
    clothing_2_R_2("clothing_2/R_2",32,48),
    clothing_2_R_3("clothing_2/R_3",32,48),
    clothing_2_L_0("clothing_2/L_0",32,48),
    clothing_2_L_1("clothing_2/L_1",32,48),
    clothing_2_L_2("clothing_2/L_2",32,48),
    clothing_2_L_3("clothing_2/L_3",32,48),
    clothing_2_D_0("clothing_2/D_0",32,48),
    clothing_2_D_1("clothing_2/D_1",32,48),
    clothing_2_D_2("clothing_2/D_2",32,48),
    clothing_2_D_3("clothing_2/D_3",32,48),

    head_1_R_0("head_1/R_0",32,48),
    head_1_R_1("head_1/R_1",32,48),
    head_1_R_2("head_1/R_2",32,48),
    head_1_R_3("head_1/R_3",32,48),
    head_1_L_0("head_1/L_0",32,48),
    head_1_L_1("head_1/L_1",32,48),
    head_1_L_2("head_1/L_2",32,48),
    head_1_L_3("head_1/L_3",32,48),
    head_1_D_0("head_1/D_0",32,48),
    head_1_D_1("head_1/D_1",32,48),
    head_1_D_2("head_1/D_2",32,48),
    head_1_D_3("head_1/D_3",32,48),

    object_1_U_0("object_1/U_0",32,48),
    object_1_U_1("object_1/U_1",32,48),
    object_1_U_2("object_1/U_2",32,48),
    object_1_U_3("object_1/U_3",32,48),

    head_1_U_0("head_1/U_0",32,48),
    head_1_U_1("head_1/U_1",32,48),
    head_1_U_2("head_1/U_2",32,48),
    head_1_U_3("head_1/U_3",32,48),

    monster_1_U_0("monster_1/U_0",80,91),
    monster_1_U_1("monster_1/U_1",80,91),
    monster_1_U_2("monster_1/U_2",80,91),
    monster_1_U_3("monster_1/U_3",80,91),
    monster_1_R_0("monster_1/R_0",80,91),
    monster_1_R_1("monster_1/R_1",80,91),
    monster_1_R_2("monster_1/R_2",80,91),
    monster_1_R_3("monster_1/R_3",80,91),
    monster_1_L_0("monster_1/L_0",80,91),
    monster_1_L_1("monster_1/L_1",80,91),
    monster_1_L_2("monster_1/L_2",80,91),
    monster_1_L_3("monster_1/L_3",80,91),
    monster_1_D_0("monster_1/D_0",80,91),
    monster_1_D_1("monster_1/D_1",80,91),
    monster_1_D_2("monster_1/D_2",80,91),
    monster_1_D_3("monster_1/D_3",80,91);

    private String unitImage;
    private int x;
    private int y;

    public static final String IMAGE_PATH=MiddlewarConfiguration.getImageDistPath()+"part/";

    private PartImage(String unit,int x,int y){
        this.unitImage = unit;
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getImage() {
        return new String(PartImage.IMAGE_PATH+unitImage+".png");
    }


}
