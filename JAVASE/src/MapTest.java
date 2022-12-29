import java.util.HashMap;
import java.util.Map;

/**
 * 地图测验
 *
 * @author zm
 * @date 2022/11/28
 */
public class MapTest {
    public static void main(String[] args) {
        Map<String,Object> map = new HashMap<>();
        map.put("1","字符串测试");
        map.put("2",1);
        System.out.println(map.get("1").getClass());
        System.out.println(map.get("2").getClass());
        Object o = map.get("1");
        System.out.println(o);
        Object c = 1;
        System.out.println(c.getClass());
    }
}
