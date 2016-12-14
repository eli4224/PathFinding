/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pathfinding;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Bug;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import java.awt.Color;

/**
 *
 * @author elicowa
 */
public abstract class PathBug extends Bug {
    protected Location goal;
    public PathBug(Color c, Location end) {
        super(c);
        this.goal = end;
    }
    public PathBug(Location end) {
        super();
        this.goal = end;
    }
    @Override
    public void putSelfInGrid(Grid<Actor> gr, Location loc) {
        super.putSelfInGrid(gr, loc);
        Actor target = new Actor() {
            @Override
            public void act() {
            }
        };
        target.setColor(getColor());
        target.putSelfInGrid(gr, goal);
    }
    public void setGoal(Location end) {
        goal = end;
    }
    public Location getGoal() {
        return goal;
    }
    public abstract int findBestDirection();
    @Override
    public final void act() {
        if (goal == null) {
            throw new NullPointerException("Goal was null and I got confused. Why u do this to me?!?");
        }
        if (getLocation().equals(goal)) {
            turn();
            return;
        }
        setDirection(findBestDirection());
        move();
    }
}
