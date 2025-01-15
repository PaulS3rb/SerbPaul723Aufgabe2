package model;

public class TeamPlayer extends Entity {
    int teamId;
    int playerId;

    @Override
    public String toString() {
        return "TeamPlayer{" +
                "id=" + id +
                ", playerId=" + playerId +
                ", teamId=" + teamId +
                '}';
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public TeamPlayer(int id, int teamId, int playerId) {
        super(id);
        this.teamId = teamId;
        this.playerId = playerId;
    }

    public TeamPlayer(int id) {
        super(id);
    }
}
