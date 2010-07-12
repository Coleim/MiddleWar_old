/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package middlewar.server.business.world.parts;

import middlewar.common.*;
import middlewar.server.business.world.*;
import middlewar.server.worldmaker.business.*;

/**
 *
 * @author jonathan
 */
public class test1_0 extends WorldPartBuilder {

    public test1_0(String name) throws WorldMakerException {
        super(name);
    }

    @Override
    public void generate() throws WorldMakerException {

      // nombre de cases type 1
      int rand1 = (int)(Math.random()*World.MAP_SURFACE.getBlockX()*World.MAP_SURFACE.getBlockY());

      int[][] mapping = new int[World.MAP_SURFACE.getBlockX()-2][World.MAP_SURFACE.getBlockY()-2];

      int count = 0;
      for(int i=2;i<mapping.length;i++){
          //if(count == rand1) break;
          for(int j=2;j<mapping[i].length;j++){
              //if(count == rand1) break;
              //if(i==0 || j==0 || i==mapping.length-1 || j==mapping.length-1)mapping[i][j]=2;
              //if((Math.random()*100)>50){
              //    mapping[i][j]=1;
              //    count++;
              //}else
                  mapping[i][j]=1;
          }
      }

      int[][] mappingBorder = {
                            { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                            { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                            { 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                            { 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                            { 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                            { 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                            { 1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                            { 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                            { 1, 1, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                            { 1, 1, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                            { 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                            { 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                            { 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                            { 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                            { 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                            { 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                            { 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                            { 1, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 },
                            { 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                            { 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                            { 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                            { 1, 1, 0, 1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                            { 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                            { 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                            { 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }
                         };


      this.addPatternCustom(new BlockPosition(0, 0), SurfaceType.water_1_A, 0, mappingBorder, false);

      //this.addPatternCustom(new BlockPosition(2, 2), SurfaceType.grass_1, 0, mapping, true);

      this.addPatternSquare(new BlockSurface(11,2), new BlockPosition(12, 7), SurfaceType.ground_1, true);
      
      
      this.addSizableElement(new BlockPosition(4, 7), ElementType.OBJ3,7,1);
      
      this.addElement(new BlockPosition(7, 5), ElementType.OBJ5);
      this.addElement(new BlockPosition(2, 2), ElementType.NAT1);
      this.addElement(new BlockPosition(5, 9), ElementType.NAT1);
      this.addElement(new BlockPosition(9, 13), ElementType.NAT1);
      this.addElement(new BlockPosition(10, 2), ElementType.NAT2);
      this.addElement(new BlockPosition(24, 6), ElementType.NAT3);
      this.addElement(new BlockPosition(24, 9), ElementType.NAT3);
      

      int[][] mapping2 = {
                            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                            { 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0 },
                            { 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0 },
                            { 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0 },
                            { 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 1, 1, 0 },
                            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                            { 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0 },
                            { 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0 },
                            { 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0 },
                            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }
                         };

      this.addPatternCustom(new BlockPosition(9, 0) , SurfaceType.grass_3, 2,mapping2 , true);


      //this.addBlock(new BlockPosition(24,7), BlockType.ground_1_N);
      //this.addBlock(new BlockPosition(24,8), BlockType.ground_1_C_I);
      //this.addBlock(new BlockPosition(24,9), BlockType.ground_1_C_I);
      //this.addBlock(new BlockPosition(24,10), BlockType.ground_1_S);


      int[][] mapping3 = {
                            { 0, 0, 0, 0, 0, 0 },
                            { 0, 1, 1, 1, 1, 0 },
                            { 0, 1, 1, 1, 1, 0 },
                            { 0, 0, 0, 0, 0, 0 }
                         };

      this.addPatternCustom(new BlockPosition(17, 17) , SurfaceType.grass_3, 1,mapping3 , true);

      this.addBlock(new BlockPosition(10, 10), BlockType.nature_simple_1);
      this.addBlock(new BlockPosition(11, 12), BlockType.nature_simple_2);
      this.addBlock(new BlockPosition(8, 15), BlockType.nature_simple_3);
      this.addBlock(new BlockPosition(5, 2), BlockType.nature_simple_3);

    }

}
