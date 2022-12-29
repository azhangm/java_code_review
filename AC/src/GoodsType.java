import java.util.*;

public class GoodsType {
    public static void main(String[] args) {
//        名称 和 产地相同 视为同一种商品
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Set<Info> infos = new HashSet<>();
        int count = 0;
        while (n -- > 0) {
            Info info = new Info(sc.next(), sc.next());
            if (!infos.add(info)) continue;
            count ++;
        }
        System.out.println(count);
    }
       static class Info {
            String name;
            String place;

           public Info(String name, String place) {
               this.name = name;
               this.place = place;
           }

           @Override
           public boolean equals(Object o) {
               if (this == o) return true;
               if (o == null || getClass() != o.getClass()) return false;
               Info info = (Info) o;
               return Objects.equals(name, info.name) && Objects.equals(place, info.place);
           }

           @Override
           public int hashCode() {
               return Objects.hash(name, place);
           }
       }

}
