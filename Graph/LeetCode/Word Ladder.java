// https://leetcode.com/problems/word-ladder/
class Solution {
    class Pair{
        String word;
        int wordcount;
        Pair(String word,int wordcount){
            this.word=word;
            this.wordcount=wordcount;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // to search in o(1) time we uses HashSet
        HashSet<String>hs=new HashSet<>(wordList); // this changes list to hashset
        Queue<Pair>q=new LinkedList<>(); 
        // if endword is not present return 0
        if(!hs.contains(endWord)){  // also can ignore this step
            return 0;
        }
        q.add(new Pair(beginWord,1));
        hs.remove(beginWord);
        while(!q.isEmpty()){
            Pair temp=q.poll();
            String word=temp.word;
            int wordcount=temp.wordcount;
            
            //if beginword is equal to endWord we direct return i.e. base condition
            if(word.equals(endWord)){
                return wordcount;
            }
            for(int i=0;i<word.length();i++){
        // check creating a new string changing char
        for(char ch='a';ch <='z';ch++){ // new for me but iterating character
        char WordCharArray[]=word.toCharArray(); // creating wiord in char array
        WordCharArray[i]=ch;
       String newWordString=new String(WordCharArray); //creating new String of charWordArray
         // now check
            if(hs.contains(newWordString)){
                q.add(new Pair(newWordString,wordcount+1));
                hs.remove(newWordString); // in place of visited we removing
            }
          }
       }
     }
        return 0;
    }
}


/*
    Time Complexity: N is size of dictionary, M is say length of each word
    O(N) - to iterate over each word of dictionary
    O(M) - to convert word to char array
    O(M) - looping for each char
    26 - to reach each possible word from a word
    O(M) - to convert charArray to String
    O(M) - to compare two words
    Inner for loop --> O(M)*26* (O(M) + O(M)) --> O(M^2)
    Time Complexity including outer-inner for loop --> O(N) * ( O(M)+O(M^2) )
    Final Time Complexity - O(N*M^2)
    */
