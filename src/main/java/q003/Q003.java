package q003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Q003 集計と並べ替え
 * <p>
 * 以下のデータファイルを読み込んで、出現する単語ごとに数をカウントし、アルファベット辞書順に並び変えて出力してください。
 * resources/q003/data.txt
 * 単語の条件は以下となります
 * - "I"以外は全て小文字で扱う（"My"と"my"は同じく"my"として扱う）
 * - 単数形と複数形のように少しでも文字列が異れば別単語として扱う（"dream"と"dreams"は別単語）
 * - アポストロフィーやハイフン付の単語は1単語として扱う（"isn't"や"dead-end"）
 * <p>
 * 出力形式:単語=数
 * <p>
 * [出力イメージ]
 * （省略）
 * highest=1
 * I=3
 * if=2
 * ignorance=1
 * （省略）
 * <p>
 * 参考
 * http://eikaiwa.dmm.com/blog/4690/
 */
public class Q003 {

    private static final String SEPARATOR = ",|\\.|[\\s]|–";

    /**
     * データファイルを開く
     * resources/q003/data.txt
     */
    private static InputStream openDataFile() {
        return Q003.class.getResourceAsStream("data.txt");
    }

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(openDataFile()));
        Map<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        try {
            String str;
            while ((str = reader.readLine()) != null) {
                list.addAll(Arrays.asList(str.split(SEPARATOR)));
            }

            for (String s : list) {
                int v;
                if (!"I".equals(s)) {
                    s = s.toLowerCase();
                }
                if (map.containsKey(s)) {
                    v = map.get(s) + 1;
                } else {
                    v = 1;
                }
                map.put(s, v);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<String> wordList = new ArrayList<>(map.keySet());
        wordList.sort(String::compareToIgnoreCase);

        for (String key : wordList) {
            System.out.println(key + "=" + map.get(key));
        }
    }
}

// 完成までの時間: 1時間 30分