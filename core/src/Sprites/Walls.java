//package Sprites;
//
//import com.badlogic.gdx.Gdx;
//import com.badlogic.gdx.maps.tiled.TiledMap;
//import com.badlogic.gdx.math.Rectangle;
//import com.badlogic.gdx.physics.box2d.World;
//
//public class Walls extends InteractiveTileObject{
//    public Walls(World world, TiledMap map, Rectangle bounds){
//        super(world, map, bounds);
//        fixture.setUserData(this);
//    }
//
//    @Override
//    public void onTouch() {
//        Gdx.app.log("Walls", "Collision");
//        System.out.println("touch");
//    }
//}
