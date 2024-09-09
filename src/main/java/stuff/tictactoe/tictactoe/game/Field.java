package stuff.tictactoe.tictactoe.game;


import lombok.Getter;
import lombok.Setter;
import stuff.tictactoe.tictactoe.enums.Outcome;
import stuff.tictactoe.tictactoe.enums.Type;

@Getter
@Setter
public class Field {
    private Type fieldTopLeft;
    private Type fieldTopMid;
    private Type fieldTopRight;

    private Type fieldMidLeft;
    private Type fieldMidMid;
    private Type fieldMidRight;

    private Type fieldBottomLeft;
    private Type fieldBottomMid;
    private Type fieldBottomRight;

    public Field() {
        this.fieldTopLeft = Type.UNDEFINED;
        this.fieldTopMid = Type.UNDEFINED;
        this.fieldTopRight = Type.UNDEFINED;
        this.fieldMidLeft = Type.UNDEFINED;
        this.fieldMidMid = Type.UNDEFINED;
        this.fieldMidRight = Type.UNDEFINED;
        this.fieldBottomLeft = Type.UNDEFINED;
        this.fieldBottomMid = Type.UNDEFINED;
        this.fieldBottomRight = Type.UNDEFINED;
    }

    private boolean checkLine(Type a, Type b, Type c) {
        return a != Type.UNDEFINED && a == b && b == c;
    }

    public Outcome gameIsDone() {
        if (checkLine(fieldTopLeft, fieldTopMid, fieldTopRight) || checkLine(fieldMidLeft, fieldMidMid, fieldMidRight) ||
                checkLine(fieldBottomLeft, fieldBottomMid, fieldBottomRight) || checkLine(fieldTopLeft, fieldMidLeft, fieldBottomLeft) ||
                checkLine(fieldTopMid, fieldMidMid, fieldBottomMid) || checkLine(fieldTopRight, fieldMidRight, fieldBottomRight) ||
                checkLine(fieldTopLeft, fieldMidMid, fieldBottomRight) || checkLine(fieldTopRight, fieldMidMid, fieldBottomLeft)) {
            return Outcome.DONE;
        }

        if (isFieldFull()) {
            return Outcome.DRAW;
        }

        return Outcome.NOT_DONE;
    }

    private boolean isFieldFull() {
        return fieldTopLeft != Type.UNDEFINED && fieldTopMid != Type.UNDEFINED && fieldTopRight != Type.UNDEFINED &&
                fieldMidLeft != Type.UNDEFINED && fieldMidMid != Type.UNDEFINED && fieldMidRight != Type.UNDEFINED &&
                fieldBottomLeft != Type.UNDEFINED && fieldBottomMid != Type.UNDEFINED && fieldBottomRight != Type.UNDEFINED;
    }

}
