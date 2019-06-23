package counter;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: ${DESCRIPTION}
 * @CreateDate: 2019/5/25 下午3:26
 * @Author: longlong.an
 * @Email: longlong.an.o@nio.com
 */
public class PerCount extends LinkedHashMap<Class<? extends Pet>, Integer> {

    public PerCount() {
        super(fillMap(LiteralPetCreator.allTypes, 0));
    }

    private static Map<Class<? extends Pet>, Integer> fillMap(List<Class<? extends Pet>> allTypes, int i) {
        LinkedHashMap<Class<? extends Pet>, Integer> linkedHashMap = new LinkedHashMap<>(allTypes.size());
        for (int j = 0; j < allTypes.size(); j++) {
            linkedHashMap.put(allTypes.get(j), 0);
        }
        return linkedHashMap;
    }


    public void count(Pet pet) {
        for (Map.Entry<Class<? extends Pet>, Integer> entry : entrySet()) {
            if (entry.getKey().isInstance(pet)) {
                put(entry.getKey(), entry.getValue() + 1);
            }
        }
    }

}
