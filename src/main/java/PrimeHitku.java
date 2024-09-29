import java.util.ArrayList;

public class PrimeHitku {
	private static int range = 529;
	private static ArrayList<Integer> hits = new ArrayList<Integer>();
	private static ArrayList<Integer> hit2s = new ArrayList<Integer>();
	private static ArrayList<Integer> misses = new ArrayList<Integer>();
	private static ArrayList<Integer> primes = new ArrayList<Integer>();

	public static void main(String args[]) {

		long startTime = System.nanoTime();
		boolean doesContainHit = false;
		int d = 1;
		if (d < 5) {
			init();
			d = 6;
		}
		while (d < range) {
			if ((d - 2) % 6 == 0) {
				d = d + 3;
			} else if (d % 6 == 0) {
				doesContainHit = hits.contains(d + 1);
				if (doesContainHit || hit2s.contains(d + 1)) {
					if (doesContainHit) {
						addHit2sForNewMiss(d + 1);
					}
					d = d + 5;
				} else {
					d++;
					addPrime(d);
					d++;
					continue;
				}
			}
			int hi = 0, h = 0;
			doesContainHit = hits.contains(d);
			while (doesContainHit || hit2s.contains(d)) {
				if (doesContainHit) {
					addHit2sForNewMiss(d);
				}
				d = d + 2;
				h++;
				//if(primes.get(hi)==h){d=d+2;hi++;h=0;}
				if (h % 2 == 0) {
					d = d + 2;
				}
				doesContainHit = hits.contains(d);
			}
			addPrime(d);
			d++;
		}

		System.out.print("\nprime count: " + primes.size() + "; ");
		long endTime = System.nanoTime();

		long duration = (endTime - startTime); // divide by 1000000 to get milliseconds
		System.out.print("\n duration: " + duration + "; ");
	}

	private static void init() {
		addPrime(2);
		addPrime(3);
		addPrime(5);
	}

	private static void addHit2sForNewMiss(int ku) {
		misses.add(ku);
		int newHit2 = 0;
		for (int j : primes) {
			newHit2 = j * ku;
			if (newHit2 <= range) {
				hit2s.add(newHit2);
			}
		}
		addHitsForNewMiss(ku);
	}

	private static void addHitsForNewMiss(int ku) {
		int newHit = 0;
		for (int j : misses) {
			newHit = j * ku;
			if (newHit <= range) {
				hits.add(newHit);
			}
		}
	}

	private static void addPrime(int ku) {
		if (ku <= range) {
			primes.add(ku);
			System.out.print(ku + "; ");
			addHits(ku);
		}
	}

	private static void addHits(int ku) {
		int newHit = 0;
		for (int j : primes) {
			newHit = j * ku;
			if (newHit <= range) {
				hits.add(newHit);
			}
		}
	}
}
