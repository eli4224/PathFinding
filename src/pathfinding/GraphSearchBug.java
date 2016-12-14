/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pathfinding;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Flower;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import java.awt.Color;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author elicowa
 */
public class GraphSearchBug extends PathBug {
    public GraphSearchBug(Location end) {
        super(end);
    }
    public GraphSearchBug(Color c, Location end) {
        super(c, end);
    }
    public int findBestDirection() {
        Grid<Actor> gr = getGrid();
        int[][] scores = new int[gr.getNumRows()][gr.getNumCols()]; //2D array of the score assigned to each grid location
        ArrayList<Location> full = gr.getOccupiedLocations(); //list of occupied location
        for (Location loc : full) { //for each location in full w/ temp varriable "loc"
            if (!(gr.get(loc) instanceof Flower || gr.get(loc) == this)) { //check to see if "loc" isn't a flower or me
                scores[loc.getRow()][loc.getCol()] = -1; //if "loc" isn't a flower, score it as "-1"
            }
        }
        scores[goal.getRow()][goal.getCol()] = 1; //set the goals's current location's score to 1
        Queue<Location> q = new LinkedList<Location>(); //declare a queue list "q"
        q.add(goal); //add the goal's location to the queue
        while (!q.isEmpty()) { //while the queue has something in it
            Location l = q.remove(); //create new temp varieable "l" from the top of "q" and removes it from "q"
            System.out.println(l);
            if (getLocation().equals(l)) {
                break;
            }
            int score1 = scores[l.getRow()][l.getCol()];//score at "l"
            ArrayList<Location> val = gr.getValidAdjacentLocations(l);
            for (Location next : val) {
                int score2 = scores[next.getRow()][next.getCol()]; //score 2 is the score of "next"
                if (score1 + 1 < score2 || score2 == 0) {
                    scores[next.getRow()][next.getCol()] = score1 + 1;
                    q.add(next);
                }
            }
        }
        ArrayList<Location> adjLocs = gr.getValidAdjacentLocations(this.getLocation());
        System.out.println(adjLocs);
        for (Location check : adjLocs) {
            System.out.println(scores[check.getRow()][check.getCol()]);
            if (scores[check.getRow()][check.getCol()] + 1 == scores[this.getLocation().getRow()][this.getLocation().getCol()]) {
                System.out.println(check);
                return getLocation().getDirectionToward(check);
            }
        }
        return 0;
    }
}
