/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pathfinding;

import info.gridworld.grid.Location;
import java.awt.Color;

/**
 *
 * @author elicowa
 */
public class AStarBug extends PathBug {
    public AStarBug(Location end) {
        super(end);
    }
    public AStarBug(Color c, Location end) {
        super(c, end);
    }
    @Override
    public int findBestDirection() {
        return 1;
    }
}
