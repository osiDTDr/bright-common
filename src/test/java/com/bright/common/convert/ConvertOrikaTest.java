package com.bright.common.convert;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * test {@link OrikaUtils}
 *
 * @author zhengyuan
 * @since 2020/11/26
 */
public class ConvertOrikaTest {
    private static ConvertUser convertUser = null;
    private static List<ConvertUser> convertUserList;
    private static Map<String, String> configMap;

    // field value
    private static final String ID_1 = "id_1";
    private static final String NAME_1 = "name_1";
    private static final String ID_2 = "id_2";
    private static final String NAME_2 = "name_2";

    @BeforeAll
    public static void before() {
        configMap = new HashMap<>();
        convertUserList = new ArrayList<>();
        convertUser = new ConvertUser();
        convertUser.setId(ID_1);
        convertUser.setName(NAME_1);

        ConvertUser convertUser1 = new ConvertUser();
        convertUser1.setId(ID_1);
        convertUser1.setName(NAME_1);
        convertUserList.add(convertUser1);

        ConvertUser convertUser2 = new ConvertUser();
        convertUser2.setId(ID_2);
        convertUser2.setName(NAME_2);
        convertUserList.add(convertUser2);

        configMap.put("id", "name");
        configMap.put("name", "id");
    }

    @Test
    public void testMap1() {
        ConvertUserVo convertUserVo = OrikaUtils.INSTANCE.map(ConvertUserVo.class, convertUser);
        assert StringUtils.equals(convertUserVo.getId(), ID_1);
        assert StringUtils.equals(convertUserVo.getName(), NAME_1);
    }

    @Test
    public void testMap2() {
        ConvertUserVo convertUserVo = OrikaUtils.INSTANCE.map(ConvertUserVo.class, convertUser, configMap);
        assert StringUtils.equals(convertUserVo.getId(), NAME_1);
        assert StringUtils.equals(convertUserVo.getName(), ID_1);
    }

    @Test
    public void testMapAsList1() {
        List<ConvertUserVo> convertUserVoList = OrikaUtils.INSTANCE.mapAsList(ConvertUserVo.class, convertUserList);
        ConvertUserVo convertUserVo1 = convertUserVoList.get(0);
        assert StringUtils.equals(convertUserVo1.getId(), ID_1);
        assert StringUtils.equals(convertUserVo1.getName(), NAME_1);

        ConvertUserVo convertUserVo2 = convertUserVoList.get(1);
        assert StringUtils.equals(convertUserVo2.getId(), ID_2);
        assert StringUtils.equals(convertUserVo2.getName(), NAME_2);
    }

    @Test
    public void testMapAsList2() {
        List<ConvertUserVo> convertUserVoList = OrikaUtils.INSTANCE.mapAsList(ConvertUserVo.class, convertUserList, configMap);
        ConvertUserVo convertUserVo1 = convertUserVoList.get(0);
        assert StringUtils.equals(convertUserVo1.getId(), NAME_1);
        assert StringUtils.equals(convertUserVo1.getName(), ID_1);

        ConvertUserVo convertUserVo2 = convertUserVoList.get(1);
        assert StringUtils.equals(convertUserVo2.getId(), NAME_2);
        assert StringUtils.equals(convertUserVo2.getName(), ID_2);
    }
}
