package sample;

import javafx.scene.paint.Color;

/**
 * Observer interface.
 */
public interface Observer {
    /**
     *The update method called when state change occur in model.
     * When position change occurred, person is drown with using drawPerson method on new position.
     * If previous location should be deleted,we delete previous location with removePerson method.
     * @param x is coordinate x.
     * @param y is coordinate y.
     * @param drawOrRemove is whether person will drawing or deleting.
     * @param color is color.
     */
    public void update(double x, double y, int drawOrRemove, Color color);
    /**
     *The updateToPrint method called every second  via model.
     * The total count of infected, healthy, hospitalized and dead numbers are shown on canvas.
     * @param string is up to date information.
     */
    public void updateToPrint(String string);
}
