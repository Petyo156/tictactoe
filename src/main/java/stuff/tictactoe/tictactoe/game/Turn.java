package stuff.tictactoe.tictactoe.game;


import stuff.tictactoe.tictactoe.enums.Player;
import stuff.tictactoe.tictactoe.enums.Type;

public class Turn {
    private Player player;
    private Type type;

    public Turn(Player player, Type type) {
        this.player = player;
        this.type = type;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
