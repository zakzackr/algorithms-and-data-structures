import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;


class Main{
    public static Map<String, Integer> createHashMap(String[] player, String[] cardPower){
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < cardPower.length; i++){
            map.put(cardPower[i], 0);
        }

        for (int i = 0; i < player.length; i++){
            map.put(player[i].substring(1), map.getOrDefault(player[i].substring(1), 0) + 1);
        }

        return map;
    }

    public static String winnerPairOfCards(String[] player1, String[] player2){
        String[] cardPower = {"A", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3", "2"};

        Map<String, Integer> map1 = createHashMap(player1, cardPower);
        Map<String, Integer> map2 = createHashMap(player2, cardPower);

        String winner = "draw";
        int maxCount = 0;

        for (int i = 0; i < cardPower.length; i++){
            if (map1.get(cardPower[i]) > maxCount || map2.get(cardPower[i]) > maxCount){
                if (map1.get(cardPower[i]) > map2.get(cardPower[i])){
                    winner = "player1";
                    maxCount = map1.get(cardPower[i]);
                } else if (map2.get(cardPower[i]) > map1.get(cardPower[i])){
                    winner = "player2";
                    maxCount = map2.get(cardPower[i]);
                }
            }
        }

        return winner;
    }

    public static void main(String[] args){
        String[] player1 = {"♣4","♥7","♥7","♠Q","♣J"};
        String[] player2 = {"♥10","♥6","♣K","♠Q","♦2"};
        String[] player3 = {"♣4","♥7","♥7","♠Q","♣J"};
        String[] player4 = {"♥7","♥7","♣K","♠Q","♦2"};

        System.out.println(winnerPairOfCards(player1, player2));
        System.out.println(winnerPairOfCards(player3, player4));
    }
}

