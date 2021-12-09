package ru.job4j.chess;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.black.PawnBlack;

public class BishopBlackTest {
    @Test
    public void positionIsTheSame() {
        BishopBlack figure = new BishopBlack(Cell.A3);
        Assert.assertEquals(Cell.A3, figure.position());
    }

    @Test
    public void positionNotTheSame() {
        Cell pos = Cell.G1;
        BishopBlack figure = new BishopBlack(Cell.A5);
        Assert.assertNotEquals(pos, figure.position());
    }

    @Test
    public void copyOnCorrectPosition() {
        Figure figure = new BishopBlack(Cell.D2);
        figure = figure.copy(Cell.D4);
        Assert.assertEquals(Cell.D4, figure.position());
    }

    @Test
    public void wayOnRightAndUp() {
        Cell[] expected = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Assert.assertEquals(expected, bishopBlack.way(Cell.G5));
    }

    @Test
    public void wayOnLeftAndUp() {
        Cell[] expected = {Cell.F2, Cell.E3, Cell.D4, Cell.C5};
        BishopBlack bishopBlack = new BishopBlack(Cell.G1);
        Assert.assertEquals(expected, bishopBlack.way(Cell.C5));
    }

    @Test
    public void wayOnRightAndDown() {
        Cell[] expected = {Cell.C7, Cell.D6, Cell.E5, Cell.F4, Cell.G3};
        BishopBlack bishopBlack = new BishopBlack(Cell.B8);
        Assert.assertEquals(expected, bishopBlack.way(Cell.G3));
    }

    @Test
    public void wayOnLeftAndDown() {
        Cell[] expected = {Cell.D4, Cell.C3, Cell.B2};
        BishopBlack bishopBlack = new BishopBlack(Cell.E5);
        Assert.assertEquals(expected, bishopBlack.way(Cell.B2));
    }

    @Test (expected = ImpossibleMoveException.class)
    public void exceptionImpossibleMoveExceptionInWay() throws FigureNotFoundException,
            OccupiedCellException, ImpossibleMoveException {
        Logic field = new Logic();
        field.add(new BishopBlack(Cell.A3));
        field.move(Cell.A3, Cell.D7);
    }

    @Test (expected = FigureNotFoundException.class)
    public void exceptionFigureNotFoundInFindBY() throws FigureNotFoundException,
            OccupiedCellException, ImpossibleMoveException {
        Logic field = new Logic();
        field.add(new BishopBlack(Cell.A3));
        field.move(Cell.E2, Cell.E3);
    }

    @Test (expected = OccupiedCellException.class)
    public void exceptionOccupiedCellExceptionInFree() throws FigureNotFoundException,
            OccupiedCellException, ImpossibleMoveException {
        Logic field = new Logic();
        field.add(new BishopBlack(Cell.A3));
        field.add(new PawnBlack(Cell.D6));
        field.move(Cell.A3, Cell.E7);
    }
}
