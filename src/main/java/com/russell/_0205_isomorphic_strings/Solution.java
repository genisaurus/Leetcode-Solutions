package com.russell._0205_isomorphic_strings;

/*
Given two strings s and t, determine if they are isomorphic.

Two strings s and t are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters.
No two characters may map to the same character, but a character may map to itself.
 */

import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean isIsomorphic(String s, String t) {
        // iterate over characters in s. As you encounter each character, add them to a map as the key, where the
        // value is the corresponding letter in t.
        // If the map already contains a character from s, and the corresponding character in t doesn't match the known
        // mapping, these cannot be isomorphic.
        // if a character in t does not exist in the mapping, that also means non-isomorphic.
        // helped by the guarantee that t.length == s.length
        if (s.length() == 1 && t.length() == 1)
            return true;
        Map<Character, Character> sMap = new HashMap<>();
        sMap.put(s.charAt(0), t.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (sMap.containsKey(s.charAt(i))) {
                if (sMap.get(s.charAt(i)) != t.charAt(i))
                    return false;
            }
            else
            if (sMap.containsValue(t.charAt(i)))
                return false;
            else
                sMap.put(s.charAt(i), t.charAt(i));
        }
        return true;
    }
}
