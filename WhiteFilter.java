public class WhiteFilter{
  public static void main(String[] args){
    HashSET<String> set;
    set = new HashSET<String>();
    In in = new In(args[0]);
    while (!in.isEmpty())
      set.add(in.readString());
    while (!StdIn.isEmpty()){
      String word = StdIn.readString();
      if (set.contains(word))
        StdOut.print(word + " ");
    }
  }
}
