class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0;
        int right = letters.length;
        
        // Binary search for the smallest character > target
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (letters[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        // If left reaches length, it means no character > target was found,
        // so we wrap around to the first character.
        return letters[left % letters.length];
    }
}
