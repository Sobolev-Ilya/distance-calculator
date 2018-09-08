This application calculates distances between pairs of geographic points from file and writes results to another file.

Application algorithm:
1. Reads CSV file in expected format (look at Example.csv file)
2. Calculate distance between N and N+1 geographic point from file (longitude and latitude)
3. Writes distances for each month in new file

For running type in terminal "java -jar distanceCalculator.jar [path_to_file_for_read] [path_to_file_for_output]"

Requires installed Java Runtime Environment 8