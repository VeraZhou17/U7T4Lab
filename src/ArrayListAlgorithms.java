import java.util.ArrayList;
import java.util.Locale;

public class ArrayListAlgorithms
{
    /**
     * Returns true if any of the elements in stringList contain
     * target as a substring; false otherwise.  Use indexOf instead of contains
     * for AP practice! (although in reality, contains is preferred)
     * <p>
     * Does NOT mutate (modify) elements of stringList.
     * PRECONDITION: stringList.size() > 0
     *
     * @param stringList original arraylist of Strings
     * @return true if target is found in any of the strings, false otherwise
     */
    public static boolean containsTarget(ArrayList<String> stringList, String target)
    {
        for (String str : stringList)
        {
            if (str.indexOf(target) != -1)
            {
                return true;
            }
        }
        return false;
    }

    /** Returns number of elements in intList that are less than the
     *  average of all elements.
     *
     *  Does NOT mutate (modify) elements of intList.
     *  PRECONDITION: intList.size() > 0
     *
     *  @param intList  original arraylist of Integers
     *  @return  the number of ints in intList that are less than the average
     */
    public static int belowAverage(ArrayList<Integer> intList)
    {
        int sum = 0;
        int count = 0;
        for (int i = 0; i < intList.size(); i++)
        {
            sum += intList.get(i);
        }

        double finalAverage = (double) sum / intList.size();

        for (int i = 0; i < intList.size(); i++)
        {
           if (intList.get(i) < finalAverage)
           {
                count++;
           }
        }
        return count;
    }

    /** Replaces all words in wordList that end in "s" with the all-uppercase
     *  version of the word.  For example, "apples" should be replaced with "APPLES".
     *  Assume all letters of all words in wordList are lowercase initially (no need
     *  to worry about checking for case or converting first to lowercase)
     *
     *  DOES mutate (modify) elements of wordList.
     *  PRECONDITION: wordList.size() > 0
     *
     *  @param wordList  original arraylist of words
     */
    public static void replaceWithCaps(ArrayList<String> wordList)
    {
        for (int i = 0; i < wordList.size(); i++)
        {
            int length = wordList.get(i).length();
            if (wordList.get(i).indexOf("s") != -1)
            {
                if (wordList.get(i).substring(length - 1, length).equals("s"))
                {
                    String upperCased = wordList.get(i).toUpperCase();
                    wordList.set(i, upperCased);
                }
            }
        }
    }

    /** Returns the index at which the minimum value of all integers in
     *  intList appears; if the minimum value appears more than once in
     *  the arraylist, return the index of the first occurrence
     *
     *  Does NOT mutate (modify) elements in intList.
     *  PRECONDITION: intList.size() > 0
     *
     *  @param intList  original arraylist of Integers
     *  @return  the index at which the minimum value occurs
     */
    public static int indexOfMinimum(ArrayList<Integer> intList)
    {
        int min = intList.get(0);
        int idxVal = 0;
        for (int i = 1; i < intList.size(); i++)
        {
            if (intList.get(i) < min)
            {
                min = intList.get(i);
                idxVal = i;
            }
        }
        return idxVal;
    }

    /** Returns true if two array lists of the same length contain the exact
     *  same elements in the same order (i.e. the two arraylists are identical).
     *  Returns false otherwise.
     *
     *  Does NOT mutate (modify) elements in either arraylist
     *  PRECONDITION: numList1.size() == numList2.size()
     *
     *  @param numList1  first arraylist of Integers
     *  @param numList2  second arraylist of Integers, has the same size as first
     *  @return  true if both arraylists are identical, element for element
     */
    public static boolean areIdentical(ArrayList<Integer> numList1, ArrayList<Integer> numList2)
    {
        for (int i = 0; i < numList1.size(); i++)
        {
            int numList1Num = numList1.get(i);
            int numList2Num = numList2.get(i);

            if (numList1Num != numList2Num)
            {
                return false;
            }
        }
        return true;
    }

