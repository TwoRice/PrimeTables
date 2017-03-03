# PrimeTables

I programmed my solution in 2-3 hours on 1 day, and then added things here and there in short bursts to optimise my solution throughout the remaining week.
I started with a simple solution which checked if each number (of the form 6k±1) was divisble by every prime number generated so far up to the root of the number being checked (simply from my knowledge of prime numbers).
This ran reasonably fast, but I later implemented The Sieve of Eratosthenes to speed it up signifigantly. I changed my approach for outputting the numbers twice,
first trying a BufferedOutputSteam to the console as the PrintStream was incredibly slow, but this made little difference so I settled on using a FileWriter to
write the output to a text file as this proved much faster.

<b>INSTRUCTIONS:</b><br/>
1. Download and run the Executable Jar file found in the build folder or in the releases section<br/>
2. Enter the number of generations of primes you would like<br/>
3. Enter 1 or 2 to choose whether you would like to output a list of the prime numbers or the prime multiplication table, respectively.<br/>
4. A text file will be created in the folder you ran the jar from called either generatedPrimes.txt or primeTable.txt, open it to view the output<br/>
5. IMPORTANT: To view a table formatted correctly please refrain from using notepad (Sublime Text, WordPad, vi, to name a few should all work fine) 
and disable word-wrap.<br/>
<br/>
<b>WHAT I'M PLEASED WITH:</b><br/>
1. The relatively fast prime number generation, 1000000 primes can be generated in <1 second.<br/>
2. My prime generation unit tests where thourgh and proved consistent (Very little change needed with drastic code change)<br/>
3. The output formatting.<br/>
<br/>
<b>WHAT I WOULD HAVE DONE WITH MORE TIME:</b><br/>
1. Implemented Threading for number generation and outputting the numbers<br/>
2. Further improved the efficient of outputting the numbers. I only noticed how slow the outputting was towards the end so I rushed my
solution. Generating primes is fast enough, but calculating and printing the multiplication table is still quite slow and I'm still not
100% sure if huge prime tables will format correctly as I don't know if the text editors I have mentioned have max line lengths. My
solution of outputting to file is also flawed as with large prime tables you recieve huge text files, so to find a better balance would be
nice.<br/>
3. Unit tested my outputting solution. As I mentioned that I rushed the solution for this I didn't get the chance to unit test it.<br/>
4. Used C/C++ instead of java for potentially increased performance.
