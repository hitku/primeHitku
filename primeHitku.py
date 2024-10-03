#primeHitku
_range=529
hits = []
hit2s =set()
misses = []
primes = []
doesContainHit=0

def addHits(ku):
 newHit = 0
 for j in range(2,len(primes)):
  newHit=primes[j]*ku
  if newHit<= _range:
   hits.append(newHit )
  else:
   break

def addPrime(ku):
 if ku<= _range:
  primes.append(ku)
  print(f" {ku};",end="")
  addHits(ku)


def init():
 addPrime(2)
 addPrime(3)

def addHitsForNewMiss(ku):
 newHit = 0
 for j in misses:
  newHit=j*ku
  if newHit<= _range:
   hits.append(newHit)
  else:
   break

def addHit2sForNewMiss(ku):
 misses.append(ku)
 newHit2 = 0
 for j in range(2,len(primes)):
  newHit2=primes[j]*ku
  if newHit2<= _range:
   hit2s.add(newHit2)
  else:
   break
 addHitsForNewMiss(ku)

d=1
if d<5:
 init()
 d=5
while d<_range:
 if (d-2)%6==0:
  d+=3
 elif d%6==0:
  doesContainHit=hits.count(d+1)
  if doesContainHit>0 or (d+1) in hit2s:
   if doesContainHit>0:
    addHit2sForNewMiss(d+1)
   d+=5
  else:
   d+=1
   addPrime(d)
   d+=1
   continue
 hi,h=0,0
 doesContainHit=hits.count(d);
 while doesContainHit>0 or d in hit2s:
  if doesContainHit>0:
   addHit2sForNewMiss(d)
  d+=2
  h+=1
#if primes[hi]==h: d=d+2 hi++ h=0
  if h%2==0:
    d+=2
  doesContainHit=hits.count(d)
 addPrime(d)
 for j in range(primes[len(primes)-2]+2, d, 2):
  hits.remove(j) if hits.count(j)>0 else hit2s.discard(j)
 d+=1
print(f"\nprime count:  {len(primes)}; ")

