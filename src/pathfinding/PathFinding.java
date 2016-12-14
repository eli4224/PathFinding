/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pathfinding;

import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Rock;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import java.awt.Color;

/**
 *
 * @author elicowa
 */
public class PathFinding {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ActorWorld world = new ActorWorld(new BoundedGrid(16, 33));
        summonPathBugs(world, 10);
        summonRocks(world, 150);
        world.show();
    }
    public static void summonPathBugs(ActorWorld world, int quantity) {
        for (int i = 0; i < quantity; i++) {
            Color c = new Color((float) Math.random(), (float) Math.random(), (float) Math.random());
            GraphSearchBug pb = new GraphSearchBug(c, randomLocation(world.getGrid()));
            world.add(pb);
        }
    }
    public static void summonRocks(ActorWorld world, int quantity) {
        for (int i = 0; i < quantity; i++) {
            Rock r = new Rock();
            world.add(r);
        }
    }
    public static Location randomLocation(Grid<Actor> g) {
        return new Location((int) (Math.random() * g.getNumRows()), (int) (Math.random() * g.getNumCols()));
    }
}
