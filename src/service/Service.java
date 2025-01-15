package service;

import model.Player;
import model.Team;
import model.TeamPlayer;
import repository.IRepository;
import repository.Repository;

import java.util.ArrayList;
import java.util.List;

public class Service {
    private IRepository<Player> playerRepository;
    private IRepository<Team> teamRepository;
    private IRepository<TeamPlayer> teamPlayerRepository;
    public Service() {
        this.playerRepository = Repository.getInstance(Player.class);
        this.teamRepository = Repository.getInstance(Team.class);
        this.teamPlayerRepository = Repository.getInstance(TeamPlayer.class);
        Player Player1 = new Player(1, "Lewandowski", 35, "Striker", 200);
        Player Player2 = new Player(2, "Neuer", 35, "Goalkeeper", 100);
        Player Player3 = new Player(3, "Alaba", 30, "Dallas", 500);
        Player Player4 = new Player(4, "Kimmich", 35, "Midfielder", 100);
        playerRepository.create(Player1);
        playerRepository.create(Player2);
        playerRepository.create(Player3);
        playerRepository.create(Player4);
        Team team1= new Team(1, "Barcelona", "Barcelona");
        Team team2= new Team(2, "Bayern", "Munchen");
        Team team3= new Team(3, "Real Madrid", "Madrid");
        Team team4 = new Team(4, "Atletico Madrid", "Madrid");
        teamRepository.create(team1);
        teamRepository.create(team2);
        teamRepository.create(team3);
        teamRepository.create(team4);
        TeamPlayer teamPlayer1 = new TeamPlayer(1,1,1);
        TeamPlayer teamPlayer2 = new TeamPlayer(2,2,2);
        TeamPlayer teamPlayer3 = new TeamPlayer(3,3,3);
        TeamPlayer teamPlayer4 = new TeamPlayer(4,2,4);
        teamPlayerRepository.create(teamPlayer1);
        teamPlayerRepository.create(teamPlayer2);
        teamPlayerRepository.create(teamPlayer3);
        teamPlayerRepository.create(teamPlayer4);



    }


    public void addPlayer(String name, int age, String position, int marketValue) {
        int id = playerRepository.getNextId();
        Player player = new Player(id, name, age, position, marketValue);
        playerRepository.create(player);
    }

    public Player getPlayer(int id) {
        return playerRepository.read(id);
    }

    public void updatePlayer(int id ,String name, int age, String position, int marketValue) {
        Player Player=new Player(id, name, age, position,marketValue);
        playerRepository.update(Player);
    }

    public void deletePlayer(int id) {
        playerRepository.delete(id);
    }

    public List<Player> getAllPlayer() {
        return playerRepository.getAll();
    }

//    public List<Player> getPlayerByLocation(String location) {
//        List<Player> Playern = playerRepository.getAll();
//        List<Player> newPlayern = new ArrayList<Player>();
//        for(Player Player: Playern) {
//            if(Player.getOrt().equals(location)) {
//                newPlayern.add(Player);
//            }
//        }
//        return newPlayern;
//    }

    public void addTeam(String name, String city) {
        int id = teamRepository.getNextId();
        Team team= new Team(id, name, city);
        teamRepository.create(team);
    }

    public Team getTeam(int id) {
        return teamRepository.read(id);
    }

    public void updateTeam(int id ,String name, String city) {
        Team team=new Team(id, name, city);
        teamRepository.update(team);
    }

    public void deleteTeam(int id) {
        teamRepository.delete(id);
    }

    public List<Team> getAllTeam() {
        return teamRepository.getAll();
    }

    public void addTeamPlayer(int teamId, int playerId) {
        int id = teamPlayerRepository.getNextId();
        TeamPlayer teamPlayer = new TeamPlayer(id, teamId, playerId);
        teamPlayerRepository.create(teamPlayer);

    }

    public TeamPlayer getTeamPlayer(int id) {
        return teamPlayerRepository.read(id);
    }

    public void updateTeamPlayer(int id ,int teamId, int playerId) {
        TeamPlayer teamPlayer=new TeamPlayer(id, teamId, playerId);
        teamPlayerRepository.update(teamPlayer);
    }

    public void deleteTeamPlayer(int id) {
        teamPlayerRepository.delete(id);
    }

    public List<TeamPlayer> getAllTeamPlayer() {
        return teamPlayerRepository.getAll();
    }

    public List<Team> filterTeamByCity(String city) {
        List<Team> teams= teamRepository.getAll();
        List<Team> newTeams= new ArrayList<>();
        for (Team team : teams) {
            if(team.getCity().equals(city)){
                newTeams.add(team);
            }
        }
        return newTeams;
    }

    public List<Player> getAllPlayerFromTeam(String teamName) {
        List<Team> teams= teamRepository.getAll();
        List<Player> players= playerRepository.getAll();
        List<TeamPlayer> teamPlayers = teamPlayerRepository.getAll();
        List<Player> newPlayers= new ArrayList<>();
        int teamId = 0;
        List<Integer> playerIds=null;

        for(Team team : teams){
            if(team.getName().equals(teamName)){
                 teamId = team.getId();
            }
        }

        for(TeamPlayer teamPlayer : teamPlayers){
            if(teamPlayer.getTeamId()==teamId)
                playerIds.add(teamPlayer.getPlayerId());
        }

        for(Player player : players){
            if(playerIds.contains(player.getId()))
                newPlayers.add(player);
        }
        return newPlayers;
    }
}