    /** Removes all elements from numList that are ODD Integers.
     *
     *  DOES mutate (modify) elements in numList
     *  PRECONDITION: numList1.size() > 0
     *
     *  @param numList  arraylist of Integers
     */
    public static void removeOdds(ArrayList<Integer> numList)
    {
        for (int i = 0; i < numList.size(); i++)
        {
            if (numList.get(i) % 2 != 0)
            {
                numList.remove(numList.get(i));
                i--;
            }
        }
    }

    /** Removes all elements from wordList that contain an a, e, i , and/or o.
     *  All other words (i.e. those that have u and/or y as the vowel
     *  such as "ugh" or "sly", or no vowels, like "psh"), add a duplicate of
     *  that element to wordList at an adjacent index.
     *
     *  Assume all words have lowercase letters (i.e. no need to check for case)
     *
     *  DOES mutate (modify) elements in wordList
     *  PRECONDITION: wordList.size() > 0
     *
     *  @param wordList  arraylist of Strings
     */
    public static void wackyVowels(ArrayList<String> wordList)
    {
        for (int i = 0; i < wordList.size(); i++)
        {
            if (wordList.get(i).indexOf("a") != -1 || wordList.get(i).indexOf("e") != -1 || wordList.get(i).indexOf("i") != -1 || wordList.get(i).indexOf("o") != -1)
            {
                wordList.remove(wordList.get(i));
                i--;
            }
            else
            {
                wordList.add(i + 1, wordList.get(i));
                i++;
            }
        }
    }

    /** Removes all duplicate values from an intList, leaving only the first
     *  occurrence in the arrayList; for example, this method will modify
     *  [1, 2, 5, 4, 2, 2, 1, 6, 4, 4, 8, 1, 7, 4, 2] --> [1, 2, 5, 4, 6, 8, 7]
     *
     *  DOES mutate (modify) elements in intList
     *  PRECONDITION: intList.size() > 0
     *
     *  @param intList  intList of Integers
     */
    public static void removeDuplicates(ArrayList<Integer> intList)
    {
        for (int i = 0; i < intList.size(); i++)
        {
            for (int j = i + 1; j < intList.size(); j++)
            {
                int num1 = intList.get(i);
                int num2 = intList.get(j);
                if (num1 == num2)
                {
                    intList.remove(j);
                    j--;
                }
            }
        }
    }

    /** Adds an uppercase version of each string directly AFTER the string
     *  in wordList; for example, if wordList is ["hello", "my", "best", "friend"]
     *  this method modifies wordList to be:
     *  ["hello", "HELLO", "my", "MY", "best", "BEST", "friend", "FRIEND"]
     *
     *  Assume all words have lowercase letters originally
     *
     *  DOES mutate (modify) elements in wordList
     *  PRECONDITION: wordList.size() > 0
     *
     *  @param wordList  arraylist of Strings
     */
    public static void duplicateUpperAfter(ArrayList<String> wordList)
    {
        for (int i = 0; i < wordList.size(); i++)
        {
            String upperCasedStr = wordList.get(i).toUpperCase();
            wordList.add(i + 1, upperCasedStr);
            i++;
        }
    }

    /** Appends an uppercase version of each string to the END of wordList;
     *  the uppercase versions appear in the same order as the lowercase versions
     *  for example, if wordList is ["hello", "my", "best", "friend"]
     *  this method modifies wordList to be:
     *  ["hello", "my", "best", "friend", "HELLO", "MY", "BEST", "FRIEND"]
     *
     *  Assume all words have lowercase letters originally
     *
     *  DOES mutate (modify) elements in wordList
     *  PRECONDITION: wordList.size() > 0
     *
     *  @param wordList  arraylist of Strings
     */
    public static void duplicateUpperEnd(ArrayList<String> wordList)
    {
        for (int i = 0; i < wordList.size() - (wordList.size() / 2); i++)
        {
            String upperCasedStr = wordList.get(i).toUpperCase();
            wordList.add(upperCasedStr);
        }
    }

