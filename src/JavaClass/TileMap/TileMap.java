package JavaClass.TileMap;

import Constant.SystemConstant;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;

import java.io.*;

public class TileMap {
    //region Map Position
    private double x;
    private double y;
    //endregion
    //region Map Bounds
    private int xmin;
    private int ymin;
    private int ymax;
    private int xmax;
    //endregion
    //region Map Properties
    private int [][] map;
    public int numRows;
    public int numCols;
    private int width;
    private int height;
    //endregion
    //region Player Spawn Point
    public int spawnX;
    public int spawnY;
    //endregion
    //region Map Tileset
    private Image tileset;
    private int numTileHorizontal;
    private int numTileVertical;
    private Tile[][] tiles;
    //endregion
    //region Map Actual Drawing Properties
    private int startRow;
    private int startCol;
    private int rowToDraw;
    private int colToDraw;
    //endregion
    public TileMap() throws FileNotFoundException {
        rowToDraw = SystemConstant.SCREEN_HEIGHT/30+2;
        colToDraw = SystemConstant.SCREEN_WIDTH/30+2;
    }
    public void loadTile(String s)
    {
        try{
            tileset=new Image(new FileInputStream(s));
            numTileHorizontal=(int)tileset.getWidth()/30;
            numTileVertical=(int)tileset.getHeight()/30;
            tiles=new Tile[numTileVertical][numTileHorizontal];
            Image subPixel;
            for(int row=0;row<numTileVertical;row++)
            {
                for(int col=0;col<numTileHorizontal;col++)
                {
                    subPixel=new WritableImage(tileset.getPixelReader(),30*col,
                            30*row,30,30);
                    if(row==0&&col==0)
                    {
                        tiles[row][col]=new Tile(subPixel,Tile.NORMAL);
                    }
                    else {
                        tiles[row][col]=new Tile(subPixel,Tile.BLOCKED);
                    }
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    private int layer2[][];//extra layer for decorations
    private int layer3[][];

    public void loadMap(String s)
    {
        try{
            InputStream in=new FileInputStream(s);
            BufferedReader br=new BufferedReader(new InputStreamReader(in));
            numCols=Integer.parseInt(br.readLine());
            numRows=Integer.parseInt(br.readLine());
            spawnX=Integer.parseInt(br.readLine());
            spawnY=Integer.parseInt(br.readLine());
            width = numCols * 30;
            height = numRows * 30;
            xmin = 0;
            xmax = width-SystemConstant.SCREEN_WIDTH;
            ymin = 0;
            ymax = height-SystemConstant.SCREEN_HEIGHT;

            map=new int[numRows][numCols];
            //layer2
            layer2=new int[numRows][numCols];
            //layer3
            layer3=new int[numRows][numCols];

            width=numCols*30;
            height=numRows*30;
            //basic layer for movement
            for(int row =0 ;row<numRows ;row++)
            {
                String line=br.readLine();
                String[] tokens=line.split(",");
                for(int col=0;col<numCols;col++)
                {
                    map[row][col]=Integer.parseInt(tokens[col]);
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public int getType(int row,int col)
    {
        if(row<0||col<0||col>numCols-1||row>numRows-1)
        {
            return Tile.BLOCKED;
        }
        //qui doi vi tri tuong ung
        int tileIndex=map[row][col]; //If Change Layer Check Collide, Change map to layer2,layer3,..
        if(tileIndex==0)
        {
            return Tile.NORMAL;
        }
        int r = (tileIndex-1) / numTileHorizontal;
        int c = (tileIndex-1) % numTileHorizontal;
        return tiles[r][c].getType();
    }
    public void setPosition(double x,double y)
    {
        this.x=x;
        this.y=y;
        fixBounds();
        startCol=(int)this.x/30;
        startRow=(int)this.y/30;
    }
    private void fixBounds() {
        if(x < xmin) x = xmin;
        if(y < ymin) y = ymin;
        if(x > xmax) x = xmax;
        if(y > ymax) y = ymax;
    }
    public void drawMap(GraphicsContext graphicsContext) {
        for (int row = startRow; row < startRow + rowToDraw; row++) {
            if (row >= numRows) break;
            for (int col = startCol;col < startCol + colToDraw;col++) {
                if (col >= numCols) break;
                if (map[row][col] == 0) continue;
                int rc = map[row][col];
                if(rc-1<0) continue;
                int r = (rc - 1) / numTileHorizontal;
                int c = (rc - 1) % numTileHorizontal;
                graphicsContext.drawImage(tiles[r][c].getImage(),-x+col*30,
                        -y + row * 30,30, 30);
            }
        }
    }
    public void drawLayer2(GraphicsContext graphicsContext)
    {
        for (
                int row = startRow;
                row < startRow + rowToDraw;
                row++) {

            if (row >= numRows) break;

            for (
                    int col = startCol;
                    col < startCol + colToDraw;
                    col++) {

                if (col >= numCols) break;

                if (layer2[row][col] == 0) continue;

                int rc = layer2[row][col];
                if(rc-1<0) continue;
                int r = (rc - 1) / numTileHorizontal;
                int c = (rc - 1) % numTileHorizontal;
                graphicsContext.drawImage(
                        tiles[r][c].getImage(),

                        -x+col*30,
                        -y + row * 30,
                        30, 30
                );
            }

        }
    }
    public void drawLayer3(GraphicsContext graphicsContext)
    {
        for (
                int row = startRow;
                row < startRow + rowToDraw;
                row++) {

            if (row >= numRows) break;

            for (
                    int col = startCol;
                    col < startCol + colToDraw;
                    col++) {

                if (col >= numCols) break;

                if (map[row][col] == 0) continue;

                int rc = layer3[row][col];
                if(rc-1<0) continue;
                int r = (rc - 1) / numTileHorizontal;
                int c = (rc - 1) % numTileHorizontal;
                graphicsContext.drawImage(
                        tiles[r][c].getImage(),
                        -x+col*30,
                        -y + row * 30,
                        30, 30
                );
            }

        }
    }

    public double getX()
    {
        return x;
    }
    public double getY()
    {
        return y;
    }

}
