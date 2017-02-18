class StringMatching {
  public static void main(String[] args) {
    StringMatching m = new StringMatching();
    
    String T = "abacaabadcabacabaaddababbbaaadaabbabbabbaabbcaadabacad";
    String P = "abbabb";
    
    System.out.println(m.boyerMoore(T, P));
    System.out.println(m.count);
    
    m.count = 0;
    System.out.println(m.naive(T, P));
    System.out.println(m.count);
    
    
  }
  
  public StringMatching(){}
  
  int count = 0;
  
  public int naive(String T, String P){
    int n = T.length();
    int m = P.length();
    for(int i = 0; i < n - m; i++){
      int j = 0;
      while(j < m && T.charAt(i + j) == P.charAt(j)){
        count++;
        j++;
      }
      if(j == m){
        return i;
      }
    }
    return -1;
  }
  
  public int boyerMoore(String T, String P){
    int[] last = last(P);
    int n = T.length();
    int m = P.length();
    int i = m - 1;
    int j = m - 1;
    if(i > n - 1){
      return -1;
    }    
    do {
      count++;
      if(P.charAt(j) == T.charAt(i)){
        if(j == 0){
          return i;
        }else{
          i--;
          j--;
        }
      }else{
        i = i + m - Math.min(j, 1 + last[T.charAt(i)]);
        j = m - 1;
      }
    }while(i <= n -1);
    return -1;
  }
  
  public int[] last(String P){
    int[] last = new int[128];
    for(int i = 0; i < 128; i++){
      last[i] = -1;
    }
    for(int i = 0; i < P.length(); i++){
      last[P.charAt(i)] = i;
    }
    return last;
  }
  
  
}
