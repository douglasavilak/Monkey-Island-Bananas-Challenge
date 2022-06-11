# The Monkey Island Bananas Challenge

## About the project
This project was developed mainly in Java with Maven using on Groovy with Spock framework for the automated tests layer.
The code is 100% covered with automated tests. This coverage can be measured with the coverage report integration Jacoco report.

### Build the project
Use "mvn clean install" to build the project and let maven download all the needed libs to your computer

### How to run the project?
1. You can run the project by running the main class located on "src.main.java.com.challenge.island.monkey" package

### How to run the tests?
2. On Intellij you can run all the tests by choosing "Run all tests" after click with the right button on "groovy" directory inside the "src.test" directory

### How to check the code coverage?
3. You need first to generate the code coverage by running "mvn clean test jacoco:report" inside the project. This will generate a directory named "site" inside the project's "target" directory. On that site directory you will have a index.html file, you just need to open it in order to check the code coverage

## Talking about algorithm performance
### Calculating the Big-O complexity
Following the Big-O idea, in order to calculate the Big-O complexity, during the analysis of the solution algorithm, I'll be always looking for the worst scenario, in other words, I'll be always looking for the most time and space consuming scenario.

#### 1. Introduction
As the first thing to do to calculate the algorithm big-o TC (Time Complexity) and SC (Space Complexity) I simplified the whole code to it's logical iteration loops and significant space consuming attributions.

```
// 2. First column rows iteration
for (int row = 0; row <= N; row++) {
    int[] possibleNextFields = N
}

// 3. Next columns iteration
for (int col = 1; col < M; col++) {

    int[] possibleNextFields = 3

    // 4. Rows iteration
    for (int row = 0; row <= 3; row++) {
        // No significant time / space complexity operation
    }

    // 5. List of monkey's visited places
    List<Field> visitedPlaces = M
}
```

#### 2. First column rows iteration
At the first column I always interact over all rows on the island Map because I need to know which of the fields has the greater number of bananas. Since the number of for iterations increases as the number of rows increase on the islandMap, this generates me a O(N) Time Complexity. And this also generates a O(N) Space complexity, since the size of the possibleNextFields array also increase as the number of rows on islandMap increases.
With that I have a TC = O(N) and a SC = O(N) for this step

#### 3. Next columns iteration
After the first column, I need now to iterate over all left columns on the islandMap, starting from the column 1 since I already iterated on the column 0 before. 
In this iteration I also have a time complexity increasing according to the number of columns I have on the islandMap.
With that I have a TC = O(N)
Inside that column iteration I have an array(possibleNextFields) that in the worst scenario will have 3 positions, this happens due to the moving business rules where the monkey can only move to front ->, front-up /, front-down \. 
This leads me to a SC = O(1), because no matters how much the islandMap columns or rows increases, in the worst scenario this array will always have a size 3

#### 4. Rows iteration
In this point of the column iteration, I have a new for loop to iterate over the selected column rows. This iteration uses the possibleNextFields array that was created on the previous step and as we saw, considering the worst scenario, it will always be an array of size 3.
With that in hands we now have this new for loop iterating on a 3 times loop. This leads us to a constant Time Consuming process, so no matters how much the islandMap columns or rows increases, in the worst scenario this loop will always iterate 3 times, in other words, it will always consume the same amount of time.
With that we have a TC = O(1).
Inside of this loop we do not have any significant operation for Time Complexity neither Space Complexity. 

#### 5. List of monkey's visited places
To complete the algorithm, we have a list of the monkey visited places, on that list we have all the real fields that the monkey visited on his journey through the island. So, for that list we will have a size equivalent to the island number of columns, since the monkey will visit 1 field by each column on the islandMap, that means that the size of the monkey's visited places list increases according to the size of the islandMap columns.
With that we have a SC = O(M), where M is the number of columns

#### Result
```
Time = O(N + M + 1) = O(N + M) = O(N) Linear Time Complexity
Space = O(N + M + 1) = O(N + M) = O(N) Linear Space Complexity
```
![image](https://user-images.githubusercontent.com/4285378/173197533-1f79c32b-5ae5-42c2-9a13-5becf1ed9e22.png)
