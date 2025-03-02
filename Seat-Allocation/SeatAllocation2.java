import java.util.Scanner;
import java.util.PriorityQueue;

public class SeatAllocation2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nParties = sc.nextInt();
        int mSeats = sc.nextInt();
        PriorityQueue<Party> maxPQ = new PriorityQueue<>();

        sc.nextLine();

        int counterId = 0;
        Party[] parties = new Party[nParties]; 
        for (int i = 0; i < nParties; i++) {
            int partyVotes = Integer.parseInt(sc.nextLine());
            Party party = new Party(partyVotes, counterId);
            maxPQ.add(party);
            parties[counterId] = party; 
            counterId++;
        }

        for (int j = 0; j < mSeats; j++) {
            Party selectedParty = maxPQ.poll();
            selectedParty.addSeat();
            maxPQ.add(selectedParty);
        }

        for (int i = 0; i < nParties; i++) { 
            Party party = parties[i];
            System.out.println(party.getSeats());
        }

        sc.close();
    }
}
