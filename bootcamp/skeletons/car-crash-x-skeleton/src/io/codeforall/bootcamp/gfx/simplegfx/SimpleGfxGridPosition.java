package io.codeforall.bootcamp.gfx.simplegfx;

import io.codeforall.bootcamp.grid.GridDirection;
import io.codeforall.bootcamp.grid.position.AbstractGridPosition;
import io.codeforall.bootcamp.grid.position.GridPosition;
import io.codeforall.bootcamp.grid.GridColor;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

/**
 * Simple graphics position
 */
public class SimpleGfxGridPosition extends AbstractGridPosition {

    private Rectangle rectangle;
    private SimpleGfxGrid simpleGfxGrid;

    /**
     * Simple graphics position constructor
     * @param grid Simple graphics grid
     */
    public SimpleGfxGridPosition(SimpleGfxGrid grid){
        super((int) (Math.random() * grid.getCols()), (int) (Math.random() * grid.getRows()), grid);
        rectangle = new Rectangle(getCol() * 10 + 10, getRow() * 10 + 10, 10,10);
        rectangle.draw();
        simpleGfxGrid = grid;
    }

    /**
     * Simple graphics position constructor
     * @param col position column
     * @param row position row
     * @param grid Simple graphics grid
     */
    public SimpleGfxGridPosition(int col, int row, SimpleGfxGrid grid){
        super(col, row, grid);
        rectangle = new Rectangle(getCol() * 10 + 10, getRow() * 10 + 10, 10,10);
        show();
        simpleGfxGrid = grid;
    }

    /**
     * @see GridPosition#show()
     */
    @Override
    public void show() {
        rectangle.draw();
        rectangle.fill();
    }

    /**
     * @see GridPosition#hide()
     */
    @Override
    public void hide() {
        rectangle.delete();
    }

    /**
     * @see GridPosition#moveInDirection(GridDirection, int)
     */
    @Override
    public void moveInDirection(GridDirection direction, int distance) {
        System.out.println(rectangle.getHeight()/10 + distance + " " + simpleGfxGrid.getRows());
        switch (direction) {
            case UP:
                if (rectangle.getHeight()/10 - distance <= 1)
                    break;
                rectangle.translate(0,distance*10);
                super.setPos(getCol(), getRow() - distance);
                break;
            case DOWN:
                if (rectangle.getHeight()/10 + distance >= simpleGfxGrid.getRows())
                    break;
                rectangle.translate(0, distance*10);
                super.setPos(getCol(), getRow() + distance);
                break;
            case LEFT:
                if (rectangle.getWidth()/10 - distance <= 1)
                    break;
                rectangle.translate(distance*10,0);
                super.setPos(getCol() - distance, getRow());
                break;
            case RIGHT:
                if (rectangle.getWidth()/10 + distance >= getGrid().getCols())
                    break;
                rectangle.translate(distance*10,0);
                super.setPos(getCol() + distance, getRow());
        }
    }

    /**
     * @see AbstractGridPosition#setColor(GridColor)
     */
    @Override
    public void setColor(GridColor color) {
        rectangle.setColor(SimpleGfxColorMapper.getColor(color));
        super.setColor(color);
    }


}
