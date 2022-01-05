package Sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.EdgeShape;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.jnm.slime.Constants;
import com.jnm.slime.SlimeGame;

import Screens.PlayScreen;

public class Slime extends Sprite implements GestureDetector.GestureListener {

    public World world;
    public Body b2body;
    public static int playerDirection = 0;

    float xStart;
    float yStart;

    float xDrag;
    float yDrag;

    boolean gestureStarted = false;

    public Slime(World world) {
        this.world = world;
        defineSlime();
    }

    public void defineSlime() {
        BodyDef bdef = new BodyDef();
        bdef.position.set(Constants.stage1Originx / Constants.PPM, Constants.stage1Originy / Constants.PPM);
        bdef.type = BodyDef.BodyType.DynamicBody;
        b2body = world.createBody(bdef);

        FixtureDef fdef = new FixtureDef();
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(7.4f/Constants.PPM, 7.4f/Constants.PPM);

        fdef.shape = shape;
        b2body.createFixture(fdef);



        EdgeShape touch = new EdgeShape();

        touch.set(new Vector2(7.4f / Constants.PPM, 7.4f / Constants.PPM), new Vector2(-7.4f / Constants.PPM, -7.4f / Constants.PPM));
        fdef.shape = touch;
        fdef.isSensor = true;

        b2body.createFixture(fdef).setUserData("touch");


    }

    @Override
    public boolean fling(float velocityX, float velocityY, int button) {

        if(b2body.getLinearVelocity().epsilonEquals(0,0)){


            if (Math.abs(velocityY) > Math.abs(velocityX)) {

                if (velocityY < 0) {

                    playerDirection = 0;
                    b2body.applyLinearImpulse(new Vector2(0, 16f), b2body.getWorldCenter(), true);



                } else {

                    playerDirection = 2;
                    b2body.applyLinearImpulse(new Vector2(0, -16f), b2body.getWorldCenter(), true);
                }

            } else {

                if (velocityX > 0) {

                    playerDirection = 1;
                    b2body.applyLinearImpulse(new Vector2(16f, 0), b2body.getWorldCenter(), true);

                } else {

                    playerDirection = 3;
                    b2body.applyLinearImpulse(new Vector2(-16f, 0), b2body.getWorldCenter(), true);

                }
            }
        }
        return false;
    }


            @Override
            public boolean touchDown ( float x, float y, int pointer, int button){

                xStart = x;
                yStart = y;

                return true;

            }

            @Override
            public boolean tap ( float x, float y, int count, int button){
                return false;
            }

            @Override
            public boolean longPress ( float x, float y){
                return false;
            }

            @Override
            public boolean pan ( float x, float y, float deltaX, float deltaY){
                return false;
            }

            @Override
            public boolean panStop ( float x, float y, int pointer, int button){
                return false;
            }

            @Override
            public boolean zoom ( float initialDistance, float distance){
                return false;
            }

            @Override
            public boolean pinch (Vector2 initialPointer1, Vector2 initialPointer2, Vector2
            pointer1, Vector2 pointer2){
                return false;
            }

            @Override
            public void pinchStop () {

            }
}
