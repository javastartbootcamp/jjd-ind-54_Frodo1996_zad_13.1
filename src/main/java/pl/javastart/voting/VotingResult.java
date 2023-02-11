package pl.javastart.voting;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Możesz dodać kolejne metody i pola do klasy. Nie zmieniaj istniejących metod.
 */
public class VotingResult {
    private static double voteFor;
    private static double voteAgainst;
    private static double voteAbstention;
    private String voteOption;

    public VotingResult(String voteOption) {
        this.voteOption = voteOption;
    }

    public String getVoteOption() {
        return voteOption;
    }

    public void setVoteOption(String voteOption) {
        this.voteOption = voteOption;
    }

    public static double getVoteFor() {
        return voteFor;
    }

    public static double getVoteAgainst() {
        return voteAgainst;
    }

    public static double getVoteAbstention() {
        return voteAbstention;
    }

    static void setVoteFor(double voteFor) {
        voteFor++;
        VotingResult.voteFor = voteFor;
    }

    static void setVoteAgainst(double voteAgainst) {
        voteAgainst++;
        VotingResult.voteAgainst = voteAgainst;
    }

    static void setVoteAbstention(double voteAbstention) {
        voteAbstention++;
        VotingResult.voteAbstention = voteAbstention;
    }

    /**
     * Metoda powinna drukować wyniki głosowania w takiej postaci:
     * Głosów za: 56.53%
     * Głosów przeciw: 35.00%
     * Wstrzymało się: 8.47%
     */
    public void printResults() {
        System.out.println("Głosów za: " + percentOfVotesFor() + "%");
        System.out.println("Głosów przeciw: " + percentOfVotesAgainst() + "%");
        System.out.println("Wstrzymało się: " + percentOfVotesAbstention() + "%");
        // metoda powinna drukować wyniki głosowania
    }

    /**
     * Metoda przyjmuje imię i nazwisko głosującego, np "Zigniew Siobro".
     * Uzupełnij tę metodę, żeby drukowała informację w formie:
     * Zigniew Siobro: ZA
     * Nie zmieniaj sygnatury tej metody!
     */
    public void printVoteForVoter(String voterName) {
        if (voteOption.equals("z")) {
            System.out.println(voterName + ": ZA");
        } else if (voteOption.equals("p")) {
            System.out.println(voterName + ": PRZECIW");
        } else if (voteOption.equals("w")) {
            System.out.println(voterName + ": WSTRZYMAŁ SIĘ");
        } else {
            System.err.println("Błędna wartość.");
        }
    }

    public BigDecimal percentOfVotesFor() {
        double allVotes = voteFor + voteAgainst + voteAbstention;
        double percent = (voteFor / allVotes) * 100;
        BigDecimal bigDecimal = new BigDecimal(percent);
        return bigDecimal.setScale(2, RoundingMode.HALF_EVEN);
    }

    public BigDecimal percentOfVotesAgainst() {
        double allVotes = voteFor + voteAgainst + voteAbstention;
        double percent = (voteAgainst / allVotes) * 100;
        BigDecimal bigDecimal = new BigDecimal(percent);
        return bigDecimal.setScale(2, RoundingMode.HALF_EVEN);
    }

    public BigDecimal percentOfVotesAbstention() {
        double allVotes = voteFor + voteAgainst + voteAbstention;
        double percent = (voteAbstention / allVotes) * 100;
        BigDecimal bigDecimal = new BigDecimal(percent);
        return bigDecimal.setScale(2, RoundingMode.HALF_EVEN);
    }
}