<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>WM doc - biblio</title>
    </head>
    
    <%@page import="middlewar.server.worldmaker.business.*" %>
    <%@page import="middlewar.server.worldmaker.business.elements.*" %>
    <%@page import="middlewar.server.worldmaker.business.animations.*" %>
    <%@page import="middlewar.server.worldmaker.html.*" %>
    <%@page import="middlewar.common.*" %>

    <link href="./wm-style.css" rel="stylesheet" type="text/css" />
    <body>
    <a href="./index.jsp"><img src="./logo.png" class='logo' ></a>
    <br><b>version 1.0 - Library</b> (<a href="./lib.jsp">index</a>)
    <br><br>


    <%

    // test mapping
    int[][] exemple_map = { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                            { 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0 },
                            { 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0 },
                            { 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 0, 0, 0 },
                            { 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 0, 0 },
                            { 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 0, 0 },
                            { 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 0, 0, 0 },
                            { 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 1, 0, 0, 0 },
                            { 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0 },
                            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0 },
                            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                            { 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0 },
                            { 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 0, 0 },
                            { 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0 },
                            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }
                           };

    // test world
    Map world = new Map(new BlockSurface(15, 15),"world-test");
    MapBuilder wb = new MapBuilder(world);

    // background
    wb.addPatternBlock(15,15,BlockPosition.origin,BlockType.dev_nice,true);

    boolean menu = false;

    // show a surface
    if(request.getParameter("surface")!=null){

        int level = 0;
        if(request.getParameter("level")!=null){
            level = Integer.parseInt(request.getParameter("level"));
        }
        SurfaceType surface = SurfaceType.valueOf(request.getParameter("surface"));
        wb.addPatternCustom(BlockPosition.origin, surface, level, exemple_map, true);
        wb.buildWorld();

    // show a element
    }else if(request.getParameter("element")!=null){

        ElementType element = ElementType.valueOf(request.getParameter("element"));
        wb.addElement(BlockPosition.origin.add(new BlockPosition(2, 2)), element);
        wb.buildWorld();

    // show a animation
    }else if(request.getParameter("animation")!=null){
        AnimationType animation = AnimationType.valueOf(request.getParameter("animation"));
        
        try{
            wb.addAnimation(BlockPosition.origin.add(new BlockPosition(2, 2)), animation);
        }catch(WorldMakerException e){
            out.print("<i>"+e.getMessage()+"</i>");
        }
        wb.buildWorld();
        
        MapVisual mv = new MapVisual(world);
        mv.printJs(out);

    }else if(request.getParameter("block")!=null){
        BlockType block = BlockType.valueOf(request.getParameter("block"));
        out.print("&nbsp;<i>BlockType.</i><b>"+block+"</b><br><br>");
        try{
            wb.addPatternBlock(1, 1, new BlockPosition(5, 5), block, true);
        }catch(WorldMakerException e){
            out.print("<i>"+e.getMessage()+"</i>");
        }
        wb.buildWorld();

    }else menu = true;

    // show example world
    if(!menu){
        /*
        MgpRender render = new MgpRender(new BlockSurface(15, 15));
        MgpLayer layer = new MgpLayer(10);
        render.addLayer(layer);
        layer.add(new MgpWorld(world,5,5,0, new BlockPosition(0, 0),new BlockSurface(15,15)));
        render.printHtml(out);
        */
        MapVisual mv = new MapVisual(world);
        mv.printHtml(out);
    }
    // index
    else{

        SurfaceType[] surfaces = SurfaceType.values();
        ElementType[] elements = ElementType.values();
        AnimationType[] animations = AnimationType.values();
        BlockType[] blocks = BlockType.values();

%>
         <ul>
            <li><a href="#surfaces">Surfaces</a> (<% out.print(surfaces.length); %>)</li>
            <li><a href="#elements">Elements</a> (<% out.print(elements.length); %>)</li>
            <li><a href="#animations">Animations</a> (<% out.print(animations.length); %>)</li>
            <li><a href="#blocks">Blocks</a> (<% out.print(blocks.length); %>)</li>
        </ul>
        <br>
<%

        out.print("<a NAME=\"surfaces\"></a><h2>Surfaces</h2>");
        
        out.print("<ul>");
        for(int i=0;i<surfaces.length;i++){
            out.print("<li>");
            out.print("<img class='miniview' src='"+surfaces[i].getBasicSet().O.getFullPathImage()+"'>");
            out.print("<img class='miniview' src='"+surfaces[i].getBasicSet().C_I.getFullPathImage()+"'>");
            out.print("<img class='miniview' src='"+surfaces[i].getBasicSet().E.getFullPathImage()+"'>");
            
            out.print("&nbsp;<i>SurfaceType.</i><a href='?surface="+surfaces[i].name()+"'><b>"+surfaces[i].name()+"</b></a>");
            out.print("&nbsp;(<a href='?surface="+surfaces[i].name()+"&level=2'>+</a>)");
            out.print("</li>");
        }
        out.print("</ul>");

        out.print("<a NAME=\"elements\"></a><h2>Elements</h2>");
        
        out.print("<ul>");
        for(int i=0;i<elements.length;i++){
            out.print("<li>");
            out.print("<i>ElementType.</i><a href='?element="+elements[i].name()+"'>"+elements[i].name()+"</a>, "+elements[i].getDescription());
            if(elements[i].getElementClass().getSuperclass()==WorldSizableElement.class){
                out.print("&nbsp;(<b>SIZABLE</b>)");
            }
            out.print("</li>");
        }
        out.print("</ul>");

        out.print("<a NAME=\"animations\"></a><h2>Animations</h2>");
        
        out.print("<ul>");
        for(int i=0;i<animations.length;i++){
            out.print("<li>");
            out.print("<i>AnimationType.</i><a href='?animation="+animations[i].name()+"'>"+animations[i].name()+"</a>, "+animations[i].getDescription());
            out.print("</li>");
        }
        out.print("</ul>");

        out.print("<a NAME=\"blocks\"></a><h2>All Blocks</h2>");
        
        out.print("<ul>");
        for(int i=0;i<blocks.length;i++){
            out.print("<a href='?block="+blocks[i]+"'><img class='miniview' src='"+blocks[i].getFullPathImage()+"'></a>");
        }
        out.print("</ul>");
        
    }
%>
    </body>
</html>
