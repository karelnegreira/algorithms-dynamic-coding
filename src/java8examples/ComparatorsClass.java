package java8examples;

import java.util.*;

public class ComparatorsClass {
    public static void main(String[] args) {
        List<Player> players = new ArrayList();
        players.add(new Player(1, "Karel", 5.5));
        players.add(new Player(2, "Carlos", 6.2));
        players.add(new Player(3, "Rebecca", 10.00));
        players.add(new Player(4, "Shung Li", 9.99));
        //displaying data..
        players.stream().forEach(System.out::println);
        //sort by scores ascendently..
        PlayerRateComparator comparator = new PlayerRateComparator();
        Collections.sort(players, comparator);
        players.stream().forEach(o -> System.out.print(o.getName() + " "));
        System.out.println();
        //comparing by name alphabetically,
        Collections.sort(players, new PlayerByNameComparator());
        players.forEach(o -> System.out.print(o.getName() + " "));
        System.out.println();
        //java 8 approach...
        Comparator<Player> byName = Comparator.comparing(Player::getName);
        Comparator<Player> byNameReverse = Comparator.comparing(Player::getName).reversed();
        Comparator<Player> byRank = Comparator.comparing(Player::getRate);
        Comparator<Player> byRanksReversed = Comparator.comparing(Player::getRate).reversed();
        //tests
        Collections.sort(players, byNameReverse);
        players.forEach(System.out::print);
    }
}

class Player {
    private long id;
    private String name;
    private double rate;

    public Player(long id, String name, double rate) {
        this.id = id;
        this.name = name;
        this.rate = rate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Double.compare(player.rate, rate) == 0 && Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, rate);
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", rate=" + rate +
                '}';
    }

}

class PlayerRateComparator implements Comparator<Player> {

    @Override
    public int compare(Player player, Player t1) {
        return Double.compare(player.getRate(), t1.getRate());
    }
}

class PlayerByNameComparator implements Comparator<Player> {

    @Override
    public int compare(Player player, Player t1) {
        return player.getName().compareTo(t1.getName());
    }
}