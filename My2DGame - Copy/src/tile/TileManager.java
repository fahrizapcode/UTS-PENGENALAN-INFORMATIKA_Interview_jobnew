package tile;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import main.GamePanel;

public class TileManager {
	GamePanel gp;
	Tile[] tile;
	int mapTileNum[][];
	
	public TileManager(GamePanel gp) {
		
		this.gp = gp;
		tile = new Tile[10];
		mapTileNum = new int[gp.lebarJendela][gp.tinggiJendela];
		getTileImage();
		loadMap();
	}
	public void getTileImage() {
		try {
			tile[0] = new Tile();
			tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/moon.png"));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	public void loadMap() {
		try {
			InputStream is = getClass().getResourceAsStream("/maps/map01.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			int col=0;
			int row=0;
			while(col < gp.lebarJendela && row < gp.tinggiJendela) {
				String line =br.readLine();
				while (col<gp.lebarJendela) {
					String numbers[] = line.split(" ");
					int num= Integer.parseInt(numbers[col]);
					mapTileNum[col][row] = num;
					col++;
				}
				if(col == gp.lebarJendela) {
					col=0;
					row++;
				}
			}
		}catch(Exception e) {
			
		}
	}
	
	public void draw(Graphics2D g2) {
		int col=0;
		int row=0;
		int x=0;
		int y=0;
		while(col < gp.lebarJendela && row < gp.tinggiJendela) {
			int tileNum=mapTileNum[col][row];
			
			g2.drawImage(tile[tileNum].image, x, y, gp.ukuranJendela, gp.ukuranJendela, null);
			col++;
			x += gp.ukuranJendela;
			if(col == gp.lebarJendela) {
				col =0;
				x=0;
				row++;
				y += gp.ukuranJendela;
			}
			
		}
	}
}