    /** Returns an arraylist of Strings that represents the input sentence parsed
     *  into separate words (using a space: " " as the delimiter) and REVERSED
     *  For example, if sentence = "This is my sentence!"
     *  this method return [sentence!, my, is, This]
     *
     *  PRECONDITION: sentence does not end with a space
     *
     *  @param sentence  the input String that represents one or more words
    separated by spaces
     *  @return  new arraylist of Strings containing the words of sentence reversed
     */
    public static ArrayList<String> parseWordsAndReverse(String sentence)
    {
        ArrayList<String> stringList = new ArrayList<String> ();
        String updatedSentence = sentence;

        int index = 0;
        while (updatedSentence.indexOf(" ") != -1)
        {
            index = updatedSentence.indexOf(" ");

            // store word
            String word = updatedSentence.substring(0, index);

            // add word to the FRONT of stringList; this will ensure that stringList is in reverse order
            stringList.add(0, word);

            // remove word and subsequent space from sentence by setting
            // it to a substring of itself starting at index + 1 (to the end)
            updatedSentence = updatedSentence.substring(index + 1);
        }
        stringList.add(0, updatedSentence);

        return stringList;
    }

    /** Removes all words from wordList that begin with "b" and inserts them at the
     *  front of wordList; all "b" words that are moved should appear in the same order
     *  in the modified arrayList as they did before being moved
     *
     *  For example, this method will take a wordList:
     *  ["apple", "banana", "cherry", "donut", "bagel", "danish", "berry", "baguette", "soda"]
     *  and modify it to
     *  ["banana", "bagel", "berry", "baguette", "apple", "cherry", "donut", "danish", "soda"]
     *
     *  DOES mutate (modify) elements in wordList
     *  PRECONDITIONS: wordList.size() > 0, all strings in wordList have at least one character
     *
     *  @param wordList  arraylist of words
     */
    public static void moveBWords(ArrayList<String> wordList)
    {
        int nextIndexToInsert = 0;
        for (int i = 0; i < wordList.size(); i++)
        {
            if (wordList.get(i).substring(0, 1).equals("b"))
            {
                String removedWord = wordList.remove(i);
                wordList.add(nextIndexToInsert, removedWord);
                nextIndexToInsert++;
            }
        }
    }

    /** Returns arraylist of Integers that contain all mode(s) of the int array numList.
     *  If elements in numList all appear exactly once, there is no mode, and this method
     *  should return an empty list
     *
     *  For example, if numList is: [1, 2, 3, 2, 4, 5, 5, 6],
     *  then numList contains two modes: 2, 5
     *  and this method returns an arraylist containing 2 and 5 (in any order)
     *  If numList is: [1, 2, 3, 2, 4, 5, 5, 6, 6, 7, 6],
     *  then numList contains one mode: 6
     *  and this method returns an arrayList containing 6
     *  If numList is: [1, 2, 3, 4, 5, 6], then numList contains no mode
     *  and this method returns an empty arrayList: []
     *  If numList is: [2, 2, 2, 3, 3, 3, 4, 4, 4],
     *  then numList contains three modes: 2, 3, 4
     *  and this method returns an arrayList containing 2, 3, and 4 (in any order)
     *
     *  Does NOT mutate (modify) elements in numList
     *  PRECONDITIONS: numList.length > 0
     *
     *  @param numList  numList of ints
     */
    public static ArrayList<Integer> modes(int[] numList)
    {
        ArrayList<Integer> modes = new ArrayList<Integer> ();

        // variable to track max count
        int maxCount = 1;
        for (int i = 0; i < numList.length; i++)
        {
            int count = 1;
            // iterate from 1 up to and including the number itself
            for (int j = i + 1; j < numList.length; j++)
            {
                if (numList[i] == numList[j])
                {
                    count++;
                }
            }
            if (count > maxCount)
            {
                maxCount = count;
                modes.clear();
                modes.add(numList[i]);
            }
            // else, if there is another mode with equal count
            // and that count is not 1
            else if (count == maxCount && count != 1)
            {
                modes.add(numList[i]);
            }
        }
        return modes;
    }
}