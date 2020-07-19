package collections;

public class DemoMain {
    public static void main(String[] args) {
        Team team = new Team();
        team.initTeam();
        System.out.println(team);

        team.increaseScope();
        System.out.println(team);
    }
}
