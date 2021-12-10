package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell ps) {
        position = ps;
    }

    @Override
    public Cell position() {
        return position;
    }

    @Override
    public Cell[] way(Cell dest) {
        int cx = position.getX();
        int cy = position.getY();
        if (!isDiagonal(position, dest)) {
            throw new ImpossibleMoveException(
                    String.format("Could not way by diagonal from %s to %s", position, dest)
            );
        }
        int size = Math.abs(dest.getX() - cx);
        Cell[] steps = new Cell[size];
        int deltaX = (dest.getX() - cx) > 0 ? 1 : -1;
        int deltaY = (dest.getY() - cy) > 0 ? 1 : -1;
        for (int index = 0; index < size; index++) {
            cx+= deltaX;
            cy+= deltaY;
            steps[index] = Cell.findBy(cx, cy);
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        return (Math.abs(dest.getX() - source.getX()) == Math.abs(dest.getY() - source.getY()));
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
