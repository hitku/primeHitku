import java.util.*;
public class PrimeHitku{
private static int range=529;
private static ArrayList<Integer> hits = new ArrayList<Integer>();
private static HashSet<Integer> hit2s = new HashSet<Integer>();
private static ArrayList<Integer> misses = new ArrayList<Integer>();
private static ArrayList<Integer> primes = new ArrayList<Integer>();
public static void main(String args[]){

long startTime = System.nanoTime();
boolean doesContainHit=false;
int d=1;
if(d<5){
init();
d=5;
}
while(d<range){
if((d-2)%6==0){
d=d+3;
}
else if(d%6==0){
doesContainHit=hits.contains(d+1);
if(doesContainHit || hit2s.contains(d+1) ){
if(doesContainHit){
addHit2sForNewMiss(d+1);
}
d=d+5;
}else{
d++;
addPrime(d);
d++;
continue;
}
}
int hi=0,h=0;
doesContainHit=hits.contains(d);
while(doesContainHit|| hit2s.contains(d)){
if(doesContainHit){
addHit2sForNewMiss(d);
}
d=d+2;h++;
//if(primes.get(hi)==h){d=d+2;hi++;h=0;}
if(h%2==0){d=d+2;}
doesContainHit=hits.contains(d);
}
addPrime(d);
for(int j=primes.get(primes.size()-2)+2;j<d;j=j+2){
if(!hits.remove((Integer)j)){
hit2s.remove((Integer)j);
}
}
d++;
}

System.out.print("\nprime count: "+  primes.size()+"; ");
long endTime = System.nanoTime();

long duration = (endTime - startTime);  //divide by 1000000 to get milliseconds
System.out.print("\n duration: "+  duration+"; ");
}

private static void init(){
addPrime(2);
addPrime(3);
}


private static void addHit2sForNewMiss(int ku){
misses.add(ku);
int newHit2 = 0;
for(int j=2;j<primes.size();j++){
newHit2=primes.get(j)*ku;
if(newHit2<= range){
hit2s.add(newHit2);
}else{
break;
}
}
addHitsForNewMiss(ku);
}

private static void addHitsForNewMiss(int ku){
int newHit = 0;
for (int j : misses) {
newHit=j*ku;
if(newHit<= range){
hits.add(newHit);
}else{
break;
}
}
}

private static void addPrime(int ku){
if(ku<= range){
primes.add(ku);
System.out.print(ku+"; ");
addHits(ku);
}
}

private static void addHits(int ku){
int newHit = 0;
for(int j=2;j<primes.size();j++){
newHit=primes.get(j)*ku;
if(newHit<= range){
hits.add(newHit );
}else{
break;
}
}
}
}
