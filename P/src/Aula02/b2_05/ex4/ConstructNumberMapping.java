import java.util.HashMap;
import java.util.Map;

public class ConstructNumberMapping extends NumbersBaseListener {
    protected Map<String, Integer> mappings = new HashMap<String, Integer>();

    public boolean exits(String key) {
        assert key != null;
        return mappings.containsKey(key);
    }

    public Integer value(String key) {
        assert key != null;
        assert exits(key);
        return mappings.get(key);
    }

    @Override
    public void exitLine(NumbersParser.LineContext ctx) {
        String key = ctx.WORD().getText();
        Integer value = Integer.parseInt(ctx.NUM().getText());

        if (exits(key)) {
            System.out.println("Error: repeated key \"" + key + "\"");
            System.exit(1);
        }
        mappings.put(key, value);
    }
}
