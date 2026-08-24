class Solution {
    public boolean subBoxValid(int i,int j,char [][] board){
        HashSet<Character> set = new HashSet<>();
        for(int p=i;p<i+3;p++){
            for(int k =j;k<j+3;k++){
                char num = board[p][k];
                if(set.contains(num)){
                    return false;
                }
                else{
                      if(num!='.'){
                        set.add(num);
                    }
                    
                }
            }
        }
        return true;
    }
    public boolean checkRow(char [][] board,int j){
        HashSet<Character> set = new HashSet<>();
        for(int i=0;i<9;i++){
            char num = board[j][i];
            if(set.contains(num)){
                    return false;
                }
                else{
                    if(num!='.'){
                        set.add(num);
                    }
                    
                }
        }
        return true;
    }
    public boolean checkCol(char [][] board,int j){
        HashSet<Character> set = new HashSet<>();
        for(int i=0;i<9;i++){
            char num = board[i][j];
            if(set.contains(num)){
                    return false;
                }
                else{
                      if(num!='.'){
                        set.add(num);
                    }
                    
                }
        }
        return true;
    }
    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<9;i++){
            if(!checkRow(board,i)){
                return false;
            }
        }
        for(int j=0;j<9;j++){
            if(!checkCol(board,j)){
                return false;
            }
        }
        for(int i=0;i<9;i+=3){
            for(int j=0;j<9;j+=3){
                if(!subBoxValid(i,j,board)){
                    return false;
                }
            }
        }
        return true;
    }
}