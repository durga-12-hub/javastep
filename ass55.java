import java.util.Arrays;
import java.util.Scanner;

public class ass55 implements Comparable<ass55> {

    String name;
    int matchesPlayed;
    double battingAverage;
    boolean injured;

    public ass55(String name, int matchesPlayed, double battingAverage, boolean injured) {
        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.battingAverage = battingAverage;
        this.injured = injured;
    }

    static boolean isDraftable(int matchesPlayed) {
        return matchesPlayed >= 10;
    }

    static boolean isDraftable(int matchesPlayed, boolean injured) {
        return matchesPlayed >= 5 && !injured;
    }

    @Override
    public int compareTo(ass55 other) {
        return Double.compare(other.battingAverage, this.battingAverage);
    }

    static String draftAndRank(ass55[] players) {

        ass55[] draftable = new ass55[players.length];
        int count = 0;

        for (ass55 player : players) {

            if (isDraftable(player.matchesPlayed) ||
                isDraftable(player.matchesPlayed, player.injured)) {

                draftable[count] = player;
                count++;
            }
        }

        draftable = Arrays.copyOf(draftable, count);

        Arrays.sort(draftable);

        String result = "";

        for (int i = 0; i < draftable.length; i++) {

            result += (i + 1) + ". " + draftable[i].name;

            if (i < draftable.length - 1) {
                result += " | ";
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of players: ");
        int n = sc.nextInt();
        sc.nextLine();

        ass55[] players = new ass55[n];

        for (int i = 0; i < n; i++) {

            System.out.println("\nPlayer " + (i + 1));

            System.out.print("Enter name: ");
            String name = sc.nextLine();

            System.out.print("Enter matches played: ");
            int matches = sc.nextInt();

            System.out.print("Enter batting average: ");
            double average = sc.nextDouble();

            System.out.print("Is player injured? (true/false): ");
            boolean injured = sc.nextBoolean();

            sc.nextLine();

            players[i] = new ass55(name, matches, average, injured);
        }

        System.out.println("\nDraft Ranking:");
        System.out.println(draftAndRank(players));

        sc.close();
    }
}