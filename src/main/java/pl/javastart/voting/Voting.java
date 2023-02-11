package pl.javastart.voting;

import java.beans.VetoableChangeListenerProxy;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Voting {

    public static void main(String[] args) {
        List<String> voters = new ArrayList<>();

        // możesz dowolnie dodawać / usuwać dane testowe
        voters.add("Jan Kowalski");
        voters.add("Zigniew Siobro");
        voters.add("Zbyszek Stonoga");

        Voting voting = new Voting();

        VotingResult votingResult = voting.executeVoting(voters, new Scanner(System.in));
        votingResult.printResults();
        votingResult.printVoteForVoter("Jan Kowalski");
        votingResult.printVoteForVoter("Zigniew Siobro");
        votingResult.printVoteForVoter("Zbyszek Stonoga");
    }

    /**
     * Uzupełnij metodę metodę, ale nie zmieniaj jej sygnatury! (typu tego, co przyjmuje i zwraca).
     * do wczytywania danych od użytkownika użyj scannera z parametru
     * Metoda powinna pobrać głos dla każdego przekazanego głosującego i zapisać wyniki głosowania do VotingResult
     */
    VotingResult executeVoting(List<String> voters, Scanner scanner) {
        String option = null;
        VotingResult votingResult = null;
        for (int i = 0; i < voters.size(); i++) {
            System.out.println("Jak głosuje " + voters.get(i) + "? (z - za, p - przeciw, w - wstrzymanie się)");
            option = scanner.nextLine();
            switch (option) {
                case "z" -> VotingResult.setVoteFor(VotingResult.getVoteFor());
                case "p" -> VotingResult.setVoteAgainst(VotingResult.getVoteAgainst());
                case "w" -> VotingResult.setVoteAbstention(VotingResult.getVoteAbstention());
                default -> System.out.println("Wybrałeś złą opcję głosowanie, spróbuj ponownie");
            }
            votingResult = new VotingResult(option);
        }
        return votingResult;  // to możesz (a nawet powinieneś/powinnaś) zmienić :)
    }

//
//    VotingResult result(List<String> voters) {
//        for (String voter : voters) {
//            if (voter.equals("z")) {
//                System.out.println(voter + ": ZA");
//            } else if (voter.equals("p")) {
//                System.out.println(voter + ": PRZECIW");
//            } else if (voter.equals("w")) {
//                System.out.println(voter + ": WSTRZYMAŁ SIĘ");
//            } else {
//                System.err.println("Błędna wartość.");
//            }
//            VotingResult result = new VotingResult(voter);
//        }
//        return result(voters);
//    }
}
