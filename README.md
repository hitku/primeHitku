This is the algorithm for finding prime numbers I found while studying pattern in the natural numbers.

I have implemented in java,python,javascript.


Visual representation of the Algorithm is as below

https://github.com/hitku/primeHitku/blob/main/IMG_20241012_144037.jpg

Algorithm maintains 4 list of numbers

1.Prime list : It contains all the prime numbers.
2.Hits list : It contains all products of each number in the prime list with every number in the prime list. And  also contains all products of each number in the misses list with every number in the prime list.
3.Misses list : It contains numbers from hits and hit2s lists which are encountered while checking for prime numbers in algorithm.
4.Hit2s list : It contains all products of each number in the misses list with every number in the misses list.


The algorithm works as follows

1. If the number n, next to a prime number, does not satisfy the condition (n-2)%6=0 and if n+1 is not present in hits or hit2s lists then  n+1 is a prime number.
The products of n+1 with all numbers present in prime list are added to hits list.And n+1 is added to prime list.

2.If the number n, next to a prime number, does not satisfy the condition (n-2)%6=0 and if n+1 is present in hits or hit2s then  n, n+1 are not prime numbers.
If n+1 is present in hits list, it is added to misses list.If it is present in hit2s list it is not added.
If n+1 is present in hits list, the products of n+1 with all numbers present in prime list are added to hits list.And the products of n+1 with all numbers present in misses list are added to hit2s list.
Then the condition in  step 3 is checked for n= n+2.

3.If the number n from step 2, satisfy the condition (n-2)%6=0,
then n,n+1,n+2 are not prime numbers.
So, n is incremented by 3 (n=n+3).

4.If the number n, from step 3, is present in hits or hit2s then  n, n+1 are not prime numbers.
If n is present in hits list, it is added to misses list.If it is present in hit2s list it is not added.
If n is present in hits list, the products of n with all numbers present in prime list are added to hits list.And the products of n with all numbers present in misses list are added to hit2s list.

Then n is incremented by 2 (n=n+2).
And the counter h  is incremented by 1.
If the condition h%2=0 is  satisfied then again n is incremented by 2 (n=n+2).

The step 4 is repeated till the number n is not present in hits or hit2s lists.

5.  The number n, from step 4, is added to prime list.And products of n with all numbers present in prime list are added to hits list.


Repeat these 5 steps, till n is less than given range upper limit.

The numbers in the prime list are all prime numbers.



please sent any suggestion or issues to me at hiteshdurgani@gmail.com
