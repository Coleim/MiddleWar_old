/* -----------------------------------------------------------------------------
 *  ________              __     __ _______         __
 * |  |  |  |.-----.----.|  |.--|  |   |   |.---.-.|  |--.-----.----.
 * |  |  |  ||  _  |   _||  ||  _  |       ||  _  ||    <|  -__|   _|
 * |________||_____|__|  |__||_____|__|_|__||___._||__|__|_____|__|
 *
 * Part of MiddleWar project.
 * -----------------------------------------------------------------------------
 * File    : WeHouse1.java
 *
 * History :
 * 1.0     : Add to wm
 *
 */

package middlewar.server.worldmaker.business.elements;

import middlewar.server.worldmaker.business.*;

/**
 * @author Higurashi
 * @version WM 1.0
 * @since WM 1.0
 */
public class WeHouse1 extends WorldSizableElement{

    @Override
    public void build() throws WorldMakerException{

         this.setBlock(0, 0, 0, BlockType.house_1_roof_00,false);
         this.setBlock(1, 0, 0, BlockType.house_1_roof_10,false);
         for(int j=2;j<x+2;j++) {
            this.setBlock(j, 0, 0, BlockType.house_1_roof_20,false);
         }
         this.setBlock(x+2, 0, 0, BlockType.house_1_roof_30,false);
         this.setBlock(x+3, 0, 0, BlockType.house_1_roof_40,false);

         this.setBlock(0, 1, 0, BlockType.house_1_roof_01,false);
         this.setBlock(1, 1, 0, BlockType.house_1_roof_11,false);
         for(int j=2;j<x+2;j++) {
            this.setBlock(j, 1, 0, BlockType.house_1_roof_21,false);
         }
         this.setBlock(x+2, 1, 0, BlockType.house_1_roof_31,false);
         this.setBlock(x+3, 1, 0, BlockType.house_1_roof_41,false);

         for(int i=0;i<y;i++) {
             this.setBlock(0, 2+i, 0, BlockType.house_1_roof_02,false);
             this.setBlock(1, 2+i, 0, BlockType.house_1_roof_12,false);
             for(int j=2;j<x+2;j++) {
                this.setBlock(j, 2+i, 0, BlockType.house_1_roof_22,false);
             }
             this.setBlock(2+x, 2+i, 0, BlockType.house_1_roof_32,false);
             this.setBlock(3+x, 2+i, 0, BlockType.house_1_roof_42,false);
         }

         this.setBlock(0, 2+y, 0, BlockType.house_1_roof_03,false);
         this.setBlock(1, 2+y, 0, BlockType.house_1_roof_13,false);
         for(int j=2;j<x+2;j++) {
            this.setBlock(j, 2+y, 0, BlockType.house_1_roof_23,false);
         }
         this.setBlock(2+x, 2+y, 0, BlockType.house_1_roof_33,false);
         this.setBlock(3+x, 2+y, 0, BlockType.house_1_roof_43,false);

         this.setBlock(0, 3+y, 0, BlockType.house_1_roof_04,false);
         this.setBlock(1, 3+y, 0, BlockType.house_1_roof_14,false);
         for(int j=2;j<x+2;j++) {
            this.setBlock(j, 3+y, 0, BlockType.house_1_roof_24,false);
         }
         this.setBlock(2+x, 3+y, 0, BlockType.house_1_roof_34,false);
         this.setBlock(3+x, 3+y, 0, BlockType.house_1_roof_44,false);

         this.setBlock(0, 4+y, 0, BlockType.house_1_face_00,false);
         this.setBlock(1, 4+y, 0, BlockType.house_1_face_10,false);
         for(int j=2;j<x+3;j++) {
            this.setBlock(j, 4+y, 0, BlockType.house_1_face_20,false);
         }
         this.setBlock(3+x, 4+y, 0, BlockType.house_1_face_30,false);

         this.setBlock(0, 5+y, 0, BlockType.house_1_face_01,false);
         this.setBlock(1, 5+y, 0, BlockType.house_1_face_11,false);
         for(int j=2;j<x+3;j++) {
            this.setBlock(j, 5+y, 0, BlockType.house_1_face_21,false);
         }
         this.setBlock(3+x, 5+y, 0, BlockType.house_1_face_31,false);

         this.setBlock(0, 6+y, 0, BlockType.house_1_face_02,false);
         this.setBlock(1, 6+y, 0, BlockType.house_1_face_12,false);
         for(int j=2;j<x+3;j++) {
            this.setBlock(j, 6+y, 0, BlockType.house_1_face_22,false);
         }
         this.setBlock(3+x, 6+y, 0, BlockType.house_1_face_32,false);
    }

}
