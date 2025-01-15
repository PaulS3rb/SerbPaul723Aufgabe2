package presentation;


import model.Player;
import model.Team;
import model.TeamPlayer;
import service.Service;

import service.Service;

import java.util.ArrayList;
import java.util.List;

public class Console {
    private static Service service;


    public Console() {
        service=new Service();
    }
    public static void run() {

        showMenu();

    }

    private static void showMenu() {
        int choice;

        System.out.println("1. Add Player");
        System.out.println("2. Get a Player");
        System.out.println("3. Update a Player");
        System.out.println("4. Delete a Player");
        System.out.println("5. Show all Players");
        System.out.println("6. Add Team");
        System.out.println("7. Get a Team");
        System.out.println("8. Update a Team ");
        System.out.println("9. Delete a Team");
        System.out.println("10. Show all Team");

        System.out.println("11. Add TeamPlayer");
        System.out.println("12. Get TeamPlayer");
        System.out.println("13. Update teamplayer");
        System.out.println("14. Delete teamplayer");
        System.out.println("15. Show all TeamPlayer");
        System.out.println("Enter your choice: ");
        choice = Integer.parseInt(System.console().readLine());
        int id;
        String name;
        int age;
        String position;
        int marketValue;


        switch (choice) {
            case 1:
                System.out.println("Please enter the name of the Player: ");
                name = System.console().readLine();
                System.out.println("Please enter the age of the Player: ");
                age = Integer.parseInt(System.console().readLine());
                System.out.println("Please enter the position of the Player: ");
                position = System.console().readLine();
                System.out.println("Please enter the price of the Player: ");
                marketValue = Integer.parseInt(System.console().readLine());

                service.addPlayer(name,age,position,marketValue);
                showMenu();
            case 2:
                System.out.println("Please enter the id of the product: ");
                id = Integer.parseInt(System.console().readLine());
                Player player;
                player = service.getPlayer(id);
                System.out.println(player);
                showMenu();

            case 3:
                System.out.println("Please enter the id of the player: ");
                id = Integer.parseInt(System.console().readLine());

                System.out.println("Please enter the name of the Player: ");
                name = System.console().readLine();
                System.out.println("Please enter the age of the Player: ");
                age = Integer.parseInt(System.console().readLine());
                System.out.println("Please enter the position of the Player: ");
                position = System.console().readLine();
                System.out.println("Please enter the price of the Player: ");
                marketValue = Integer.parseInt(System.console().readLine());

                service.updatePlayer(id,name,age,position,marketValue);
                showMenu();
            case 4:
                System.out.println("Please enter the id of the product: ");
                id = Integer.parseInt(System.console().readLine());
                service.deletePlayer(id);
                showMenu();
            case 5:
                List<Player> players = new ArrayList<>();
                players = service.getAllPlayer();
                for(Player player1 : players) {
                    System.out.println(player1);
                }
                showMenu();
            case 6:
                System.out.println("Please enter the name of the Team: ");
                name = System.console().readLine();
                System.out.println("Please enter the city of the Team: ");
                String city= System.console().readLine();
                service.addTeam(name,city);
                showMenu();

            case 7:
                System.out.println("Please enter the id of the team: ");
                id = Integer.parseInt(System.console().readLine());
                Team team= service.getTeam(id);
                System.out.println(team);
                showMenu();

            case 8:
                System.out.println("Please enter the id of the team: ");
                id = Integer.parseInt(System.console().readLine());
                System.out.println("Please enter the name of the Team: ");
                name = System.console().readLine();
                System.out.println("Please enter the city of the Team: ");
                city= System.console().readLine();

                service.updateTeam(id,name,city);
                showMenu();
            case 9:
                System.out.println("Please enter the id of the team: ");
                id = Integer.parseInt(System.console().readLine());
                service.deleteTeam(id);
                showMenu();
            case 10:
                List<Team> teams = new ArrayList<>();
                teams = service.getAllTeam();
                for(Team team1 : teams) {
                    System.out.println(team1);
                }
                showMenu();
            case 11:
                System.out.println("Please enter the id of the team: ");
                int teamId=Integer.parseInt(System.console().readLine());
                System.out.println("Please enter the id of the player: ");
                int playerId=Integer.parseInt(System.console().readLine());
                service.addTeamPlayer(teamId,playerId);
                showMenu();

            case 12:
                System.out.println("Please enter the id of the teamplayer: ");
                id = Integer.parseInt(System.console().readLine());

                TeamPlayer teamPlayer= service.getTeamPlayer(id);
                System.out.println(teamPlayer);
                showMenu();
            case 13:
                System.out.println("Please enter the id of the teamplayer: ");
                id = Integer.parseInt(System.console().readLine());
                System.out.println("Please enter the id of the team: ");
                teamId = Integer.parseInt(System.console().readLine());
                System.out.println("Please enter the id of the player: ");
                playerId = Integer.parseInt(System.console().readLine());
                service.updateTeamPlayer(id,teamId,playerId);
                showMenu();
            case 14:

                System.out.println("Please enter the id of the team: ");
                id = Integer.parseInt(System.console().readLine());
                service.deleteTeamPlayer(id);
                showMenu();

            case 15:
                List<TeamPlayer> teamPlayers = new ArrayList<>();
                teamPlayers = service.getAllTeamPlayer();
                for(TeamPlayer teamPlayer1 : teamPlayers) {
                    System.out.println(teamPlayer1);
                }
                showMenu();

            case 16:
                System.out.println("Please enter the city: ");
                city= System.console().readLine();
                teams = service.filterTeamByCity(city);
                for(Team team1:teams)
                {
                    System.out.println(team1);
                }
            case 17:
                System.out.println("Please enter the id of the name of the team: ");
                String teamName = System.console().readLine();
                players =service.getAllPlayerFromTeam(teamName);
                for(Player player1:players)
                {
                    System.out.println(player1);
                }


        }
    }
}
